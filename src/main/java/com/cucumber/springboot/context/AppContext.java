package com.cucumber.springboot.context;

import java.util.HashMap;
import java.util.Map;

public class AppContext {
    public static String profile;
    public static String environment;
    public static String hostUrl;
    public static String browser;
    public static Map<String,String> inputDate = new HashMap<String,String>();
}
