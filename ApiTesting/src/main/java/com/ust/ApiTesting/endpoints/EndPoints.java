package com.ust.ApiTesting.endpoints;

import com.ust.ApiTesting.payload.Model;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndPoints {

	// Method to get all the comments
	public static Response getAllcomments() {
		RestAssured.useRelaxedHTTPSValidation();
		return RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(Routes.BASE_URI)
				.basePath(Routes.GET).when().get();
	}

	// Method to create a comment
	public static Response createcomments(Model payload) {
		RestAssured.useRelaxedHTTPSValidation();
		return RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(Routes.BASE_URI)
				.basePath(Routes.CREATE_COMMENTS).body(payload).when().get();
	}

	// Method to delete the comments
	public static Response deleteacomment(int id) {
		RestAssured.useRelaxedHTTPSValidation();
		return RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(Routes.BASE_URI)
				.queryParam("id", id).basePath(Routes.GET).when().delete();
	}

	//Method for accecing individuall comments
	public static Response getIndiviallComments(int id) {
		// TODO Auto-generated method stub
		RestAssured.useRelaxedHTTPSValidation();
		return RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(Routes.BASE_URI)
				.queryParam("id", id).basePath(Routes.GET).when().get();
	}

}
