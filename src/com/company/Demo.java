package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Demo {

    private static final String helpPath = "src/Help.txt";

    public static void demo () throws IOException {

        Map<String, String> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerHelp = new BufferedReader(new FileReader("src/Help.txt"));
        String strCurrentLine;

        String key;
        String value;
        DemoOptions demoOptions;

        displayHelp();

        while (true) {

            strCurrentLine = reader.readLine();

            if (regexCheck(strCurrentLine)) {

                demoOptions = DemoOptions.values()[Integer.parseInt(strCurrentLine.substring(0,1))];

                switch (demoOptions) {
                    case ZERO:
                        System.out.println("Goodbye");
                        return;
                    case ONE:
                        key = strCurrentLine.split("_")[1];
                        value = strCurrentLine.split("_")[2];
                        map.put(key, value);
                        System.out.println("Key " + key + " and value " + value + " have been successfully added");
                        break;
                    case TWO:
                        key = strCurrentLine.split("_")[1];
                        if (map.containsKey(key)) {
                            System.out.println(map.get(key));
                        } else {
                            System.out.println("Key doesn't exist");
                        }
                        break;
                    case THREE:
                        map.forEach((k, i) -> System.out.println("k=" + k + ", v=" + i + "; "));
                        break;
                    default:
                        throw new IOException("Invalid input");
                }

            } else {

                System.out.println("Invalid input");

            }
        }
    }

    private static void displayHelp () {
        try (BufferedReader readerHelp = new BufferedReader(new FileReader("src/Help.txt"))) {
            String strCurrentLine;
            while ((strCurrentLine = readerHelp.readLine()) != null) {
                System.out.println(strCurrentLine);
            }
        } catch (IOException iex) {
            iex.printStackTrace();
        };
    };

    private static boolean regexCheck (String strCurrentLine) {
            return (strCurrentLine.matches("(0)" + "|(1_[a-zA-Z0-9]+_[a-zA-Z0-9]+)" + "|(2_[a-zA-Z0-9]+)" + "|(3)"));
    };







}
