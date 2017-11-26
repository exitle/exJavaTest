package d6_20171126.exceptions;

import java.util.Optional;

/**
 * Created: 26.11.17.
 */
public class NumberManager {
    int[] table;

    public NumberManager(int[] table) {
        this.table = table;
    }

    public int findMin() throws IllegalTableStateException {

        if (table == null) {
            throw new IllegalTableStateException("Table is null");
        }
        if(table.length==0){
            throw new IllegalTableStateException("Table is empty");
        }

        int min = Integer.MAX_VALUE;
        for (int i : table) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public Optional<Integer> findMinOptional(){
        if (table == null || table.length==0) {
            return Optional.empty();
        }

        int min = Integer.MAX_VALUE;
        for (int i : table) {
            if (i < min) {
                min = i;
            }
        }
        return Optional.of(min);
    }


}
