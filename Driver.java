import java.util.*;

public class Driver {

    public static void main(String[] args) {
        List<Book> books = DatasetReader.readBooksFromCSV("bestsellers with categories.csv");

        // Example usage
        printBooksByAuthor(books, "George Orwell");
        printAllAuthors(books);
        printBookTitlesByAuthor(books, "JJ Smith");
        printBooksByRating(books, 4.7);
        printPricesByAuthor(books, "Jen Sincero");
    }

    public static void printBooksByAuthor(List<Book> books, String author) {
        long count = books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).count();
        System.out.println("Total books by " + author + ": " + count);
    }

    public static void printAllAuthors(List<Book> books) {
        Set<String> authors = new TreeSet<>();
        for (Book b : books) {
            authors.add(b.getAuthor());
        }
        System.out.println("Authors in dataset:");
        authors.forEach(System.out::println);
    }

    public static void printBookTitlesByAuthor(List<Book> books, String author) {
        System.out.println("Books by " + author + ":");
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("- " + b.getTitle());
            }
        }
    }

    public static void printBooksByRating(List<Book> books, double rating) {
        System.out.println("Books with rating " + rating + ":");
        for (Book b : books) {
            if (b.getUserRating() == rating) {
                b.printDetails();
            }
        }
    }

    public static void printPricesByAuthor(List<Book> books, String author) {
        System.out.println("Prices of books by " + author + ":");
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle() + " - $" + b.getPrice());
            }
        }
    }
}
