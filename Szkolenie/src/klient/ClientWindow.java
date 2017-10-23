/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author exitle
 */
class ClientWindow extends JFrame {
    static Socket s = null;
    static PrintWriter pw = null;

    public static void main(String[] args) {
        Klient kn = new Klient();
        ClientWindow o = new ClientWindow("Klient");

//        Socket s = null;
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

    private JScrollPane jScrollPane1;
    public JButton vBtn;
    public JTextField vText;
    public JTextArea vTextArea;
    String tekst;

    public ClientWindow(String s) {
        super(s);

        vText = new javax.swing.JTextField();
        vBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vBtn.setText("Wyślij");
        vBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VBtnClick(evt);
            }
        });

        vTextArea.setColumns(20);
        vTextArea.setRows(5);
        jScrollPane1.setViewportView(vTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(vText)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vBtn)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(vText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .addContainerGap())
        );

        pack();
        setVisible(true);
    }

    public void writeText(String what) {
        vTextArea.append(what);
    }

    public void VBtnClick(java.awt.event.ActionEvent evt) {
        String tekst = vText.getText();

        String line = vText.getText().toString();
        try {
            pw = new PrintWriter(s.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pw.println(line);
            this.vText.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
