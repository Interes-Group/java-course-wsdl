package sk.stuba.fei.uim.asos.books;

import sk.stuba.fei.uim.asos.books.ws.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.LinkedList;
import java.util.List;

@WebService(name = "BookServicePortType", targetNamespace = "books")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class BookEndpoint implements BookServicePortType {

    private final List<Book> books;

    public BookEndpoint() {
        this.books = new LinkedList<Book>();
        Book book = new Book();
        book.setType(BookType.KNIHA);
        book.setName("Lord of the Rings");
        book.setIsbn("123456789");
        books.add(book);
    }

    public Books list() {
        Books books = new Books();
        books.getBook().addAll(this.books);
        return books;
    }
}
