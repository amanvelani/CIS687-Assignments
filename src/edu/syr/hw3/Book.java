// SUID: 982212915
package edu.syr.hw3;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;
    private BookType bookType;


    public Book(String a, String t, String p, String i, int y, BookType bookType) {
        if((a == null || a.equals("")) && (t == null || t.equals("")) && (p == null || p.equals("")) ) throw new NullPointerException("Author, Title, and Publisher all cannot be empty values!");
        this.author = Objects.equals(a, "") ? null : a;
        this.title = Objects.equals(t, "") ? null : t;
        this.publisher = Objects.equals(p, "") ? null : p;
        this.isbn = Objects.equals(i, "") ? null : i;
        this.yearPublished = y == 0 || y == -1 ? -1 : y;
        this.bookType = bookType == null ? BookType.ANY : bookType;
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
    public BookType getType() {
        return bookType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Author: ").append(this.getAuthor()).append("\n");
        sb.append("Title: ").append(this.getTitle()).append("\n");
        sb.append("Publisher: ").append(this.getPublisher()).append("\n");
        sb.append("ISBN: ").append(this.getIsbn()).append("\n");
        sb.append("Year Publisher: ").append(this.getYearPublished()).append("\n");
        sb.append("Book Type: ").append(this.bookType).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Book)){
            return false;
        }
        final Book otherBook = (Book) obj;
        try{
            boolean isEqual = true;

            if (otherBook.getAuthor() != null) {
                if (this.author != null) {
                    if (!otherBook.getAuthor().equals(this.author)) {
                        isEqual = false;
                    }
                }
            }

            if (otherBook.getTitle() != null) {
                if (this.title != null) {
                    if (!otherBook.getTitle().equals(this.title)) {
                        isEqual = false;
                    }
                }
            }

            if (otherBook.getIsbn() != null) {
                if (this.isbn != null) {
                    if (!otherBook.getIsbn().equals(this.isbn)) {
                        isEqual = false;
                    }
                }
            }

            if (otherBook.getPublisher() != null) {
                if (this.publisher != null) {
                    if (!otherBook.getPublisher().equals(this.publisher)) {
                        isEqual = false;
                    }
                }
            }

            if (this.yearPublished != otherBook.getYearPublished()) {
                isEqual = false;
            }

            if (this.bookType != otherBook.bookType) {
                isEqual = false;
            }

            return isEqual;

        }catch (ClassCastException e) {
            System.out.println("Could not cast object to Book");
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 11;
        for (String str : new String[]{this.author, this.title, this.isbn, this.publisher, this.bookType.getType()}) {
            hash = (31 * hash) + (str == null ? 0 : str.hashCode());
        }
        return (hash * 31) + this.yearPublished;
    }
}
