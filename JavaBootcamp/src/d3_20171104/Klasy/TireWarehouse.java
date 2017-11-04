package d3_20171104.Klasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by exitle on 04.11.17.
 */
public class TireWarehouse {
    private Map<String, String> usedShelves;
    private Map<Tire, String> warehouse;

    public TireWarehouse() {
        usedShelves = new HashMap<>();
        warehouse = new HashMap<>();
    }

    public void addTire(int x, int y, int z, Tire tire) {
        String shelf = "[" + x + "," + y + "," + z + "]";
        if (this.usedShelves.get(shelf) == null) {
            usedShelves.put(shelf,tire.getTireCode());
            warehouse.put(tire, shelf);
            System.out.printf("Tire added (Shelf: %s | Code: %s)%n", shelf, tire.getTireCode());
        } else {
            System.out.println("Shelf already used. Try different one.");
        }

    }


    public List<String> findShelf(String tireCode) {
        List<String> ls = new ArrayList<>();
        for (Map.Entry<String, String> entry : usedShelves.entrySet()) {
            if (entry.getValue().equals(tireCode)) {
                ls.add(entry.getKey());
            }
        }
        return ls;
    }

    public String getTireOnShelf(int x, int y, int z) {
        for (Map.Entry<Tire, String> entry : warehouse.entrySet()) {
            if (entry.getValue().equals("[" + x + "," + y + "," + z + "]")) {
                return entry.getKey().getTireCode();
            }
        }
        return "Empty.";
    }

    public void removeTire(String tireCode) {
        usedShelves.remove(warehouse.get(tireCode));
        warehouse.remove(tireCode);
    }

    public void printWarehouse(){
        System.out.println("Current usage: ");
        for(Map.Entry<String, String> e : usedShelves.entrySet()){
            System.out.println(e);
        }
    }


}
