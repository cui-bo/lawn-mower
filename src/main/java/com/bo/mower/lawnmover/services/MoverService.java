package com.bo.mower.lawnmover.services;


import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Mover;
import com.bo.mower.lawnmover.models.Position;

public interface MoverService {

    String launch(String inputData) throws MissingDataException, BadFormatInputDataException;

    Position startMover();

    Orientation calculateOrientation();

    Position calculatePosition();

    // Checking if mover is on the edge of the lawn
    Boolean canMoverForward(Lawn lawn, Position position, Orientation orientation) throws MissingDataException;

    // Update mover's situation
    Mover updateMover(Mover mover, Position position, Orientation orientation);

    String printFinalStatus(Mover mover);


}
