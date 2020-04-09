package com.intellias;

import com.intellias.enums.CarState;
import com.intellias.models.Car;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActionResolver {
    public static void doAction(Car car, char actionName) {
        switch (actionName) {
            case 'o':
                car.open();
                break;
            case 's':
                car.startEngine();
                car.setState(CarState.STANDBY);
                break;
            case 'f':
                car.moveForward();
                car.setState(CarState.DRIVE_FORWARD);
                break;
            case 'v':
                car.moveBackward();
                car.setState(CarState.DRIVE_REVERSE);
                break;
            case 'l':
                car.turnLeft();
                break;
            case 'r':
                car.turnRight();
                break;
            case 'b':
                car.stopMotion();
                car.setState(CarState.STANDBY);
                break;
            case 'p':
                car.stopEngine();
                break;
            case 'c':
                car.lock();
                car.setState(CarState.OFF);
                break;
            default:
                log.info("Unknown character! Try again!");

        }
    }
}
