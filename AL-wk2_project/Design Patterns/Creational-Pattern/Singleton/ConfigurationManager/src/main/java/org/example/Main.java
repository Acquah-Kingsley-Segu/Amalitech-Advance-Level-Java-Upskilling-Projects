package org.example;

public class Main {
    public static void main(String[] args) {
        ConfigurationReader textConfigReader = ConfigurationReader.getInstance();
        textConfigReader.readConfigurations("config.txt", ":");
        textConfigReader.printConfigurations();


        ConfigurationReader envConfigReader = ConfigurationReader.getInstance();
        envConfigReader.readConfigurations(".env", "=");
        envConfigReader.printConfigurations();

        System.out.println("env1 = " + textConfigReader.getConfigurations("env1") +  "\nenv1 = " + envConfigReader.getConfigurations("env1"));
    }
}