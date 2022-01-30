package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(CustomListeners.class);


    public void onStart(ITestContext arg) {
        LOGGER.info("Starts with test execution......... " + arg.getName());
    }

    public void onFinish(ITestContext arg) {
        LOGGER.info("Finish with test execution......... " + arg.getName());
    }

    public void onTestStart(ITestResult arg) {
        LOGGER.info("Starts test......... " + arg.getName());
    }

    public void onTestSkipped(ITestResult arg) {
        LOGGER.info("Skipped test......... " + arg.getName());
    }

    public void onTestSuccess(ITestResult arg) {
        LOGGER.info("Passed test......... " + arg.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg) {

    }
}
