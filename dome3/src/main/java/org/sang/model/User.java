package org.sang.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//import org.sang.model.Book;

@Component
@ConfigurationProperties(prefix = "book0")
public class User {

    private List<Book> books;
//    private   List<Book> books = new ArrayList<Book>();
//
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> Books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "books=" + books +
                '}';
    }
}

