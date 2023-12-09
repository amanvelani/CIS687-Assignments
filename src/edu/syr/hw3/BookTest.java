package edu.syr.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

//  @Test
//  public void testTypeMatches() {
//    Book hard = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.HARDCOVER);
//    Book paper = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.PAPERBACK);
//    Book eBook = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.EBOOK);
//    Book any = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.ANY);
//
//     Testing same book but different type
//    assertFalse(hard.matches(paper));
//    assertFalse(hard.matches(eBook));
//    assertFalse(paper.matches(eBook));
//
//     Testing same book using ANY to match
//    assertTrue(any.matches(hard));
//    assertTrue(any.matches(paper));
//    assertTrue(any.matches(eBook));
//  }

    @Test
    void testEquals() {
        Book hard = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.HARDCOVER);
        Book paper = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.PAPERBACK);
        Book eBook = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.EBOOK);
        Book any = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.ANY);

        // Testing same book
        assertTrue(hard.equals(hard));

        assertFalse(hard.equals(paper));
        assertFalse(paper.equals(hard));

        assertFalse(hard.equals(eBook));
        assertFalse(eBook.equals(hard));

        assertFalse(hard.equals(any));
        assertFalse(any.equals(hard));

        assertFalse(paper.equals(eBook));
        assertFalse(eBook.equals(paper));

        assertFalse(paper.equals(any));
        assertFalse(any.equals(paper));

        assertFalse(eBook.equals(any));
        assertFalse(any.equals(eBook));
    }

    @Test
    void testHashCode() {
        Book hard = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.HARDCOVER);
        Book paper = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.PAPERBACK);
        Book eBook = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.EBOOK);
        Book any = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.ANY);

        assertNotEquals(hard.hashCode(), paper.hashCode());
        assertNotEquals(hard.hashCode(), eBook.hashCode());
        assertNotEquals(hard.hashCode(), any.hashCode());

        assertNotEquals(paper.hashCode(), eBook.hashCode());
        assertNotEquals(paper.hashCode(), any.hashCode());

        assertNotEquals(eBook.hashCode(), any.hashCode());
    }

    @Test
    void testToString() {
        try {
            Class c = Book.class.getMethod("toString").getDeclaringClass();
            assertTrue(c.equals(Book.class));
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }
}