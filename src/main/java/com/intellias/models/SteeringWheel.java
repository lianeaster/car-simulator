package com.intellias.models;

import lombok.Data;

@Data
public class SteeringWheel {

    public void turnLeft() {
        System.out.println("Car is moving left");
    }

    public void turnRight() {
        System.out.println("Car is moving right");
    }
}
