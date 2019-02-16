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
 *To Verifywhether check in date and check out date
 *Use Data driven framework use Excel file data
 */
public class TestCase_05 extends basic_class{
		
	LoginPage login;
	SearchHotelPage hotel;
	SelectHotelPage selHotel;
	
	
	@Test
	public void TC05_verify_CheckDate() throws Exception {
		
		log.info("----------TestCase_05 started----------");
		login = new LoginPage(driver);
		hotel = new SearchHotelPage(driver);
		selHotel = new SelectHotelPage(driver);
		
		ExcelUtil.setExcelFileSheet("TestData");
		
		String userN = ExcelUtil.getCellData(1, 1);
		String passW = ExcelUtil.getCellData(1, 2);
		
		login.setLogin(userN, passW);
		
		staticWait(2000);
		
		hotel.select_location(ExcelUtil.getCellData(1, 3));
		log.info("Input location - " + ExcelUtil.getCellData(1, 3));
		staticWait(1000);
		
		hotel.select_Hotels(ExcelUtil.getCellData(1, 4));
		log.info("Input Hotel - " + ExcelUtil.getCellData(1, 4));
		staticWait(1000);
		
		hotel.select_RoomType(ExcelUtil.getCellData(1, 5));
		log.info("Input Room Type - " + ExcelUtil.getCellData(1, 5));
		staticWait(1000);
		
		hotel.select_NumOfRoom(ExcelUtil.getCellData(1, 6));
		log.info("Input No of Room - " + ExcelUtil.getCellData(1, 6));
		staticWait(1000);
		
		hotel.input_CheckInDate(ExcelUtil.getCellData(1, 7));
		log.info("Input check in date - " + ExcelUtil.getCellData(1, 7));
		staticWait(1000);
		
		hotel.input_CheckOutDate(ExcelUtil.getCellData(1, 8));
		log.info("Input Check out date - " + ExcelUtil.getCellData(1, 8));
		staticWait(1000);
						
		hotel.click_Search();
		log.info("Click Search button");
		staticWait(1000);
		
		String checkInD =  selHotel.getCheckInDate0();
		try {
			Assert.assertEquals(ExcelUtil.getCellData(1, 7), checkInD);
			log.info("Verified Check In Date in Select Hotel Page - " + checkInD);
		} catch(AssertionError e) {
			log.error("Check In Date is not same :  expected - " + ExcelUtil.getCellData(1, 7) + "  displayed - " + checkInD);
		}
				
		String checkOutD = selHotel.getCheckOutDate0();
		try {
			Assert.assertEquals(ExcelUtil.getCellData(1, 8), checkOutD);
			log.info("Verified Check Out Date in Select Hotel Page - " + checkOutD);
		} catch(AssertionError e) {
			log.error("Check Out Date is not same :  expected - " + ExcelUtil.getCellData(1, 8) + "  displayed - " + checkOutD);
		}
		
			
	
		log.info("----------TestCase_05 Completed----------");
	
	
	
	}
	
}
