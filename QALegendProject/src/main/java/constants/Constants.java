package constants;

import java.io.File;

public class Constants {
	public static final String TESTDATA_EXCELPATH = "\\src\\test\\resources\\TestData.xlsx";
	public static final String HOME_DIRECTORY = System.getProperty("user.dir");
	public static final String LOGIN_PAGE = "LoginPage";
	public static final String USERMANAGEMENT_PAGE = "UserManagementPage";
	public static final String FORGOTPASSWORD_PAGE = "PasswordResetPage";
	public static final String EMAIL_RANDOMDATADOT = ".";
	public static final String EMAIL_RANDOMDATASUFFIX = "@yahoo.com";
	public static final String USERNAME_RANDOMDATASUFFIX = "@1";
	public static final String WELCOMEMESSAGE_EXPECTEDPREFIX = "Welcome";
	public static final String WELCOMEMESSAGE_EXPECTEDSUFFIX = ",";
	public static final String CONFIG_FILE = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config.properties";
	
	

}
