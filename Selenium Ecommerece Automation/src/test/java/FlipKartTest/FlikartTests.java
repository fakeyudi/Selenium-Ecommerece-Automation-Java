package FlipKartTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
// import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class FlikartTests {

    static WebDriver driver = new ChromeDriver();

    static void print(String str) {
        System.out.println(str);
    }

    @Test
    static void t01_flipKartTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("FlipKart Test Automation");
        driver.get("https://www.flipkart.com/");
        print("Launching FlipKart");
    }

    @Test
    static void t02_checkLogin(){
        print("Checking Login...");
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/span/span"));
        assert login.getText().equals("Login");
    }

    @Test
    static void t03_checkEmailField(){
        print("Checking Email Field...");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
        assert  emailField.isDisplayed();
    }

    @Test
    static void t04_checkPasswordField(){
        print("Checking Password Field...");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
        assert  passwordField.isDisplayed();
    }

    @Test
    static void t05_checkLoginButton(){
        print("Checking Login Button...");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button"));
        assert  loginButton.isDisplayed();
    }

    @Test
    static void t06_clickCloseButton(){
        print("Clicking Close Button...");
        WebElement closeButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
        closeButton.click();
    }

    @Test
    static void t07_checkCategoriesBanner(){
        print("Checking Categories Banner...");
        WebElement categoriesBanner = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div"));
        assert  categoriesBanner.isDisplayed();
    }

    @Test
    static void t08_clickMobiles(){
        print("Clicking Mobiles...");
        WebElement mobiles = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/a/div[2]"));
        mobiles.click();
    }

    @Test
    static void t09_clickFirstPhone(){
        print("Clicking First Phone...");
        WebElement firstPhone = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div[1]"));
        firstPhone.click();
    }

    @Test
    static void t10_checkFilters(){
        print("Checking Filters...");
        WebElement filters = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[1]/div/section[1]/div[1]/div[1]/span"));
        assert  filters.getText().equals("Filters");
    }

    @Test
    static void t11_updatePriceFilter(){
        print("Updating Price Filter...");
        WebElement price = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
        Select select = new Select(price);
        select.selectByVisibleText("₹20000");
    }

    @Test
    static void t12_checkNeedHelp(){
        print("Scrolling to Need Help...");
        driver.findElement(By.tagName("body")).sendKeys(Keys.END);
        print("Checking Need Help...");
        WebElement needHelp = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[2]/a/div[1]/span"));
        assert  needHelp.getText().equals("Need help?");
    }

}
