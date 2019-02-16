/**
 * 
 */
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author jayjo
 *Search Hotel page factory
 */
public class SearchHotelPage {
	
	WebDriver driver;
	
	@FindBy(name="location")
	WebElement selLocation;
	
	@FindBy(name="hotels")
	WebElement selHotels;
	
	@FindBy(name="room_type")
	WebElement selRoomType;
	
	@FindBy(name="room_nos")
	WebElement selNumOfRoom;
	
	@FindBy(name="datepick_in")
	WebElement txtCheckInDate;
	
	@FindBy(name="datepick_out")
	WebElement txtCheckOutDate;
	
	@FindBy(name="adult_room")
	WebElement selAdultsPerRoom;
		
	@FindBy(name="child_room")
	WebElement selChildrenPerRoom;
		
	@FindBy(name="Submit")
	WebElement btnSearch;
	
	@FindBy(name="Reset")
	WebElement btnReset;
	
	//Check-In Date shall be before than Check-Out Date
	@FindBy(id="checkin_span")
	WebElement spanCheckin;
	
	//Check-Out Date shall be after than Check-In Date
	@FindBy(id="checkout_span")
	WebElement spanCheckout;
	
	
	public SearchHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//verify for Search Hotel Page is come out or not
	public boolean verifylocationExist() {
		selLocation.isDisplayed();
		return true;			
	}
	
	public boolean verifyCheckInErrorMessage() {
		spanCheckin.isDisplayed();
		return true;
	}
	
	public boolean verifyCheckOutErrorMessage() {
		spanCheckout.isDisplayed();
		return true;
	}
	
	//Select location
	public void select_location(String Hotellocation) {
		Select locationDropdown = new Select(selLocation);
		locationDropdown.selectByVisibleText(Hotellocation);	
	}
	
	//Select Hotels
	public void select_Hotels(String HotelName) {
		Select hotelDropdown = new Select(selHotels);
		hotelDropdown.selectByVisibleText(HotelName);		
	}
	
	//Select Room Type
	public void select_RoomType(String RoomType) {
		Select hotelRoomType = new Select(selRoomType);
		hotelRoomType.selectByVisibleText(RoomType);
	}
	
	//Select Number of Rooms
	public void select_NumOfRoom(String NumberOfRoom) {
		Select numRoom = new Select(selNumOfRoom);
		numRoom.selectByVisibleText(NumberOfRoom);
	}
	
	//Type Check In Date
	public void input_CheckInDate(String CheckInDate) {
		txtCheckInDate.clear();
		txtCheckInDate.sendKeys(CheckInDate);
	}
	
	//Type Check out Date
	public void input_CheckOutDate(String CheckOutDate) {
		txtCheckOutDate.clear();
		txtCheckOutDate.sendKeys(CheckOutDate);
	}
	
	//Select Adults per Room
	public void select_AdultsPerRoom(String adultPerRoom) {
		Select AdultsRoom = new Select(selAdultsPerRoom);
		AdultsRoom.selectByVisibleText(adultPerRoom);
	}
	
		
	public void click_Search() {
		btnSearch.click();
	}
	
	

}
