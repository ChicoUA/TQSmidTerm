package pt.ua.tqs.air_polution_project;

import org.junit.jupiter.api.*;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class FuncionalTest {
	
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test() {
    driver.get("http://localhost:8080/greeting");
    driver.manage().window().setSize(new Dimension(1092, 790));
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Aveiro");
    driver.findElement(By.id("country")).click();
    driver.findElement(By.id("country")).sendKeys("PT");
    driver.findElement(By.cssSelector("p:nth-child(3) > input:nth-child(1)")).click();
    driver.findElement(By.cssSelector("p:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("City Name: Aveiro"));
    driver.findElement(By.cssSelector("p:nth-child(3)")).click();
    driver.findElement(By.linkText("Search other city")).click();
  }
}
