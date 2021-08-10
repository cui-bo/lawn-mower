package com.bo.mower.lawnmover.models;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mover {
    private String idMover;
    private int xLimit;
    private int yLimit;
    private Position position;
}
