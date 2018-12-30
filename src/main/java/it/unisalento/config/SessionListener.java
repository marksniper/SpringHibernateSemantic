package it.unisalento.config;

import it.unisalento.model.DatabaseModel;
import it.unisalento.service.DateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener {
    private final static Logger log = LoggerFactory.getLogger(SessionListener.class);
    private int intervalSeconds = Integer.parseInt(
            DatabaseModel.rb.getString(DatabaseModel.SESSION_LISTENER_MAX_INACTIVETIME)
    );
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        log.info("SESSION-ID [" + event.getSession().getId() + "].Session is created. Creation date: "
                + DateService.convertDate(event.getSession().getCreationTime())
                + ". Max inactive time: " + intervalSeconds + " seconds");
        event.getSession().setMaxInactiveInterval(intervalSeconds);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        log.info("SESSION-ID [" + event.getSession().getId() + "] - Destroy session.");
    }

}
