package com.bo.mower.lawnmover.services;


import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Position;

public interface MoverService {

    String launch(String inputData) throws MissingDataException;

    Position startMover();

    Orientation calculateOrientation();

    // Checking if mover is on the edge of the lawn
    Boolean canMoverForward(Lawn lawn, Position position, Orientation orientation) throws MissingDataException;

    String displayFinalPosition();


}
