package com.sys.exec;

import java.util.Scanner;

import com.sys.ping.PingTerm;
import com.sys.sound.SoundControlTerm;
import com.sys.close.ShutdownTerm;

public class ExecTerm extends Exec {
   private String os = super.getOs();

   public ExecTerm() {
      Scanner sc = new Scanner(System.in);
      Integer choice = 1;
      System.out.println(os);

      while (choice!=0) {

         printMenu();
         choice = sc.nextInt();

         switch (choice) {
         case 1:
            new SoundControlTerm();
            break;
         case 2:
            new ShutdownTerm();
            break;
         case 3:
            new PingTerm();
            break;

         case 0:
            break;
         default:
            break;
         }

      }
      sc.close();
   }
   
   private void printMenu(){
      System.out.printf("%s%n%s%n%s%n%s%n%s%n%n%s"
            , "Available commands:"
            , "\t(1) vol - Control Volume"
                    + "\n\t\t+x - Volume up by x%"
                    + "\n\t\t-x - Volume down by x%"
                    + "\n\t\tx  - Volume set to x%"
            , "\t(2) shut - Schedule system shutdown"
                    + "\n\t\tx  - Shutdown in x minutes"
                    + "\n\t\t-c - Cancel shutdown"
            , "\t(3) ping - Print active IP adressess within selected range"
                    + "\n\t\tdefault: 192.168.0-1.*"
                    + "\n\t\tAvailable options:"
                    + "\n\t\t\t*   - range 0-255"
                    + "\n\t\t\tx-y - range x-y"
                    + "\n\t\t\tx   - only x value"
            , "\t(0) exit - exit program"
            , "Selection: "
            );
   }
   
   public String getOs(){
      return this.os;
   }
   
}
