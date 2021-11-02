package com.library.backend.Service;

import com.library.backend.Entity.bookEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface bookService {

    public List<bookEntity> getBooks();
    public void addNewBook(bookEntity book);
    public void deleteBook(Integer bookId);
    @Transactional
    public void updateBook(Integer bookId, String name, String price);

}
