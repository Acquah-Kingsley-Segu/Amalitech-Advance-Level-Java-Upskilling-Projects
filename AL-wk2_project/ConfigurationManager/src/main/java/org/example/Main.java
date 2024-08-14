package org.example;

public class Main {
    public static void main(String[] args) {
        ConfigurationReader configurationReader = ConfigurationReader.getInstance();
        configurationReader.readConfigurations("config,txt");
        configurationReader.printConfigurations();
        String value = configurationReader.getConfigurations("key1");
        System.out.println(value);
    }
}