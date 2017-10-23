import java.awt.BorderLayout;

import javax.swing.JFrame;

public class NotepTesting {

   public static void main(String[] args) {
      NotepadWindow notep = new NotepadWindow();
      notep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      notep.add(new TabbedPane(), BorderLayout.CENTER);
      notep.setSize(500, 300);
      notep.setResizable(true);
      notep.setFocusable(true);
      notep.requestFocusInWindow();
      notep.setVisible(true);
   }

}
