package W2_Homework.Z2;

public class Run {
    public static void main(String[] args) {
        Person p1 = new Person("dad", 34);
        Person p2 = new Person("son", 12);

        Car c1 = new Car(p1,p2);
        Car c2 = new Car(p2,p1);

        c1.go();
        c2.go();
    }

}
