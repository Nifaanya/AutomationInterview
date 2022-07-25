package testscript;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;




/**
 * @author Nifa
 *
 */
@Test
public class ExecuteLeadTest {
	
	@Test
	public  void LeadTest() throws Exception {	
	//new Testupdatingintoexcel();
		ArrayList data=new ArrayList();
		Keyword key=new Keyword(); 
		FileInputStream fis=new FileInputStream("D://Screenshots//eclipse-workspace//eclipse-workspace//AutomationforAliExpress//src//main//java//testcases//TestcaseLeadSuite.xlsx");
		XSSFWorkbook work=new XSSFWorkbook(fis);
		Sheet s=work.getSheet("UnDosTres"); 
		Iterator itr=s.iterator();
		while(itr.hasNext()){
			Row r=(Row) itr.next();
			Iterator citr=r.iterator();
			//row iteration
			while(citr.hasNext())
			{			
				Cell c=(Cell) citr.next();
				switch(c.getCellType()){
				case STRING:
					data.add(c.getStringCellValue());
					break;
				case NUMERIC:
					data.add(c.getNumericCellValue());
					break;
				}
			}
		}
		
		/*
		 * for(int i=0;i<data.size();i++) { System.out.println("******  "+data.get(i));
		 * }
		 */
String a="";
		for(int i=0;i<data.size();i++){
			if(data.get(i).equals("openbrowser")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes"))
					System.out.println( key.openbrowser());
				}
			else if(data.get(i).equals("navigate")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String datas=String.valueOf(data.get(i+1));
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes"))
					key.navigate(datas,testcase);
			}
			else if(data.get(i).equals("action")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String datas=String.valueOf(data.get(i+1));
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.action(datas,objectName,testcase);}
			}else if(data.get(i).equals("input")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String datas=String.valueOf(data.get(i+1));
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.input(datas,objectName,testcase);}
			}
			else if(data.get(i).equals("inputtab")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String datas=String.valueOf( data.get(i+1));
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.inputtab(datas,objectName,testcase);}
			}
			else if(data.get(i).equals("click")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.click(objectName,testcase);}
			}
			else if(data.get(i).equals("enter")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.enter(objectName,testcase);}
			}
			else if(data.get(i).equals("verifyText")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String datas=String.valueOf(data.get(i+1));
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.screenshot(testcase);
					String actual=key.verifyText(testcase,datas,objectName);
					Assert.assertEquals(datas, actual);
				}
			}
			else if(data.get(i).equals("verifyTitle")){
				String testcase=String.valueOf(data.get(i-1));
				System.out.println(testcase);
				Reporter.log("*****"+testcase+"*****");
				String objectName=(String) data.get(i+2);
				String datas=String.valueOf(data.get(i+1));
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					String actual=key.verifyTitle(objectName);
					Assert.assertEquals(datas, actual);
				}}
		}


	}
}
