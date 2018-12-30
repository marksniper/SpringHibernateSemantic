package it.unisalento.config;

import it.unisalento.model.UserEntity;
import it.unisalento.model.details.User;
import it.unisalento.model.persistence.inter.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final static Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        log.info("Controllo autenticazioni");
        User.getInstance().setPassword(authentication.getCredentials().toString());
        User.getInstance().setUsername(authentication.getName());
        User.getInstance().setRole("ROLE_USER");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserEntity user = userService.getgetByUsernameAndPassword(User.getInstance());
        if (user != null) {
            log.info("User is authenticated");
            User.getInstance().setEntity(user);
            return new UsernamePasswordAuthenticationToken
                    (User.getInstance().getUsername(), User.getInstance().getPassword(), grantedAuthorities);
        } else {
            log.warn("Warning! User did not pass authentication with DB.");
            User.setInstance(null);
            throw new BadCredentialsException("Error! Username or Password not valid.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }

}