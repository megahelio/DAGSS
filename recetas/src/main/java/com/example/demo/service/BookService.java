package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listAllBook() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(Integer id) {
        return bookRepository.findById(id).get();
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}