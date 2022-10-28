package nopCommerce.user.PageUIs;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON="xpath=//button[text()='Register']";
	public static final String CONTINUE_BUTTON="xpath=//a[text()='Continue']";
	public static final String FIRST_NAME_REQUIRED_MESSAGE= "id=FirstName-error";
	public static final String LAST_NAME_REQUIRED_MESSAGE= "id=LastName-error";
	public static final String PASSWORD_REQUIRED_MESSAGE= "id=Password-error";
	public static final String CONFIRM_PASSWORD_REQUIRED_MESSAGE= "id=ConfirmPassword-error";
	public static final String EMAIL_ERROR_MESSAGE = "id=Email-error";
	public static final String GENDER_CHECKBOX = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DATE_BIRTH_DROPDOWN = "name=DateOfBirthDay";
	public static final String MONTH_BIRTH_DROPDOWN = "name=DateOfBirthMonth";
	public static final String YEAR_BIRTH_DROPDOWN = "name=DateOfBirthYear";
	public static final String REGISTER_SUCCESSFUL_MESSAGE="css=div.result";
	public static final String EXIST_EMAIL_ERROR_MESSAGE="css=div[class*='message-error'] li";
	public static final String PASSWORD_ERROR_MESSAGE_FIRST_LINE="css=span#Password-error>p";
	public static final String PASSWORD_ERROR_MESSAGE_SECOND_LINE="css=span#Password-error li";
	public static final String NOT_MATCHED_PASSWORD_ERROR_MESSAGE="id=ConfirmPassword-error";
	
}
