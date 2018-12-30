package it.unisalento.model;

import java.util.ResourceBundle;

public class DatabaseModel {

    public static ResourceBundle rb = ResourceBundle.getBundle("config");
    public static String SESSION_LISTENER_MAX_INACTIVETIME = "session.sessionlistener.maxinactivetime";
    public static String FILTER_SESSION_LISTENER_MAX_INACTIVETIME = "session.filter.maxinactivetime";
}
