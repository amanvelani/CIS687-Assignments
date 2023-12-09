package edu.syr.hw1;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class LibraryTest {
    Library library = new Library();
    @BeforeEach
    public void setup() {


        // Initialize the library with a catalog of publications
        String[] catalog = {
                "The Go Programming Language, Alan Donovan and Brian Kernighan",
                "Java for Beginners, Syracuse University",
                "Python for Beginners, abcd"
        };
        library.init(catalog);
    }
    @Test
    public void findBook() {
        //Search for a publication
        String query = "Python for Beginners";
        String result = library.search(query).toString();
        Assert.assertEquals("Python for Beginners, abcd", result);
    }
    @Test
    public void findBookCaseInsensitive() {
        // Search for a publication
        String query = "python for beginners";
        String result = library.search(query).toString();
        Assert.assertEquals("Python for Beginners, abcd", result);
    }
    @Test
    public void noMatchFound() {
        // Search for a publication
        String query = "junk value";
        String result = library.search(query).toString();
        assertTrue(result == null || result.isEmpty());
    }

    @Test
    public void searchSubstring() {
        // Search for a publication
        String query = "python";
        String result = library.search(query).toString();
        Assert.assertEquals("Python for Beginners, abcd", result);
    }
}