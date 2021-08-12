package com.bo.mower.lawnmover.services;

import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Position;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import static com.bo.mower.lawnmover.utils.CustomConstants.LINE_SEPARATOR;

@Service
@Slf4j
public class MoverServiceImpl implements MoverService {


    @Override
    public String launch(String inputData) throws MissingDataException {


        // Get lawn

        // Get movers

        // Execute orders by each mover

        // Check if mover can forward

        // Print final position of mover

        return "";
    }

    @Override
    public Position startMover() {

        return null;
    }

    @Override
    public Orientation calculateOrientation() {
        return null;
    }

    @Override
    public Boolean canMoverForward(Lawn lawn, Position position, Orientation orientation) throws MissingDataException {
        if (null == lawn || null == position || null == orientation) {
            throw new MissingDataException("[MoverService][canMoverForward] Missing parameters");
        }

        return (position.getX() == 0 && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.W.getLabel()))
                || (position.getY() == 0 && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.S.getLabel()))
                || (position.getX() == lawn.getWidth() && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.E.getLabel())
                || (position.getY() == lawn.getHeight() && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.N.getLabel()))
        );
    }

    @Override
    public String displayFinalPosition() {
        return null;
    }

}
