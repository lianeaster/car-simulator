package com.intellias.models.transmission;

import com.intellias.enums.TransmissionState;
import com.intellias.models.transmission.pedals.Pedals;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Transmission {
    private Pedals pedals;
    private SteeringWheel steeringWheel;
    private Boolean reverseGear;
    private TransmissionState tState;

    public Transmission() {
        pedals = new Pedals();
        steeringWheel = new SteeringWheel();
        tState=TransmissionState.PARKING;
    }

    public void setTState(TransmissionState tState) {
        this.tState = tState;
        log.info("Transmission state is changed to: " + tState.toString());
    }
}
