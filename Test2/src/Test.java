import java.awt.Dimension;

import javax.swing.*;

public class Test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	public static void main(String[] args) throws Exception {
		Test frame = new Test();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public Test() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);

			JPanel panel = new JPanel();

			panel.setBounds(10, 10, 81, 5*30);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			jContentPane.add(panel);
			
//	        JScrollPane scrollPane = new JScrollPane(panel);
//	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//	        scrollPane.setBounds(0, 0, 300, 150);
//			jContentPane.setPreferredSize(new Dimension(300, 200));
//			jContentPane.add(scrollPane);

			JPanel[] diceView = new JPanel[15];
			JLabel[] labels = new JLabel[15];
			for (int i = 0; i < diceView.length; i++) {
				diceView[i] = new JPanel();
				panel.add(diceView[i]);
				labels[i] = new JLabel();
				labels[i].setText((i+1) + ". Dice");
				diceView[i].add(labels[i]);
			}

		}
		return jContentPane;
	}

	@SuppressWarnings("unused")
	private static void add() {
		JTextField input_box = new JTextField(7);

		JComponent[] inputs = new JComponent[] { new JLabel("Thing 1:"),
				input_box };

		int rval = JOptionPane.showConfirmDialog(null, inputs, "Enter Stuff",
				JOptionPane.OK_CANCEL_OPTION);

		if (rval == 0) {
			System.out.printf("%s", input_box.getText());
		}
	}

}
