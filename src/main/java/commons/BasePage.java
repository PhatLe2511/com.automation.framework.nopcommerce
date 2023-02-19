package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import nopCommerce.user.PageObject.DashboardPageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import nopCommerce.user.PageObject.HomePageObject;
import nopCommerce.user.PageObject.PageGeneratorManager;
import nopCommerce.user.PageUIs.BasePageUI;

public class BasePage {
	
	private int shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
	private int longTimeOut = GlobalConstants.LONG_TIMEOUT;
	
	public void backToPreviousPage(WebDriver driver){
		driver.navigate().back();
	}


	public void setImplicitTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public void openURL(WebDriver driver, String url){
		driver.get(url);
	}
	
	public By getLocatorBy(String locator) {
		By by = null;
		
		if(locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")) {
			by = By.xpath(locator.substring(6));
		}else if(locator.startsWith("css=")|| locator.startsWith("CSS=") || locator.startsWith("Css=")) {
			by = By.cssSelector(locator.substring(4));
		}else if(locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")) {
			by = By.name(locator.substring(5));
		}else if (locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=")) {
			by = By.id(locator.substring(3));
		}else {
			throw new RuntimeException("Element is not valid!");
		}
		return by;
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getLocatorBy(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... dynamicValue) {
		return driver.findElement(getLocatorBy(castRestParameters(locator, dynamicValue)));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getLocatorBy(locator));
	}
	
	public String castRestParameters(String locator, String... dynamicValues) {
		locator = String.format(locator, (Object[]) dynamicValues);
		return locator;
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, shortTimeOut).
				until(ExpectedConditions.elementToBeClickable(getLocatorBy(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, shortTimeOut).until(ExpectedConditions.elementToBeClickable(getLocatorBy(castRestParameters(locator, dynamicValues))));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, shortTimeOut).until(ExpectedConditions.visibilityOfElementLocated(getLocatorBy(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, shortTimeOut).until(ExpectedConditions.visibilityOfElementLocated(getLocatorBy(castRestParameters(locator, dynamicValues))));
	}
	
	public void waitForElementInvisibleInDOM(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getLocatorBy(locator)));
	}
	
	public void waitForElementInvisibleInDOM(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getLocatorBy(castRestParameters(locator, dynamicValues))));
	}
	
	public void waitForElementInvisibleNotInDOM(WebDriver driver, String locator) {
		new WebDriverWait(driver, shortTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getLocatorBy(locator)));
	}
	
	public void waitForElementInvisibleNotInDOM(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, shortTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getLocatorBy(castRestParameters(locator, dynamicValues))));
	}
	
	public Alert waitForAlertPresence(WebDriver driver, String locator) {
		return new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		setImplicitTimeOut(driver, shortTimeOut);
		List<WebElement> elements = getElements(driver, locator);
		setImplicitTimeOut(driver, longTimeOut);
		if(elements.size() == 0) {
			System.out.println("Element not in DOM!");
			return true;
		}else if (elements.size() > 0 && !elements.get(0).isDisplayed()){
			System.out.println("Element in DOM but not displayed");
			return true;
		}else {
			System.out.println("Element is in DOM and visible");
			return false;
		}	
	}
	
	public boolean isElementDisplayed(WebDriver driver, String Locator) {
		return getElement(driver, Locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String Locator, String... dynamicValues) {
		return getElement(driver, castRestParameters(Locator, dynamicValues)).isDisplayed();
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeValue) {
		return getElement(driver,locator).getAttribute(attributeValue);
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeValue, String...dynamicValues) {
		return getElement(driver, castRestParameters(locator, dynamicValues)).getAttribute(attributeValue);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator, String... dynamicValues) {
		setImplicitTimeOut(driver, shortTimeOut);
		List<WebElement> elements = getElements(driver, castRestParameters(locator, dynamicValues));
		setImplicitTimeOut(driver, longTimeOut);
		if(elements.size() == 0) {
			System.out.println("Element not in DOM!");
			return true;
		}else if (elements.size() > 0 && !elements.get(0).isDisplayed()){
			System.out.println("Element in DOM but not displayed");
			return true;
		}else {
			System.out.println("Element is in DOM and visible");
			return false;
		}		
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		waitForElementClickable(driver, locator);
		getElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... dynamicValues) {
		waitForElementClickable(driver, castRestParameters(locator, dynamicValues));
		getElement(driver, castRestParameters(locator, dynamicValues)).click();
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String keysValue) {
		WebElement element = getElement(driver, locator);
		element.clear();
		element.sendKeys(keysValue);
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String keysValue, String... dynamicValues) {
		WebElement element = getElement(driver, castRestParameters(locator, dynamicValues));
		element.clear();
		element.sendKeys(keysValue);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String... dynamicValues) {
		return getElement(driver, castRestParameters(locator, dynamicValues)).getText();
	}
	
	public void selectValueOfDefaultDropdown(WebDriver driver, String locator, String itemText) {
		Select select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public void selectInDefaultDropDown(WebDriver driver, String locator, String itemText, String... dynamicValues) {
		Select select = new Select(getElement(driver, castRestParameters(locator, dynamicValues)));
		select.selectByVisibleText(itemText);
	}
	
	public String getFirstSelectedItem(WebDriver driver, String locator) {
		Select select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public void dismissAlert(WebDriver driver, String locator) {
		waitForAlertPresence(driver, locator).dismiss();
	}
	
	public void acceptAlert(WebDriver driver, String locator) {
		waitForAlertPresence(driver, locator).accept();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		Actions actions = new Actions(driver);
		actions.moveToElement(getElement(driver, locator)).perform();;
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions actions = new Actions(driver);
		actions.contextClick(getElement(driver, locator)).perform();;
	}
	
	public void pressKeyToElement(WebDriver driver, String Locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, Locator), key).perform(); 
	}
	
	public void checkToCheckBox(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckBox(WebDriver driver, String locator, String... dynamicValues) {
		WebElement element = getElement(driver, castRestParameters(locator, dynamicValues));
		
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void unCheckToCheckBox(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public void unCheckToCheckBox(WebDriver driver, String locator, String... dynamicValues) {
		WebElement element = getElement(driver, castRestParameters(locator, dynamicValues));
		
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
	}

	public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}
	
	public void inputToTextBoxByID(WebDriver driver, String textBoxById, String keyToSend) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_ID, textBoxById);
		sendKeysToElement(driver, BasePageUI.TEXT_BOX_BY_ID, keyToSend, textBoxById);
	}
	
	public DashboardPageObject clickToHeaderImage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.HOME_PAGE_IMAGE);
		clickToElement(driver, BasePageUI.HOME_PAGE_IMAGE);
		return PageGeneratorManager.getDasboardPageObject(driver);
	}

	protected void sleepInSecond(long timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			
		}
	}

}
