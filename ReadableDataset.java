import java.util.List;

public interface ReadableDataset {
    void loadData(String filePath);

    List<Book> getBooks();

    void displayAll();
}
