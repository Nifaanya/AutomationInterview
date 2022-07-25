import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @AfterClass
  public void afterClass() {
  }

  @AfterTest
  public void afterTest() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
