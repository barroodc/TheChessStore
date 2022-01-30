import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class TC2 {

    private static final Logger LOGGER = LogManager.getLogger(TC2.class);

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
    void test3() {
        LOGGER.info("This is test3...");
    }

    @Test
    void test4() {
        LOGGER.info("This is test4...");
    }

    @BeforeSuite
    void beforeSuite() {
        LOGGER.info("This will execute before the Test Suite");
    }

    @AfterSuite
    void afterSuite() {
        LOGGER.info("This will execute after the Test Suite");
    }
}
