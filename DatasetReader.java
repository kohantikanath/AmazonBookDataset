// import java.io.*;
// import java.util.*;

// public class DatasetReader {

//     public static List<Book> readBooksFromCSV(String filename) {
//         List<Book> books = new ArrayList<>();

//         try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//             String line;
//             br.readLine(); 

//             while ((line = br.readLine()) != null) {
//                 String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Handles commas inside quotes

//                 if (data.length != 7)
//                     continue;

//                 try {
//                     String title = data[0].replace("\"", "").trim();
//                     String author = data[1].replace("\"", "").trim();
//                     double rating = Double.parseDouble(data[2]);
//                     int reviews = Integer.parseInt(data[3]);
//                     int price = Integer.parseInt(data[4]);
//                     int year = Integer.parseInt(data[5]);
//                     String genre = data[6].replace("\"", "").trim();

//                     books.add(new Book(title, author, rating, reviews, price, year, genre));
//                 } catch (Exception e) {
//                     // Skip malformed lines
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading file: " + e.getMessage());
//         }

//         return books;
//     }
// }
import java.io.*;
import java.util.*;

public class DatasetReader implements ReadableDataset {
    private List<Book> books = new ArrayList<>();

    @Override
    public void loadData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 7) {
                    String title = data[0].trim();
                    String author = data[1].trim();
                    double rating = Double.parseDouble(data[2].trim());
                    int reviews = Integer.parseInt(data[3].trim());
                    int price = Integer.parseInt(data[4].trim());
                    int year = Integer.parseInt(data[5].trim());
                    String genre = data[6].trim();

                    books.add(new Book(title, author, rating, reviews, price, year, genre));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void displayAll() {
        for (Book book : books) {
            book.printDetails();
        }
    }
}
