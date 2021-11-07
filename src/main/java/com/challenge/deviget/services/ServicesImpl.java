package com.challenge.deviget.services;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ServicesImpl implements Services {
	
	private Response responsee;

	public Responsee getEndPoint(String endPoint) {
		 responsee = given().when().log().all().get(endPoint);
		return new Responsee(responsee);
	}

	public Responsee postEndPoint(String endPoint, Object mensagem) {
		responsee = given().contentType("application/json").body(mensagem).when().log().all().post(endPoint);
		return new Responsee(responsee);
	}

	public Responsee putEndPoint(String endPoint, Object mensagem) {
		responsee = given().contentType("application/json").body(mensagem).when().log().all().put(endPoint);
		return new Responsee(responsee);
	}

	public Responsee deleteEndpoint(String endPoint) {
		responsee = given().when().log().all().delete(endPoint);
		return new Responsee(responsee);
	}

}
