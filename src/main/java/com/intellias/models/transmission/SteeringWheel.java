package com.intellias.models.transmission;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class SteeringWheel {

    public void turnLeft() {
        log.info("Car has moved left!");
    }

    public void turnRight() {
        log.info("Car has moved right!");
    }
}
