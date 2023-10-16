
# OOD_Assignment

The list of OOD_Assignment for Fall'23 Semester Syracuse.



## Assignment 1

All code for this assignment should be in package edu.syr.hw1. Follow the same
convention for future assignments, i.e. code for homework 2 should be in
package edu.syr.hw2 and so on.
For the most part your submissions will be graded by running unit tests. Don't
change the structure of any code given to you as part of the assignment. More
specifically, class names, method signatures, field visibility should not be
changed. Check with the TA for specific questions.
1. Write a class, Hello, which has a main method which prints "Hello World" to
    stdout. This class will be run like so: java -cp . edu/syr/hw1/Hello

2. Write a class, Greeting, which has a method greet(), which prints "Hello World" to stdout. This class will be run like so:

        import syr.edu.hw1.Greeting 
        public class Runner {
            public static void main(String[] args) {
                Greeting g = new Greeting();
                g.greet();
            }
        }

3. Write a class, Library, with init() and search() methods.The init() method will be passed a String[] as parameter. An example of the String in the array: "The Go Programming Language, Alan Donovan and Brian Kernighan" The init method should keep a reference to the array param in a field This list is the catlog of the Library, i.e. these are all the publications in the Library available to be borrowed. The search() method will be passed a String as parameter, and will return one of the matching items stored in the Library's catalog.
4. Complete the implementation of the IntMatrix class. The idea is to use a one-dimensional array as a matrix. The field data should be initialized by the constructor to a size large enough to hold all the elements of the matrix. Feel free to add other fields as needed. The get() and set() methods should convert the row and column parameters to an appropriate index, and do error checking based on the size of the matrix.
For example:

        IntMatrix m1 = new IntMatrix(2, 3);
        // data should be initialized to int[6]
        // and should be all 0s: {0, 0, 0, 0, 0, 0}
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(0, 2, 3);
        // m1 is now {{1, 2, 3}, {0, 0, 0}}
        // data is now {1, 2, 3, 0, 0, 0}
        m1.set(0, 3, 4); // throws exception; invalid cell
        m1.set(1, 0, 4);
        m1.set(1, 1, 5);
        m1.set(1, 2, 6);
        // m1 is now {{1, 2, 3}, {4, 5, 6}}
        // data is now {1, 2, 3, 4, 5, 6}

## Assignment 2
1. Update the Library class from hw1 to use the given Book class. Instead of the init() method, Library should have a public add method, which takes a Book obj as param and returns nothing. Library should use a List<Book> to store its catalog of books. Also, update the search method to take a Book as parameter. The input may have one or more attributes set, and the returned list will have Book objects that match all the attributes specified in the input Book.
2. Add a hashCode, equals and toString methods to the given Book class.
3. Compare two approaches for storing multi-dimensional data. First, using a multi-dimensional array:
```int[3][4][5] matrix;```

## Assignment 3
1. Update the Book class from hw2 so it has one more field: type. Define a public enum, BookType, which has four values: HARDCOVER, PAPERBACK, EBOOK, and ANY.

    The Book instances in the Library.catalog will have all their attributes
    set. No book in the catalog will have an unknown author or title etc. But
    a user may be searching for all books written by Dennis Ritchie. This
    implies that the Book instance to the search method may have only one
    attribute (author) set. Make sure that your updated Book class allows all
    String attributes to be set to null, int attributes to -1, and BookType to
    ANY.

    Update the equals, hashCode and toString methods if needed.
    The attached Library.java assumes that you've updated Book, and should
    compile. But it has a runtime bug. The main method initalizes a Library
    and then searches for a book, but doesn't find a result. Fix this bug, and
    submit your updated Book.java and fixed Library.java.

2. Modify the attached Node class so that it is generic. Users should be able
    to make a Node with String, or Integer or any other Reference type, as
    value. The next field can only point to a Node with the same type value
    as the current Node. In other words if n is a Node<String>, then n.next
    must also be a Node<String>. Don't change the visibility of the value and
    next fields, but feel free to change their types if needed. Treat the code
    in the main method as a test; if you've changed Node correctly, the main
    method should just run.

