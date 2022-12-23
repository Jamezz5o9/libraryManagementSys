package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.data.models.Book;
import com.library.librarymanagesystem.dtos.request.BookAuthorRequest;
import com.library.librarymanagesystem.dtos.request.BookCreateRequest;
import com.library.librarymanagesystem.dtos.response.*;
import com.library.librarymanagesystem.exception.*;
import com.library.librarymanagesystem.data.repository.BookRepository;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
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
    private AuthorService authorService;


    @Override
    public BookCreateResponse createBook(BookCreateRequest bookCreateRequest) {
        if(bookRepository.findBookByIsbn(bookCreateRequest.getIsbn()).isPresent()) throw new BookException("Book with " + bookCreateRequest.getIsbn() + " already exist");
        Author author = authorService.getAuthorById(bookCreateRequest.getAuthorId());
        Book book = new Book();
        book.setIsbn(bookCreateRequest.getIsbn());
        book.getBookAuthor().add(author);
        book.setBookTitle(bookCreateRequest.getBookTitle());
        book.setAvailableQuantity(bookCreateRequest.getIsbn());
        book.setYearPublished(bookCreateRequest.getYearPublished());
        Book savedBook = bookRepository.save(book);
        return mapper.map(savedBook, BookCreateResponse.class);
    }

    @Override
    public String deleteBookById(Long id) {
        bookRepository.deleteById(id);
        return "Book with " + id + " deleted successfully";
    }
    @Override
    public List<Book> viewBookByAuthor(BookAuthorRequest authorRequest) {
        return null;
    }

    @Override
    public String deleteAllBooks() {
        bookRepository.deleteAll();
        return "All Books deleted successfully";
    }

    @Override
    public Book viewBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookException("Book with " + id + " doesn't exist"));

    }
    @Override
    public Book viewBookByName(String name) {
        return bookRepository.findBookByName(name).orElseThrow(() -> new BookException("Book with "+ name + " doesn't exist"));
    }

    @Override
    public List<Book> viewAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public String deleteBookByIsbn(Long isbn) {
        bookRepository.deleteBookByIsbn(isbn);
        return "Book deleted successfully";
    }

    @Override
    public Book viewBookByIsbn(Long isbn) {
        return bookRepository.findBookByIsbn(isbn).orElseThrow(() -> new BookException("Book with " + isbn + " does'nt exist"));
    }

}
