package com.example.BookStore;

import com.example.BookStore.controller.BookStoreApplicationController;
import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookStoreApplicationTests {

	@Autowired
	private BookStoreApplicationController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}


}
