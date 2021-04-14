package com.tao.jiang.demo.utils.general;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static Log log = LogFactory.getFactory().getInstance(TimeUtils.class);

    // TODO fix logic
    public static boolean tokenValidate(Date date1, Date date2, int timeSlot) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fromM = null;
        Date toM = null;
        try {
            fromM = simpleFormat.parse(simpleFormat.format(date1).substring(0, 19));
            toM = simpleFormat.parse(simpleFormat.format(date2).substring(0, 19));
        } catch (ParseException e) {
            log.error("Failed to calculate time gap!");
        }
        long from = fromM.getTime();
        long to = toM.getTime();
        int gap = (int) ((to - from) / 1000);
        return gap < timeSlot;
    }
}
