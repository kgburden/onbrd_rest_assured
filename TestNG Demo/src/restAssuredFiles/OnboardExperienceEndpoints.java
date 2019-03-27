package restAssuredFiles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OnboardExperienceEndpoints {
	
	public Response GetProductTypes() {
		
		// GET Product Types
		RestAssured.baseURI = "https://muleint.tabbank.com";
		Response res = 
			given().
			when().
					post("/api/exp/onboard/product-types?productLine=deposit&custType=consumer").
			then().
					assertThat().statusCode(200).
					and().contentType(ContentType.JSON).
					and().body("results[1].productLine", equalTo("DEPOSIT")).
			extract().response();
		return res;
	}
	
	public Response PostApplicant() {
		
		// GET Product Types
		RestAssured.baseURI = "https://muleint.tabbank.com";
		Response res = 
			given().
			when().
					post("/api/exp/onboard/product-types?productLine=deposit&custType=consumer").
			then().
					assertThat().statusCode(201).
					and().contentType(ContentType.JSON).
					and().body("results[1].productLine", equalTo("DEPOSIT")).
			extract().response();
		return res;
	}
}
