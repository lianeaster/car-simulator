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
        setCarState(CarState.OFF);
    }

    public void open() {
        getCarBody().getLock().openLock();
        log.info(carState.toString());
    }

    public void startEngine() {
        getEngine().startEngine();
        setState(CarState.STANDBY);
    }

    public void moveForward() {
        getTransmission().getPedals().getAccelerator().pressPedal();
        setState(CarState.DRIVE_FORWARD);
    }

    public void moveBackward() {
        getTransmission().setReverseGear(true);
        setState(CarState.DRIVE_REVERSE);
    }

    public void turnLeft() {
        getTransmission().getSteeringWheel().turnLeft();
        log.info(carState.toString());
    }

    public void turnRight() {
        getTransmission().getSteeringWheel().turnRight();
        log.info(carState.toString());

    }

    public void stopMotion() {
        getTransmission().getPedals().getBrake().pressPedal();
        setState(CarState.STANDBY);
    }

    public void stopEngine() {
        getEngine().stopEngine();
        setState(CarState.OFF);
    }

    public void lock() {
        getCarBody().getLock().closeLock();
        log.info(carState.toString());
    }

    private void setState(CarState carState) {
        this.carState = carState;
        log.info("Car state is changed to: " + carState.toString());
    }
}
