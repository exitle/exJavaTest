package d4_20171105.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created: 05.11.17.
 */
public class Library {
    private Map<Integer, Book> books;

    public Library() {
        books = new HashMap<>();
        new GetBooks(books);
    }

    public void printBooks(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d. %s", i + 1, books.get(i).toString());
        }
    }

    public void printBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d. %s", i + 1, books.get(i).toString());
        }
    }

    public List<Book> findByTitle(String title) {
        List<Book> tempBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().equals(title))
                tempBooks.add(book);
        }
        return tempBooks;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> tempBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author))
                tempBooks.add(book);
        }
        return tempBooks;
    }

    public void rentById(int id) {
        try {
            books.get(id).rent();
        } catch (Exception e) {
            System.out.println("Rent -> BookID: " + id + " does not exist.");
        }
    }

    public void giveBackById(int id) {
        try {
            books.get(id).returnBook();
        } catch (Exception e) {
            System.out.println("Return -> BookID: " + id + " does not exist.");
        }
    }

    public void checkAvailabilityById(int id) {
        try {
            if (books.get(id).isAvailable()) {
                System.out.println("Avail -> Book is available.");
            } else {
                System.out.println("Avail -> Book not available.");
            }
        } catch (Exception e) {
            System.out.println("BookID: " + id + " does not exist.");
        }
    }

}
