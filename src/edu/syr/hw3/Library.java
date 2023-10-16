// SUID: 982212915
package edu.syr.hw3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> catalog;
    public Library() {
        catalog = new ArrayList<>();
    }
    public void add(Book b) {
        if(b != null){
            if(b.getAuthor() == null
                    || b.getTitle() == null
                    || b.getPublisher() == null
                    || b.getIsbn() == null
                    || b.getYearPublished() <= 0
                    || b.getType() == BookType.ANY) {
                System.out.println("Missing one or more attributes!");
            }
            else {
                catalog.add(b);
            }
        }else{
            System.out.println("Book is null!");
        }

    }
    public List<Book> search(Book lookFor) {
        List<Book> results = new ArrayList<>();

        for (Book curr: catalog) {
            if (lookFor.getAuthor() != null) {
                if (!curr.getAuthor().toLowerCase().trim().contains(lookFor.getAuthor().toLowerCase().trim())) {
                    continue;
                }
            }
            if (lookFor.getTitle() != null) {
                if (!curr.getTitle().toLowerCase().trim().contains(lookFor.getTitle().toLowerCase().trim())) {
                    continue;
                }
            }
            if (lookFor.getPublisher() != null) {
                if (!curr.getPublisher().toLowerCase().trim().contains(lookFor.getPublisher().toLowerCase().trim())) {
                    continue;
                }
            }
            if (lookFor.getIsbn() != null) {
                if (!curr.getIsbn().toLowerCase().trim().contains(lookFor.getIsbn().toLowerCase().trim())) {
                    continue;
                }
            }
            if (lookFor.getYearPublished() != -1) {
                if (lookFor.getYearPublished() != curr.getYearPublished()) {
                    continue;
                }
            }
            if (lookFor.getType() != BookType.ANY) {
                if (lookFor.getType() != curr.getType()) {
                    continue;
                }
            }
            results.add(curr);
        }
        return results;
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.add(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.HARDCOVER));
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011, BookType.PAPERBACK);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.EBOOK);
        // Added b2 and b3 to lib
        lib.add(b2);
        lib.add(b3);
        // The ordering of the book parameters was wrong.
        List<Book> results = lib.search(new Book(null, "Learning Spark",null, null, -1, BookType.ANY));
        if(results.size() == 0){
            System.out.println("No books found related to the search query!");
        }else{
            for (Book b: results) {
                System.out.println(b.toString());
            }
        }

    }
}
