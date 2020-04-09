package com.intellias.utils;

import java.util.Scanner;

public class KeyListener {

    public static String listenToKeyPressed() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
