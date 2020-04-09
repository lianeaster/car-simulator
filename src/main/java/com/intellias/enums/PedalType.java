package com.intellias.enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum PedalType {
    ACCELERATOR, BRAKE;

    public void pressPedal() {
        log.info("Pedal is pressed!");
    }
}
