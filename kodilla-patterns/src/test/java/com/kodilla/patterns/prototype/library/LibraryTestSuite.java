package com.kodilla.patterns.prototype.library;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LibraryTestSuite {

    Library library = new Library("Library");

    @Before public void initialize() {
        Set<Book> booksNewBook = new HashSet<>();
        booksNewBook.add(new Book("amiętnik carycy", "Maria Fiodorowna", LocalDate.of(2016, 7, 7)));
        booksNewBook.add(new Book("Historia w dziesięciu meczach", "Anatomia Liverpoolu", LocalDate.of(2018, 12, 1)));
        booksNewBook.add(new Book("Przyszłość architektury w 100 budynkach (TED Books)", "Marc Kushner", LocalDate.of(2016, 1, 2)));
        booksNewBook.stream()
                .forEach(book -> library.addBook(book));
    }

    @Test
    public void testGetBooksObtainedClones1() {
        // Given

        // When
        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            fail("Exception " + e);
        }

        // Then
        assertFalse(shallowClonedLibrary == library);
        assertFalse(deepClonedLibrary == library);
        assertEquals(shallowClonedLibrary.getBooks(), library.getBooks());
        assertEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }

    @Test
    public void testGetBooksObtainedClones2() {
        // Given

        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            fail("Exception " + e);
        }

        // When
        library.addBook(new Book("Wersy w czarnym smokingu/Man in Black Attire", "Jakub Zięba", LocalDate.of(2017, 6, 7)));

        // Then
        assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}
