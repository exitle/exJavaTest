package com.sys.exec;

import com.sys.close.Shutdown;
import com.sys.close.ShutdownGUI;
import com.sys.ping.PingMain;
import com.sys.sound.SoundControl;
import com.sys.sound.SoundControlTerm;
import com.sys.sound.SoundGUI;

public class Exec extends OS {
   /**
    * 
    * @param args
    *           vol - SoundControl ( +x - increase by x -x - decrease by x x -
    *           set to x )
    * 
    *           shut - Shutown (x - shutdown in x minutes -c - cancel shutdown)
    * 
    *           ping - ping selected range (* | x-y | int | default:
    *           192.168.0-1.*)
    */
   private String os = super.getOs();
   private static boolean isAlive;

   public static void main(String[] args) {
      if (args.length > 0) {

         switch (args[0]) {
         case "vol":
            if (args.length > 1) {
               new SoundControl(args[1]);
            } else {
               new SoundControlTerm();
            }
            break;
         case "shut":
            if (args.length > 1) {
               new Shutdown(args[1]);
            } else {
               System.out.printf("%s%n%s%n", "Missing parameter.", "i.e. shut 60 - for shutdown in 60 minutes");
            }
            break;
         case "ping":
            if (args.length > 1) {
               new PingMain(args[1]);
            } else {
               new PingMain("192.168.0-1.*");
            }
            break;
         case "help":
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "Available commands:", "\tNo arguments - display GUI",
                  "\tvol - Control Volume" + "\n\t\t+x - Volume up by x%" + "\n\t\t-x - Volume down by x%"
                        + "\n\t\tx  - Volume set to x%",
                  "\tshut - Schedule system shutdown" + "\n\t\tx  - Shutdown in x minutes"
                        + "\n\t\t-c - Cancel shutdown",
                  "\tping - Print active IP adressess within selected range" + "\n\t\tdefault: 192.168.0-1.*"
                        + "\n\t\tAvailable options:" + "\n\t\t\t*   - range 0-255" + "\n\t\t\tx-y - range x-y"
                        + "\n\t\t\tx   - only x value",
                  "\tshutGUI - Shutdown GUI",
                  "\tvolGUI - Sound GUI"
            );
            break;
         case "shutGUI":
            new ShutdownGUI();
            break;
         case "volGUI":
            new SoundGUI();
            break;
         default:
            System.out.printf("%s%n%s%n", "Invalid argument. ", "Run with 'help' argument to list available options.");
            break;
         }

      } else {
         isAlive = true;
         new ExecTerm();
      }

   }

   public String getOs() {
      return this.os;
   }

   public boolean isAlive() {
      return isAlive;
   }

}
