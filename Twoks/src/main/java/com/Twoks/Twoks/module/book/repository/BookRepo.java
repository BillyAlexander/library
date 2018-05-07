package com.Twoks.Twoks.module.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Twoks.Twoks.module.book.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
