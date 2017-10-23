package com.sys.sound;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SoundGUI extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel contentPane;
    private JPanel buttonPane;
    private JLabel volUpL;
    private JButton volUp;
    private JLabel volDownL;
    private JButton volDown;
    private JSlider slider;
    private JTextField sliderVal;




    public SoundGUI(){
        super("Sound");
        frame = new JFrame("Sound");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShowGUI();
        frame.pack();
        frame.setVisible(true);

    }

    public void ShowGUI() {
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(3,2));
        volUpL = new JLabel("Increase Volume");
        volUp = new JButton("+");
        volDownL = new JLabel("Decrease Volume");
        volDown = new JButton("-");


        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
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


        buttonPane.add(volUpL);
        buttonPane.add(volUp);
        buttonPane.add(volDownL);
        buttonPane.add(volDown);
        buttonPane.add(sliderVal);
        buttonPane.add(slider);
        contentPane.add(buttonPane);
        frame.add(contentPane);



        slider.addChangeListener(SLIDER_LISTENER);
        volUp.addActionListener(VOL_UP);
        volDown.addActionListener(VOL_DOWN);

    }

    private ChangeListener SLIDER_LISTENER = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            sliderVal.setText(Integer.toString(slider.getValue()));
            new SoundControl("" + slider.getValue());
        }
    };

    private ActionListener VOL_UP = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            slider.setValue(slider.getValue()+5);
        }
    };

    private ActionListener VOL_DOWN = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            slider.setValue(slider.getValue()-5);
        }
    };

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

