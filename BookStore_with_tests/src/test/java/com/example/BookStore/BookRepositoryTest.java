package com.example.BookStore;

import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookRepository;
import com.example.BookStore.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = repository.findByAuthor("Mussolini");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("The Fascist Manifesto");
    }

    @Test
    public void createNewBook() {

        Book newBook = new Book(1111, "Mickey", "Mouse", 1945, 15, new Category("Mickey Mouse books"));
        repository.save(newBook);
        assertThat(newBook.getId()).isNotNull();
    }
}
