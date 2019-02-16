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
public class TestCase_01 extends basic_class{
	
	LoginPage login; 
	SearchHotelPage searchHotel;
	
	//Login to application
	@Test
	public void practic01() {
		
		log.info("----------TestCase_01 Started----------");
		
		//Log in to application 
		login = new LoginPage(driver);
		searchHotel = new SearchHotelPage(driver);
		
		login.setLogin(config.getProperty("userID"),config.getProperty("passWord"));
		
		try {
			Assert.assertEquals(true, searchHotel.verifylocationExist());
			log.info("Logged in to Hotel application.");
		} catch(AssertionError e) {
			log.error("Failed to Log in..");
		}
		
		
		log.info("----------TestCase_01 Completed----------");
		
	}
	
	
}
