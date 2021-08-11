package com.bo.mower.lawnmover.services;


import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Position;

public interface MoverService {

    String launch(String inputData) throws MissingDataException;

    Position startMover();

    Orientation calculateOrientation();

    // Checking if mover is on the edge of the lawn
    Boolean canMoverForward(Position position, Orientation orientation);

    String displayFinalPosition();





}
