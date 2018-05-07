package com.Twoks.Twoks.module.author.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Twoks.Twoks.module.author.entity.Author;
import com.Twoks.Twoks.module.author.service.AuthorService;
import com.Twoks.Twoks.utils.constants.Constants;

@RestController
@RequestMapping(value = Constants.APP + "api/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
	private AuthorService authorService;

	public AuthorService getAuthorService() {
		return authorService;
	}
	
	@RequestMapping(value = "getAllAuthors", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBooks() {
		List<Author> authors = getAuthorService().getAllAuthores();
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}
}
