package com.sys.sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SoundGUI extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel contentPane;
    private JPanel buttonPane;
    private JLabel volUpL;
    private JButton volUp;
    private JLabel volDownL;
    private JButton volDown;



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
        volUpL = new JLabel("Increase Volume");
        volUp = new JButton("+");
        volDownL = new JLabel("Decrease Volume");
        volDown = new JButton("-");
        buttonPane.add(volUpL);
        buttonPane.add(volUp);
        buttonPane.add(volDownL);
        buttonPane.add(volDown);
        contentPane.add(buttonPane);
        frame.add(contentPane);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

