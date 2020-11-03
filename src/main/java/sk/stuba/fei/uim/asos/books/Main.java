package sk.stuba.fei.uim.asos.books;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sk.stuba.fei.uim.asos.books.ws.Author;
import sk.stuba.fei.uim.asos.books.ws.Book;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.Endpoint;
import java.time.LocalDate;

import static sk.stuba.fei.uim.asos.books.ws.BookType.KNIHA;

public class Main {

    public static void main(String[] args) throws DatatypeConfigurationException {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        BookService service = appContext.getBean(BookService.class);

        Book book = new Book();
        book.setName("The Lord of the Rings: The Fellowship of the Ring");
        book.setIsbn("978-000-748-830-8");
        book.setType(KNIHA);
        book.setPrice(10f);
        Author author = new Author();
        author.setName("John");
        author.setMiddleName("Ronald Reuel");
        author.setSurname("Tolkien");
        author.setBirthDate(LocalDate.of(2009, 5, 7));
        book.getAuthors().add(author);
        service.save(book);

        Endpoint.publish("http://localhost:8080/book", appContext.getBean(BookEndpoint.class));
    }
}
