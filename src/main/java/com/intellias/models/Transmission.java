package com.intellias.models;

import lombok.Data;

@Data
public class Transmission {
    private Pedals pedals;
    private SteeringWheel steeringWheel;

    public Transmission() {
        pedals= new Pedals();
        steeringWheel= new SteeringWheel();
    }
}
