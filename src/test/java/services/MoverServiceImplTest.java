package services;

import com.bo.mower.lawnmover.services.MoverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MoverServiceImpl.class)
class MoverServiceImplTest {

    @Autowired
    MoverServiceImpl moverService;

}
