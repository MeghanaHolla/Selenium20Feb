package com.webappsecurity.zero.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;
import com.webappsecurity.zero.Pages.TransferFundsConfirmation;
import com.webappsecurity.zero.Pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base{

	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
		
		String[][] data = GenericMethods.getData("D:\\SelJan23\\TestData.xlsx", "Sheet1");
		
		for(int i = 0;i<data.length;i++) {
			lp.applicationLogin(data[i][0], data[i][1]);
			driver.navigate().back();
			driver.navigate().to(data[i][2]);
			acc.clickTransferFunds();
			tf.doFundTransfer(data[i][3], data[i][4]);
			tfv.clickSubmit();
			String actualMsg = tfc.getConfMsg();
			String expectedMsg =data[i][5];
			Assert.assertEquals(actualMsg, expectedMsg);
			tfc.logoutFromApp();
		}
	}
}
