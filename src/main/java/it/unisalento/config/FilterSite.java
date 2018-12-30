package it.unisalento.config;

import it.unisalento.model.DatabaseModel;
import it.unisalento.service.DateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
@Controller
public class FilterSite implements Filter {
    private final static Logger log = LoggerFactory.getLogger(FilterSite.class);

    @Override
    public void init(FilterConfig filterConfig) {
     }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        String loginURI = request.getContextPath() + "/acces";
        log.info("Session is active: " + session.getId() + ". Max time: " + session.getMaxInactiveInterval() +
                ". Session is created: " +
                "" + DateService.convertDate(session.getCreationTime()) + ". Last acess: " +
                "" + DateService.convertDate(session.getLastAccessedTime())
        );
        if (session == null) {
            log.info("Session is null. Redirect");
            response.sendRedirect(loginURI);
        }
        session.setMaxInactiveInterval(Integer.parseInt(
                DatabaseModel.rb.getString(DatabaseModel.FILTER_SESSION_LISTENER_MAX_INACTIVETIME)));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
