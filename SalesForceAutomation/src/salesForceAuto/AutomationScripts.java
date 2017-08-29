package salesForceAuto;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import readExcel.ReadExcel;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationScripts extends ReUsableMethods{
	public static WebDriver driver;

	@Test
	public static void SFDCLogin() throws Exception {

		startReport("SFDCLoginReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");

		/* Launch a Browser*/
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");
		driver = new FirefoxDriver(); 

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");


		Update_Report("Pass","SFDC Launch and Login","Login succesfull");
		driver.close();
		bw.close();

	}

	public static void clearPassword() throws IOException
	{
		startReport("ClearPasswordReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(recData[1][1]);
		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		driver.findElement(By.xpath("//*[@id='password']")).clear();

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");

		String mes=driver.findElement(By.xpath("//*[@id='error']")).getText();
		Update_Report("Pass","Clear password",mes);
		Update_Report("Pass","Clear password","Password cleared");
		bw.close();
		driver.close();
	}

	public static void checkRemeberMe() throws IOException
	{
		startReport("CheckRememberMe","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(recData[1][1]);
		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		//check remember me
		boolean isChecked = driver.findElement(By.xpath("//*[@id='rememberUn']")).isSelected();
		if(isChecked==false)
		{
			driver.findElement(By.xpath("//*[@id='rememberUn']")).click();
			WebElement rememberMe = driver.findElement(By.xpath("//*[@id='rememberUn']"));
			ReUsableMethods.clickButton(rememberMe, "Remember Me");
		}

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");

		//Logout
		WebElement userNameNav = driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		ReUsableMethods.clickButton(userNameNav, "User navigation arrow");


		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		ReUsableMethods.clickButton(logout, "Logout");


		String selUsername=driver.findElement(By.cssSelector("#idcard-identity")).getText();
		Update_Report("Pass",selUsername,"Username is displayed in username field");
		bw.close();
		driver.close();
	}

	public static void forgotPassword() throws IOException
	{
		startReport("ForgotPassword","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/ForgotPassword4A.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(recData[1][1]);
		//click forgot password
		WebElement forgotpassword = driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
		ReUsableMethods.clickButton(forgotpassword, "Forgot Password");
		//Enter username
		WebElement sendUsername = driver.findElement(By.xpath("//*[@id='un']"));
		ReUsableMethods.enterText(sendUsername, recData[1][2], "Username");
		//Click on continue
		WebElement continuebut = driver.findElement(By.xpath("//*[@id='continue']"));
		ReUsableMethods.clickButton(continuebut, "Continue");

		driver.close();
		bw.close();
	}

	public static void wrongUsernameAndWrongPassword() throws IOException
	{
		startReport("WrongUsernameAndWrongPasswordReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/ForgotPassword4B.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");

		String errMes=driver.findElement(By.xpath("//*[@id='error']")).getText();

		Update_Report("Pass","Give wrong username and password",errMes);
		bw.close();
		driver.close();

	}

	public static void userMenuDropdown() throws IOException, InterruptedException
	{
		startReport("UserMenuDropdownReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		//Login
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");

		Thread.sleep(5000);
		//Click on userMenu Dropdown
		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		ReUsableMethods.clickButton(userMenu, "User menu dropdown");
		//driver.findElement(By.xpath("//*[@id='userNavButton']")).click();

		String userMenuItems=driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[1]")).getText()+" ,"
				+driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]")).getText()+" ,"
				+driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[3]")).getText()+" ,"
				+driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[4]")).getText()+" ,"
				+driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]")).getText()+" ,";
		Update_Report("Pass","Click on UserMenu",userMenuItems+" Displyed");
		bw.close();
		driver.close();
	}

	public static void developerConsoleClose() throws InterruptedException, IOException
	{
		startReport("DeveloperConsoleReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		//Login
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");

		//Click on userMenu Dropdown
		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		ReUsableMethods.clickButton(userMenu, "User menu dropdown");


		//Click on developer console
		Thread.sleep(5000);
		WebElement developerCons = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[3]"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ReUsableMethods.clickButton(developerCons, "Developer console");

		//driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[3]")).click();

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
		driver.close();
		Update_Report("Pass","Click on Developer Console","Developer console window is opened");
		bw.close();

	}

	public static void SFDCLogout() throws IOException, InterruptedException
	{

		startReport("SFDCLogoutReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/LoginSF.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");

		/* Launch a Browser*/
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");
		driver = new FirefoxDriver(); 

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");

		Thread.sleep(3000);
		//Click on userMenu Dropdown
		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		ReUsableMethods.clickButton(userMenu, "User menu dropdown");
		//Logout
		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		ReUsableMethods.clickButton(logout, "Logout");

		driver.close();
		bw.close();

	}

	public static void createAnAccount() throws IOException
	{
		startReport("CreateAnAccountReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/AddNewAccount.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		//Login
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");
		//Click on account
		WebElement account = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		ReUsableMethods.clickButton(account, "Accounts");
		//driver.findElement(By.xpath("//*[@id='Account_Tab']/a")).click();

		WebElement newaccount = driver.findElement(By.xpath("//*[@id='createNewButton']"));
		ReUsableMethods.clickButton(newaccount, "Create New");
		//driver.findElement(By.xpath("//*[@id='createNewButton']")).click();

		//Navigate to account
		WebElement acc = driver.findElement(By.xpath("//*[@id='createNewMenu']/a[3]"));
		ReUsableMethods.clickButton(acc, "Acount");
		//driver.findElement(By.xpath("//*[@id='createNewMenu']/a[3]")).click();

		//Enter new account name
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement newaccountname = driver.findElement(By.xpath("//*[@id='acc2']"));
		ReUsableMethods.enterText(newaccountname, recData[1][4], "Account Name");
		//driver.findElement(By.xpath("//*[@id='acc2']")).sendKeys(recData[1][4]);

		//Save
		WebElement save = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		ReUsableMethods.clickButton(save, "Save");
		//driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();

		String an=driver.findElement(By.xpath("//*[@id='contactHeaderRow']/div[2]/h2")).getText();
		Update_Report("Pass","Create new account",an+" is created");
		bw.close();
		driver.close();
	}

	public static void createAnView() throws IOException
	{
		startReport("CreateNewViewReport","C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/SalesForceReport");
		String dtpath="C:/Users/VHEGDE/Desktop/javascreenshot/salesforce/CreateNewView.xls";
		String[][] recData=ReadExcel.readXlSheet(dtpath,"Sheet1");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver-v0.18.0-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Launch URL*/
		driver.get(recData[1][1]);

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, recData[1][2], "UserName");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		ReUsableMethods.enterText(password, recData[1][3], "Password");

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ReUsableMethods.clickButton(loginButton, "Login");

		//Click Accounts
        WebElement account = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		ReUsableMethods.clickButton(account, "Accounts");
		
		//Click create new view
		WebElement newview = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[2]"));
		ReUsableMethods.clickButton(newview, "Create New View");
			
		//View name
		WebElement viewname = driver.findElement(By.xpath("//*[@id='fname']"));
		ReUsableMethods.enterText(viewname, recData[1][4], "View Name");
			
		//View unique name
			WebElement viewuniqname = driver.findElement(By.xpath("//*[@id='devname']"));
			ReUsableMethods.enterText(viewuniqname, recData[1][5], "View Unique Name");
			
		//Save
			 WebElement saveview = driver.findElement(By.xpath("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]"));
				ReUsableMethods.clickButton(saveview, "Save");
			
		try{
			WebElement selectMenu=driver.findElement(By.xpath("//select[@class='title' and @title='View:']"));
			Select select=new Select(selectMenu);
			select.selectByVisibleText(recData[1][4]);
			Update_Report("Pass","Create new new","New View "+recData[1][4]+" is created");
		}catch(Exception e){Update_Report("Fail","Create new new",recData[1][4]+" is not created");}
		bw.close();
		driver.close();
	}
}
