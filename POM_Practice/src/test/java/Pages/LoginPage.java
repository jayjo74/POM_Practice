/**
 * 
 */
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author jayjo
 *page factory for login page
 */
public class LoginPage {
	
	WebDriver driver;
	
	//Username textbox
	@FindBy(name="username")
	WebElement txtuserName;
	
	//Password text box
	@FindBy(name="password")
	WebElement txtpassWord;
	
	//Login button
	@FindBy(name="login")
	WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String username) {
		txtuserName.clear();
		txtuserName.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtpassWord.clear();
		txtpassWord.sendKeys(password);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	public void setLogin(String username,String password) {
		txtuserName.clear();
		txtuserName.sendKeys(username);
		txtpassWord.clear();
		txtpassWord.sendKeys(password);
		btnLogin.click();
	}

}
