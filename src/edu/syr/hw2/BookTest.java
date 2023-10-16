package edu.syr.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void authorMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Holden Karau", "", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void authorSubstringMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Holden", "", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void authorIgnoreCaseMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("holden", "", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void titleMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "Learning Spark", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void titleSubstringMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "earning", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void titleIgnoreCaseMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "spark", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void publisherMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "", "O'Reilly", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void publisherSubstringMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "", "Reilly", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void publisherIgnoreCaseMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "", "reilly", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void isbnMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "", "", "9781449358624", Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void partialIsbnNoMatch() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "", "", "49358624", Integer.MIN_VALUE);
        assertFalse(b1.matches(b2));
    }
    @Test
    public void yearMatches() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "", "", "", 2015);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void yearMismatch() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("", "", "", "", 1999);
        assertFalse(b1.matches(b2));
    }
    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        assertTrue(b1.equals(b1));
        Book b2 = new Book("holden karau", "learning spark", "o'reilly", "9781449358624", 2015);
        assertTrue(b1.equals(b2));
        assertTrue(b2.equals(b1));
        Book b3 = new Book("", "learning spark", "o'reilly", "9781449358624", 2015);
        assertFalse(b1.equals(b3));
        Book b4 = new Book("holden karau", "learning", "o'reilly", "9781449358624", 2015);
        assertFalse(b1.equals(b4));
        Book b5 = new Book("holden karau", "learning spark", "", "4", 2015);
        assertFalse(b1.equals(b5));
        Book b6 = new Book("holden karau", "learning spark", "o'reilly", "9781449358624", 20);
        assertFalse(b1.equals(b6));
    }

    @Test
    void testHashCode() {
        Book b1 = new Book("Holden Karau", "Learning Spark", "", "", -1);
        Book b2 = new Book("Learning Spark", "Holden Karau", "", "", -1);
        assertNotEquals(b1.hashCode(), b2.hashCode());
        Book b3 = new Book("Holden Karau", "Learning Spark", "", "", -1);
        assertEquals(b1.hashCode(), b3.hashCode());
    }
}