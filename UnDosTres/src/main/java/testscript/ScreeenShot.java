package testscript;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreeenShot {
	static int number=0;

	public ScreeenShot(ChromeDriver driver,String testcase) throws Exception{

		String file="D:\\Screenshots\\eclipse-workspace\\eclipse-workspace\\AutomationforAliExpress\\src\\main\\java\\Screenshots\\";
		String extension=".png";
		String filename=file+testcase+extension;
		this.takeSnapShot(driver, filename) ;     

	}

	/**

	 * This function will take screenshot

	 * @param webdriver

	 * @param fileWithPath

	 * @throws Exception

	 */

	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(fileWithPath);

		//Copy file at destination

		Files.copy(SrcFile, DestFile);

	}

}