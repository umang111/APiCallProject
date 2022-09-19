package com.blog.comment.error;

public class PostNotFound extends Throwable {

	private static final long serialVersionUID = -967220233242729731L;

	public PostNotFound(String message) {
		super(message);
	}
	
	public PostNotFound(String message, Throwable rootCause) {
		super(message, rootCause);
	}
}