## Assignment 4
1. The attached Rational.java represents a rational number. Fill in the
    implementation of the methods so that the code in main runs. Don't change
    any method signatures, but add any methods you need.

    Rational should have three private int fields to represent its numerator,
    denominator and the greatest common divisor (gcd) of its numerator and
    denominator. So if the Rational represents 10/15, it might store 2, 3 and 5
    as its numerator, denominator and gcd respectively.

    Rational should have two constructors. The first is obvious, takes two
    int parameters for numerator and denominator. The second takes one int
    parameter and assumes that the denominator is 1.

    Also implement a toString method, representing a Rational as "n/d".
    Implement two add methods. One that takes a Rational as parameter and
    returns a new Rational whose value is the sum of the two rationals. The
    second add method should take an int parameter and return a new Rational.

    Implement two lessThan methods, one that takes a Rational parameter, the
    other that takes an int parameter. Both return a boolean.

    Lastly, implement two max methods. Following the pattern, one takes a
    Rational parameter, the other takes an int. This method returns either a
    reference to its instance, or to its Rational parameter, or to a new
    Rational created with its int parameter. If the instance equals the
    parameter, return either.

2. Modify the given Questionnaire class so that:
a. The user's response is validated. If anything other than True/Fals is entered, the user should be shown an error message and prompted for a response again.

b. Add support for a Liekert scale questions. Add a Leikert scale question in main() with the text: CSE 687 is awesome. The user should then be prompted to respond with an integer in the range 1-5. The user should also be shown the five levels of agreement corresponding to the integers: Strongly Agree, Somewhat Agree, Neutral, Somewhat Disagree and Strong Disagree.

## Assignment 5

1. Modify the given Rational class so that it uses a static cache. The
    modified class should have no public constructors. Instead, add two static
    getInstance() methods. One of them should take two ints representing
    numerator and denominator, the other should take one int and assume the
    denominator is 1.

    The cache size can be small and fixed, perhaps implemented by using an array.
    Use the code in the main() method as a test. If your implementation is
    correct, the code should run without error, and the comparison of the two
    object references should give true.

    Look at Integer.IntegerCache for more guidance.

2. Modify the given Questionnaire class to support Liekert scale questions.
    Add a Leikert scale question in main() with the text: CSE 687 is awesome.
    The user should then be prompted to respond with an integer in the range
    1-5. The user should also be shown the five levels of agreement
    corresponding to the integers: Strongly Agree, Somewhat Agree, Neutral,
    Somewhat Disagree and Strong Disagree.

3. Write a class, following the adapter design pattern, that implements the
    attached Stack interface using a java.util.List as adaptee.

## Assignment 6

1. Write a set of classes that represent text. Given an array of these,
    elements, client code should be able to loop over the array and print the
    content of the elements as text, or markdown. A potential enhancement is
    to add a toHtml method to all classes.

    https://www.markdownguide.org/cheat-sheet/
    https://markdownlivepreview.com/

    For example, assume that we have an Element class which overrides
    toString() and also provides a toMarkdown() method (both returning String).
    Also, we have subclasses representing bold, italic and strikethru text.
    Then the following is an example of what we want to support in client code:
    ```
    Element[] pangram = new Element[9];
    pangram[0] = new Element("The");
    pangram[1] = new Italic("quick");
    pangram[2] = new Bold("bold");
    pangram[3] = new Element("fox");
    pangram[4] = new Element("jumps");
    pangram[5] = new Element("over");
    pangram[6] = new Element("the");
    pangram[7] = new Strikethru("lazy");
    pangram[8] = new Element("dog");
    StringBuffer justText = new StringBuffer();
    StringBuffer markdown = new StringBuffer();
    for (Element e: pangram) {
        justText.append(e.toString());
        markdown.append(e.toMarkdown());
    }
    System.out.println(justText.toString());
    // The quick bold fox jumps over the lazy dog
    System.out.println(markdown.toString());
    // The *quick* **bold** fox jumped over the ~~lazy~~ dog
    ```
    Also, make modifications, or add classes, to support combinations. So
    user code should be able to specify any combination of the three
    attributes, e.g. bold-strikethru or italic-strikethru-bold. These
    combinations should produce the same text and markdown no matter the
    order. For example, a bold-italic element should behave the same as a
    italic-bold element.
    
    If your solution is more than four classes, reconsider the Decorator
    design pattern.