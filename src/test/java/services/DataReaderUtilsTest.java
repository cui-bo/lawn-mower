package services;

import com.bo.mower.lawnmover.utils.DataReaderUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DataReaderUtils.class)
class DataReaderUtilsTest {

    @DisplayName("test getDataFromFile when parameter is missing")
    @Test
    void getDataFromFileTest1() {
        try {
            DataReaderUtils.getDataFromFile("");
        } catch (IOException e) {
            assertTrue(e.getMessage().contains("Error of reading input file"));
        }
    }


    @DisplayName("test getDataFromFile with given data file")
    @Test
    void getDataFromFileTest2() {
        try {
            String result = DataReaderUtils.getDataFromFile("data.txt");
            assertEquals("5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA", result);
        } catch (IOException e) {
            fail();
        }
    }
}
