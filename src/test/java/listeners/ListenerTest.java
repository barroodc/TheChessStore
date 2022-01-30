package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.CustomListeners.class)
public class ListenerTest {

    private static final Logger LOGGER = LogManager.getLogger(ListenerTest.class);

    @Test
    void test1() {
        LOGGER.info("This is test1");
        Assert.assertEquals("A","A");
    }

    @Test
    void test2() {
        LOGGER.info("This is test2");
        Assert.assertEquals("A","B");
    }

    @Test
    void test3() {
        LOGGER.info("This is test3");
        Assert.assertEquals("A","B");
        throw new SkipException("This is skip exception...");
    }

}
