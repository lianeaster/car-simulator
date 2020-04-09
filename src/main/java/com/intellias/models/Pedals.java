package com.intellias.models;

import lombok.Data;

@Data
public class Pedals {
    private Pedal accelerator;
    private Pedal brake;

    public Pedals() {
        accelerator= new AcceleratorPedal();
        brake= new BrakePedal();
    }
}
