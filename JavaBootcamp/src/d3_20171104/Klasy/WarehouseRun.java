package d3_20171104.Klasy;

/**
 * Created by exitle on 04.11.17.
 */
public class WarehouseRun {
    public static void main(String[] args) {
        TireWarehouse tw = new TireWarehouse();
        tw.addTire(1,1,1,new Tire(170,70,15));
        tw.addTire(1,1,1,new Tire(170,70,15));
        tw.addTire(1,2,3,new Tire(170,70,15));

        System.out.println(tw.getTireOnShelf(1,1,1));
        System.out.println(tw.findShelf("[170/70 R15]"));

//        tw.printWarehouse();


    }
}
