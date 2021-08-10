package com.bo.mower.lawnmover.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Lawn {
    /**
     * The width of lawn
     * largeur de la pelouse
     */
    private int width;

    /**
     * The height of lawn
     * hauteur de la pelouse
     */
    private int height;
}
