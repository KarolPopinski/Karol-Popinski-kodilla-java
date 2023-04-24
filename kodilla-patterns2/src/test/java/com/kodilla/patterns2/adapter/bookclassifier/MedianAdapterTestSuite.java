package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("AuthorTest1", "TestTitle1", 1990, "B190");
        Book book2 = new Book("AuthorTest2", "TestTitle2", 1980, "B180");
        Book book3 = new Book("AuthorTest3", "TestTitle3", 1970, "B170");
        Book book4 = new Book("AuthorTest4", "TestTitle4", 1960, "B160");

        Set<Book> bookSet = new HashSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println(publicationYearMedian);
        assertEquals(1980, publicationYearMedian);

    }
}
