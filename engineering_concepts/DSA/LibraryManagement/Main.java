import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Book[] books = {

                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido van Rossum"),
                new Book(103, "C", "Dennis Ritchie"),
                new Book(104, "DSA", "Mark Allen")

        };

        System.out.println("Linear Search");

        Book b1 = LibrarySearch.linearSearch(books, "Python");

        if (b1 != null)
            System.out.println(b1);
        else
            System.out.println("Book Not Found");

        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        System.out.println("\nBinary Search");

        Book b2 = LibrarySearch.binarySearch(books, "Python");

        if (b2 != null)
            System.out.println(b2);
        else
            System.out.println("Book Not Found");
    }
}