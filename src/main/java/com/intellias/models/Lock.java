package com.intellias.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Lock {
    public void openLock() {
        log.info("Lock is opened");
    }

    public void closeLock() {
        log.info("Lock is closed");
    }
}
