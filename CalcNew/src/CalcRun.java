
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class CalcRun {

	public static void main(String[] args) {
		CalcFrame calcFrame = new CalcFrame();
		calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcFrame.setSize(350,275);
		calcFrame.setResizable(false);
		calcFrame.setFocusable(true);
		calcFrame.requestFocusInWindow();
		
calcFrame.addKeyListener(new KeyListener() {

   @Override
   public void keyTyped(KeyEvent e) {}

   @Override
   public void keyReleased(KeyEvent e) {}

   @Override
   public void keyPressed(KeyEvent e) {
       System.out.println("" + e.getKeyCode());
//       calcFrame.keyPressed(e.getKeyChar());
       calcFrame.keyPressed(e);
   }
});
		
		calcFrame.setVisible(true);
	}

}

/*
10 enter
27 escape 
8 backspace
127 delete


*/