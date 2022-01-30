import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class PriorityExample {
    private static final Logger LOGGER = LogManager.getLogger(PriorityExample.class);

    @Test(priority = 0)
    void TestOne() {
        LOGGER.info("This is Test1");
    }

    @Test(priority = 1)
    void TestTwo() {
        LOGGER.info("This is Test2");
    }

    @Test(priority = 2)
    void TestThree() {
        LOGGER.info("This is Test3");
    }

    @Test(priority = 3, enabled = false)
    void TestFour() {
        LOGGER.info("This is Test4");
    }
}
