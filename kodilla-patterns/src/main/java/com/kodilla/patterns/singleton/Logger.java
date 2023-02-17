package com.kodilla.patterns.singleton;

public class Logger {

    private String lastlog = "";

    public void log(String log) {
        lastlog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastlog() {
        return lastlog;
    }
}
