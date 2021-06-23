package com.company;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Demo.demo();
        } catch (IOException iex) {
            iex.printStackTrace();
        }
    }
}
