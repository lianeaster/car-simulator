package com.intellias;

import com.intellias.models.Car;
import com.intellias.utils.KeyListener;

public class ActionListener {
    public void listen(Car car) {
        String s;
        do {
            s = KeyListener.listenToKeyPressed();
            char symbol= s.charAt(0);
            ActionResolver.doAction(car, symbol);
        }
        while (!s.equals("exit"));
    }
}
