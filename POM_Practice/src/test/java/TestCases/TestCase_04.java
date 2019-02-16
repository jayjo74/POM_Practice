/**
 * 
 */
package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SearchHotelPage;
import Pages.SelectHotelPage;
import base_classes.basic_class;

/**
 * @author jayjo
 *
 */
public class TestCase_04 extends basic_class{
	
	LoginPage login;
	SearchHotelPage hotel;
	SelectHotelPage selHotel;
	
	@Test
	public void TC04_Verify_Hotel() {
		
		log.info("----------TestCase_04 started----------");
		login = new LoginPage(driver);
		hotel = new SearchHotelPage(driver);
		selHotel = new SelectHotelPage(driver);
		
		login.setLogin(config.getProperty("userID"), config.getProperty("passWord"));
		
		try {
			Assert.assertEquals(true, hotel.verifylocationExist());
			log.info("Logged in to Hotel application.");
		} catch(AssertionError e) {
			log.error("Failed to Log in..");
		}
		
		//select location
		hotel.select_location(config.getProperty("location"));
		log.info("Input location - " + config.getProperty("location"));
		
		//select Hotel
		hotel.select_Hotels(config.getProperty("hotel"));
		log.info("Input Hotel - Hotel Creek" + config.getProperty("hotel"));
		
		//select room type
		hotel.select_RoomType(config.getProperty("roomType"));
		log.info("Input Room Type - " + config.getProperty("roomType"));
		
		//select no-of-rooms
		hotel.select_NumOfRoom(config.getProperty("noOfRoom"));
		log.info("Input No of Room - " + config.getProperty("noOfRoom"));
		
		//enter check in date
		hotel.input_CheckInDate(config.getProperty("checkInDate"));
		log.info("Input check in date - " + config.getProperty("checkInDate"));
		
		//enter check out date
		hotel.input_CheckOutDate(config.getProperty("checkOutDate"));
		log.info("Input Check out date - " + config.getProperty("checkOutDate"));
		
		//click Search
		hotel.click_Search();
		log.info("Click Search button");
		
		String hotelReturn = selHotel.getHotelName0();
		log.info("Hotel name is " +hotelReturn);
			
		try {
			Assert.assertEquals(config.getProperty("hotel"), hotelReturn);
			log.info("Verified Hotel name in Select Hotel Page - " + hotelReturn);
		} catch(AssertionError e) {
			log.error("Hotel name is not same :  expected - " + config.getProperty("hotel") + "  displayed - " + hotelReturn);
		}
		
		log.info("----------TestCase_04 Completed----------");
	}

}
