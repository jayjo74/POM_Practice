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
 *Page Factory - Select Hotel page
 */
public class SelectHotelPage {
	
	WebDriver driver;
	
	@FindBy(name="hotel_name_0")
	WebElement txtHotelName0;
	
	@FindBy(name="arr_date_0")
	WebElement txtCheckInDate0;
	
	@FindBy(name="dep_date_0")
	WebElement txtCheckOutDate0;
	
	public SelectHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public String getHotelName0() {
		String hotelname = txtHotelName0.getAttribute("value");
		return hotelname;
	}
	
	public String getCheckInDate0() {
		String hotelname = txtCheckInDate0.getAttribute("value");
		return hotelname;
	}

	public String getCheckOutDate0() {
		String hotelname = txtCheckOutDate0.getAttribute("value");
		return hotelname;
	}
}
