package com.terminal.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Execute {
   private String os = System.getProperty("os.name");
   private String[] args;

   public Execute(String param) {
      if (os.equals("Linux")) {
         args = new String[] { "/bin/bash", "-c", param };
      } else if (System.getProperty("os.name").startsWith("Windows")) {
         args = new String[] { param };
      }

      try {
         Process proc = new ProcessBuilder(args).start();
         BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
         String line = "";
         while ((line = reader.readLine()) != null) {
            System.out.printf("%s%n", line);
         }
         proc.waitFor();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}
