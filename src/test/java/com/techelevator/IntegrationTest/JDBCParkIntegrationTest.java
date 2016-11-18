package com.techelevator.IntegrationTest;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Dao.JdbcParkDao;
import com.techelevator.npgeek.model.Dao.ParkDao;

public class JDBCParkIntegrationTest extends DAOIntegrationTest {
	ParkDao parkDao;
	
	@Before
	public void setupDAO() {
		DataSource dataSource = getDataSource();
		parkDao = new JdbcParkDao(dataSource);
	}
	@Test
	public void dao_returns_all_parks(){
		addParksToDatabase(4);
		addParkToDatabase("test");
		List<Park>allParks= parkDao.getAllParks();
		Assert.assertEquals(15,allParks.size());
		
	}
	@Test
	public void dao_returns_park_details_by_parkCode(){
		Park park=parkDao.getParkDetailsByParkCode("CVNP");
		Assert.assertEquals("CVNP", park.getParkCode());
		Assert.assertEquals("Cuyahoga Valley National Park", park.getParkName());
		Assert.assertEquals("Ohio", park.getState());
		Assert.assertEquals(32832,park.getAcreage());
		Assert.assertEquals(696, park.getElevationInFeet());
		Assert.assertEquals("125.0", Double.toString(park.getMilesOfTrail()));
		Assert.assertEquals(0, park.getNumberOfCampsites());
		Assert.assertEquals("Woodland", park.getClimate());
		Assert.assertEquals(2000, park.getYearFounded());
		Assert.assertEquals(2189849, park.getAnnualVisitorCount());
		Assert.assertEquals("Of all the paths you take in life, make sure a few of them are dirt.", park.getInspirationalQuote());
		Assert.assertEquals("John Muir", park.getInspirationalQuoteSource());
		Assert.assertEquals("Though a short distance from the urban areas of Cleveland and Akron, Cuyahoga Valley National Park seems worlds away. The park is a refuge for native plants and wildlife, and provides routes of discovery for visitors. The winding Cuyahoga River gives way to deep forests, rolling hills, and open farmlands. Walk or ride the Towpath Trail to follow the historic route of the Ohio & Erie Canal", park.getParkDescription());
		Assert.assertEquals(0,park.getEntryFee());
		Assert.assertEquals(390, park.getNumberOfAnimalSpecies());
		
		
}
	

}
