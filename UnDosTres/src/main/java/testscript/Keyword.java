package testscript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author Nifa
 *
 */
public class Keyword {
	static ChromeDriver driver ;
	static Properties prop;
	static  WebDriverWait wait;
	static WebElement tempdata;
	/**
	 * openbrowser() is to set configuration of a browser
	 * @throws Exception
	 */

	public String openbrowser()throws Exception{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Eclipse\\Jar\\chromedriver_win32_latest\\chromedriver.exe");
		Reporter.log("Opening Browser");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		FileInputStream ffile=new FileInputStream("D://Screenshots//eclipse-workspace//eclipse-workspace//AutomationforAliExpress//src//main//java//properties//UnDosTres.properties");
		prop=new Properties();
		prop.load(ffile);
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return "retruning check";
	}
	/**
	 * implicitWait() methods inbuild wait for a field
	 */
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * navigate() method is to get the url
	 * @param datas
	 * @param testcase 
	 */

	public void navigate(String datas, String testcase) throws Exception{
		System.out.println("Getting into website");
		driver.get(datas);
		new ScreeenShot(driver,testcase);
		System.out.println("Screenshot is taken");

	}
	/**
	 * action() is to move mouse pointer to specific location and perform click
	 * @param datas
	 * @param objectName
	 * @param testcase 
	 */

	public void action(String datas, String objectName, String testcase) {
		System.out.println("Inside Action class radiobutton click");
		Actions act=new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/td/label")));
		tempdata=driver.findElement(By.xpath("//table/tbody/tr[1]/td/label"));
		act.moveToElement(tempdata).click(tempdata).perform();
		System.out.println("Radiobutton is selected ");
	}
	/**
	 * input() is to enter input into the field 
	 * @param datas
	 * @param objectName
	 * @param testcase 
	 */

	public void input(String datas, String objectName, String testcase) {		
		if(objectName.contains("ele")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(objectName))));
		}
		System.out.println("Inside input");
		System.out.println(prop.getProperty(objectName)+ "input is :"+datas);
		tempdata=driver.findElement(By.xpath(prop.getProperty(objectName)));
		tempdata.sendKeys(datas);
		System.out.println("Input is written");
	}
	/**
	 * inputtab() is to enter input into the field and press TAB 
	 * @param datas
	 * @param objectName
	 * @param testcase 
	 */

	public void inputtab(String datas, String objectName, String testcase) {		
		System.out.println("Inside inputtab");
		tempdata=driver.findElement(By.xpath(prop.getProperty(objectName)));
		tempdata.sendKeys(datas);
		tempdata.sendKeys(Keys.TAB);
		System.out.println("Input is written");
	}

	/**
	 * click() method is used to click actions with and without explicit wait handling for 10 seconds
	 * @param objectName
	 * @param testcase 
	 * @throws Exception
	 */

	public void click(String objectName, String testcase) throws Exception {
		if(objectName.contains("vis")) {
			System.out.println("wait visiblity is verified ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(objectName))));
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		}else if (objectName.contains("ele")) {
			System.out.println("wait clickable is verified ");
			new ScreeenShot(driver,testcase);
			System.out.println("Screenshot is taken");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(objectName))));
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		}
		else if(objectName.contains("pre")) {
			System.out.println("wait presence is verified ");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(objectName))));	      
	        driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		}
		else  
		{
			System.out.println("without explicit wait ");
			new ScreeenShot(driver,testcase); 
			System.out.println("Screenshot is taken");
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		}
	}
	/**
	 * verifyTitle() method used to verify title by assert
	 * @param objectName 
	 * @return
	 */

	public String verifyTitle(String objectName) {
		wait.until(ExpectedConditions.urlContains(objectName));
		System.out.println("verify Title::::"+driver.getCurrentUrl());
		return driver.getCurrentUrl();	
	}
	/**
	 * enter() method is to Automate click on I'm not a robot Google captcha 
	 * @param objectName
	 * @param testcase 
	 * @throws Exception 
	 */
	public void enter(String objectName, String testcase) throws Exception {
		// TODO Auto-generated method stub
		Actions builder=new Actions(driver);
        builder.sendKeys(Keys.ENTER).perform();
		new ScreeenShot(driver,testcase);
		System.out.println("Screenshot is taken");		
		System.out.println("Captcha is handled  ");
	}
	
	public void screenshot(String testcase) throws Exception
	{
		System.out.println("Taking last Screenshot");
		new ScreeenShot(driver,testcase); 
		System.out.println("Screenshot is taken");
	}
	/**
	 * verifyText() method is to Verify if the user gets a success message and recharge gets successful
	 * @param objectName
	 * @return 
	 * @throws Exception 
	 */

	public String verifyText(String testcase,String datas,String objectName) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * wait.until(ExpectedConditions.textToBe(By.xpath(prop.getProperty(objectName))
		 * , datas)); System.out.println("Taking last Screenshot"); new
		 * ScreeenShot(driver,testcase); System.out.println("Screenshot is taken");
		 */
		return driver.findElement(By.xpath(prop.getProperty(objectName))).getText();
		
	}
}

