package com.iban.library.book_management_system;

import com.iban.library.book_management_system.model.Book;
import com.iban.library.book_management_system.repository.BookRepository;
import com.iban.library.book_management_system.service.BookService;
import com.iban.library.book_management_system.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    private Book book;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookServiceImpl(bookRepository);
        book = new Book("Java Basics", "John Doe", 150.00);
        book.setId(1); // Simulate an auto-generated ID
    }

    @Test
    public void testAddBook() {
        when(bookRepository.save(book)).thenReturn(book);

        Book addedBook = bookService.addBook(book);

        assertEquals(book, addedBook);
        System.out.println("Book successfully added: " + addedBook);
    }

    @Test
    public void testGetAllBooks() {
        // Mock the repository to return a list of books
        Book book1 = new Book("Java Basics", "John Doe", 150.00);
        Book book2 = new Book("Advanced Java", "Jane Smith", 200.00);

        book1.setId(1);
        book2.setId(2);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.getAllBooks();
        assertEquals(2, books.size());  // Ensure 2 books are returned
        System.out.println("Books found successfully: " + books);  // Print list of books
    }

    @Test
    public void testGetBookById() {
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        Book retrievedBook = bookService.getBookById(1);

        assertNotNull(retrievedBook);
        assertEquals(book, retrievedBook);
        System.out.println("Book retrieved successfully: " + retrievedBook);
    }

    @Test
    public void testUpdateBook() {
        // Mocked data: Existing book in the repository
        Book existingBook = new Book("Java Basics", "John Doe", 150.00);
        existingBook.setId(1);

        // Mocked data: Updated book details
        Book updatedBook = new Book("Advanced Java", "John Doe", 200.00);
        updatedBook.setId(1);

        // Simulate repository behavior
        when(bookRepository.findById(1)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        // Call the service method
        Book result = bookService.updateBook(1, updatedBook);

        // Assertions
        assertNotNull(result);
        assertEquals("Advanced Java", result.getTitle());
        assertEquals(200.00, result.getPrice(), 0.01);
        System.out.println("Book updated successfully: " + result);
    }


    @Test
    public void testDeleteBook() {
        when(bookRepository.existsById(1)).thenReturn(true);

        boolean isDeleted = bookService.deleteBook(1);

        assertTrue(isDeleted);
        verify(bookRepository, times(1)).deleteById(1);
        System.out.println("Book deleted successfully.");
    }

    @Test
    public void testSearchBooks() {
        Book book1 = new Book("Java Basics", "John Doe", 150.00);
        Book book2 = new Book("Advanced Java", "Jane Smith", 200.00);

        book1.setId(1);
        book2.setId(2);

        when(bookRepository.findByTitleContainingIgnoreCase("Java")).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.searchBooks("Java");
        assertEquals(2, books.size());  // Ensure 2 books match the search
        System.out.println("Books retrieved successfully: " + books);  // Print found books
    }

}
