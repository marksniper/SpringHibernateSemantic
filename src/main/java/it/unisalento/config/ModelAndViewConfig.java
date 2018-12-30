package it.unisalento.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("it.unisalento")
@PropertySources({
        @PropertySource("classpath:config.properties")
})

public class ModelAndViewConfig implements WebMvcConfigurer {
    private final static Logger log = LoggerFactory.getLogger(ModelAndViewConfig.class);

    /*Property resolver*/
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setNullValue("");
        return p;
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver htmlViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        String viewPath = "/WEB-INF/views/";
        log.info("Define viewPath : " + viewPath);
        viewResolver.setPrefix(viewPath);
        viewResolver.setSuffix("");
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        String originLocation = "/WEB-INF/views/resources/";
        String targetLocation = "/res/**";
        log.info("Resource target location: " + targetLocation + " from original location:" + originLocation);
        registry.addResourceHandler(targetLocation).addResourceLocations(originLocation);
    }
}