package com.Twoks.Twoks.module.author.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Twoks.Twoks.module.author.entity.Author;
import com.Twoks.Twoks.module.author.repository.AuthorRepo;
import com.Twoks.Twoks.utils.base.service.BaseService;

@Service
public class AuthorService extends BaseService<Author> {

	public AuthorService() {
		super(Author.class);
	}
	
	@Autowired
	private AuthorRepo authorRepo;

	public AuthorRepo getAuthorRepo() {
		return authorRepo;
	}
	
	public List<Author> getAllAuthores(){
		List<Author> authores = getAuthorRepo().findAll();
		return authores;
	}
	
	public Author save(Author newAuthor) {
		Author author = getAuthorRepo().save(newAuthor);
		return author;
	}
	
	public void delete(Long id) {
		Author author = getAuthorRepo().getOne(id);
		if(author != null) {
			author.setStatus(false);
			getAuthorRepo().save(author);
		}
	}

}
