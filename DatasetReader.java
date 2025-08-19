import java.io.*;
import java.util.*;

public class DatasetReader {

    public static List<Book> readBooksFromCSV(String filename) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Handles commas inside quotes

                if (data.length != 7)
                    continue;

                try {
                    String title = data[0].replace("\"", "").trim();
                    String author = data[1].replace("\"", "").trim();
                    double rating = Double.parseDouble(data[2]);
                    int reviews = Integer.parseInt(data[3]);
                    int price = Integer.parseInt(data[4]);
                    int year = Integer.parseInt(data[5]);
                    String genre = data[6].replace("\"", "").trim();

                    books.add(new Book(title, author, rating, reviews, price, year, genre));
                } catch (Exception e) {
                    // Skip malformed lines
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return books;
    }
}
