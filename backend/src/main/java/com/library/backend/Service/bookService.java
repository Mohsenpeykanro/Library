package com.library.backend.Service;

import com.library.backend.Entity.book;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface bookService {

    public List<book> getBooks();
    public void addNewBook(book book);
    public void deleteBook(Integer bookId);
    @Transactional
    public void updateBook(Integer bookId, String name, String price);

}
