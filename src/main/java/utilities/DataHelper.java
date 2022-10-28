package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	
	Faker faker = new Faker();
	
	Faker faker_US = new Faker(new Locale("en-US"));
	
	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	
	public String getFirstNameData() {
		return faker.address().firstName();
	}
	
	public String getLastNameData() {
		return faker.address().lastName();
	}
	
	public String getEmailData() {
		return faker.internet().emailAddress();
	}

	public String getPasswordData() {
		return faker.internet().password(true);
	}

	public String getUSPhoneNumberData() {
		return faker_US.phoneNumber().phoneNumber();
	}

	public String getUSAddressData() {
		return faker_US.address().fullAddress();
	}
	
	public String getUSZipCodeData() {
		return faker_US.address().zipCode();
	}
	
	public String getUSCityData() {
		return faker_US.address().city();
	}

	public String getUSCompanyNameData() {
		return faker_US.company().name();
	}
}
