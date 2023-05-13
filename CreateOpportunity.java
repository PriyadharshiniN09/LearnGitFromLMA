package week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("BootcampSel$123");
        driver.findElement(By.xpath("//input[@id ='Login']")).click();
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[@title ='Manage your sales process with accounts, leads, opportunities, and more']")).click();  
        WebElement opp =  driver.findElement(By.xpath("//a[@title='Opportunities']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", opp);
        driver.findElement(By.xpath("//div[@title='New']")).click();
        driver.findElement(By.xpath("//label[text()='Opportunity Name']/following-sibling::div/input")).sendKeys("Salesfoce Automation By PriyaDhar");
        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("2/28/2022");
        WebElement stage =  driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//button"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", stage);
        WebElement stageopt = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
        JavascriptExecutor executor3 = (JavascriptExecutor)driver;
        executor3.executeScript("arguments[0].click();", stageopt);
        WebElement save =driver.findElement(By.xpath("//button[@name='SaveAndNew']"));
        JavascriptExecutor executor4 = (JavascriptExecutor)driver;
        executor4.executeScript("arguments[0].click();", save);
//        @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")));
        String name = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(name);
        boolean b = name.equals("Opportunity \"Salesfoce Automation By PriyaDhar\" was created.");
        if (b) {
        	System.out.println("Opportunity is created");
        }
        else {
        	System.out.println("Opportunity is not created");
        }
	}

}
