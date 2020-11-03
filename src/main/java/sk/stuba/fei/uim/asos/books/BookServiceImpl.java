package sk.stuba.fei.uim.asos.books;

import sk.stuba.fei.uim.asos.books.ws.Book;

import java.util.LinkedList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final List<Book> books;

    public BookServiceImpl() {
        this.books = new LinkedList<Book>();
    }

    public List<Book> findAll() {
        return books;
    }

    public void save(Book book) {
        books.add(book);
    }
}
