# Java Web services with WSDL
![License MIT](https://img.shields.io/badge/License-MIT-green)
![Java 1.8](https://img.shields.io/badge/Java-1.8-blue)

Cieľom projektu je demonštrovať jednoduchú SAO aplikáciu s webovou službou definovanú pomocou WSDL schémy.
Aplikácia implementuje spracovanie WSDL schémy pre webovú službu,
spracovanie XML súborov pre automatické generovanie POJO tried.

## JAXB
JAXB je využívaný aplikáciou, ako maven plugin.
XML súbory definujúce triedy sú umiestnené `src/main/resources/`.
Vygenerované triedy sú umiestnené v `target/generated-sources/java/`.

Viac informácií o JAXB [baeldung.com](https://www.baeldung.com/jaxb).

### Vygenerovanie tried
Pre vygenerovanie tried pomocou JAXB Maven plugin
```
mvn clean compile
```

## Web service
Aplikácia implementuje webovú službu s jedným endpointom `http://localhost:8080/book`,
ktorý vráti zoznam kníh v aplikácii.

### Test
Testovať implementovanú webovú službu je možné pomocou [SoapUI](https://www.soapui.org/),
alebo cez cUrl.

Request
```
curl -v -H "Content-Type: text/xml; charset=utf-8" -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body/></soapenv:Envelope>" -X POST http://localhost:8080/book  
```

Response
```
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <listResponse xmlns="books">
         <book isbn="123456789">
            <name>Lord of the Rings</name>
            <type>kniha</type>
         </book>
      </listResponse>
   </S:Body>
</S:Envelope>
```

## Build
Pre kompilovanie aplikácie
```
mvn clean package
```

## Run
Pre spustenie aplikácie po vygenerovaní tried
```
java -jar target/java-course-wsdl-1.0.jar
```