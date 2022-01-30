import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData(){
        Object[][] data = {{"abc@gmail.com", "abcPassword"}, {"xyz@gmail.com", "xyzPassword"}, {"mno@gmail.com", "mnoPassword"}};
        return data;
    }
}
