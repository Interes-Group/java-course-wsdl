package sk.stuba.fei.uim.asos.books;

import sk.stuba.fei.uim.asos.books.ws.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void save(Book book);
}