package com.library.librarymanagesystem.services.serviceInterface;
import com.library.librarymanagesystem.data.models.Book;
import com.library.librarymanagesystem.dtos.request.*;
import com.library.librarymanagesystem.dtos.response.*;

import java.util.List;

public interface BookService {

    BookCreateResponse createBook(BookCreateRequest bookCreateRequest);
    String deleteBookById(Long id);
    List<Book> viewBookByAuthor(BookAuthorRequest bookAuthorRequestRequest);
    String deleteAllBooks();
    Book viewBookById(Long id);
    Book viewBookByName(String name);
    List<Book> viewAllBooks();
    String deleteBookByIsbn(Long isbn);
    Book viewBookByIsbn(Long isbn);
}
