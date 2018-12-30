package it.unisalento.config;

import it.unisalento.model.details.UserDetailsServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static Logger log = LoggerFactory.getLogger(ModelAndViewConfig.class);
    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp();
    }

    @Override
    protected void configure(
            AuthenticationManagerBuilder auth) throws Exception {
        log.info("Configure userDetailsService e authenticationProvider");
        auth.userDetailsService(userDetailsService());
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] publicUrls = new String[]{
                "/registration/**",
                "/acces",
                "/user/update",
                "/user/addproduct"
        };
        log.info("Configure site security");
        http.csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository()).ignoringAntMatchers(publicUrls);
        http.authorizeRequests()
                .antMatchers("/res/**").permitAll()
                .antMatchers(HttpMethod.POST, "/registration/**").permitAll()
                .antMatchers(HttpMethod.GET, "/registration/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().and().formLogin()
                .loginPage("/acces")
                .permitAll(true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/acces?logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
        ;
    }

}
