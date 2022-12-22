package com.library.librarymanagesystem.services.serviceInterface;
import com.library.librarymanagesystem.data.models.Book;
import com.library.librarymanagesystem.dtos.request.*;
import com.library.librarymanagesystem.dtos.response.*;

import java.util.List;

public interface BookService {

    BookCreateResponse saveBook(BookCreateRequest bookCreateRequest);
    DeletedBookResponse deleteBookById(Long id);
    List<Book> getBookByAuthor(BookAuthorRequest bookAuthorRequestRequest);
    String deleteAll();
    BookResponse getBookById(Long id);
    BookResponse getBookByName(String name);
    List<Book> getAllBooks();
}
