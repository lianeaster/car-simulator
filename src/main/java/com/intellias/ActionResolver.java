package com.intellias;

import com.intellias.enums.CarState;
import com.intellias.models.Car;

public class ActionResolver {
    public static void doAction(Car car, char actionName) {
        switch (actionName) {
            case 'o':
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
                System.out.println("Unknown character! Try again!");

        }
    }
}
