package deviget;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import com.challenge.deviget.services.Responsee;
import com.challenge.deviget.services.ServicesImpl;
import io.restassured.RestAssured;

public class ApiNasaTest {

	ServicesImpl services = new ServicesImpl();
	Responsee assertion = new Responsee();
	
	
	public ApiNasaTest() {
		RestAssured.baseURI = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";
	}

	@Test
	public void RetrieveFirst10MarsPhotosMadeByCuriosity1000MartianSo() {
		services.getEndPoint("?sol=1000&api_key=DEMO_KEY&page=1");
		assertion.getResposta().statusCode(200);
		String saveObject = assertion.saveObjectsBody("photos");
		for(int index = 1; index <=10;index++) {
			System.out.println("10 photos: "+saveObject); // You can use a log it's best way
		};
		

	}
	
	@Test
	public void RetrieveTheFirst10MarsPhotosMadeByCuriosityOnEarthDateEqualTo1000MartianSol() {
		services.getEndPoint("?earth_date=2015-05-30&api_key=DEMO_KEY&page=1");
		assertion.getResposta().statusCode(200);
		String saveObject = assertion.saveObjectsBody("photos.sol");
		for(int index = 1; index<=saveObject.length();index++) {
		    assertion.getResposta().and().assertThat().body("photos.sol[0]", equalTo(1000));
		}

	}

}
