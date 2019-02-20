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
public class TestCase_06 extends basic_class{
	LoginPage login;
	SearchHotelPage hotel;
	SelectHotelPage selHotel;
	
	
	@Test
	public void TC06_verify_NoOfRoom() throws Exception {
		
		log.info("----------TestCase_06 started----------");
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
		
		String rooms =  selHotel.getRooms();
		rooms = rooms.split(" ")[0];
		String roomsD = ExcelUtil.getCellData(1, 6);
		roomsD = roomsD.split(" ")[0];
		
//		if(roomsD.contains(rooms)) {
//			log.info("Verified Rooms number in Select Hotel Page - " + rooms);
//		} else {
//			log.error("Rooms number is not same :  expected - " + roomsD + "  displayed - " + rooms);
//		}
		
		try {
			Assert.assertEquals(rooms, roomsD);
			log.info("Verified Rooms number in Select Hotel Page - " + rooms);
		} catch(AssertionError e) {
			log.error("Rooms number is not same :  expected - " + roomsD + "  displayed - " + rooms);
		}
				
		
			
	
		log.info("----------TestCase_06 Completed----------");
	}
}
