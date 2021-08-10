package com.bo.mower.lawnmover.models;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {
    private int x;
    private int y;
}
