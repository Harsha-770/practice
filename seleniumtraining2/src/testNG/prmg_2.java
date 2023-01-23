package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class prmg_2 {
	@Test(dependsOnMethods = "register")
	public void createAnAccount() {
		Reporter.log("account created",true);
		
	}
	@Test(dependsOnMethods = "createAnAccount")
	public void amountTransfer() {
		Reporter.log("amount is transfer",true);
	}
	@Test(dependsOnMethods= {"register","createAnAccount"})
	public void deleteAccount() {
		Reporter.log("account is deleted",true);
	}
	@Test
	public void register() {
		Reporter.log("account is register",true);
	}
	@Test(dependsOnMethods = {"register","createAnAccount"})
	public void modifyAccount() {
		Reporter.log("account is modified",true);
	}
}
