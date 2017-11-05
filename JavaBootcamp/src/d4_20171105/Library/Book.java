package d4_20171105.Library;

/**
 * Created: 05.11.17.
 */
public class Book {
    private int id;
    private String author;
    private String title;
    private boolean available;

    public Book(int id, String author, String title, boolean available) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.available = available;
    }

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.available = true;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        if (available) {
            available = false;
            System.out.println("Rent -> Success.");
        } else {
            System.out.println("Rent -> Impossible. Book is not available.");
        }
    }

    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Return -> Success.");
        } else {
            System.out.println("Return -> But how?");
        }
    }

    @Override
    public String toString() {
        String avail = (available) ? "Available" : "Not Available";
        return String.format("[ID[%s]\t| Author: %s\t| Title: %s\t| %s]%n", id, author, title, avail);
    }
}
