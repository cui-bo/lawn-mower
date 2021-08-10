package com.bo.mower.lawnmover.services;

import com.bo.mower.lawnmover.enums.Order;
import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Position;
import com.bo.mower.lawnmover.utils.CustomConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.bo.mower.lawnmover.utils.CustomConstants.*;

@Service
@Slf4j
public class InstructionServiceImpl implements InstructionService {

    /**
     * Get lawn information from given file
     * <p>
     * example of input data :
     * 5 5
     * 0 0 N
     * <p>
     * example of return data :
     * 5 5
     *
     * @param inputData - first line in given file
     * @return - a string which contains lawn size
     * @throws BadFormatInputDataException
     * @throws MissingDataException
     */
    @Override
    public String getLawnInfo(String inputData) throws BadFormatInputDataException, MissingDataException {
        if (StringUtils.isBlank(inputData)) {
            throw new MissingDataException("[OrderServiceImpl][getLawnInfo] No input data");
        }

        if (!StringUtils.containsIgnoreCase(inputData, CustomConstants.LINE_SEPARATOR)) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getLawnInfo] bad format input data");
        }

        String[] inputLines = inputData.split(CustomConstants.LINE_SEPARATOR);

        if (StringUtils.isBlank(inputLines[0])) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getLawnInfo] found empty string for lawn");
        }

        // Get first line from input data which gives lawn information
        return inputLines[0];
    }

    /**
     * Get lawn size from given string
     * example of input data :
     * 5 5
     * example of return data :
     * an object Lawn
     *
     * @param lawnInfo - a string which contains lawn size
     * @return - object Lawn which contains lawn size
     * @throws BadFormatInputDataException
     * @throws MissingDataException
     */
    @Override
    public Lawn getLawnSize(String lawnInfo) throws BadFormatInputDataException, MissingDataException {
        if (StringUtils.isBlank(lawnInfo)) {
            throw new MissingDataException("[OrderServiceImpl][getLawnSize] No input data");
        }

        if (!StringUtils.containsIgnoreCase(lawnInfo, CustomConstants.FIELD_SEPARATOR)) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getLawnSize] bad format input data");
        }

        String[] fields = lawnInfo.split(CustomConstants.FIELD_SEPARATOR);
        if (fields.length != 2 || StringUtils.isBlank(fields[0]) || StringUtils.isBlank(fields[1])) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getLawnSize] cannot find lawn size");
        }

        return Lawn.builder()
                .width(NumberUtils.toInt(fields[0]))
                .height(NumberUtils.toInt(fields[1]))
                .build();
    }

    /**
     * Get initial position of a mover
     * <p>
     * example of input data :
     * 0 0 N
     * <p>
     * example of return data :
     * an object of Position which has mover coordinate
     *
     * @param inputData - string
     * @return - object Position which contains mover coordinate
     * @throws BadFormatInputDataException
     * @throws MissingDataException
     */
    @Override
    public Position getMoverInitPosition(String inputData) throws BadFormatInputDataException, MissingDataException {
        if (StringUtils.isBlank(inputData)) {
            throw new MissingDataException("[OrderServiceImpl][getMoverInitPosition] No input data");
        }

        if (!StringUtils.containsIgnoreCase(inputData, CustomConstants.FIELD_SEPARATOR)) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getMoverInitPosition] bad format input data");
        }

        String[] fields = inputData.split(CustomConstants.FIELD_SEPARATOR);
        if (fields.length < 2 || StringUtils.isBlank(fields[0]) || StringUtils.isBlank(fields[1])) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getMoverInitPosition] cannot find position");
        }

        return Position.builder()
                .x(NumberUtils.toInt(fields[0]))
                .y(NumberUtils.toInt(fields[1]))
                .build();
    }

    /**
     * Get initial orientation of a mover
     * <p>
     * example of input data :
     * 0 0 N
     * <p>
     * example of return data :
     * an object of Orientation which contains mover orientation which is North in example
     *
     * @param inputData - string
     * @return - object Orientation which contains mover orientation
     * @throws BadFormatInputDataException
     * @throws MissingDataException
     */
    @Override
    public Orientation getMoverInitOrientation(String inputData) throws BadFormatInputDataException, MissingDataException {
        if (StringUtils.isBlank(inputData)) {
            throw new MissingDataException("[OrderServiceImpl][getMoverInitOrientation] No input data");
        }

        if (!StringUtils.containsIgnoreCase(inputData, CustomConstants.FIELD_SEPARATOR)) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getMoverInitOrientation] bad format input data");
        }

        String[] fields = inputData.split(CustomConstants.FIELD_SEPARATOR);
        if (fields.length < 2 || StringUtils.isBlank(fields[2])) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getMoverInitOrientation] cannot find direction");
        }

        switch (fields[2]) {
            case ORIENTATION_NORTH:
                return Orientation.N;
            case ORIENTATION_SOUTH:
                return Orientation.S;
            case ORIENTATION_EAST:
                return Orientation.E;
            case ORIENTATION_WEST:
                return Orientation.W;
            default:
                return null;
        }
    }

    /**
     * Get list of command for mover
     *
     * <p>
     * example of input data :
     * GAGAA
     * <p>
     * example of return data :
     * Orders :
     * turn left
     * forward
     * turn left
     * forward twice
     *
     * @param inputData - string
     * @return - list of objects Order which contains the orders of mover
     * @throws BadFormatInputDataException
     * @throws MissingDataException
     */
    @Override
    public List<Order> getOrders(String inputData) throws MissingDataException, BadFormatInputDataException {
        if (StringUtils.isBlank(inputData)) {
            throw new MissingDataException("[OrderServiceImpl][getOrders] Missing input data");
        }
        if (!StringUtils.isAlpha(inputData)) {
            throw new BadFormatInputDataException("[OrderServiceImpl][getOrders] Bad format input data");
        }

        List<Order> orders = new ArrayList<>();
        int i = 0;
        while (i < inputData.length()) {
            switch (Character.toString(inputData.charAt(i))) {
                case ORDER_FORWARD:
                    orders.add(Order.A);
                    break;
                case ORDER_LEFT:
                    orders.add(Order.G);
                    break;
                case ORDER_RIGHT:
                    orders.add(Order.D);
                    break;
                default:
                    return null;
            }
            i++;
        }
        return orders;
    }


}
