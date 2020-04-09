package com.intellias;

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
                break;
            case 'f':
                car.moveForward();
                break;
            case 'v':
                car.moveBackward();
                break;
            case 'l':
                car.turnLeft();
                break;
            case 'r':
                car.turnRight();
                break;
            case 'b':
                car.stopMotion();
                break;
            case 'p':
                car.stopEngine();
                break;
            case 'c':
                car.lock();
                break;
            case 'e':
                log.info("Program overs it's work. Thanks :)");
                break;
            default:
                log.info("Unknown character! Try again!");
        }
    }
}
