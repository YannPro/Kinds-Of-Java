package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created jsm on 2018/1/24.
 */
public class DateUtil {
    static {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+08:00"));
    }

    private static final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    public static Date now() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00")).getTime();
    }

    public static Date getDayEnd(Date date) {

        calendar.setTimeInMillis(date.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date getDayStart(Date date) {
        calendar.setTimeInMillis(date.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        log.info("time:" + calendar.getTime());
        return calendar.getTime();
    }

    public static Date getTodyEnd() {
        return getDayEnd(now());
    }




    public static Date getDayStart() {
        return getDayStart(now());
    }


    public static Date before(int day) {
        return before(null, day);
    }

    public static Date beforeHour(Date date, int hour) {
        if (date == null) {
            date = getDayStart();
        }
        long current = date.getTime();
        long onehour = 60 * 60 * 1000;
        calendar.setTimeInMillis(current - (onehour * hour));
        return calendar.getTime();
    }

    public static Date before(Date date, int day) {
        if (date == null) {
            date = getDayStart();
        }
        long current = date.getTime();
        long oneday = 24 * 60 * 60 * 1000;
        calendar.setTimeInMillis(current - (oneday * day));
        return getDayStart(calendar.getTime());
    }

    public static String format(Date date) {
        return sdf.format(date);
    }

    public static int getBetweenDays(Date starttime, Date enditme) {
        long start = starttime.getTime();
        long end = enditme.getTime();
        return (int) ((end - start) / (1000 * 60 * 60 * 24) + 0.5);
    }


    public static String format(Date date, String format) {
        if (format != null) {
            SimpleDateFormat format1 = new SimpleDateFormat(format);
            return format1.format(date);
        } else {
            return format(date);
        }
    }

    public static Date afterHour(Date date, int hour) {
        if (date == null) {
            date = now();
        }
        long current = date.getTime();
        long onehour = 60 * 60 * 1000;
        calendar.setTimeInMillis(current + (onehour * hour));
        return calendar.getTime();
    }

    public static Date beforeMinute(int minute) {
        long current = now().getTime();
        long oneMinute = 60 * 1000;
        calendar.setTimeInMillis(current + (minute * oneMinute));
        return calendar.getTime();
    }

    public static void main(String[] args) {

    }
}
