package com.intellias.models;


import com.intellias.enums.CarState;
import lombok.Data;

@Data
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
    }
}
