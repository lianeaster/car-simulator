package com.intellias.models;

import com.intellias.enums.PedalType;
import lombok.Data;

@Data
public class Pedals {
    private PedalType accelerator;
    private PedalType brake;
}
