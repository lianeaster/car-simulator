package com.intellias.models;


import com.intellias.enums.CarState;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Car {
    private Engine engine;
    private CarBody carBody;
    private Transmission transmission;
    private CarState carState;

    public Car() {
        engine = new Engine();
        carBody = new CarBody();
        transmission = new Transmission();
    }

    public void setState(CarState carState) {
        this.carState = carState;
        log.info("Car state is: " + carState.toString());
    }

    public void open() {
        getCarBody().getLock().openLock();
    }

    public void startEngine() {
        getEngine().startEngine();
    }

    public void moveForward() {
        getTransmission().getPedals().getAccelerator().pressPedal();
    }

    public void moveBackward() {
        getTransmission().getPedals().getBrake().pressPedal();
    }

    public void turnLeft() {
        getTransmission().getSteeringWheel().turnLeft();
    }

    public void turnRight() {
        getTransmission().getSteeringWheel().turnRight();
    }

    public void stopMotion() {
        getTransmission().getPedals().getBrake().pressPedal();
    }

    public void stopEngine() {
        getEngine().stopEngine();
    }

    public void lock() {
        getCarBody().getLock().closeLock();
    }
}
