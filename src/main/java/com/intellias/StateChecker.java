package com.intellias;

import com.intellias.enums.CarState;

import java.util.*;

import static com.intellias.enums.CarState.*;
import static com.intellias.enums.CarState.OFF;
import static com.intellias.enums.CarState.STANDBY;

public class StateChecker {
    public static Map<CarState, List<CarState>> stateChain;

    static {
        stateChain = new HashMap<>();
        stateChain.put(OFF,  new ArrayList<CarState>() {
            {
                add(OFF);
                add(STANDBY);
            }
        });;
        stateChain.put(STANDBY, new ArrayList<CarState>() {
            {
                add(STANDBY);
                add(DRIVE_FORWARD);
                add(DRIVE_REVERSE);
                add(OFF);
            }
        });
        stateChain.put(DRIVE_FORWARD, new ArrayList<CarState>() {
            {
                add(DRIVE_FORWARD);
                add(DRIVE_REVERSE);
                add(STANDBY);
            }
        });
        stateChain.put(DRIVE_REVERSE, new ArrayList<CarState>() {
            {
                add(DRIVE_REVERSE);
                add(DRIVE_FORWARD);
                add(STANDBY);
            }
        });
    }

    public static boolean checkIfStateIsAllowed(CarState currentCarState, CarState nextCarState){
        List<CarState> appropriateCarStates = stateChain.get(currentCarState);
        return appropriateCarStates.contains(nextCarState);
    }
}
