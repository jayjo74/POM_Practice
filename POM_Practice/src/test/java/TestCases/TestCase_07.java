/**
 * 
 */
package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SearchHotelPage;
import Pages.SelectHotelPage;
import Utility.ExcelUtil;
import base_classes.basic_class;

/**
 * @author jayjo
 *
 */
public class TestCase_07 extends basic_class{
	
	LoginPage login;
	SearchHotelPage hotel;
	SelectHotelPage selHotel;
	
	@Test
	public void TC07_verify_RoomType() throws Exception {
		
		log.info("----------TestCase_07 started----------");
		
		login = new LoginPage(driver);
		hotel = new SearchHotelPage(driver);
		selHotel = new SelectHotelPage(driver);
		
		ExcelUtil.setExcelFileSheet("TestData");
		
		String userN = ExcelUtil.getCellData(1, 1);
		String passW = ExcelUtil.getCellData(1, 2);
		
		log.info("Step#1 - Launch hotel reservation application.");
		login.setLogin(userN, passW);
		log.info("Step#2 - Login to the application.");
		staticWait(2000);
		
		hotel.select_location(ExcelUtil.getCellData(1, 3));
		log.info("Step#3 : Input location - " + ExcelUtil.getCellData(1, 3));
		staticWait(1000);
		
		hotel.select_Hotels(ExcelUtil.getCellData(1, 4));
		log.info("Step#4 : Input Hotel - " + ExcelUtil.getCellData(1, 4));
		staticWait(1000);
		
		hotel.select_RoomType(ExcelUtil.getCellData(1, 5));
		log.info("Step#5 : Input Room Type - " + ExcelUtil.getCellData(1, 5));
		staticWait(1000);
		
		hotel.select_NumOfRoom(ExcelUtil.getCellData(1, 6));
		log.info("Step#6 : Input No of Room - " + ExcelUtil.getCellData(1, 6));
		staticWait(1000);
		
		hotel.input_CheckInDate(ExcelUtil.getCellData(1, 7));
		log.info("Step#7 : Input check in date - " + ExcelUtil.getCellData(1, 7));
		staticWait(1000);
		
		hotel.input_CheckOutDate(ExcelUtil.getCellData(1, 8));
		log.info("Step#8 : Input Check out date - " + ExcelUtil.getCellData(1, 8));
		staticWait(1000);
		
		hotel.click_Search();
		log.info("Step#9 : Click Search button");
		staticWait(2000);
		
		String roomTypeV = selHotel.getRoomType();
		try {
			Assert.assertEquals(ExcelUtil.getCellData(1, 5), roomTypeV);
			log.info("Step#10 : Verified Rooms number in Select Hotel Page - " + roomTypeV);
		} catch(AssertionError e) {
			log.error("Step#10 : Rooms number is not same :  expected - " + ExcelUtil.getCellData(1, 5) + "  displayed - " + roomTypeV);
		}
		
		log.info("----------TestCase_07 Completed----------");
	}

}
