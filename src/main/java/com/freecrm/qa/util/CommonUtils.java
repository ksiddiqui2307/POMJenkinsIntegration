package com.freecrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.qa.basesetup.BaseSetup;

public class CommonUtils extends BaseSetup {

	public void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}

	public static void takeScreenshotAtEndOfTest() throws IOException{
		// TODO Auto-generated method stub
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currDir=System.getProperty("user.dir");
		
		FileUtils.copyFile(srcFile,new File(currDir+"/Screenshots/"+System.currentTimeMillis()+".png"));
		
	}
	
	
}
