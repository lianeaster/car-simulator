package com.intellias.models;

import lombok.Data;

@Data
public class Engine {
    public void startEngine() {
        System.out.println("Engine is started!");
    }

    public void stopEngine() {
        System.out.println("Engine is stopped!");
    }
}
