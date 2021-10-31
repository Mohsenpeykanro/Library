package com.library.backend.Service;

import com.library.backend.Entity.bookEntity;
import com.library.backend.Repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class bookService {
    private final bookRepository bookRepository;
    @Autowired
    public bookService(com.library.backend.Repository.bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<bookEntity> getBooks(){
        return bookRepository.findAll();
    }


    public void addNewBook(bookEntity book) {
        Optional<bookEntity> bookOptional =
                bookRepository.findbookEntityByname(book.getName());
        if (bookOptional.isPresent()){
            throw new IllegalStateException("book is exist");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Integer bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists){
            throw new IllegalStateException(
                    "book with id " + bookId + "does not exists");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Integer bookId, String name, String price) {
        bookEntity book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("book with id " + bookId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(book.getName(), book)){
            book.setName(name);
        }

        if (price != null && price.length() > 0 && !Objects.equals(book.getPrice(), price)){
            book.setPrice(price);
        }
    }
}
