package d6_20171126.generic;

/**
 * Created: 26.11.17.
 */
public class GenericsExample {

    public static void main(String[] args) {
        String toBox = "r";
        Box<String> box = new Box<>(toBox);


        Exception ex = new Exception();
        Box<Exception> boxEx = new Box<>(ex);

        Person p = new Person();
        Box<Person> boxPerson = new Box<>(p);

    }

}
