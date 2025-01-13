package com.iban.library.book_management_system.controller;

import com.iban.library.book_management_system.model.Book;
import com.iban.library.book_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. Add a new book
    @PostMapping
    public ResponseEntity<Map<String, Object>> addBook(@RequestBody Book book) {
        Book createdBook = bookService.addBook(book);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book added successfully.");
        response.put("data", createdBook);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 2. Get all books
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Books retrieved successfully.");
        response.put("data", books);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 3. Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getBookById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book retrieved successfully.");
        response.put("data", book);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 4. Update a book
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book updated successfully.");
        response.put("data", updatedBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //5. Search a book
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookService.searchBooks(keyword);
    }

    // 6. Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Book deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
