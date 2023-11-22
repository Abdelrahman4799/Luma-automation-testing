import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Shopping {
     public static WebDriver driver;
    Shopping()
    {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
    }

    public static void CreateNewAccount(){
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
    }

    public static void AddTeesToCart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[1]/div[2]/a[2]")).click();
        //size
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[1]/div/div[2]")).click();
        //color
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[2]/div/div[3]")).click();
        //add to cart
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[2]/div/div[3]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button")).click();
        Thread.sleep(1000);

        ////2
        //size
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div[1]/div/div[2]")).click();
        //color
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div[2]/div/div[3]")).click();
        //add to cart
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div[2]/div/div[3]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[4]/div/div[1]/form/button")).click();
        Thread.sleep(1000);
    }

    public static void MoveToGear() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[1]/div[1]/a[2]")).click();
    }

    public static void AddFitnessToCart()
    {
        Actions action = new Actions(driver);
        //1
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[3]"))).perform();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[3]/div/div/div[3]/div/div[1]/form/button")).click();

        //2
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[6]"))).perform();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[6]/div/div/div[3]/div/div[1]/form/button")).click();

        //3
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[9]"))).perform();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[9]/div/div/div[3]/div/div[1]/form/button")).click();
    }


    public static void MoveToCart() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
    }

    public static void AddShippingAdd() throws InterruptedException {
        driver.findElement(By.name("street[0]")).sendKeys("20 misr el gideda");
        driver.findElement(By.name("city")).sendKeys("Cairo");
        Select country = new Select(driver.findElement(By.name("country_id")));
        country.selectByIndex(25);
      //  driver.findElement(By.name("region_id")).sendKeys("Cairo");
        driver.findElement(By.name("postcode")).sendKeys("123456");
        driver.findElement(By.name("telephone")).sendKeys("10254851254");
        driver.findElement(By.name("ko_unique_1")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
    }

    public static void FinishOrder() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
        Thread.sleep(25000);
        driver.quit();
    }

}
