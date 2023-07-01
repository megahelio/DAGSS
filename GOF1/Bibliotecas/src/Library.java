import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Book> books;

    /**
     * @param books
     */
    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    /**
     * Library vacía
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * @return the books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addBooks(List<Book> books){
        for (Book book : books) {
            this.addBook(book);
        }
    }

    public int librarySize() {
        return books.size();
    }

    public Book getBook(int index) {
        return books.get(index);
    }

}
