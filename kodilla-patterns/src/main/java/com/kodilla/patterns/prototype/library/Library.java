package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("null");
        }
        return books.add(book);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for(Book theBook : books) {
            Book clonedBooks = new Book(theBook.getTitle(), theBook.getAuthor(),theBook.getPublicationDate() );
            clonedLibrary.getBooks().add(clonedBooks);
        }
        return clonedLibrary;
    }
    @Override
    public String toString() {
        return name;
    }


}

