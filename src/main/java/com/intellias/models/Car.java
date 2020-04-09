package com.intellias.models;


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
        getEngine().startEngine();
        getTransmission().setTState(TransmissionState.DRIVE);
        setState(CarState.STANDBY);
    }

    public void increaseSpeed() {
        getTransmission().getPedals().getAccelerator().pressPedal();
        log.info(getTransmission().getTState().toString());
        setState(CarState.DRIVE_FORWARD);
    }

    public void moveBackward() {
        getTransmission().setReverseGear(true);
        getTransmission().setTState(TransmissionState.REVERSE);
        setState(CarState.DRIVE_REVERSE);
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
        getTransmission().getPedals().getBrake().pressPedal();
        log.info(getTransmission().getTState().toString());
        setState(CarState.STANDBY);
    }

    public void park() {
        getTransmission().setTState(TransmissionState.PARKING);
        setState(CarState.DRIVE_REVERSE);
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
        getEngine().stopEngine();
        log.info(getTransmission().getTState().toString());
        setState(CarState.OFF);
    }
}
