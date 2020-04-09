package com.intellias.models;

import lombok.Data;

@Data
public class CarInterior {
    private Seat[] seats = new Seat[2];
}
