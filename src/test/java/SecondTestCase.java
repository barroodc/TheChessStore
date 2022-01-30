import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {
    private static final Logger LOGGER = LogManager.getLogger(SecondTestCase.class);

    @Test(priority = 1)
    void setup() {
        LOGGER.info("Opening browser");
    }

    @Test(priority = 3)
    void searchCustomer() {
        LOGGER.info("This is a search customer test");
        Assert.assertEquals(1,1);
    }

    @Test(priority = 2)
    void addCustomer() {
        LOGGER.info("This is a add customer test");
    }

    @Test(priority = 4)
    void teardown(){
        LOGGER.info("Closing browser");
    }
}
