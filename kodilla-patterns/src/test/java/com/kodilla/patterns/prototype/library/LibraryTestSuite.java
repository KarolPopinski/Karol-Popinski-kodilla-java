package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {

        Library library = new Library("Library number 1");
        library.getBooks().add(new Book("Paszczaki", "Jan Testowy", LocalDate.of(2012, 5, 28)));
        library.getBooks().add(new Book("Gejsze", "Testowy Adam", LocalDate.of(2002, 8, 3)));
        library.getBooks().add(new Book("Food Truck", "Miki Sam", LocalDate.of(2008, 8, 4)));
        library.getBooks().add(new Book("Draftozaur", "Ufo Azipy", LocalDate.of(2014, 10, 10)));

        //making a shallow copy obj. library
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library number 2");
        }catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy obj. library
        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepCopy();
            deepCloneLibrary.setName("Library number 3");
        }catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        deepCloneLibrary.getBooks().add(new Book("Sen", "GameWright", LocalDate.of(1996, 12, 6)));

        //When
        //Then
        System.out.println(library);
        System.out.println();
        System.out.println(clonedLibrary);
        System.out.println();
        System.out.println(deepCloneLibrary);
        assertEquals(4, library.getBooks().size());
        assertEquals(4, clonedLibrary.getBooks().size());
        assertEquals(5, deepCloneLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepCloneLibrary.getBooks(), library.getBooks());

    }
}
