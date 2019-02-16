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
 *
 */
public class TestCase_03 extends basic_class{
	
	LoginPage login;
	SearchHotelPage hotel;
	
	@Test
	public void TC03_Verify_CheckOut_ErrorMessage() {
		
		log.info("----------TestCase_03 started----------");
		login = new LoginPage(driver);
		hotel = new SearchHotelPage(driver);
		
		login.setLogin(config.getProperty("userID"), config.getProperty("passWord"));
		
		try {
			Assert.assertEquals(true, hotel.verifylocationExist());
			log.info("Logged in to Hotel application.");
		} catch(AssertionError e) {
			log.error("Failed to Log in..");
		}
		
		//select location
		hotel.select_location("Sydney");
		log.info("Input location - Sydney");
		
		//select Hotel
		hotel.select_Hotels("Hotel Creek");
		log.info("Input Hotel - Hotel Creek");
		
		//select room type
		hotel.select_RoomType("Standard");
		log.info("Input Room Type - Standard");
		
		//select no-of-rooms
		hotel.select_NumOfRoom("1 - One");
		log.info("Input No of Rooms - 1");
		
		//enter check in date
		hotel.input_CheckInDate("25/02/2019");
		log.info("Input check in date - 25/02/2019");
		
		//enter check out date
		hotel.input_CheckOutDate("23/02/2019");
		log.info("Input Check out date - 23/02/2019");
		
		//click Search
		hotel.click_Search();
		log.info("Click Search button");
		
		try {
			Assert.assertEquals(true, hotel.verifyCheckOutErrorMessage());
			log.info("Error message came out - Check-Out Date shall be after than Check-In Date");
		} catch(AssertionError e) {
			log.error("Error message didn't come out..");
		}
		
		log.info("----------TestCase_03 Completed----------");
	}

}
