package d6_20171126.Zadania;

/**
 * Created: 26.11.17.
 */
public class Z1 {
    public static void main(String[] args) {
//        System.out.println(3/0);
        DivideUnC(3,0);
        try {
            Divide(3,0);
        } catch (DivisionByZeroException e) {
            e.printStackTrace();
        }
    }

    public static double Divide(double a, double b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException();
        } else {
            return a / b;
        }
    }

    public static double DivideUnC(double a, double b){
        if (b==0)
            throw new DivisionByZeroRuntimeException();
        return a/b;
    }


}
