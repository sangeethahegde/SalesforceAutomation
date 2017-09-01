package salesForceAuto;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AutomationScripts extends ReUsableMethods{
	//public static WebDriver driver;

	@Test
	public static void SFDCLogin() throws Exception {

		//startReport("SFDCLoginReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport","Firefox");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		/* Launch a Browser*/
		/*System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");
		driver = new FirefoxDriver(); */

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);
		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		/*//actual data
		setValue(4);
		By byerror = getBy(locatorType,value);
		WebElement textError = driver.findElement(byerror);
		String actual = textError.getText();

		//Verify Result
		String expected=recData[1][4];
		result = verify(expected,actual);*/

		Update_Report("Pass","SFDC Launch and Login","Login succesfull",driver);
		result="Pass";


	}

	public static void clearPassword() throws IOException
	{
		//startReport("ClearPasswordReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(recData[1][1]);
		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);
		driver.findElement(byPassword).clear();

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Error message
		setValue(4);
		By errMes = getBy(locatorType,value);
		String actual=driver.findElement(errMes).getText();

		//testing purpose
		String expected="Hello";
		result=ReUsableMethods.verify(expected, actual);

		Update_Report(result,"Clear password","Password cleared",driver);

	}

	public static void checkRemeberMe() throws IOException, InterruptedException
	{
		//startReport("CheckRememberMe","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");

		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(recData[1][1]);
		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);

		//check remember me
		setValue(5);
		By byRememberMe = getBy(locatorType,value);
		boolean isChecked = driver.findElement(byRememberMe).isSelected();
		if(isChecked==false)
		{
			WebElement rememberMe = driver.findElement(byRememberMe);
			ReUsableMethods.clickButton(rememberMe, obj_Name);
		}


		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//UserMenu
		setValue(6);
		By userNav = getBy(locatorType,value);		
		WebElement userNameNav = driver.findElement(userNav);
		Thread.sleep(5000);
		ReUsableMethods.clickButton(userNameNav,obj_Name);

		//Logout
		setValue(7);
		By bylogout = getBy(locatorType,value);
		WebElement logout = driver.findElement(bylogout);
		ReUsableMethods.clickButton(logout, obj_Name);

		setValue(8);
		By byusername = getBy(locatorType,value);
		String selUsername=driver.findElement(byusername).getText();
		Update_Report("Pass",selUsername,"Username is displayed in username field",driver);

		result="Pass";
	}

	public static void forgotPassword() throws IOException
	{
		//startReport("ForgotPassword","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/ForgotPassword4A.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");

		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(recData[1][1]);
		//click forgot password
		setValue(9);
		By byForgotPassword = getBy(locatorType,value);
		WebElement forgotpassword = driver.findElement(byForgotPassword);
		ReUsableMethods.clickButton(forgotpassword, obj_Name);
		//Enter username
		setValue(10);
		By byFPUsername = getBy(locatorType,value);
		WebElement sendUsername = driver.findElement(byFPUsername);
		ReUsableMethods.enterText(sendUsername, recData[1][2], obj_Name);
		//Click on continue
		setValue(11);
		By byContinue = getBy(locatorType,value);
		WebElement continuebut = driver.findElement(byContinue);
		ReUsableMethods.clickButton(continuebut, obj_Name);

		result="Pass";
	}

	public static void wrongUsernameAndWrongPassword() throws IOException
	{
		//startReport("WrongUsernameAndWrongPasswordReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/ForgotPassword4B.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);
		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Error message
		setValue(4);
		By errMes = getBy(locatorType,value);
		String mes=driver.findElement(errMes).getText();

		Update_Report("Pass","Give wrong username and password",mes,driver);

		result="Pass";

	}


	public static void userMenuDropdown() throws IOException, InterruptedException
	{
		//startReport("UserMenuDropdownReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/UserMenuDropdown.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String[] expected=recData[1][4].split(",");

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);
		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		Thread.sleep(5000);
		//Click on userMenu Dropdown
		setValue(6);
		By userNav = getBy(locatorType,value);	
		WebElement userMenu = driver.findElement(userNav);
		ReUsableMethods.clickButton(userMenu, obj_Name);

		//Locate dropDown
		setValue(12);
		By byUserDropDown = getBy(locatorType,value);
		Thread.sleep(5000);
		List<WebElement> dropdown = driver.findElements(byUserDropDown);

		String[] actual=new String[dropdown.size()];
		int index=0;
		for(WebElement e: dropdown)
		{
			String s = e.getText();
			actual[index]=s;
			index++;
		}

		if(expected.length==actual.length)
		{
			int x=0;
			result="Pass";
			while(x<actual.length)
			{
				if(!expected[x].equals(actual[x]))
				{
					result="Fail";
					break;
				}
				x++;
			}
		}
		Update_Report( result, "SFUserMenuDropDown_5","Execution Completed",driver);


	}

	public static void developerConsoleClose() throws InterruptedException, IOException
	{
		//startReport("DeveloperConsoleReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");

		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Click on userMenu Dropdown

		setValue(6);
		By userNav = getBy(locatorType,value);
		WebElement userMenu = driver.findElement(userNav);
		ReUsableMethods.clickButton(userMenu, obj_Name);


		//Click on developer console
		Thread.sleep(5000);
		setValue(13);
		By byDevConsole = getBy(locatorType,value);
		WebElement developerCons = driver.findElement(byDevConsole);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ReUsableMethods.clickButton(developerCons, obj_Name);

		String parentWindow=driver.getWindowHandle();

		for(String newWindow: driver.getWindowHandles())
		{
			driver.switchTo().window(newWindow);
		}
		//developer window close
		Thread.sleep(5000);
		driver.close();

		//switch to parent window and close
		driver.switchTo().window(parentWindow);

		Update_Report("Pass","Click on Developer Console","Developer console window is opened",driver);

		result="Pass";

	}

	public static void SFDCLogout() throws IOException, InterruptedException
	{

		//startReport("SFDCLogoutReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		Thread.sleep(3000);
		//Click on userMenu Dropdown
		setValue(6);
		By userNav = getBy(locatorType,value);
		WebElement userMenu = driver.findElement(userNav);
		ReUsableMethods.clickButton(userMenu, obj_Name);

		//Logout
		setValue(14);
		By byLogout = getBy(locatorType,value);
		WebElement logout = driver.findElement(byLogout);
		ReUsableMethods.clickButton(logout, obj_Name);

		result="Pass";

	}

	public static void createAnAccount() throws IOException
	{
		//startReport("CreateAnAccountReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/AddNewAccount.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Click on Accounts
		setValue(15);
		By byAccount = getBy(locatorType,value);
		WebElement account = driver.findElement(byAccount);
		ReUsableMethods.clickButton(account, obj_Name);

		//Create New 
		setValue(16);
		By byCreateNew = getBy(locatorType,value);
		WebElement newaccount = driver.findElement(byCreateNew);
		ReUsableMethods.clickButton(newaccount, obj_Name);

		//Navigate to account
		setValue(17);
		By byAcc = getBy(locatorType,value);
		WebElement acc = driver.findElement(byAcc);
		ReUsableMethods.clickButton(acc, obj_Name);


		//Enter new account name
		setValue(18);
		By byAccName = getBy(locatorType,value);
		WebElement newaccountname = driver.findElement(byAccName);
		ReUsableMethods.enterText(newaccountname, recData[1][4], obj_Name);


		//Save
		setValue(19);
		By bySave = getBy(locatorType,value);
		WebElement save = driver.findElement(bySave);
		ReUsableMethods.clickButton(save, obj_Name);

		String expected= recData[1][5];

		setValue(20);
		By byNewAccName = getBy(locatorType,value);
		String actual=driver.findElement(byNewAccName).getText();
		result = verify(expected,actual);
		Update_Report(result,"Create new account","Test Exicuted",driver);

		result="Pass";
	}

	public static void createAnView() throws IOException
	{
		//startReport("CreateNewViewReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/CreateNewView.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, recData[1][2], obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, recData[1][3], obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Click on Accounts
		setValue(15);
		By byAccount = getBy(locatorType,value);
		WebElement account = driver.findElement(byAccount);
		ReUsableMethods.clickButton(account, obj_Name);

		//Click create new view
		setValue(21);
		By bynewview = getBy(locatorType,value);
		WebElement newview = driver.findElement(bynewview);
		ReUsableMethods.clickButton(newview, obj_Name);

		//View name
		setValue(22);
		By byviewname = getBy(locatorType,value);
		WebElement viewname = driver.findElement(byviewname);
		ReUsableMethods.enterText(viewname, recData[1][4], obj_Name);

		//View unique name
		setValue(23);
		By byviewuniqname = getBy(locatorType,value);
		WebElement viewuniqname = driver.findElement(byviewuniqname);
		ReUsableMethods.enterText(viewuniqname, recData[1][5], obj_Name);

		//Save
		setValue(24);
		By bysaveview = getBy(locatorType,value);
		WebElement saveview = driver.findElement(bysaveview);
		ReUsableMethods.clickButton(saveview, obj_Name);

		try{
			setValue(25);
			By byselectMenu = getBy(locatorType,value);
			WebElement selectMenu=driver.findElement(byselectMenu);
			Select select=new Select(selectMenu);
			select.selectByVisibleText(recData[1][4]);
			Update_Report("Pass","Create new new","New View "+recData[1][4]+" is created",driver);
		}catch(Exception e){Update_Report("Fail","Create new new",recData[1][4]+" is not created,driver",driver);}

		result="Pass";
	}

	public static void editView() throws IOException
	{
		//startReport("EditViewReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/EditView.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String viewName=recData[1][4];
		String newViewName=recData[1][5];
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Click on Accounts
		setValue(15);
		By byAccount = getBy(locatorType,value);
		WebElement account = driver.findElement(byAccount);
		ReUsableMethods.clickButton(account, obj_Name);

		//Select view name to edit
		setValue(26);
		By byviewMenu = getBy(locatorType,value);
		WebElement viewMenu=driver.findElement(byviewMenu);
		Select select=new Select(viewMenu);
		select.selectByVisibleText(viewName);

		//Edit
		setValue(27);
		By byeditview = getBy(locatorType,value);
		WebElement editView=driver.findElement(byeditview);
		ReUsableMethods.clickButton(editView, obj_Name);

		//New view name
		setValue(22);
		By byNewViewName = getBy(locatorType,value);
		WebElement newviewName = driver.findElement(byNewViewName);
		ReUsableMethods.enterText(newviewName, sfpassword, obj_Name);

		//Save
		setValue(24);
		By bysaveview = getBy(locatorType,value);
		WebElement saveview = driver.findElement(bysaveview);
		ReUsableMethods.clickButton(saveview, obj_Name);

		try{
			setValue(25);
			By byselectMenu = getBy(locatorType,value);
			WebElement selectMenu=driver.findElement(byselectMenu);
			Select selectview=new Select(selectMenu);
			selectview.selectByVisibleText(newViewName);
			Update_Report("Pass","Edit View","View "+recData[1][4]+" is edited",driver);
		}catch(Exception e){Update_Report("Fail","Edit View",recData[1][4]+" is not edited",driver);}

		result="Pass";
	}

	public static void mergeAccounts() throws IOException
	{
		//startReport("MergeAccount","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/MergeAccount.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String accountName=recData[1][4];
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Click on Accounts
		setValue(15);
		By byAccount = getBy(locatorType,value);
		WebElement account = driver.findElement(byAccount);
		ReUsableMethods.clickButton(account, obj_Name);

		//Merge account
		setValue(28);
		By byMergeAccount = getBy(locatorType,value);
		WebElement MergeAccount = driver.findElement(byMergeAccount);
		ReUsableMethods.clickButton(MergeAccount, obj_Name);


		//Search account name
		setValue(29);
		By bysearchAccount = getBy(locatorType,value);
		WebElement searchAccount = driver.findElement(bysearchAccount);
		ReUsableMethods.enterText(searchAccount, accountName, obj_Name);

		//Find Account
		setValue(30);
		By byFindAccount = getBy(locatorType,value);
		WebElement FindAccount = driver.findElement(byFindAccount);
		ReUsableMethods.clickButton(FindAccount, obj_Name);

		//Select first

		setValue(31);
		By byselectFirst = getBy(locatorType,value);
		WebElement selectFirst = driver.findElement(byselectFirst);
		/*boolean issel1=selectFirst.isSelected();
		if(issel1==false)*/
		ReUsableMethods.clickButton(selectFirst, obj_Name);

		//Select second
		setValue(32);
		By byselectSecond = getBy(locatorType,value);
		WebElement selectSecond = driver.findElement(byselectSecond);
		/*boolean issel2=selectSecond.isSelected();
		if(issel2==false)*/
		ReUsableMethods.clickButton(selectSecond, obj_Name);

		//Next
		setValue(33);
		By bynext = getBy(locatorType,value);
		WebElement next = driver.findElement(bynext);
		ReUsableMethods.clickButton(next, obj_Name);

		//Merge
		setValue(34);
		By bymerge = getBy(locatorType,value);
		WebElement merge = driver.findElement(bymerge);
		ReUsableMethods.clickButton(merge, obj_Name);

		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();

		result="Pass";

	}

	public static void  accountReport() throws IOException
	{
		//startReport("MergeAccount","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/MergeAccount.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Click on Accounts
		setValue(15);
		By byAccount = getBy(locatorType,value);
		WebElement account = driver.findElement(byAccount);
		ReUsableMethods.clickButton(account, obj_Name);

		driver.findElement(By.linkText("Accounts with last activity > 30 days")).click();

		//date field
		WebElement datefield=driver.findElement(By.xpath("//*[@id='ext-gen20']"));
		datefield.click();
		Select selectdate=new Select(datefield);
		selectdate.selectByVisibleText("Created Date");

		//locate from date
		driver.findElement(By.xpath("//*[@id='ext-gen152']")).click();
		//select date
		driver.findElement(By.xpath("//*[@id='ext-gen308']")).click();

		//locate to date
		driver.findElement(By.xpath("//*[@id='ext-gen154']")).click();
		//select to date
		driver.findElement(By.xpath("//*[@id='ext-gen325']")).click();

		//save
		driver.findElement(By.xpath("//*[@id='ext-gen49']")).click();

		//Popup window will open

		driver.findElement(By.xpath("//*[@id='saveReportDlg_reportNameField']")).sendKeys("a");
		driver.findElement(By.xpath("//*[@id='saveReportDlg_DeveloperName']")).sendKeys("b");

		//save 
		driver.findElement(By.xpath("//*[@id='dlgSaveReport']")).click();

		result="Pass";
	}

	public static void opportunitiesDropdown() throws IOException, InterruptedException
	{
		//startReport("OpportunitiesDropdownReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Opportunities.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String[] expected=recData[1][4].split(",");

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Opportunities
		setValue(36);
		By byOpportunities = getBy(locatorType,value);
		WebElement Opportunities = driver.findElement(byOpportunities);
		ReUsableMethods.clickButton(Opportunities, obj_Name);

		//view Opportunities
		setValue(37);
		By byViewOpportunities = getBy(locatorType,value);
		WebElement ViewOpportunities = driver.findElement(byViewOpportunities);
		ReUsableMethods.clickButton(ViewOpportunities, obj_Name);

		//To get the select(Option) list
		Select select=new Select(ViewOpportunities);
		List<WebElement> dropdown = select.getOptions();

		String[] actual=new String[dropdown.size()];
		int index=0;
		for(WebElement e: dropdown)
		{
			String s = e.getText();
			actual[index]=s;
			index++;
		}

		if(expected.length==actual.length)
		{
			int x=0;
			result="Pass";
			while(x<actual.length)
			{
				if(!expected[x].equals(actual[x]))
				{
					result="Fail";
					break;
				}
				x++;
			}
		}
		Update_Report( result, "OpportunitiesDropdown","Execution Completed",driver);

		result="Pass";

	}

	public static void createNewOpportunities() throws IOException
	{
		//startReport("CreateNewOpportunitiesReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/NewOpportunities.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String OpportunityName=recData[1][4];
		String expected=recData[1][4];
		String Stage=recData[1][5];

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Opportunities
		setValue(36);
		By byOpportunities = getBy(locatorType,value);
		WebElement Opportunities = driver.findElement(byOpportunities);
		ReUsableMethods.clickButton(Opportunities, obj_Name);

		//Create New
		setValue(38);
		By byNewOpportunities = getBy(locatorType,value);
		WebElement NewOpportunities = driver.findElement(byNewOpportunities);
		ReUsableMethods.clickButton(NewOpportunities, obj_Name);

		//Opportunity
		setValue(39);
		By byOpportunity = getBy(locatorType,value);
		WebElement Opportunity = driver.findElement(byOpportunity);
		ReUsableMethods.clickButton(Opportunity, obj_Name);

		//Opportunity name
		setValue(40);
		By byOpportunityName = getBy(locatorType,value);
		WebElement OpportunityName1 = driver.findElement(byOpportunityName);
		ReUsableMethods.enterText(OpportunityName1, OpportunityName, obj_Name);

		//Date
		setValue(41);
		By byDate = getBy(locatorType,value);
		WebElement Date = driver.findElement(byDate);
		ReUsableMethods.clickButton(Date, obj_Name);

		//Stage
		setValue(42);
		By byStage = getBy(locatorType,value);
		WebElement StageElm = driver.findElement(byStage);
		Select select=new Select(StageElm);
		select.selectByVisibleText(Stage);

		//Save
		setValue(43);
		By bySave = getBy(locatorType,value);
		WebElement Save = driver.findElement(bySave);
		ReUsableMethods.clickButton(Save, obj_Name);

		//Actual opy name
		setValue(44);
		By byNewOpy = getBy(locatorType,value);
		String actual=driver.findElement(byNewOpy).getText();
		result=verify(expected,actual);

		Update_Report( result, "NewOpportunities","Execution Completed",driver);
		result="Pass";
	}

	public static void opportunityPipeline() throws IOException
	{
		//startReport("OpportunitiesPipelineReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/OpportunitiesPipelineReport.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String expected=recData[1][4];

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Opportunities
		setValue(36);
		By byOpportunities = getBy(locatorType,value);
		WebElement Opportunities = driver.findElement(byOpportunities);
		ReUsableMethods.clickButton(Opportunities, obj_Name);

		//Under report Opportunities pipeline
		setValue(45);
		By byOptpipeline = getBy(locatorType,value);
		WebElement Optpipeline = driver.findElement(byOptpipeline);
		ReUsableMethods.clickButton(Optpipeline, obj_Name);

		//Actual Report
		setValue(46);
		By bypipelineReport = getBy(locatorType,value);
		String actual=driver.findElement(bypipelineReport).getText();

		result=verify(expected,actual);
		Update_Report( result, "Opportunity Pipeline Report","Execution Completed",driver);

		result="Pass";
	}

	public static void stuckOpportunities() throws IOException
	{
		//startReport("StuckOpportunitiesReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/StuckOpportunitiesReport.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String expected=recData[1][4];

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Opportunities
		setValue(36);
		By byOpportunities = getBy(locatorType,value);
		WebElement Opportunities = driver.findElement(byOpportunities);
		ReUsableMethods.clickButton(Opportunities, obj_Name);

		//Under report Stuck Opportunities
		setValue(47);
		By byStuck = getBy(locatorType,value);
		WebElement Stuck = driver.findElement(byStuck);
		ReUsableMethods.clickButton(Stuck, obj_Name);

		//Actual Report
		setValue(46);
		By bypipelineReport = getBy(locatorType,value);
		String actual=driver.findElement(bypipelineReport).getText();

		result=verify(expected,actual);
		Update_Report( result, "Stuck Opportunities Report","Execution Completed",driver);

		result="Pass";
	}

	public static void leadsTab() throws IOException
	{
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String result="Fail";

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Leads
		setValue(48);
		By byLeads = getBy(locatorType,value);
		WebElement Leads = driver.findElement(byLeads);
		ReUsableMethods.clickButton(Leads, obj_Name);
		result="Pass";
		Update_Report( result, "Leads Tab","Execution Completed",driver);

	}

	public static void leadsSelectView() throws IOException
	{
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/leadsSelectView.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String[] expected=recData[1][4].split(",");
		String result="Fail";

		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Leads
		setValue(48);
		By byLeads = getBy(locatorType,value);
		WebElement Leads = driver.findElement(byLeads);
		ReUsableMethods.clickButton(Leads, obj_Name);

		//view 
		setValue(37);
		By byViewOpportunities = getBy(locatorType,value);
		WebElement ViewOpportunities = driver.findElement(byViewOpportunities);
		ReUsableMethods.clickButton(ViewOpportunities, obj_Name);

		//To get the select(Option) list
		Select select=new Select(ViewOpportunities);
		List<WebElement> dropdown = select.getOptions();

		String[] actual=new String[dropdown.size()];
		int index=0;
		for(WebElement e: dropdown)
		{
			String s = e.getText();
			actual[index]=s;
			index++;
		}

		if(expected.length==actual.length)
		{
			int x=0;
			result="Pass";
			while(x<actual.length)
			{
				if(!expected[x].equals(actual[x]))
				{
					result="Fail";
					break;
				}
				x++;
			}
		}
		Update_Report( result, "LeadsDropdown","Execution Completed",driver);
	}

	public static void todaysLeads() throws IOException
	{
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/TodaysReport.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
	    String result="Fail";
		
		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Leads
		setValue(48);
		By byLeads = getBy(locatorType,value);
		WebElement Leads = driver.findElement(byLeads);
		ReUsableMethods.clickButton(Leads, obj_Name);

		//view 
		setValue(37);
		By byViewOpportunities = getBy(locatorType,value);
		WebElement ViewOpportunities = driver.findElement(byViewOpportunities);
		ReUsableMethods.clickButton(ViewOpportunities, obj_Name);

		//To get the select(Option) list
		Select select=new Select(ViewOpportunities);
		select.selectByVisibleText("Today's Leads");

		//Go
		setValue(49);
		By byGo = getBy(locatorType,value);
		WebElement Go = driver.findElement(byGo);
		ReUsableMethods.clickButton(Go, obj_Name);

		/*//actual
		setValue(50);
		By byTodaysLead = getBy(locatorType,value);
		WebElement TodaysLead = driver.findElement(byTodaysLead);
        actual=TodaysLead.getText();

        result=ReUsableMethods.verify(expected, actual);*/
		result="Pass";
		Update_Report( result, "TodaysLeads","Execution Completed",driver);
	}

	public static void createLead() throws IOException
	{
		//startReport("CreateAnAccountReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/CreateNewLead.xls";
		String[][] recData=readXlSheet(dtpath,"Sheet1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String orPath = "C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/Sf_ObjectRepository.xls";
		readLocators(orPath,"Sheet1");
		String URL=recData[1][1];
		String sfusername=recData[1][2];
		String sfpassword=recData[1][3];
		String LastName=recData[1][4];
		String Company=recData[1][5];
		String expected=recData[1][6];


		/*Launch URL*/
		driver.get(URL);

		/*Enter UserName*/
		setValue(1);
		By byUsername = getBy(locatorType,value);
		WebElement userName = driver.findElement(byUsername);
		enterText(userName, sfusername, obj_Name);

		/*Enter Password*/
		setValue(2);
		By byPassword = getBy(locatorType,value);
		WebElement password = driver.findElement(byPassword);
		ReUsableMethods.enterText(password, sfpassword, obj_Name);

		//Login
		setValue(3);
		By byLogin = getBy(locatorType,value);
		WebElement loginButton = driver.findElement(byLogin);
		ReUsableMethods.clickButton(loginButton, obj_Name);

		//Leads
		setValue(48);
		By byLeads = getBy(locatorType,value);
		WebElement Leads = driver.findElement(byLeads);
		ReUsableMethods.clickButton(Leads, obj_Name);
		
		
		//Create New 
		setValue(16);
		By byCreateNew = getBy(locatorType,value);
		WebElement newaccount = driver.findElement(byCreateNew);
		ReUsableMethods.clickButton(newaccount, obj_Name);

		//Navigate to Lead
		setValue(51);
		By byAcc = getBy(locatorType,value);
		WebElement acc = driver.findElement(byAcc);
		ReUsableMethods.clickButton(acc, obj_Name);


		//Enter Last name
		setValue(52);
		By byLastName = getBy(locatorType,value);
		WebElement newLastName = driver.findElement(byLastName);
		ReUsableMethods.enterText(newLastName,LastName, obj_Name);
		
		//Enter Company
		setValue(53);
		By byCompany = getBy(locatorType,value);
		WebElement newCompany = driver.findElement(byCompany);
		ReUsableMethods.enterText(newCompany,Company, obj_Name);

		//Save
		setValue(54);
		By bySave = getBy(locatorType,value);
		WebElement save = driver.findElement(bySave);
		ReUsableMethods.clickButton(save, obj_Name);

		//Actual
		setValue(55);
		By byLeadName = getBy(locatorType,value);
		String actual=driver.findElement(byLeadName).getText();
		result = verify(expected,actual);
		Update_Report(result,"Create new account","Test Exicuted",driver);

		result="Pass";
	}
}

