package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.dtos.request.BookAuthorRequest;
import com.library.librarymanagesystem.dtos.request.BookCreateRequest;
import com.library.librarymanagesystem.dtos.request.UpdateBookRequest;
import com.library.librarymanagesystem.dtos.response.*;
import com.library.librarymanagesystem.exception.AuthorException;
import com.library.librarymanagesystem.models.*;
import com.library.librarymanagesystem.repository.AuthorRepository;
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
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public BookCreateResponse createNewBook(BookCreateRequest bookCreateRequest) {
        Author bookAuthor = authorRepository.findById(bookCreateRequest.getAuthorId()).orElseThrow(() -> new AuthorException("Author does not exist"));
        Book book = Book.builder()
                .isbn(bookCreateRequest.getIsbn())
                .bookTitle(bookCreateRequest.getBookTitle())
                .yearPublished(bookCreateRequest.getYearPublished())
                .bookAuthor(bookAuthor)
                .availableQuantity(0L)
                .build();
        Book savedBook = bookRepository.save(book);
        return mapper.map(savedBook, BookCreateResponse.class);
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
