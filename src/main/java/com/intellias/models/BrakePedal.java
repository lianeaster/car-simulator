package com.intellias.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BrakePedal implements Pedal {
    @Override
    public void pressPedal() {
        log.info("Brake pedal is pressed!");
    }
}
