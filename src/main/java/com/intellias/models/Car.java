package com.intellias.models;


import com.intellias.enums.CarState;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Car {
    private Engine engine;
    private CarBody carBody;
    private Transmission transmisison;
    private CarState carState;

    public Car() {
        engine = new Engine();
        carBody = new CarBody();
        transmisison = new Transmission();
    }

    public void setState(CarState carState) {
        this.carState = carState;
        log.info("Car state is: " + carState.toString());
    }

    public void openLock() {

    }
}
