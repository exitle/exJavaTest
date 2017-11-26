package d6_20171126.exceptions;

import java.util.Optional;

/**
 * Created: 26.11.17.
 */
public class ExTest {
    public static void main(String[] args) {
        NumberManager nm = new NumberManager(null);

        try {
            System.out.println(nm.findMin());
        } catch (IllegalTableStateException e) {
            System.out.println(e.getMessage());
        }

        Optional<Integer> minOptional = nm.findMinOptional();
        if(minOptional.isPresent()){
            System.out.println(minOptional.get());
        } else {
            System.out.println("IsNull");
        }
    }

}
