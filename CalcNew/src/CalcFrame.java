import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalcFrame extends JFrame implements ActionListener {
	private final JButton[] buttons;
	private static final String[] names =
		{"1","2","3","4","5","6","7","8","9"};
	private final JPanel buttonPanel;
//	private final Container container;
//	private final GridLayout gridLayout;
//	private final GridLayout gridLayout2;
	
	
	public CalcFrame(){
		super("Calc");
//		gridLayout = new GridLayout(3,3);
//		container = getContentPane();
//		setLayout(gridLayout);
		buttons = new JButton[names.length];
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3, 3, 3));
		
		for (int i=0; i< names.length; i++){
			buttons[i] = new JButton(names[i]);
			buttonPanel.add(buttons[i]);
//			buttons[i].addActionListener(this);
//			add(buttons[i]);
		}
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
