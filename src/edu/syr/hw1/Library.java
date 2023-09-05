package edu.syr.hw1;

import java.util.*;

public class Library {
    private List<String> book_list;
    public void init(String[] input){
        // If input is null throw and exception
        if(input.length == 0) throw new NullPointerException("Input is Null");
        book_list = new ArrayList<>();
        for(String book : input) {
            // Check if the book name is not an empty string
            if (!book.equals("")) {
                book_list.add(book);
            }
        }
    }

    public List<String> search(String find){
        if(find.length() == 0) {
            System.out.println("Invalid search query");
            return null;
        }
        // Store the books in HashSet so no duplicates are added to the final list
        Set<String> unique_books = new HashSet<>();
        for(String book : book_list) {
            String lowerCase_book = book.toLowerCase();
            if (lowerCase_book.contains(find.toLowerCase())) {
                unique_books.add(book);
            }
        }
        if(unique_books.size() == 0){
            System.out.println("Your search does not have any matches.");
            return null;
        }

        return new ArrayList<>(unique_books);
    }
}
