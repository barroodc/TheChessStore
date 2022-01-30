import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    private static final Logger LOGGER = LogManager.getLogger(DataProviderExample.class);

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = CustomDataProvider.class)
    public void loginTest(String email, String password) {
        LOGGER.info(email + "      " + password);
    }
}
