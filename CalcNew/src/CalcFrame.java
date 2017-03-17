import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalcFrame extends JFrame implements ActionListener {

   private static final long serialVersionUID = 1L;
   private final JButton[] numBtn;
   private final JButton[] sigBtn;
   private final JButton[] execBtn;
   private final JTextArea txtOutput;
   private final JTextField txtInput;
   private static final String[] numBtns = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ",", "%" };
   private static final String[] signBtns = { "+", "x", "(", "-", "/", ")" };
   private static final String[][] execBtns = { { "x\u00B2", "squareBtn" }, { "\u221A", "rootBtn" }, { "C", "clearBtn" } };
   private final JPanel numBtnPanel;
   private final JPanel signBtnPanel;
   private final JPanel btnPanel;
   private final JPanel txtPanel;
   private final JButton evalBtn;

   public CalcFrame() {
      super("Calculator");
      numBtn = new JButton[numBtns.length];
      sigBtn = new JButton[signBtns.length];
      execBtn = new JButton[execBtns.length];
      evalBtn = new JButton("=");
      evalBtn.setPreferredSize(new Dimension(50, 20));
      numBtnPanel = new JPanel();
      signBtnPanel = new JPanel();
      btnPanel = new JPanel();
      txtPanel = new JPanel();
      txtOutput = new JTextArea(6, 20);
      txtInput = new JTextField();
      txtInput.setFocusable(false);
      Font txtInputFont = new Font("Courier", Font.PLAIN, 20);
      Font txtOutputFont = new Font("Courier", Font.PLAIN, 15);
      numBtnPanel.setLayout(new GridLayout(4, 3, 3, 3));
      signBtnPanel.setLayout(new GridLayout(4, 3, 3, 3));
      btnPanel.setLayout(new GridLayout(1, 2, 3, 4));
      txtPanel.setLayout(new BoxLayout(txtPanel, BoxLayout.PAGE_AXIS));
      JScrollPane txtScroll = new JScrollPane(txtOutput);
      txtInput.setPreferredSize(new Dimension(20, 50));
      txtInputFont = txtInputFont.deriveFont(30);
      txtInput.setFont(txtInputFont);
      txtInput.setHorizontalAlignment(SwingConstants.RIGHT);
      txtOutput.setFont(txtOutputFont);
      txtOutput.setEditable(false);
      txtOutput.setFocusable(false);

      for (int i = 0; i < numBtns.length; i++) {
         numBtn[i] = new JButton(numBtns[i]);
         numBtnPanel.add(numBtn[i]);
         numBtn[i].addActionListener(this);
         numBtn[i].setName(numBtns[i]);
      }
      for (int i = 0; i < execBtns.length; i++) {
         execBtn[i] = new JButton(execBtns[i][0]);
         signBtnPanel.add(execBtn[i]);
         execBtn[i].setName(execBtns[i][1]);
      }
      for (int i = 0; i < signBtns.length; i++) {
         sigBtn[i] = new JButton(signBtns[i]);
         signBtnPanel.add(sigBtn[i]);
         sigBtn[i].addActionListener(this);
         sigBtn[i].setName(signBtns[i]);
      }

      signBtnPanel.add(evalBtn, BorderLayout.EAST);
      btnPanel.add(numBtnPanel, BorderLayout.SOUTH);
      btnPanel.add(signBtnPanel, BorderLayout.LINE_END);
      txtPanel.add(txtScroll, BorderLayout.CENTER);
      txtPanel.add(txtInput, BorderLayout.SOUTH);
      txtPanel.add(btnPanel, BorderLayout.SOUTH);
      txtPanel.setFocusable(false);
      add(txtPanel, BorderLayout.NORTH);

   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      this.txtInput.setText(this.txtInput.getText() + ((JComponent) arg0.getSource()).getName());
      super.requestFocus();
   }

   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if (key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9 || key >= KeyEvent.VK_NUMPAD0 && key <= KeyEvent.VK_NUMPAD9) {
         this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
      } else {
         switch (key) {
         case KeyEvent.VK_DELETE:
            this.txtInput.setText("");
            break;
         case KeyEvent.VK_ENTER:
            // eval()
            break;
         case KeyEvent.VK_BACK_SPACE:
            if (this.txtInput.getText().length() == 0)
               break;
            this.txtInput.setText(this.txtInput.getText().substring(0, this.txtInput.getText().length() - 1));
            break;
         case KeyEvent.VK_ESCAPE:
            this.txtInput.setText("");
            break;
         case KeyEvent.VK_COMMA:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_PERIOD:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_SLASH:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_SEMICOLON:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_EQUALS:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()).replace("=", ""));
            break;
         case KeyEvent.VK_OPEN_BRACKET:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_BACK_SLASH:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_CLOSE_BRACKET:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_ADD:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_MULTIPLY:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_SEPARATOR:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_SUBTRACT:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_DECIMAL:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_DIVIDE:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()));
            break;
         case KeyEvent.VK_MINUS:
            this.txtInput.setText(this.txtInput.getText() + Character.toString((char) e.getKeyChar()).replace("_", ""));
            break;
         case KeyEvent.VK_EXCLAMATION_MARK:
            // pow();
            break;
         }

      }

   }

}
