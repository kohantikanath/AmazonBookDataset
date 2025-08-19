// public class Book {
//     private String title;
//     private String author;
//     private double userRating;
//     private int reviews;
//     private int price;
//     private int year;
//     private String genre;

//     public Book(String title, String author, double userRating, int reviews, int price, int year, String genre) {
//         this.title = title;
//         this.author = author;
//         this.userRating = userRating;
//         this.reviews = reviews;
//         this.price = price;
//         this.year = year;
//         this.genre = genre;
//     }

//     // Getters
//     public String getTitle() {
//         return title;
//     }

//     public String getAuthor() {
//         return author;
//     }

//     public double getUserRating() {
//         return userRating;
//     }

//     public int getReviews() {
//         return reviews;
//     }

//     public int getPrice() {
//         return price;
//     }

//     public int getYear() {
//         return year;
//     }

//     public String getGenre() {
//         return genre;
//     }

//     // Print book details
//     public void printDetails() {
//         System.out.println("Title: " + title);
//         System.out.println("Author: " + author);
//         System.out.println("Rating: " + userRating);
//         System.out.println("Reviews: " + reviews);
//         System.out.println("Price: $" + price);
//         System.out.println("Year: " + year);
//         System.out.println("Genre: " + genre);
//         System.out.println("---------------------------");
//     }
// }

public class Book extends AbstractBook {
    private double userRating;
    private int reviews;
    private int price;
    private String genre;

    public Book(String title, String author, double userRating, int reviews, int price, int year, String genre) {
        super(title, author, year);
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.genre = genre;
    }

    public double getUserRating() {
        return userRating;
    }

    public int getReviews() {
        return reviews;
    }

    public int getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void printDetails() {
        System.out.println(
                "Title: " + title +
                        " | Author: " + author +
                        " | Rating: " + userRating +
                        " | Reviews: " + reviews +
                        " | Price: $" + price +
                        " | Year: " + year +
                        " | Genre: " + genre);
    }
}
