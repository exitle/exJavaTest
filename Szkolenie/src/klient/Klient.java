package klient;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
//import dzien5.Dzien5.Serwer;

public class Klient {

    public static void main(String[] args) {        

        Socket s = null;
        Scanner sc = new Scanner(System.in);
        try {
            s = new Socket("localhost", 1234);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread t = new Thread(new Reader(s));
        t.start();

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(s.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String line = "";

        while (!line.contains("exit")) {
            System.out.println("Wpisz komunikat: ");
            line = sc.nextLine();
            try {
                pw.println(line);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

class Reader extends Thread {

    private Socket s;
    private BufferedInputStream bis;

    public Reader(Socket s) {
        this.s = s;
        try {
            this.bis = new BufferedInputStream(s.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean przerwijCzynnosc() {
        boolean tf;
        if (s.isConnected()) {
            tf = false;
        } else {
            tf = true;
        }
        return tf;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        int c;
        try {
            while ((c = this.bis.read()) != -1) {
                if (this.przerwijCzynnosc()) {
                    break;
                }
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            this.bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
