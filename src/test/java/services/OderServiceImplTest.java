package services;

import com.bo.mower.lawnmover.enums.Order;
import com.bo.mower.lawnmover.enums.Orientation;
import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.models.Lawn;
import com.bo.mower.lawnmover.models.Position;
import com.bo.mower.lawnmover.services.InstructionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(classes = InstructionServiceImpl.class)
class OderServiceImplTest {
    @Autowired
    InstructionServiceImpl orderService;

    @DisplayName("test getLawnInfo when given empty parameter should throw exception")
    @Test
    void getLawnInfoTest1() {
        try {
            orderService.getLawnInfo("");
        } catch (MissingDataException e) {
            assertEquals("[OrderServiceImpl][getLawnInfo] No input data", e.getMessage());
        } catch (BadFormatInputDataException e) {
            fail();
        }
    }

    @DisplayName("test getLawnInfo when given good parameter should return lawn information")
    @Test
    void getLawnInfoTest2() throws BadFormatInputDataException, MissingDataException {
        assertEquals("5 5", orderService.getLawnInfo("5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA"));
    }

    @DisplayName("test getLawnInfo when given bad parameter should throw exception")
    @Test
    void getLawnInfoTest3() {
        try {
            orderService.getLawnInfo("5 5 1 2 N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getLawnInfo] bad format input data", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getLawnInfo when lawn information is not given should throw exception")
    @Test
    void getLawnInfoTest4() {
        try {
            orderService.getLawnInfo("\n1 2 N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getLawnInfo] found empty string for lawn", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getLawnSize when lawn information is not given should throw exception")
    @Test
    void getLawnSizeTest1() {
        try {
            orderService.getLawnSize("");
        } catch (MissingDataException e) {
            assertEquals("[OrderServiceImpl][getLawnSize] No input data", e.getMessage());
        } catch (BadFormatInputDataException e) {
            fail();
        }
    }

    @DisplayName("test getLawnSize when lawn width is not given should throw exception")
    @Test
    void getLawnSizeTest2() {
        try {
            orderService.getLawnSize(" 5");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getLawnSize] cannot find lawn size", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getLawnSize when lawn height is not given should throw exception")
    @Test
    void getLawnSizeTest3() {
        try {
            orderService.getLawnSize("5 ");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getLawnSize] cannot find lawn size", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getLawnSize when lawn information has bad format should throw exception")
    @Test
    void getLawnSizeTest4() {
        try {
            orderService.getLawnSize("55");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getLawnSize] bad format input data", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getLawnSize when given good input data should return lawn width and height")
    @Test
    void getLawnSizeTest5() {
        try {
            Lawn result = orderService.getLawnSize("5 5");
            assertEquals(5, result.getWidth());
            assertEquals(5, result.getHeight());
        } catch (BadFormatInputDataException | MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitPosition when input data is not given should throw exception")
    @Test
    void getMoverInitPositionTest1() {
        try {
            orderService.getMoverInitPosition("");
        } catch (MissingDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitPosition] No input data", e.getMessage());
        } catch (BadFormatInputDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitPosition when first field is not given should throw exception")
    @Test
    void getMoverInitPositionTest2() {
        try {
            orderService.getMoverInitPosition(" 5 N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitPosition] cannot find position", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitPosition when first field is not given should throw exception")
    @Test
    void getMoverInitPositionTest3() {
        try {
            orderService.getMoverInitPosition("5  N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitPosition] cannot find position", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitPosition when input data has bad format should throw exception")
    @Test
    void getMoverInitPositionTest4() {
        try {
            orderService.getMoverInitPosition("55N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitPosition] bad format input data", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitPosition when given good input data should return init position")
    @Test
    void getMoverInitPositionTest5() {
        try {
            Position result = orderService.getMoverInitPosition("5 5 N");
            assertEquals(5, result.getX());
            assertEquals(5, result.getY());
        } catch (BadFormatInputDataException | MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitOrientation when input data is not given should throw exception")
    @Test
    void getMoverInitOrientationTest1() {
        try {
            orderService.getMoverInitOrientation("");
        } catch (MissingDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitOrientation] No input data", e.getMessage());
        } catch (BadFormatInputDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitOrientation when first field is not given should throw exception")
    @Test
    void getMoverInitOrientationTest2() {
        try {
            orderService.getMoverInitOrientation(" 5 N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitOrientation] cannot find position", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitOrientation when first field is not given should throw exception")
    @Test
    void getMoverInitOrientationTest3() {
        try {
            orderService.getMoverInitOrientation("5  N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitOrientation] cannot find position", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitOrientation when input data has bad format should throw exception")
    @Test
    void getMoverInitOrientationTest4() {
        try {
            orderService.getMoverInitOrientation("55N");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getMoverInitOrientation] bad format input data", e.getMessage());
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverInitOrientation when given good input data should return init orientation")
    @Test
    void getMoverInitOrientationTest5() {
        try {
            Orientation result = orderService.getMoverInitOrientation("5 5 N");
            assertEquals("NORTH", result.getLabel());
        } catch (BadFormatInputDataException | MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getOrders when input data is not given should throw exception")
    @Test
    void getOrdersTest1() {
        try {
            orderService.getOrders("");
        } catch (MissingDataException e) {
            assertEquals("[OrderServiceImpl][getOrders] Missing input data", e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @DisplayName("test getOrders when parameters contain not only letters")
    @Test
    void getOrdersTest2() {
        try {
            orderService.getOrders("5GA");
        } catch (BadFormatInputDataException e) {
            assertEquals("[OrderServiceImpl][getOrders] Bad format input data", e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @DisplayName("test getOrders when given good input data should return list of orders")
    @Test
    void getOrdersTest3() {
        try {
            List<Order> result = orderService.getOrders("GADA");
            assertEquals("GAUCHE", result.get(0).getLabel());
            assertEquals(-90, result.get(0).getAngle());
            assertEquals("AVANCER", result.get(1).getLabel());
            assertEquals(0, result.get(1).getAngle());
            assertEquals("DROITE", result.get(2).getLabel());
            assertEquals(90, result.get(2).getAngle());
            assertEquals("AVANCER", result.get(3).getLabel());
            assertEquals(0, result.get(3).getAngle());
        } catch (BadFormatInputDataException | MissingDataException e) {
            fail();
        }
    }
}
