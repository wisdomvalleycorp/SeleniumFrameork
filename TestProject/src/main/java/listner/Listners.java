package listner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mycompanyTest.TestProject.BaseClass;

public class Listners extends BaseClass implements ITestListener {
	
	WebDriver driver = init();

	public void onTestStart(ITestResult result) {
		System.out.println("in test start : "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("in test success : "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()){
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(projectPath+"\\failedtest-screenshot\\"+result.getName()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("in test skipped : "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		System.out.println("in test finish : "+context.getName());
	}

}
