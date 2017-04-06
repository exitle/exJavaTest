
import java.util.HashMap;
import java.util.Map;

public class PingExec {
   public static void main(String[] args) {
      String ip;
      Map<String, String> ipMap = new HashMap<String, String>();

      String[][] sl = new String[255][255];
      for (int i = 1; i <= 255; i++) {
         ip = "192.168.0." + i;
         Ping a = new Ping(ip);
         a.start();
         sl[i - 1][0] = ip;
         sl[i - 1][1] = String.valueOf(a.getIsAlive());
         ipMap.put(ip, String.valueOf(a.getIsAlive()));
      }

//      Map<String, String> ipMapSorted = new HashMap<String, String>();
//
//      PingAll a = new PingAll(1, 255);
//      Map<String, String> mapA = a.createMap();
//
//      if (!a.isAlive()) {
//         List<String> sortedKeys = new ArrayList<String>(mapA.keySet());
//         Collections.sort(sortedKeys);
//         for (String s : sortedKeys) {
//            ipMapSorted.put(s, mapA.get(s));
//         }
//      }
//
//      System.out.println(ipMapSorted);

   }
}
