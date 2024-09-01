package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {static Faker faker;
public static String getFirstName()
{
	faker = new Faker();
	String firstname = faker.name().firstName();
	return firstname;
}

public static String getLastName()
{
	faker = new Faker();
	String lastname = faker.name().lastName();
	return lastname;
}

public static String getEmailid()
{
	faker = new Faker();
	String emailid = faker.internet().emailAddress();
	return emailid;
}

}
