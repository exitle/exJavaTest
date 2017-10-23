import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PingAll extends Thread {
   private boolean isAlive;
   private String ip;
   int low;
   int high;

   public PingAll(int low, int high) {
      this.low = low;
      this.high = high;
   }

   private boolean isAlive(String ip) {
      String line = " ";
      Process p;
      try {
         p = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ping -c 1 -W 3 " + ip + " | grep '1 received'" });
         BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
         line = br.readLine();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return (line == null) ? false : true;
   }

   public Map<String, String> createMap() {
      String ip;
      Map<String, String> ipMap = new HashMap<String, String>();

      String[][] sl = new String[255][255];
      for (int i = this.low; i <= this.high; i++) {
         ip = "192.168.0." + i;
         Ping a = new Ping(ip);
         a.start();
         sl[i - 1][0] = ip;
         sl[i - 1][1] = String.valueOf(a.getIsAlive());
         ipMap.put(ip, String.valueOf(a.getIsAlive()));
      }
      return ipMap;
   }

   public boolean getIsAlive() {
      return this.isAlive;
   }

   @Override
   public void run() {
      this.isAlive = isAlive(ip);
   }

}