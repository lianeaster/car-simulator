package com.intellias;

import com.intellias.models.Car;

import static com.intellias.utils.IOUtils.listenToKeyPressed;

public class ActionListener {
    public void listen(Car car) {
        String s;
        do {
            s = listenToKeyPressed();
            char symbol = s.charAt(0);
            ActionResolver.doAction(car, symbol);
        }
        while (!s.equals("e"));
    }
}
