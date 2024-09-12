package org.example;

public class Main {
    public static void main(String[] args) {
        MyLogger infoLogger = MyLogger.getLogger();
        infoLogger.log("INFO", "Hello World");
        MyLogger errorLogger = MyLogger.getLogger();
        errorLogger.log("ERROR", "Hello World type Error");
    }
}