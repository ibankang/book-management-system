package com.iban.library.book_management_system.service;

import com.iban.library.book_management_system.exception.BookNotFoundException;
import com.iban.library.book_management_system.exception.NoBooksFoundException;
import com.iban.library.book_management_system.model.Book;
import com.iban.library.book_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book){
        return bookRepository.save(book); // Save a new book
    }

    @Override
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);  // Returns paginated and sorted books
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Retrieve all books
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(keyword);
        if (books.isEmpty()) {
            throw new NoBooksFoundException("No books found with the keyword: " + keyword);
        }
        return books;
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        // Fetch the existing book by ID or throw exception if not found
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));

        // Update fields with the new data
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());

        // Save the updated book and return it
        return bookRepository.save(existingBook);
    }


    @Override
    public boolean deleteBook(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
        bookRepository.deleteById(id);  // Delete the book from the repository
        return true;  // Return true after successfully deleting the book
    }


}
