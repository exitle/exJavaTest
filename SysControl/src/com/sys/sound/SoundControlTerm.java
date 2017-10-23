package com.sys.sound;

import java.util.Scanner;

import com.sys.exec.Exec;

public class SoundControlTerm extends Exec {

   public SoundControlTerm() {
      int choice = 1;
      int x;

      if (!super.getOs().equals("Linux")) {
         System.out.printf("%s%n%s%n%s%n%n%s", "Your OS is not yet supported.", "Currently supported OS:", "\tLinux",
               "See webpage for updates.");
      } else {

         if (super.isAlive()) System.out.println("\n");
         
         Scanner sc = new Scanner(System.in);
         while (choice != 0) {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%n%s", "Select option", "(1) Increase by 5%",
                  "(2) Decrease by 5%", "(3) Increase by x%", "(4) Decrease by x%", "(5) Set to x%", "(6) Mute",
                  "(7) Max volume", "(0) Exit", "Choice: ");

            try {
               choice = sc.nextInt();
            } catch (Exception e) {
               System.out.printf("%n%n%s%n%s", "Program closed.",
                     "Try again when you feel like selecting one of available options ;)");
               break;
            }
            switch (choice) {
            case 1:
               new SoundControl("+5");
               break;
            case 2:
               new SoundControl("-5");
               break;
            case 3:
               System.out.printf("%s", "Increase by: ");
               x = sc.nextInt();
               new SoundControl("+" + x);
               break;
            case 4:
               System.out.printf("%s", "Decrease by: ");
               x = sc.nextInt();
               new SoundControl("-" + x);
               break;
            case 5:
               System.out.printf("%s", "Set to: ");
               x = sc.nextInt();
               new SoundControl("" + x);
               break;
            case 6:
               new SoundControl("" + 0);
               break;
            case 7:
               new SoundControl("" + 100);
               break;
            case 0:
               break;
            default:
               System.out.printf("%n%n%s", "Input values 1-5 or 0.");
               break;
            }
            System.out.printf("%n%n");
         }
         if(!super.isAlive()){
            sc.close();
         }
      }
   }

}
