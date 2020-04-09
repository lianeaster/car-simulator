package com.intellias.enums;

public enum PedalType {
    ACCELERATOR, BRAKE;

    public void pressPedal() {
        System.out.println("Pedal is pressed!");
    }
}
