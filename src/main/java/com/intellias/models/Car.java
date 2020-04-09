package com.intellias.models;


import com.intellias.StateChecker;
import com.intellias.enums.CarState;
import com.intellias.enums.TransmissionState;
import com.intellias.models.transmission.Transmission;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static com.intellias.StateChecker.*;

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
        carState = CarState.OFF;
    }

    public void open() {
        carBody.getLock().openLock();
        log.info("Car state is: "+carState.toString());
        log.info("Transmission state is: "+transmission.getTState().toString());
    }

    public void startEngine() {
        try {
            if (!checkIfStateIsAllowed(carState, CarState.STANDBY))
                throw new IllegalStateException();
            engine.startEngine();
            setState(CarState.STANDBY);
            transmission.setTState(TransmissionState.DRIVE);
        } catch (IllegalStateException e) {
            log.error("You can't do this action while car is " + carState);
        }
    }

    public void increaseSpeed() {
        try {
            if (!checkIfStateIsAllowed(carState, CarState.DRIVE_FORWARD))
                throw new IllegalStateException();
            transmission.getPedals().getAccelerator().pressPedal();
            log.info("Transmission state is: "+transmission.getTState().toString());
            setState(CarState.DRIVE_FORWARD);
        } catch (IllegalStateException e) {
            log.error("You can't do this action while car is " + carState);
        }
    }

    public void moveBackward() {
        try {
            if (!checkIfStateIsAllowed(carState, CarState.DRIVE_REVERSE))
                throw new IllegalStateException();
            transmission.setReverseGear(true);
            transmission.setTState(TransmissionState.REVERSE);
            setState(CarState.DRIVE_REVERSE);
        } catch (IllegalStateException e) {
            log.error("You can't do this action while car is " + carState);
        }
    }

    public void turnLeft() {
        transmission.getSteeringWheel().turnLeft();
        log.info("Transmission state is: "+transmission.getTState().toString());
        log.info("Car state is: "+carState.toString());
    }

    public void turnRight() {
        transmission.getSteeringWheel().turnRight();
        log.info("Transmission state is: "+transmission.getTState().toString());
        log.info("Car state is: "+carState.toString());

    }

    public void decreaseSpeed() {
        try {
            if (!checkIfStateIsAllowed(carState, CarState.STANDBY))
                throw new IllegalStateException();
            transmission.getPedals().getBrake().pressPedal();
            log.info("Transmission state is: "+transmission.getTState().toString());
            setState(CarState.STANDBY);
        } catch (IllegalStateException e) {
            log.error("You can't do this action while car is " + carState);
        }
    }

    public void park() {
        try {
            if (!checkIfStateIsAllowed(carState, CarState.DRIVE_REVERSE))
                throw new IllegalStateException();
            transmission.setTState(TransmissionState.PARKING);
            setState(CarState.DRIVE_REVERSE);
        } catch (IllegalStateException e) {
            log.error("You can't do this action while car is " + carState);
        }
    }

    public void lock() {
        carBody.getLock().closeLock();
        log.info("Transmission state is: "+transmission.getTState().toString());
        log.info("Car state is: "+carState.toString());
    }

    public void stopEngine() {
        try {
            if (!checkIfStateIsAllowed(carState, CarState.OFF))
                throw new IllegalStateException();
            engine.stopEngine();
            log.info("Transmission state is: "+transmission.getTState().toString());
            setState(CarState.OFF);
        } catch (IllegalStateException e) {
            log.error("You can't do this action while car is " + carState);
        }
    }

    private void setState(CarState carState) {
        this.carState = carState;
        log.info("Car state is changed to: " + carState.toString());
    }
}