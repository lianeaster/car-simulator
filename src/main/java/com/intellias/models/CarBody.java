package com.intellias.models;

import lombok.Data;

@Data
public class CarBody {
    private Lock lock;

    public CarBody() {
        lock = new Lock();
    }
}
