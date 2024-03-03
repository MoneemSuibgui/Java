package com.model_tests.moneem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.model_tests.moneem.models.Author;
import com.model_tests.moneem.models.Book;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
class ModelTestsApplicationTests {
	
	private static  Validator validator;

	@Test
	void contextLoads() {
	}
	
	@BeforeAll
	static void setUp() {
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    validator = factory.getValidator();
	}
	
	// This test will pass, because we tested to see that the violations Set would not be empty using assertFalse
	@Test
	void assumeTitleIsNull() {
		// create an instance of Book model 
	    Book book = new Book();
	    
	    book.setDescription("Great Book");
	    book.setLanguage("English");
	    book.setNumberOfPages(734);
	    
	    Set<ConstraintViolation<Book>> violations = validator.validate(book);
	    assertFalse(violations.isEmpty());
	}

	
	@Test
	public void testAuthorModel() {
		Author newAuthor=new Author();
		
		newAuthor.setAge(55);
		newAuthor.setFullName("Steve jobs");
		
		Set<ConstraintViolation<Author>> violations = validator.validate(newAuthor);
		assertTrue(violations.isEmpty());
		System.out.println(newAuthor.getFullName());
	}
	
	
	@Test
	void testBookModel() {
	    Book book = new Book();
	    book.setTitle("Harry Potter and the Goblet of Fire");
	    book.setDescription("Great book");
	    book.setLanguage("English");
	    book.setNumberOfPages(777);
	    
	    Set<ConstraintViolation<Book>> violations = validator.validate(book);
	    for (ConstraintViolation<Book> violation : violations) {
	        System.out.println(violation.getMessage()); 
	    }
	    assertTrue(violations.isEmpty());
	}

}
