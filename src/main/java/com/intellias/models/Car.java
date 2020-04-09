package com.intellias.models;


import com.intellias.StateChecker;
import com.intellias.enums.CarState;
import com.intellias.enums.TransmissionState;
import com.intellias.models.transmission.Transmission;
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
        log.info(transmission.getTState().toString());
    }

    public void startEngine() {
        if (StateChecker.checkIfStateIsAllowed(carState, CarState.STANDBY)) {
            getEngine().startEngine();
            setState(CarState.STANDBY);
            getTransmission().setTState(TransmissionState.DRIVE);
        } else
            log.error("You can't do this action for while car is " + carState);
    }

    public void increaseSpeed() {
        if (StateChecker.checkIfStateIsAllowed(carState, CarState.DRIVE_FORWARD)) {
            getTransmission().getPedals().getAccelerator().pressPedal();
            log.info(getTransmission().getTState().toString());
            setState(CarState.DRIVE_FORWARD);
        } else
            log.error("You can't do this action for while car is " + carState);
    }

    public void moveBackward() {
        if (StateChecker.checkIfStateIsAllowed(carState, CarState.DRIVE_REVERSE)) {
            getTransmission().setReverseGear(true);
            getTransmission().setTState(TransmissionState.REVERSE);
            setState(CarState.DRIVE_REVERSE);
        } else
            log.error("You can't do this action for while car is " + carState);
    }

    public void turnLeft() {
        getTransmission().getSteeringWheel().turnLeft();
        log.info(getTransmission().getTState().toString());
        log.info(carState.toString());
    }

    public void turnRight() {
        getTransmission().getSteeringWheel().turnRight();
        log.info(getTransmission().getTState().toString());
        log.info(carState.toString());

    }

    public void decreaseSpeed() {
        if (StateChecker.checkIfStateIsAllowed(carState, CarState.STANDBY)) {
            getTransmission().getPedals().getBrake().pressPedal();
            log.info(getTransmission().getTState().toString());
            setState(CarState.STANDBY);
        } else
            log.error("You can't do this action for while car is " + carState);
    }

    public void park() {
        if (StateChecker.checkIfStateIsAllowed(carState, CarState.DRIVE_REVERSE)) {
            getTransmission().setTState(TransmissionState.PARKING);
            setState(CarState.DRIVE_REVERSE);
        } else
            log.error("You can't do this action for while car is " + carState);
    }

    public void lock() {
        getCarBody().getLock().closeLock();
        log.info(carState.toString());
    }

    private void setState(CarState carState) {
        this.carState = carState;
        log.info("Car state is changed to: " + carState.toString());
    }

    public void stopEngine() {
        if (StateChecker.checkIfStateIsAllowed(carState, CarState.OFF)) {
            getEngine().stopEngine();
            log.info(getTransmission().getTState().toString());
            setState(CarState.OFF);
        } else
            log.error("You can't do this action for while car is " + carState);
    }
}