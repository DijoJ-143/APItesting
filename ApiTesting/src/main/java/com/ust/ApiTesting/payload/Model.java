package com.ust.ApiTesting.payload;

public class Model {

	private int id;
	private String content;
	private int user;
	private int post;

	// default constructor
	public Model() {

	}

	// parameterized constructor

	public Model(int id, String content, int user, int post) {
		super();
		this.id = id;
		this.content = content;
		this.user = user;
		this.post = post;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	@Override
	public String toString() {

		return " {"
				+ "id:" + id + "," + " content=" + content + "," + " user=" + user + ", " + "post="
				+ post + "}]";

	}

}
