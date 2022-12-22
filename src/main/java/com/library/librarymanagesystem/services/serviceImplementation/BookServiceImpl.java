package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.data.models.Book;
import com.library.librarymanagesystem.dtos.request.BookAuthorRequest;
import com.library.librarymanagesystem.dtos.request.BookCreateRequest;
import com.library.librarymanagesystem.dtos.response.*;
import com.library.librarymanagesystem.exception.AuthorException;
import com.library.librarymanagesystem.data.repository.AuthorRepository;
import com.library.librarymanagesystem.data.repository.BookRepository;
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
    public BookCreateResponse saveBook(BookCreateRequest bookCreateRequest) {
        Author bookAuthor = authorRepository.findById(bookCreateRequest.getAuthorId()).orElseThrow(() -> new AuthorException("Author does not exist"));
        Book book = Book.builder()
                .isbn(bookCreateRequest.getIsbn())
                .bookTitle(bookCreateRequest.getBookTitle())
                .yearPublished(bookCreateRequest.getYearPublished())
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
    public List<Book> getBookByAuthor(BookAuthorRequest authorRequest) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public BookResponse getBookById(Long id) {
        return null;

    }

    @Override
    public BookResponse getBookByName(String name) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

}
