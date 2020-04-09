package com.intellias;

import com.intellias.enums.CarState;
import com.intellias.models.Car;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActionResolver {
    public static void doAction(Car car, char actionName) {
        switch (actionName) {
            case 'o':
//                car.openLock();
                car.getCarBody().getLock().openLock();
                break;
            case 's':
                car.getEngine().startEngine();
                car.setState(CarState.STANDBY);
                break;
            case 'f':
                car.getTransmisison().getPedals().getAccelerator().pressPedal();
                car.setState(CarState.DRIVE_FORWARD);
                break;
            case 'v':
                car.getTransmisison().getPedals().getAccelerator().pressPedal();
                car.setState(CarState.DRIVE_FORWARD);
                break;
            case 'l':
                car.getTransmisison().getSteeringWheel().turnLeft();
                break;
            case 'r':
                car.getTransmisison().getSteeringWheel().turnRight();
                break;
            case 'b':
                car.getTransmisison().getPedals().getBrake().pressPedal();
                car.setState(CarState.STANDBY);
                break;
            case 'p':
                car.getEngine().stopEngine();
                break;
            case 'c':
                car.getCarBody().getLock().closeLock();
                car.setState(CarState.OFF);
                break;
            default:
                log.info("Unknown character! Try again!");

        }
    }
}
