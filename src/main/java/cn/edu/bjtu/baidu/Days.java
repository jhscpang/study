package cn.edu.bjtu.baidu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pangchao on 2016/10/23.
 */
public class Days {

    public static void main(String[] args) {
        Date date1 = parseDate("2016-9-10 10:10:10");
        Date date2 = parseDate("2016-9-12 20:21:22");

        System.out.println(calculate(date1, date2));
    }

    public static long calculate(Date date1, Date date2) {
        if(date1 == null || date2 == null)
            return 0;

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        long timestamp1 = calendar1.getTimeInMillis();
        long timestamp2 = calendar2.getTimeInMillis();

        long days = (timestamp1 - timestamp2) / (24 * 60 * 60 * 1000);
        return days > 0 ? days : -days;

    }

    public static Date parseDate(String date) {
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date myDate2 = null;
        try {
            myDate2 = dateFormat2.parse(date);
        } catch (ParseException e) {
            //
            e.printStackTrace();
            return null;
        }
        return myDate2;
    }
}
