package com.sys.close;

import com.terminal.tools.Execute;

public class Shutdown {
   public Shutdown(String param) {
      new Execute("shutdown " + param);
      System.out.println("Command executed.");
   }

}
