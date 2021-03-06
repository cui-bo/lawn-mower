package com.bo.mower.lawnmover.services;

import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Mover;
import com.bo.mower.lawnmover.models.Position;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class MoverServiceImpl implements MoverService {

    @Autowired
    InstructionServiceImpl instructionService;

    @Override
    public String launch(String inputData) throws MissingDataException, BadFormatInputDataException {

        // Get lawn
        Lawn lawn = instructionService.getLawnSize(instructionService.getLawnInfo(inputData));

        // Get movers
        List<Mover> movers = instructionService.getMovers(inputData);

        List<String> outputStrList = new ArrayList<>();

        // Execute orders by each mover
        movers.forEach(mover -> {
            for (int i = 0; i < mover.getOrders().size(); i++) {
                try {
                    if (canMoverForward(lawn, mover.getPosition(), mover.getOrientation())) {
                        log.info("[MoverService][launch] Mover will forward");
                        // update mover's position and orientation
                        // TODO
                        updateMover(mover, calculatePosition(), calculateOrientation());
                        if(i == mover.getOrders().size()-1) {
                            // get mover's final position
                            String moverFinalPosition = printFinalStatus(mover);
                            // we could print mover's final position here or at the end of function or in the controller
                            outputStrList.add(moverFinalPosition);
                        }
                    }
                } catch (MissingDataException e) {
                    e.printStackTrace();
                }
            }
        });

        // Print final position of mover
        return String.join("\n", outputStrList);
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
    public Position calculatePosition() {
        return null;
    }

    @Override
    public Boolean canMoverForward(Lawn lawn, Position position, Orientation orientation) throws MissingDataException {
        if (null == lawn || null == position || null == orientation) {
            throw new MissingDataException("[MoverService][canMoverForward] Missing parameters");
        }

        return !((position.getX() == 0 && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.W.getLabel()))
                || (position.getY() == 0 && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.S.getLabel()))
                || (position.getX() == lawn.getWidth() && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.E.getLabel())
                || (position.getY() == lawn.getHeight() && StringUtils.equalsIgnoreCase(orientation.getLabel(), Orientation.N.getLabel())))
        );
    }

    @Override
    public Mover updateMover(Mover mover, Position position, Orientation orientation) {
        if (null == position || null == orientation) {
            log.info("[MoverService][updateMover] Nothing to update");
            return mover;
        }
        mover.setOrientation(orientation);
        mover.setPosition(position);
        return mover;
    }

    @Override
    public String printFinalStatus(Mover mover) {
        return mover.getPosition().getX() +
                StringUtils.SPACE +
                mover.getPosition().getX() +
                StringUtils.SPACE +
                instructionService.transformOrientationToStr(mover.getOrientation());
    }

}
