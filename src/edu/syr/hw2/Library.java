// SUID: 982212915

package edu.syr.hw2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Library {
    private List<Book> book_list;
    public Library(){
        book_list = new ArrayList<>();
    }

    public void add(Book input_book){
        //Check if the book object is null then what's the point of adding to the library.
        if(input_book == null){
            System.out.println("Input book is null!");
            return;
        }

        if(input_book.getTitle().equals("") && input_book.getAuthor().equals("") && input_book.getIsbn().equals("") && input_book.getPublisher().equals("")){
            System.out.println("No valid data!");
            return;
        }

        this.book_list.add(input_book);
    }

    public List<Book> search(Book find){
        if(find == null){
            System.out.println("Enter a valid Book!");
            return null;
        }

        Set<Book> unique_books = new HashSet<>();

        for(Book book : this.book_list) {
            // We will use matches method in Book class to compare both books
            if (find.matches(book)) {
                unique_books.add(book);
            }
        }

        if(unique_books.size() == 0){
            System.out.println("No matches found!");
            return null;
        }

        return new ArrayList<>(unique_books);
    }
}
