package com.bo.mower.lawnmover.services;

import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
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
    public Boolean canMoverForward(Position position, Orientation orientation) {
        if (null == position || null == orientation) {
            log.warn("[MoverService][isMoverBlocked] Missing parameters");
            return false;
        }

        return (position.getX() == 0 && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.W.getLabel()))
                || (position.getY() == 0 && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.S.getLabel()));
    }

    @Override
    public String displayFinalPosition() {
        return null;
    }

}
