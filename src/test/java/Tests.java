import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static WebDriver driver;

    @AfterEach
    void Quit()
    {
        driver.quit();
    }

    @BeforeEach
     void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
    }

    @AfterAll
    static void closeDriver() {
        driver.quit();
    }


    @ParameterizedTest
    @DisplayName("Login with valid and invalid data")
    @CsvSource(value = {"abdelrahman1234@yahoo.com,12345678910Abdelrahman" , "ahmed@yahoo.com,102030504052"})
    void TestLogin(String param1, String param2){
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));
        email.sendKeys(param1);
        pass.sendKeys(param2);
        driver.findElement(By.id("send2")).click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";
        assertEquals(actualTitle, expectedTitle);
    }

    @Test
    @DisplayName("create new account")
    void TestNewAcc()
    {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
        WebElement first = driver.findElement(By.id("firstname"));
        first.sendKeys("abdelrahman");
        WebElement last = driver.findElement(By.id("lastname"));
        last.sendKeys("mohamed");
        WebElement email = driver.findElement(By.id("email_address"));
        Random rand = new Random();
        String randInt = String.valueOf(rand.nextInt(10000));
        String randEmail = "abdelrahman" + randInt + "@yahoo.com";
        email.sendKeys(randEmail);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("12345678910Abdelrahman");
        WebElement password_confirmation = driver.findElement(By.id("password-confirmation"));
        password_confirmation.sendKeys("12345678910Abdelrahman");
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
        submit.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "My Account";
        assertEquals(actualTitle, expectedTitle);
    }

}
