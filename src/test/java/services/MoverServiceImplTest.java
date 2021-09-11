package services;

import com.bo.mower.lawnmover.enums.Order;
import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Mover;
import com.bo.mower.lawnmover.models.Position;
import com.bo.mower.lawnmover.services.InstructionServiceImpl;
import com.bo.mower.lawnmover.services.MoverServiceImpl;
import com.bo.mower.lawnmover.utils.DataReaderUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.MethodOverride;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MoverServiceImpl.class)
class MoverServiceImplTest {

    @Autowired
    MoverServiceImpl moverService;

    @MockBean
    InstructionServiceImpl instructionService;

    @DisplayName("test launch")
    @Test
    void launchTest1() throws BadFormatInputDataException, MissingDataException {
        Order order = Order.A;
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        Mover mover = Mover.builder()
                .orders(orders)
                .position(Position.builder().x(0).y(0).build())
                .orientation(Orientation.E)
                .build();
        List<Mover> movers = new ArrayList<>();
        movers.add(mover);

        when(instructionService.getLawnInfo(anyString())).thenReturn("");
        when(instructionService.getLawnSize(anyString())).thenReturn(new Lawn(2, 2));
        when(instructionService.getMovers(anyString())).thenReturn(movers);

        try {
            String finalPosition = moverService.launch("input data");
            assertEquals("1 1 E", finalPosition);
        } catch (Exception e) {
            fail();
        }
    }

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
