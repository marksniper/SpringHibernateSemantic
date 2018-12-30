package it.unisalento.controllers;

import it.unisalento.model.details.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {
    public static final Logger log = LoggerFactory.getLogger(PageController.class);

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        String pageName = "index.jsp";
        log.info("Load " + pageName);
        ModelAndView view = new ModelAndView(pageName);
        log.debug("Add object in view: utente");
        return view;
    }

    @GetMapping(value = {"/acces"})
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String pageName = "login.jsp";
        log.info("Load " + pageName);
        ModelAndView view = new ModelAndView(pageName);
        return view;
    }

    @GetMapping(value = "/log")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        String pageName;
        if (User.getInstance() != null) {
            request.getSession().invalidate();
            pageName = "login.jsp";
        } else {
            pageName = "index.jsp";
        }
        log.info("Load " + pageName);
        ModelAndView view = new ModelAndView(pageName);
        return view;
    }

    @GetMapping(value = "/buyProduct")
    public ModelAndView prova(HttpServletRequest request, HttpServletResponse response) {
        String pageName = "buyProduct.jsp";
        log.info("Load " + pageName);
        ModelAndView view = new ModelAndView(pageName);
        return view;
    }

    @GetMapping(value = "/updateInfo")
    public ModelAndView semantic(HttpServletRequest request, HttpServletResponse response) {
        String pageName = "updateInfo.jsp";
        log.info("Load " + pageName);
        ModelAndView view = new ModelAndView(pageName);
        return view;
    }

}
