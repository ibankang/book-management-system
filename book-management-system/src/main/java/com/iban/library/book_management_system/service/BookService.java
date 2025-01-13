package com.iban.library.book_management_system.service;

import com.iban.library.book_management_system.model.Book;
import com.iban.library.book_management_system.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {


    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Integer id);
    Book updateBook(Integer id, Book book);
    void deleteBook(Integer id);
    List<Book> searchBooks(String keyword);

}
