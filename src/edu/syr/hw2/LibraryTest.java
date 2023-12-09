package edu.syr.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {
    private Library lib;
    private Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
    @BeforeEach
    public  void setup() {
        lib = new Library();
        lib.add(b1);
        lib.add(new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011));
        lib.add(new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016));
    }
    @Test
    public void mismatch() {
        List<Book> b = lib.search(new Book("Someone Else", "Learning Spark", "O'Reilly", "9781449358624", 2015));
        assertTrue( b== null || b.size()==0);
        b = lib.search(new Book("Holden Karau", "Something Else", "O'Reilly", "9781449358624", 2015));
        assertTrue( b== null || b.size()==0);
        b = lib.search(new Book("Holden Karau", "Learning Spark", "NONEXISTENT", "9781449358624", 2015));
        assertTrue( b== null || b.size()==0);
        b = lib.search(new Book("Holden Karau", "Learning Spark", "O'Reilly", "22222222222", 2015));
        assertTrue( b== null || b.size()==0);
        b = lib.search(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 1999));
        assertTrue( b== null || b.size()==0);
    }
    @Test
    public void findByAuthor() {
        List<Book> b = lib.search(new Book("Holden Karau", "", "", "", 0));
        assertTrue(b.get(0).getAuthor().equalsIgnoreCase("Holden Karau"));
        assertTrue(b.get(0).getTitle().equalsIgnoreCase("Learning Spark"));
        assertTrue(b.get(0).getPublisher().equalsIgnoreCase("O'Reilly"));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(0).getYearPublished()== 2015);
    }
    @Test
    public void findByPartialAuthor() {
        List<Book> b = lib.search(new Book("Karau", "", "", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByIgnoreCaseAuthor() {
        List<Book> b = lib.search(new Book("karau", "", "", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByTitle() {
        List<Book> b = lib.search(new Book("", "Learning Spark", "", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByPartialTitle() {
        List<Book> b = lib.search(new Book("", "Spark", "", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByIgnoreCaseTitle() {
        List<Book> b = lib.search(new Book("", "learning", "", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByPublisher() {
        List<Book> b = lib.search(new Book("", "", "O'Reilly", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByPartialPublisher() {
        List<Book> b = lib.search(new Book("", "", "Reilly", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByIgnoreCasePublisher() {
        List<Book> b = lib.search(new Book("", "", "reilly", "", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByIsbn() {
        List<Book> b = lib.search(new Book("", "", "", "9781449358624", 0));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
    @Test
    public void findByYear() {
        List<Book> b = lib.search(new Book("", "", "", "", 2015));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
    }
}