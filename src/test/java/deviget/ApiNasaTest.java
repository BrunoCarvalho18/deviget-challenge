package deviget;

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
		services.getEndPoint("?api_key=DEMO_KEY&sol=1000");
		assertion.getResposta().statusCode(200);

	}

}
