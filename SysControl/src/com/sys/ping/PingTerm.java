package com.sys.ping;


import com.sys.exec.Exec;

import java.util.Scanner;

public class PingTerm extends Exec{

    public PingTerm(){
        int choice=1;
        String range;
        Scanner sc = new Scanner(System.in);

        while(choice!=0) {
            System.out.printf("%n%s%n%s%n%s%n%s%n", "Select option"
                    , "(1) Insert IP range"
                    , "(2) Run default '192.168.0-1.*'"
                    , "(0) Exit");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.printf("%s%n", "Insert range:");
                    range=sc.next();
                    new PingMain(range);
                    break;
                case 2:
                    new PingMain("192.168.0-1.*");
                    break;
                case 0:
                    break;
                default:
                    break;
            }


        }

    }
}
