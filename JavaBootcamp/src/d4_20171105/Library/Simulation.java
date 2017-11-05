package d4_20171105.Library;

import java.util.List;

/**
 * Created: 05.11.17.
 */
public class Simulation {
    public static void main(String[] args) {

        Library lib = new Library();

        List<Book> searchResults = lib.findByAuthor("GenericAuthor_2");
        lib.printBooks(searchResults);
        lib.rentById(99);
        lib.rentById(17);
        lib.checkAvailabilityById(17);
        lib.giveBackById(17);
        lib.checkAvailabilityById(17);
        lib.giveBackById(17);

    }
}
