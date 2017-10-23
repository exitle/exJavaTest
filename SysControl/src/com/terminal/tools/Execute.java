package com.terminal.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sys.exec.OS;

public class Execute extends OS {
   private String os = super.getOs();
   private String[] args;
   private String output = "";

   public Execute(String param) {
      if (os.equals("Linux")) {
         args = new String[] { "/bin/bash", "-c", param };
      } else if (os.equals("Windows")) {
         args = new String[] { param };
      } else if (os.equals("Mac")) {
         args = new String[] { param };
      }

      try {
         Process proc = new ProcessBuilder(args).start();
         BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
         StringBuilder sb = new StringBuilder();
         String line = "";
         while ((line = reader.readLine()) != null) {
            // System.out.printf("%s%n", line);
            sb.append(line);
         }
         output = sb.toString();
         proc.waitFor();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public String getParam() {
      return this.output;
   }

   public String getOs() {
      return this.os;
   }

}
