package edu.syr.hw1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {
    private List<String> book_list;
    public void init(String[] input){
        if(input.length == 0) return;
        book_list = new ArrayList<>();
        for(String s : input){
            book_list.add(s);
        }
    }

    public List<String> search(String find){
        try{
            if(find.length() == 0) return null;
            List<String> books_found = new ArrayList<>();
            // To get unique books from duplicates
            Set<String> unique_books = new HashSet<>();
            for(String book : book_list) {
                String lowerCase_book = book.toLowerCase();
                if (lowerCase_book.contains(find)) {
                    unique_books.add(book);
                }
            }
            if(unique_books.size() == 0) return null;
            for(String unique : unique_books){
                books_found.add(unique);
            }
            return books_found;
        }catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //Testing
    public static void main(String[] args) {
        String[] books = {
                "The Go Programming Language, by Alan Donovan and Brian Kernighan",
                "Java Programming, by John Doe",
                "Java Programming, by John Doe",
                "Python for Beginners, by Jane Smith",
                "Java Programming, By Aman"
        };

        Library library = new Library();
        library.init(books);

        String query = "ja";
        List<String> result = library.search(query);
        System.out.println("Following books that match you search result for '" + query + "': ");
        if(result != null){
            for(String res : result){
                System.out.println(res);
            }
        }else{
            System.out.println("No Books Found!");
        }
    }
}
