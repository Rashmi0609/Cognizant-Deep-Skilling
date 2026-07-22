package com.cognizant.spring.service;

import com.cognizant.spring.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void display() {
        System.out.println("Book Service Called");
        bookRepository.saveBook();
    }
} 