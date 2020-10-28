package sk.stuba.fei.uim.asos.books;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/book", new BookEndpoint());
    }
}
