package com.bo.mower.lawnmover.models;

import com.bo.mower.lawnmover.enums.Order;
import com.bo.mower.lawnmover.enums.Orientation;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mover {
//    private int xLimit;
//    private int yLimit;
    private Position position;
    Orientation orientation;
    List<Order> orders;
}
