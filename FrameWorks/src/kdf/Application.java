package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

	@Test
	public void veirfyInvalidLogin() throws IOException {
		Methods mtd = new Methods();
		String[][] data = GenericMethods.getData("D:\\SelJan23\\TestData.xlsx", "Sheet2");
		
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApplication(data[i][6]);
				break;
			case "enterInTextBox":
				mtd.enterInTextBox(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				String actualMsg = mtd.getMsg(data[i][4],data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApp":
				mtd.closeApplication();
				break;
			}
		}
	}
}
