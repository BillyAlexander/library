package com.Twoks.Twoks.module.book.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Twoks.Twoks.module.book.entity.Book;
import com.Twoks.Twoks.module.book.service.BookService;
import com.Twoks.Twoks.utils.constants.Constants;

@RestController
@RequestMapping(value = Constants.APP + "api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}
	
	@RequestMapping(value = "getAllBooks", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBooks() {
		List<Book> books = getBookService().getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
}
