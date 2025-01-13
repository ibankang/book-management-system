package com.iban.library.book_management_system;

import com.iban.library.book_management_system.exception.NoBooksFoundException;
import com.iban.library.book_management_system.model.Book;
import com.iban.library.book_management_system.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BookServiceTest {

//    @Autowired
//    private BookService bookService;
//
//    @Test
//    public void testAddBook() {
//        Book book = new Book("Effective C", "Aman", 80.99);
//        bookService.addBook(book);
//        assertNotNull("Book ID should not be null after adding", book.getId());
//    }
//
//    @Test(expected = NoBooksFoundException.class)
//    public void testSearchBooksNoResults() {
//        // Assuming the searchBooks method throws NoBooksFoundException when no books are found
//        bookService.searchBooks("nonexistentbook");
//    }
}
