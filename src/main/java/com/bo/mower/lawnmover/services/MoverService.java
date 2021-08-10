package com.bo.mower.lawnmover.services;


import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Position;

public interface MoverService {

    void launch();

    Position startMover();

    Orientation calculateOrientation();

    Boolean isMoverBlocked();


    // Get movers' number
    Integer getMoverNumber(String inputData) throws BadFormatInputDataException, MissingDataException;




}
