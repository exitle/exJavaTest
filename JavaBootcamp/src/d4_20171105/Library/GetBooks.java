package d4_20171105.Library;

import java.util.Map;

/**
 * Created: 05.11.17.
 */
public class GetBooks {
    public GetBooks(Map<Integer, Book> books){
        fillBooks(books);
    }

    private void fillBooks(Map<Integer, Book> books) {
        for (int i = 0; i < 50; i++) {
            books.put(i, new Book(i, getGenericAuthor(), getGenericTitle(), true));
        }
    }

    private String getGenericAuthor() {
        return "GenericAuthor_" + (int) (Math.random() * ((10 - 1) + 1));
    }

    private String getGenericTitle() {
        return "GenericTitle_" + (int) (Math.random() * ((50 - 1) + 1));
    }
}
