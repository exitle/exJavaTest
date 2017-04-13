package com.sys.close;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.terminal.tools.Execute;

public class ShutdownGUI extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;

   private JFrame frame;
   private JPanel contentPane;
   private JPanel timePane;
   private JPanel sliderPane;
   private JPanel buttonPane;
   private JTextField timeVal;
   private JTextField sliderVal;
   private JSlider slider;
   private JButton setBtn;
   private JButton cancelBtn;
   private JButton closeBtn;
   private String timeStamp;

   public ShutdownGUI() {
      super("Shutdown");
      frame = new JFrame("Shutdown");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ShowGUI();
      frame.pack();
      frame.setVisible(true);

   }

   public void ShowGUI() {

      contentPane = new JPanel();
      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

      timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      timeVal = new JTextField(timeStamp);
      timeVal.setEditable(false);
      timeVal.setPreferredSize(new Dimension(80, 30));
      timeVal.setFont(timeVal.getFont().deriveFont(16.0F).deriveFont(Font.BOLD));
      timeVal.setHorizontalAlignment(JTextField.CENTER);

      timePane = new JPanel();
      timePane.setLayout(new BoxLayout(timePane, BoxLayout.LINE_AXIS));
      timePane.add(timeVal);

      slider = new JSlider(JSlider.HORIZONTAL, 0, 120, 60);
      slider.setMinorTickSpacing(2);
      slider.setMajorTickSpacing(10);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      slider.setLabelTable(slider.createStandardLabels(20));

      sliderVal = new JTextField();
      sliderVal.setPreferredSize(new Dimension(30, 20));
      sliderVal.setMaximumSize(new Dimension(30, 20));
      sliderVal.setHorizontalAlignment(JTextField.RIGHT);
      sliderVal.setText(Integer.toString(slider.getValue()));
      sliderVal.setEditable(false);

      sliderPane = new JPanel();
      sliderPane.setLayout(new BoxLayout(sliderPane, BoxLayout.LINE_AXIS));
      sliderPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
      sliderPane.add(Box.createHorizontalGlue());
      sliderPane.add(sliderVal);
      sliderPane.add(slider);

      setBtn = new JButton("Set");
      cancelBtn = new JButton("Cancel");
      closeBtn = new JButton("Close");

      buttonPane = new JPanel();
      buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
      buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
      buttonPane.add(Box.createHorizontalGlue());
      buttonPane.add(setBtn);
      buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
      buttonPane.add(cancelBtn);
      buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
      buttonPane.add(closeBtn);

      contentPane.add(timePane);
      contentPane.add(sliderPane);
      contentPane.add(buttonPane);
      frame.add(contentPane);

      slider.addChangeListener(SLIDER_LISTENER);
      setBtn.addActionListener(SET_LISTENER);
      cancelBtn.addActionListener(CANCEL_LISTENER);
      closeBtn.addActionListener(CLOSE_LISTENER);
   }

   public int getSlider() {
      return this.slider.getValue();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

   }

   private ChangeListener SLIDER_LISTENER = new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
         sliderVal.setText(Integer.toString(getSlider()));
         Calendar cal = Calendar.getInstance();
         cal.setTime(new Date());
         cal.add(Calendar.MINUTE, getSlider());
         timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
         timeVal.setText(timeStamp);
      }
   };

   private ActionListener SET_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         if (System.getProperty("os.name").equals("Linux")) {
            new Execute("shutdown " + getSlider());
         } else if (System.getProperty("os.name").startsWith("Windows")){
        	 new Execute("shutdown /s /t " + (getSlider()*60));
         }
         JOptionPane.showMessageDialog(null, String.format("%s%n%s", "Shutdown scheduled for:", timeStamp));
      }
   };

   private ActionListener CANCEL_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         if (System.getProperty("os.name").equals("Linux")) {
            new Execute("shutdown -c");
         } else if (System.getProperty("os.name").startsWith("Windows")){
        	 new Execute("shutdown /a");
         }
         JOptionPane.showMessageDialog(null, String.format("%s", "Shutdown canceled."));
      }
   };

   private ActionListener CLOSE_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         frame.dispose();
      }
   };

}
