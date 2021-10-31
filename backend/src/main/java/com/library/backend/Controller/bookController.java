package com.library.backend.Controller;

import com.library.backend.Entity.bookEntity;
import com.library.backend.Entity.userEntity;
import com.library.backend.Service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "book")
public class bookController {

    private final bookService bookService;
    @Autowired
    public bookController(com.library.backend.Service.bookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void registerNewBook(@RequestBody bookEntity book){
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId){
        bookService.deleteBook(bookId);
    }


    @PutMapping(path = "/update/{bookId}")
    public void updateBook(@PathVariable("bookId") Integer bookId, @RequestParam(required = false) String name, @RequestParam(required = false) String price){
        bookService.updateBook(bookId, name, price);
    }
}
