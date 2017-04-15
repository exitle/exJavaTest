package com.sys.ping;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ping extends Thread {
   private boolean isAlive;
   private String ip;

   public Ping(String ip) {
      this.ip = ip;
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

   public boolean getIsAlive() {
      return this.isAlive;
   }

   @Override
   public void run() {
      this.isAlive = isAlive(ip);
      if (this.isAlive) System.out.println(ip);// + " : " + isAlive);

   }

}