package com.intellias.models;

import lombok.Data;

@Data
public class Lock {
    public void openLock() {
        System.out.println("Lock is opened");
    }

    public void closeLock() {
        System.out.println("Lock is closed");
    }
}
