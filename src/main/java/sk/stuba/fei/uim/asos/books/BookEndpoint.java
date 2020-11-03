package sk.stuba.fei.uim.asos.books;

import sk.stuba.fei.uim.asos.books.ws.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "BookServicePortType", targetNamespace = "books")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class BookEndpoint implements BookServicePortType {

    private BookService bookService;

    public BookEndpoint(BookService bookService) {
        this.bookService = bookService;
    }

    public Books list() {
        Books books = new Books();
        books.getBook().addAll(bookService.findAll());
        return books;
    }
}
