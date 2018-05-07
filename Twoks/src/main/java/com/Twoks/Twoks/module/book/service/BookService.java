package com.Twoks.Twoks.module.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Twoks.Twoks.module.book.entity.Book;
import com.Twoks.Twoks.module.book.repository.BookRepo;
import com.Twoks.Twoks.utils.base.service.BaseService;

@Service
public class BookService extends BaseService<Book> {

	public BookService() {
		super(Book.class);
	}
	
	private BookRepo bookRepo;

	public BookRepo getBookRepo() {
		return bookRepo;
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = getBookRepo().findAll();
		return books;
	}
	
	public Book save(Book book) {
		Book newBook = getBookRepo().save(book);
		return newBook;
	}

}
