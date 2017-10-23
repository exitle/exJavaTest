package com.notepad.main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class RunNotepad {

   public static void main(String[] args) {
      NotepadWindow notep = new NotepadWindow();
      notep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      notep.setSize(500, 300);
      notep.setResizable(true);
      notep.setFocusable(true);
      notep.setStartupFocus();
      notep.setVisible(true);
      
      notep.addWindowFocusListener(new WindowAdapter() {
         public void windowGainedFocus(WindowEvent e) {
            notep.setStartupFocus().requestFocusInWindow();
         }
     });
   }


   
}
