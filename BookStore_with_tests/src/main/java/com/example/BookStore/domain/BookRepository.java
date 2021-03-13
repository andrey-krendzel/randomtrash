package com.example.BookStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByisbn(long isbn);
	List<Book> findByAuthor(String author);

	List<Object> findByName(String political_books);
}
