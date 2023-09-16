// SUID: 982212915
package edu.syr.hw2;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;

    public Book(String a, String t, String p, String i, int y) {
        this.author = a==null ? "" : a;
        this.title = t==null ? "" : t;
        this.publisher = p==null ? "" : p;
        this.isbn = i==null ? "" : i;
        this.yearPublished = y;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getYearPublished() {
        return yearPublished;
    }

    public boolean matches(Book b) {
        if (!author.equals("") && !author.toLowerCase().contains(b.author.toLowerCase())) {
            return false;
        }
        if (!title.equals("") && !title.toLowerCase().contains(b.title.toLowerCase())) {
            return false;
        }
        if (!publisher.equals("") && !publisher.toLowerCase().contains(b.publisher.toLowerCase())) {
            return false;
        }
        if (!isbn.equals("") && ! b.isbn.equals("") && !isbn.equals(b.isbn)) {
            return false;
        }
        if (yearPublished > 1700 && b.yearPublished> 1700 && yearPublished != b.yearPublished) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Author: " + this.getAuthor() + "\n");
        sb.append("Title: " + this.getTitle() + "\n");
        sb.append("Publisher: " + this.getPublisher() + "\n");
        sb.append("ISBN: " + this.getIsbn() + "\n");
        sb.append("Year Publisher: " + this.getYearPublished() + "\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Book)){
            return false;
        }
        final Book otherBook = (Book) obj;
        if (this.author.equals(otherBook.author) &&
                this.isbn.equals(otherBook.isbn) &&
                this.publisher.equals(otherBook.publisher) &&
                this.yearPublished == otherBook.yearPublished &&
                this.title.equals(otherBook.title)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        for (String str : new String[]{this.author, this.title, this.isbn, this.publisher}) {
            hash = (31 * hash) + (str == null ? 0 : str.hashCode());
        }
        return (hash * 31) + this.yearPublished;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);
    }
}
