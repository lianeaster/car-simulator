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
                car.increaseSpeed();
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
                car.decreaseSpeed();
                break;
            case 'p':
                car.park();
                break;
            case 't':
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
