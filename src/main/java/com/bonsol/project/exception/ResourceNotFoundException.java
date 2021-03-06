package com.bonsol.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resource, Integer id) {

		super(resource + " with id = " + id + " was not found");
	}

	public ResourceNotFoundException(String resource, String username) {

		super(resource + " with username = " + username + " was not found");
	}

	public ResourceNotFoundException(String resource) {

		super(resource + " was not found");
	}

}
