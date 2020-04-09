package com.intellias.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Engine {
    public void startEngine() {
        log.info("Engine is started!");
    }

    public void stopEngine() {
        log.info("Engine is stopped!");
    }
}
