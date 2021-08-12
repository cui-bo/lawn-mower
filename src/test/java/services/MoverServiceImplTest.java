package services;

import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Position;
import com.bo.mower.lawnmover.services.MoverServiceImpl;
import javafx.geometry.Pos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(classes = MoverServiceImpl.class)
class MoverServiceImplTest {

    @Autowired
    MoverServiceImpl moverService;


    @DisplayName("test canMoverForward parameter lawn is null")
    @Test
    void canMoverForwardTest1() {
        try {
            moverService.canMoverForward(null, new Position(), Orientation.N);

        } catch (MissingDataException e) {
            assertEquals("[MoverService][canMoverForward] Missing parameters", e.getMessage());
        }
    }

    @DisplayName("test canMoverForward parameter position is null")
    @Test
    void canMoverForwardTest2() {
        try {
            moverService.canMoverForward(new Lawn(), null, Orientation.N);

        } catch (MissingDataException e) {
            assertEquals("[MoverService][canMoverForward] Missing parameters", e.getMessage());
        }
    }

    @DisplayName("test canMoverForward parameter orientation is null")
    @Test
    void canMoverForwardTest3() {
        try {
            moverService.canMoverForward(new Lawn(), new Position(), null);

        } catch (MissingDataException e) {
            assertEquals("[MoverService][canMoverForward] Missing parameters", e.getMessage());
        }
    }

    @DisplayName("test canMoverForward position x is 0 and orientation is W")
    @Test
    void canMoverForwardTest4() {
        Lawn lawn = Lawn.builder().height(2).width(2).build();
        Position position = Position.builder().x(2).y(1).build();

        try {
            moverService.canMoverForward(lawn, position, Orientation.W);

        } catch (MissingDataException e) {
            fail();
        }
    }

    // TODO test canMoverForward


}
