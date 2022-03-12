package com.luv2kode.adapters;

import com.luv2kode.data.BookDto;
import com.luv2kode.entity.Book;
import com.luv2kode.mappers.BookMapper;
import com.luv2kode.ports.spi.BookPersistencePort;
import com.luv2kode.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookJpaAdapter implements BookPersistencePort{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto addBook(BookDto bookDto) {

        Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);

        Book bookSaved = bookRepository.save(book);

        return BookMapper.INSTANCE.bookToBookDto(bookSaved);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {

        List<Book> bookList = bookRepository.findAll();

        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
    }

    @Override
    public BookDto getBookById(Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            return BookMapper.INSTANCE.bookToBookDto(book.get());
        }

        return null;
    }
}
