package com.bo.mower.lawnmover.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Order {
    D("DROITE", 90), G("GAUCHE", -90), A("AVANCER", 0);

    private String label;
    private int angle;

    public String getLabel() {
        return label;
    }

    public int getAngle() {
        return angle;
    }
}
