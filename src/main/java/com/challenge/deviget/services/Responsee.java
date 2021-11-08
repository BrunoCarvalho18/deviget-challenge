package com.challenge.deviget.services;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Responsee {
	

	private static Response responsee;

	public Responsee(Response responsee) {
		Responsee.responsee = responsee;
	}
	
	public Responsee() {
		
	}

	public ValidatableResponse getResposta() {
		return responsee.then().log().all();
	}

	public Integer retrieveStatusCode(Integer statusCode) {

		return responsee.statusCode();

	}
	
	public String saveObjectsBody(String caminho) {
		return responsee.jsonPath().get(caminho).toString();
	}
	
	
	


}
