package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
@DataProvider(name= "InvalidUserCredentials")
	
	public Object[][] verifyUserCredentialsData()
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "555";
		
		data[1][0] = "test";
		data[1][1] = "123456";
		
		data[2][0] = "test";
		data[2][1] = "555";
		
		return data;
		
	}

}
