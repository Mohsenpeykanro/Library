package com.library.backend.Implementation;

import com.library.backend.Entity.book;
import com.library.backend.Repository.bookRepository;
import com.library.backend.Service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class bookImpl implements bookService {

    // Repository
    private final bookRepository bookRepository;
    @Autowired
    bookImpl(com.library.backend.Repository.bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Show All Book
    @Override
    public List<book> getBooks() {
        return bookRepository.findAll();
    }

    // Add New Book
    @Override
    public void addNewBook(book book) {
        Optional<com.library.backend.Entity.book> bookOptional =
                bookRepository.findbookEntityByname(book.getName());
        if (bookOptional.isPresent()){
            throw new IllegalStateException("book is exist");
        }
        bookRepository.save(book);
    }

    //Delete Book
    @Override
    public void deleteBook(Integer bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists){
            throw new IllegalStateException(
                    "book with id " + bookId + "does not exists");
        }
        bookRepository.deleteById(bookId);
    }

    //Update Book
    @Override
    public void updateBook(Integer bookId, String name, String price) {
        book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("book with id " + bookId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(book.getName(), book)){
            book.setName(name);
        }

        if (price != null && price.length() > 0 && !Objects.equals(book.getPrice(), price)){
            book.setPrice(price);
        }
    }
}
