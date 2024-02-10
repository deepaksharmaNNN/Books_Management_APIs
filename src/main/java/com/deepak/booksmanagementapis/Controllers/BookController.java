package com.deepak.booksmanagementapis.Controllers;

import com.deepak.booksmanagementapis.Entities.Book;
import com.deepak.booksmanagementapis.Services.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@AllArgsConstructor

public class BookController {
    @Autowired
    private BookService bookService;
    @PutMapping(path = "/book")
    public ResponseEntity<String> updateBook(@RequestBody Book book){
        boolean isExist = bookService.isBookExist(book.getIsbn());
        Book savedBook = bookService.save(book);
        if(isExist) {
            return new ResponseEntity<>("Book with ISBN " + savedBook.getIsbn() + " updated successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Book with ISBN " + savedBook.getIsbn() + " created successfully", HttpStatus.CREATED);
        }
    }
    @GetMapping(path = "/findBook")
    public ResponseEntity<String> findBookById(String isbn) {
        try {
            Optional<Book> foundBook = bookService.findBookById(isbn);
            if (foundBook.isPresent()) {
                return new ResponseEntity<>("Found Book with ISBN " + isbn, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No book found with ISBN " + isbn, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.listBooks(),HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteBook")
    public ResponseEntity<String> deleteBookById(String isbn){
        boolean isExist = bookService.isBookExist(isbn);
        if(isExist){
            bookService.deleteBookById(isbn);
            return new ResponseEntity<>("Book Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book Not Found" ,HttpStatus.NOT_FOUND);
    }
}
