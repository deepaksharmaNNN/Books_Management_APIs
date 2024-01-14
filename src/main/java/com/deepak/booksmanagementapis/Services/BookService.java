package com.deepak.booksmanagementapis.Services;

import com.deepak.booksmanagementapis.Entities.Book;
import com.deepak.booksmanagementapis.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book save(Book book){
        return bookRepository.save(book);
    }
    public Optional<Book> findBookById(String isbn) throws Exception{
        Optional<Book> foundBook = bookRepository.findById(isbn);
        if(foundBook.isEmpty()) throw new Exception("No book is present with this Id");
        else return foundBook;
    }

    public List<Book> listBooks(){
        return bookRepository.findAll();
    }

    public boolean isBookExist(String isbn){
        return bookRepository.existsById(isbn);
    }

    public void deleteBookById(String isbn){
        bookRepository.deleteById(isbn);
    }
}
