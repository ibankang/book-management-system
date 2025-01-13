package com.iban.library.book_management_system.service;

import com.iban.library.book_management_system.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

public interface BookService {


    Book addBook(Book book);
    Page<Book> getAllBooks(Pageable pageable);
    List<Book> getAllBooks();
    Book getBookById(Integer id);
    Book updateBook(Integer id, Book book);
    boolean deleteBook(Integer id);
    List<Book> searchBooks(String keyword);

}
