package com.ust.ApiTesting.commentApi;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.ApiTesting.endpoints.EndPoints;
import com.ust.ApiTesting.payload.Model;
import com.ust.ApiTesting.utilities.ExtentReportManager;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

@Listeners(ExtentReportManager.class)
public class CommentApiTest {

	private Model model;

	@BeforeClass
	public void setUpCommentModel() {
		model = new Model();
		model.setId(1);
		model.setUser(1);
		model.setPost(1);
		model.setContent("This is the comment content");
		;
	}

	@Test(priority = 0)
	public void testGetComments() {
		Response response = EndPoints.getAllcomments();
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 1)
	public void testGetIndiviallComments() {
		Response response = EndPoints.getIndiviallComments(model.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void testCreateComment() {
		Response response = EndPoints.createcomments(model);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3)
	public void testDeleteComment() {
		Response response = EndPoints.deleteacomment(model.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void testSchemaValidation() {
		File schema = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\resource\\Schema.json");
		Response res = EndPoints.getIndiviallComments(1);
		res.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
	}

}
