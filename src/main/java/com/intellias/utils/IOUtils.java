package com.intellias.utils;

import java.util.Scanner;

public class IOUtils {
    private IOUtils() {
    }

    public static String listenToKeyPressed() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
