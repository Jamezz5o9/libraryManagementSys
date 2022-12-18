package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.dtos.request.BookAuthorRequest;
import com.library.librarymanagesystem.dtos.request.BookCreateRequest;
import com.library.librarymanagesystem.dtos.request.UpdateBookRequest;
import com.library.librarymanagesystem.dtos.response.*;
import com.library.librarymanagesystem.models.Book;
import com.library.librarymanagesystem.repository.BookRepository;
import com.library.librarymanagesystem.services.serviceInterface.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    private Long count;


    @Override
    public BookCreateResponse createNewBook(BookCreateRequest bookCreateRequest) {
        Book book = new Book();
        book.setBookId(++count);
//        book.setAuthor(bookCreateRequest.);
        return null;
    }

    @Override
    public DeletedBookResponse deleteBookById(Long id) {
        return null;

    }

    @Override
    public BookAuthorResponse findBookByAuthor(BookAuthorRequest authorRequest) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public BookResponse viewBook(Long id) {
        return null;
    }

    @Override
    public List<BookResponse> bookList() {
        return null;
    }

    @Override
    public UpdateBookResponse updateBookQuantity(UpdateBookRequest updateBookRequest) {
        return null;
    }
}
