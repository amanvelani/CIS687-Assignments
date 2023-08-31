package edu.syr.hw1;

import java.util.*;

public class Library {
    private List<String> book_list;
    public void init(String[] input){
        if(input.length == 0 || input == null) throw new NullPointerException("Input is Null");
        book_list = new ArrayList<>();
        for(String book : input) {
            if (book.length() == 0 || book == null || book.equals("")) {
                continue;
            } else book_list.add(book);
        }
    }

    public List<String> search(String find){
        try{
            if(find.length() == 0) return null;
            // To get unique books from duplicates
            Set<String> unique_books = new HashSet<>();
            for(String book : book_list) {
                String lowerCase_book = book.toLowerCase();
                if (lowerCase_book.contains(find)) {
                    unique_books.add(book);
                }
            }
            if(unique_books.size() == 0) return null;
            return new ArrayList<>(unique_books);
        }catch (IllegalArgumentException e) {
            throw e;
        }catch (Exception exp){
            throw exp;
        }
    }
    //Testing
    public static void main(String[] args) {
        String[] books = {
                ""
        };

        Library library = new Library();
        library.init(books);

        String query = "jane";
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
