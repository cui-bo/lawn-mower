package com.bo.mower.lawnmover.services;

import com.bo.mower.lawnmover.enums.Order;
import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Position;

import java.util.List;

public interface OrderService {

    // Get lawn's information from input data
    String getLawnInfo(String inputData) throws BadFormatInputDataException, MissingDataException;

    // Get lawn's width and height
    Lawn getLawnSize(String inputData) throws BadFormatInputDataException, MissingDataException;

    // Get mover initial position (x,y)
    Position getMoverInitPosition(String inputData) throws BadFormatInputDataException, MissingDataException;

    // Get mover initial orientation
    Orientation getMoverInitOrientation(String inputData) throws BadFormatInputDataException, MissingDataException;

    // Get orders from input data
    List<Order> getOrders(String inputData) throws BadFormatInputDataException, MissingDataException;
}