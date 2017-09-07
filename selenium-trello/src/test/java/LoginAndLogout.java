import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;


public class LoginAndLogout {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void LoginAndLogout() {
        wd.get("https://trello.com/");
        wd.findElement(By.linkText("Войти")).click();
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("akiva.ein@gmail.com");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("QwertY613");
        wd.findElement(By.id("login")).click();
        wd.findElement(By.cssSelector("img.member-avatar")).click();
        wd.findElement(By.linkText("Выйти")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
