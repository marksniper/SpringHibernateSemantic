package it.unisalento.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateService {
    private final static Logger log = LoggerFactory.getLogger(DateService.class);

    public static String convertDate(long timestamp) {
        try {
            log.debug("Convert date.");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timestamp);
            return df.format(calendar.getTime());
        } catch (Exception e) {
            log.error("Error to convert date. Exception is occured (" + timestamp + "). Return invalid date.");
            return "invalid date";
        }
    }
}
