package com.intellias.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class SteeringWheel {

    public void turnLeft() {
        log.info("Car is moving left");
    }

    public void turnRight() {
        log.info("Car is moving right");
    }
}
