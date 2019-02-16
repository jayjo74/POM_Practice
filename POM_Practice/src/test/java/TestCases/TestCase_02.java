/**
 * 
 */
package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SearchHotelPage;
import base_classes.basic_class;


/**
 * @author jayjo
 *To verify whether the check-out data field accepts a later date than check-in date.
 */
public class TestCase_02 extends basic_class{
	
	LoginPage login;
	SearchHotelPage hotel;

	
	@Test
	public void TC02_Verify_CheckIn_ErrorMessage() throws InterruptedException {

		log.info("----------TestCase_02 Started----------");
		
		login = new LoginPage(driver);
		hotel = new SearchHotelPage(driver);
		
		//Login to application using user name and password as in test data
		login.setLogin(config.getProperty("userID"),config.getProperty("passWord"));
		try {
			Assert.assertEquals(true, hotel.verifylocationExist());
			log.info("Logged in to Hotel application.");
		} catch(AssertionError e) {
			log.error("Failed to Log in..");
		}
		
		Thread.sleep(1000); //wait 1 second
		
		//select location as in test data Sydney
		hotel.select_location("Sydney");
		log.info("Input Location - Sydney");
		
		Thread.sleep(1000); //wait 1 second
		
		//Select hotel as in test data HotelCreek
		hotel.select_Hotels("Hotel Creek");
		log.info("Input Hotel - Hotel Creek");
		
		Thread.sleep(1000); //wait 1 second
		
		//Select room type as in test data  - Standard
		hotel.select_RoomType("Standard");
		log.info("Input Room Type - Standard");
		
		Thread.sleep(1000); //wait 1 second
		
		//Select no of rooms as in test data
		hotel.select_NumOfRoom("1 - One");
		log.info("Input Number of Room - 1");
		
		Thread.sleep(1000); //wait 1 second
		
		//Check in data - today + 7 day
		hotel.input_CheckInDate("02/15/2019");
		log.info("Input Check In Date - 02/15/2019");
		
		Thread.sleep(1000); //wait 1 second
		
		//Check out date - today +5 day
		hotel.input_CheckOutDate("02/13/2019");
		log.info("Input Check Out Date - 02/13/2019");
		
		Thread.sleep(1000); //wait 1 second
		
		//click Search button
		hotel.click_Search();
		log.info("Click Search button..");
		//verify error message
		
		try {
		Assert.assertEquals(true, hotel.verifyCheckInErrorMessage());
		log.info("Verified Check In Error Message");
		} catch(AssertionError e) {
			log.error("Check In Error Message didn't come out..");
		}
		
		log.info("----------TestCase_02 Completed----------");
	}
	
	

}
