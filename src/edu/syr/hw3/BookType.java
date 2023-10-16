// SUID: 982212915
package edu.syr.hw3;

public enum BookType {
    HARDCOVER("Hardcover"),
    PAPERBACK("Paperback"),
    EBOOK("Ebook"),
    ANY("Any");

    private final String label;

    private BookType(String label) {
        this.label = label;
    }

    public String getType() {
        return label;
    }
}
