package com.bo.mower.lawnmover.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum  Orientation {
    N("NORTH", 0), E("EAST", 90), W("WEST", 270), S("SOUTH", 180);

    private String label;
    private int angle;


    public String getLabel() {
        return label;
    }

    public int getAngle() {
        return angle;
    }
}
