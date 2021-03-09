package edu.suse.bookstore.domain;

import java.io.Serializable;
import java.util.List;

public class OrderExt implements Serializable {
    private  List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}