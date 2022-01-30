import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class FirstTestCase {

    private static final Logger LOGGER = LogManager.getLogger(FirstTestCase.class);

    @Test(priority = 1)
    void setup() {
        LOGGER.info("Opening browser");
    }

    @Test(priority = 2)
    void login() {
        LOGGER.info("This is a login test");
    }

    @Test(priority = 3)
    void teardown(){
        LOGGER.info("Closing browser");
    }
}
