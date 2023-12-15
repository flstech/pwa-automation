package com.aktivo.framework;

public class GlobalParams {

    private static final ThreadLocal<String> browserName = new ThreadLocal<>();


    public String getBrowserName() {
        return browserName.get();
    }


    public void setBrowserName(String browserName2) {
        browserName.set(browserName2);
    }

}
