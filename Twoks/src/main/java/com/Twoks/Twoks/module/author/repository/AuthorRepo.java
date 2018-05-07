package com.Twoks.Twoks.module.author.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Twoks.Twoks.module.author.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
	
}
