package com.iban.library.book_management_system.controller;

import com.iban.library.book_management_system.model.Book;
import com.iban.library.book_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        if (book.getPrice() <= 0) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Price must be greater than 0.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        Book createdBook = bookService.addBook(book);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book added successfully.");
        response.put("data", createdBook);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 2. Get all books with pagination and sorting
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllBooks(Pageable pageable) {
        Page<Book> books = bookService.getAllBooks(pageable); // Uses Pageable for pagination
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Books retrieved successfully.");
        response.put("data", books.getContent());
        response.put("totalPages", books.getTotalPages());
        response.put("totalItems", books.getTotalElements());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 3. Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getBookById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Book not found.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book retrieved successfully.");
        response.put("data", book);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 4. Update a book
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Book not found or update failed.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book updated successfully.");
        response.put("data", updatedBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 5. Search books by keyword
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchBooks(@RequestParam String keyword) {
        List<Book> books = bookService.searchBooks(keyword);
        Map<String, Object> response = new HashMap<>();
        if (books.isEmpty()) {
            response.put("message", "No books found for the given keyword.");
        } else {
            response.put("message", "Books retrieved successfully.");
        }
        response.put("data", books);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 6. Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable Integer id) {
        boolean isDeleted = bookService.deleteBook(id);
        Map<String, String> response = new HashMap<>();
        if (isDeleted) {
            response.put("message", "Book deleted successfully.");
            return new ResponseEntity<>(response, HttpStatus.OK);  // Return 200 OK
        } else {
            response.put("message", "Book not found or deletion failed.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);  // Return 404 if not found
        }
    }
}
