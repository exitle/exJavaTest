package com.sys.exec;

public abstract class OS {

   private String os;
   private String osName = System.getProperty("os.name");

   public String getOs() {
      if (osName.equals("Linux")) {
         setOs("Linux");
      } else if (osName.startsWith("Windows")) {
         setOs("Windows");
      } else if (osName.startsWith("Mac")) {
         setOs("Mac");
      }
      return os;
   }

   public void setOs(String os) {
      this.os = os;
   }
   
}
