
// Fig. 12.9: TextFieldFrame.java
// JTextFields and JPasswordFields.
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame {
	private final JTextField textField1; // text field with set size

	// TextFieldFrame constructor adds JTextFields to JFrame
	public TextFieldFrame() {
		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout());

		// construct textfield with 10 columns
		textField1 = new JTextField(10);
		add(textField1); // add textField1 to JFrame

		// register event handlers
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
	} // end TextFieldFrame constructor

	// private inner class for event handling
	private class TextFieldHandler implements ActionListener {
		// process textfield events
		@Override
		public void actionPerformed(ActionEvent event) {
			String string = "";
			// user pressed Enter in JTextField textField1
			if (event.getSource() == textField1)
				string = String.format("textField1: %s", event.getActionCommand());

			// display JTextField content
			JOptionPane.showMessageDialog(null, string);
		}
	} // end private inner class TextFieldHandler
} // end class TextFieldFrame

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
