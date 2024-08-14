package org.example;

import java.time.LocalDateTime;

public class MyLogger {
    private static MyLogger logger = null;

    private MyLogger() {
    }

    public static MyLogger getLogger() {
        if (logger == null) {
            logger = new MyLogger();
        }
        return logger;
    }

    public void log(String severityLevel, String message) {
        switch (severityLevel) {
            case "INFO":
                System.out.println(LocalDateTime.now() + " - " + severityLevel + " - " + message);
                break;
            case "WARNING":
                System.err.println(LocalDateTime.now() + " - " + severityLevel + " - " + message);
                break;
            case "ERROR":
                System.err.println(LocalDateTime.now() + " - " + severityLevel + " - " + message);
                break;
            case "DEBUG":
                System.out.println(LocalDateTime.now() + " - " + severityLevel + " - " + message);
                break;
            case "CRITICAL":
                System.err.println(LocalDateTime.now() + " - " + severityLevel + " - " + message);
                break;
            default:
                System.err.println("Unknown severity level: " + severityLevel);
                break;
        }
    }
}
