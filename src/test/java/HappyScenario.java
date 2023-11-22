import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HappyScenario  {

    public static WebDriver driver;
    HappyScenario()
    {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
    }
    public static void main(String[] args) throws InterruptedException {
        Shopping obj = new Shopping();
        Shopping.CreateNewAccount();
        Thread.sleep(5000);
        Shopping.AddTeesToCart();
        Shopping.MoveToGear();
        Shopping.AddFitnessToCart();
        Shopping.MoveToCart();
        Thread.sleep(20000);
        Shopping.AddShippingAdd();
        Shopping.FinishOrder();
    }


}
