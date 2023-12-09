package edu.syr.hw3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library lib;

    @BeforeEach
    public void setup() {
        lib = new Library();
        lib.add(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.HARDCOVER));
        lib.add(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.PAPERBACK));
        lib.add(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.EBOOK));

        lib.add(new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011, BookType.HARDCOVER));
        lib.add(new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011, BookType.PAPERBACK));

        lib.add(new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.EBOOK));
    }

    @Test
    public void testSearchType() {
        List<Book> b = lib.search(new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.HARDCOVER));
        assertTrue(b == null || b.size() == 0);
        b = lib.search(new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.PAPERBACK));
        assertTrue(b == null || b.size() == 0);
        b = lib.search(new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.EBOOK));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9780134190440"));
        b = lib.search(new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9780134190440"));

        b = lib.search(new Book(null, null, null, null, -1, BookType.HARDCOVER));
        assertEquals(2, b.size());
        b = lib.search(new Book(null, null, null, null, -1, BookType.EBOOK));
        assertEquals(2, b.size());
        b = lib.search(new Book(null, null, null, null, -1, BookType.PAPERBACK));
        assertEquals(2, b.size());
        b = lib.search(new Book(null, null, null, null, -1, BookType.ANY));
        assertEquals(6, b.size());
    }

    @Test
    public void mismatch() {
        List<Book> b = lib.search(new Book("Someone Else", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.ANY));
        assertTrue(b == null || b.size() == 0);
        b = lib.search(new Book("Holden Karau", "Something Else", "O'Reilly", "9781449358624", 2015, BookType.ANY));
        assertTrue(b == null || b.size() == 0);
        b = lib.search(new Book("Holden Karau", "Learning Spark", "NONEXISTENT", "9781449358624", 2015, BookType.ANY));
        assertTrue(b == null || b.size() == 0);
        b = lib.search(new Book("Holden Karau", "Learning Spark", "O'Reilly", "22222222222", 2015, BookType.ANY));
        assertTrue(b == null || b.size() == 0);
        b = lib.search(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 1999, BookType.ANY));
        assertTrue(b == null || b.size() == 0);
    }

    @Test
    public void findByAuthor() {
        List<Book> b = lib.search(new Book("Holden Karau", null, null, null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByPartialAuthor() {
        List<Book> b = lib.search(new Book("Karau", null, null, null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByIgnoreCaseAuthor() {
        List<Book> b = lib.search(new Book("holden Karau", null, null, null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByTitle() {
        List<Book> b = lib.search(new Book(null, "Learning Spark", null, null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByPartialTitle() {
        List<Book> b = lib.search(new Book(null, "Spark", null, null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByIgnoreCaseTitle() {
        List<Book> b = lib.search(new Book(null, "learning Spark", null, null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByPublisher() {
        List<Book> b = lib.search(new Book(null, null, "O'Reilly", null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByPartialPublisher() {
        List<Book> b = lib.search(new Book(null, null, "Reilly", null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByIgnoreCasePublisher() {
        List<Book> b = lib.search(new Book(null, null, "O'reilly", null, -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByIsbn() {
        List<Book> b = lib.search(new Book(null, null, null, "9781449358624", -1, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }

    @Test
    public void findByYear() {
        List<Book> b = lib.search(new Book(null, null, null, null, 2015, BookType.ANY));
        assertTrue(b.get(0).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(1).getIsbn().equalsIgnoreCase("9781449358624"));
        assertTrue(b.get(2).getIsbn().equalsIgnoreCase("9781449358624"));
    }
}