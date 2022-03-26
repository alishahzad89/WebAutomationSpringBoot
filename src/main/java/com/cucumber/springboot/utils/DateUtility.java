package com.cucumber.springboot.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    public static String getFormattedDate(String sDate, String currentFormat,String newFormat) throws ParseException {
       DateFormat formatter = new SimpleDateFormat(currentFormat);
        Date date = (Date)formatter.parse(sDate);
        SimpleDateFormat newFor = new SimpleDateFormat(newFormat);
        return newFor.format(date);
    }
}
