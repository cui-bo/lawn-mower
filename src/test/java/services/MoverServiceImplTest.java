package services;

import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.services.MoverServiceImpl;
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

    @DisplayName("test getMoverNumber without input data")
    @Test
    void getMoverNumberTest1() {
        try {
            moverService.getMoverNumber("");
        } catch (MissingDataException e) {
            assertEquals("[OrderServiceImpl][getMoverNumber] Missing input data", e.getMessage());
        }
    }

    @DisplayName("test getMoverNumber with input data finished by \n")
    @Test
    void getMoverNumberTest2() {
        try {
            Integer result = moverService.getMoverNumber("5 5\n1 1 N\nGADAGA\n2 2 N\nGADAGA\n");
            assertEquals(2, result);
        } catch (MissingDataException e) {
            fail();
        }
    }

    @DisplayName("test getMoverNumber with input data not finished by \n")
    @Test
    void getMoverNumberTest3() {
        try {
            Integer result = moverService.getMoverNumber("5 5\n1 1 N\nGADAGA\n1 1 N\nGADAGA");
            assertEquals(2, result);
        } catch (MissingDataException e) {
            fail();
        }
    }
}
