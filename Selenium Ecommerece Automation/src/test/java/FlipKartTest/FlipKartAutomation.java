package FlipKartTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlipKartAutomation {

    static void print(String str) {
        System.out.println(str);
    }
    static void flipKartTest() throws InterruptedException {
        System.out.println("FlipKart Test Automation");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        print("Launching FlipKart");
        assert checkLogin(driver);
        assert checkEmailField(driver);
        assert checkPasswordField(driver);
        assert checkLoginButton(driver);
        clickCloseButton(driver);
        assert checkCategoriesBanner(driver);
        clickMobiles(driver);
        print("Waiting for 5 seconds");
        Thread.sleep(5000);
        clickFirstPhone(driver);
        print("Waiting for 5 seconds");
        Thread.sleep(5000);
        assert checkFilters(driver);
        updatePriceFilter(driver);
        assert checkNeedHelp(driver);
        print("Waiting for 20 seconds");
        Thread.sleep(20000);
        driver.quit();
        driver.close();
    }

    static Boolean checkLogin(WebDriver driver){
        print("Checking Login...");
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/span/span"));
        return login.getText().equals("Login");
    }

    static Boolean checkEmailField(WebDriver driver){
        print("Checking Email Field...");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
        return emailField.isDisplayed();
    }

    static Boolean checkPasswordField(WebDriver driver){
        print("Checking Password Field...");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
        return passwordField.isDisplayed();
    }

    static Boolean checkLoginButton(WebDriver driver){
        print("Checking Login Button...");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button"));
        return loginButton.isDisplayed();
    }

    static void clickCloseButton(WebDriver driver){
        print("Clicking Close Button...");
        WebElement closeButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
        closeButton.click();
    }

    static Boolean checkCategoriesBanner(WebDriver driver){
        print("Checking Categories Banner...");
        WebElement categoriesBanner = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div"));
        return categoriesBanner.isDisplayed();
    }

    static void clickMobiles(WebDriver driver){
        print("Clicking Mobiles...");
        WebElement mobiles = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/a/div[2]"));
        mobiles.click();
    }

    static void clickFirstPhone(WebDriver driver){
        print("Clicking First Phone...");
        WebElement firstPhone = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div[1]"));
        firstPhone.click();
    }

    static Boolean checkFilters(WebDriver driver){
        print("Checking Filters...");
        WebElement filters = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[1]/div/section[1]/div[1]/div[1]/span"));
        return filters.getText().equals("Filters");
    }

    static void updatePriceFilter(WebDriver driver){
        print("Updating Price Filter...");
        WebElement price = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
        Select select = new Select(price);
        select.selectByVisibleText("₹20000");
    }

    static Boolean checkNeedHelp(WebDriver driver){
        print("Scrolling to Need Help...");
        driver.findElement(By.tagName("body")).sendKeys(Keys.END);
        print("Checking Need Help...");
        WebElement needHelp = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[2]/a/div[1]/span"));
        return needHelp.getText().equals("Need help?");
    }

    public static void main( String[] args ) throws InterruptedException {
        flipKartTest();
    }
}
