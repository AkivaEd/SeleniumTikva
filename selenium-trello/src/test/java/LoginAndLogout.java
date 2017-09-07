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
        openSite();
        goToTheLoginFormWithClickButtonLogin();
        fillFormsLoginUserAndPassword();
        clickButtonLoginInTheFormLogin();
        openOptionsForUserAccaunt();
        clickButtonLogout();
    }

    public void clickButtonLogout() {
        wd.findElement(By.linkText("Выйти")).click();
    }

    public void openOptionsForUserAccaunt() {
        wd.findElement(By.cssSelector("img.member-avatar")).click();
    }

    public void clickButtonLoginInTheFormLogin() {
        wd.findElement(By.id("login")).click();
    }

    public void fillFormsLoginUserAndPassword() {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("akiva.ein@gmail.com");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("QwertY613");
    }

    public void goToTheLoginFormWithClickButtonLogin() {
        wd.findElement(By.linkText("Войти")).click();
    }

    public void openSite() {
        wd.get("https://trello.com/");
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
