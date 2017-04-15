package com.sys.sound;

import java.io.IOException;
import java.util.Scanner;

import com.terminal.tools.Execute;

public class SoundControlTerm {

//	public static void main(String[] args){
	public SoundControlTerm() {
		int choice = 1;
		int x=0;
		Scanner sc = new Scanner(System.in);
		while (choice != 0) {
			System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%n%s"
					, "Select option"
					, "(1) Increase by 5%"
					, "(2) Decrease by 5%"
					, "(3) Increase by x%"
					, "(4) Decrease by x%"
					, "(5) Set to x%"
					, "(0) Exit"
					, "Choice: ");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				new Execute("pactl -- set-sink-volume 0 +5%");
				break;
			case 2:
				new Execute("pactl -- set-sink-volume 0 -5%");
				break;
			case 3:
				System.out.printf("%s","Increase by: ");
				x = sc.nextInt();
				new Execute("pactl -- set-sink-volume 0 +" + x + "%");
				break;
			case 4:
				System.out.printf("%s","Decrease by: ");
				x = sc.nextInt();
				new Execute("pactl -- set-sink-volume 0 -" + x + "%");
				break;
			case 5 :
				System.out.printf("%s","Set to: ");
				x = sc.nextInt();
				new Execute("pactl -- set-sink-volume 0 " + x + "%");
				break;
			default:
				break;
			}
			System.out.printf("%n%n");
		}
		sc.close();
	}

}
