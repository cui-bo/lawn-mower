package com.bo.mower.lawnmover.services;

import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Position;
import com.bo.mower.lawnmover.utils.CustomConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import static com.bo.mower.lawnmover.utils.CustomConstants.LINE_SEPARATOR;

@Service
@Slf4j
public class MoverServiceImpl implements MoverService {


    @Override
    public void launch() {

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
    public Boolean isMoverBlocked() {
        return null;
    }

    @Override
    public Integer getMoverNumber(String inputData) throws MissingDataException {
        if (StringUtils.isBlank(inputData)) {
            throw new MissingDataException("[OrderServiceImpl][getMoverNumber] Missing input data");
        }

        int lineSepNumbers = StringUtils.countMatches(inputData, LINE_SEPARATOR);

        return (int) Math.ceil(lineSepNumbers >> 1);
    }
}
