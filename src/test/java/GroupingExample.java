import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class GroupingExample {
    private static final Logger LOGGER = LogManager.getLogger(DependencyExample.class);

    @Test(groups = {"sanity"})
    void test1() {
        LOGGER.info("This is test1...");
    }

    @Test(groups = {"sanity"})
    void test2() {
        LOGGER.info("This is test2...");
    }

    @Test(groups = {"regression"})
    void test3() {
        LOGGER.info("This is test3...");
    }

    @Test(groups = {"regression"})
    void test4() {
        LOGGER.info("This is test4...");
    }

    @Test(groups = {"sanity","regression"})
    void test5() {
        LOGGER.info("This is test5...");
    }
}
