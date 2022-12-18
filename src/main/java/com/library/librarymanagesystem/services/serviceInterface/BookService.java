package com.library.librarymanagesystem.services.serviceInterface;
import com.library.librarymanagesystem.dtos.request.*;
import com.library.librarymanagesystem.dtos.response.*;
import com.library.librarymanagesystem.models.Book;

import java.util.List;

public interface BookService {

    BookCreateResponse createNewBook(BookCreateRequest bookCreateRequest);
    DeletedBookResponse deleteBookById(Long id);
    BookAuthorResponse findBookByAuthor(BookAuthorRequest bookAuthorRequestRequest);
    String deleteAll();
    BookResponse viewBook(Long id);
    List<BookResponse> bookList();
    UpdateBookResponse updateBookQuantity(UpdateBookRequest updateBookRequest);
}
