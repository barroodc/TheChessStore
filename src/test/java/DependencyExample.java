import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyExample {
    private static final Logger LOGGER = LogManager.getLogger(DependencyExample.class);

    @Test
    void startCar() {
        LOGGER.info("Car started");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})
    void driveCar() {
        LOGGER.info("Car driving");
    }

    @Test(dependsOnMethods = {"driveCar"})
    void stopCar() {
        LOGGER.info("Car stopped");
    }

    @Test(dependsOnMethods = {"driveCar","stopCar"}, alwaysRun = true)
    void parkCar() {
        LOGGER.info("Car parked");
    }

}
