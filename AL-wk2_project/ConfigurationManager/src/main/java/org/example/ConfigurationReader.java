package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConfigurationReader {
    private final Map<String, String> configurations;
    private static ConfigurationReader configReader = null;

    private ConfigurationReader() {
        this.configurations = new HashMap<>();
    }

    public static ConfigurationReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigurationReader();
        }
        return configReader;
    }
    public void readConfigurations(String fileName) {
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(":");
                configurations.put(tokens[0], tokens[1]);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void printConfigurations() {
        System.out.println(configurations);
    }
    public String getConfigurations(String key) {
        return configurations.get(key);
    }
}
