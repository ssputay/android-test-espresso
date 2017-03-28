package com.example.serhiysputay.espressotest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Data class to provide specific data
 */

public class DataService
{
    private static DataService ourInstance = new DataService();


    public static DataService getInstance()
    {
        return ourInstance;
    }

    private DataService()
    {
    }

    public String getYear()
    {
        SimpleDateFormat df            = new SimpleDateFormat("yyyy");
        return df.format(Calendar.getInstance().getTime());
    }

    public String getMonth()
    {
        SimpleDateFormat df            = new SimpleDateFormat("MM");
        return df.format(Calendar.getInstance().getTime());
    }

    public String getTime()
    {
        SimpleDateFormat df            = new SimpleDateFormat("HH:mm");
        return df.format(Calendar.getInstance().getTime());
    }

}
