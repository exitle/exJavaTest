
public class PingExec {
   public static void main(String[] args) {
      String ip;

      for (int i = 1; i <= 255; i++) {
         ip = "192.168.0." + i;
         new Ping(ip).start();
      }

   }
}
