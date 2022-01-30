import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class TC1 {
    private static final Logger LOGGER = LogManager.getLogger(TC1.class);

    @BeforeClass
    void beforeClass() {
        LOGGER.info("This will execute before the Class");
    }

    @AfterClass
    void afterClass() {
        LOGGER.info("This will execute after the Class");
    }

    @BeforeMethod
    void beforeMethod() {
        LOGGER.info("This will execute before every Method");
    }

    @AfterMethod
    void afterMethod() {
        LOGGER.info("This will execute after every Method");
    }

    @Test
    void test1() {
        LOGGER.info("This is test1...");
    }

    @Test
    void test2() {
        LOGGER.info("This is test2...");
    }

    @BeforeTest
    void beforeTest() {
        LOGGER.info("This will execute before the Test");
    }

    @AfterTest
    void afterTest() {
        LOGGER.info("This will execute after the Test");
    }
}
