//cd /tmp
//mknod backpipe p
//nc localhost 1234


package serwer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Serwer {
    public static List<Klient> lista = new ArrayList<>();
    public static void main(String[] args) {
//        Okno o =new Okno();
        ServerWindow o = new ServerWindow("Serwer");
        o.writeText("Start servera.\n");
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(1234);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Socket s = null;
        o.writeText("Czekam na połączenie...\n");
        int ctr=1;
        while(true){
        try {
            s = ss.accept();
            o.writeText("Połączono\n");
            lista.add(new Klient(s, ctr+"", o));
            ctr++;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
    }
}

class ListChecker implements Runnable{
    public ListChecker(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true){
            for(Klient k : Serwer.lista){
                System.out.println(k);
            }
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
        }
    }
}

class Klient implements Runnable {

    private Socket ktos;
    private String login;
    private BufferedInputStream bis;
    private Thread t;
    private ServerWindow okno;

    public Klient(Socket ktos, String login, ServerWindow o) {
        this.ktos = ktos;
        this.login = login;
        this.okno = o;
        try {
            this.bis = new BufferedInputStream(this.ktos.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        Socket s = null;
        StringBuilder sb = new StringBuilder();
        int c;
        try {
            while ((c = this.bis.read()) != -1) {
                sb.append((char) c);
                if (c == 10) {
                    okno.writeText("[" + this.login + "]: "+sb.toString());
                    sb.setLength(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
