
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {
    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel contentsPanel;
    JLabel label_CS;
    JPanel panel_CS;
    JButton button_CS;
    JCheckBox checkBox_CS;
    JTextField textField_CS;
    JLabel label1_PC;
    JLabel label2_PC;
    JPanel panel_PC;
    JButton button_PC;
    JCheckBox checkBox_PC;
    JTextField textField1_PC;
    JTextField textField2_PC;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    ArrayList<ParkingSlot> arr = new ArrayList<ParkingSlot>();

    MyFrame() {
        // set Main Frame
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.pack();
        this.setVisible(true);
        // set Main Panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.blue);
        mainPanel.setBounds(0, 0, 1000, 1000);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new TitledBorder("ParkingLot System"));
        this.add(mainPanel);
        // set button Panel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.yellow);
        // buttonPanel.setBounds(0, 0, 1000, 100);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        // set contents Panel
        contentsPanel = new JPanel();
        contentsPanel.setBackground(Color.green);
        // contentsPanel.setBounds(0, 0, 1000, 100);
        mainPanel.add(contentsPanel, BorderLayout.CENTER);
        // Adding Create Slot panel and contents
        label_CS = new JLabel();
        label_CS.setText("Enter parking slot ID to create (an uppercase letter followed by 2 digits)");
        panel_CS = new JPanel();
        panel_CS.setLayout(new BoxLayout(panel_CS, BoxLayout.Y_AXIS));
        panel_CS.setBorder(new TitledBorder("Create Slot"));
        panel_CS.setVisible(false);
        panel_CS.add(label_CS);
        panel_CS.setBackground(Color.gray);
        panel_CS.setBounds(0, 0, 100, 100);
        contentsPanel.add(panel_CS);

        button_CS = new JButton("Create A Slot");
        button_CS.addActionListener(this);
        textField_CS = new JTextField();
        textField_CS.setPreferredSize(new Dimension(250, 40));
        checkBox_CS = new JCheckBox("Is the parking slot for staff?");
        checkBox_CS.setBounds(100, 100, 50, 50);
        checkBox_CS.addActionListener(this);
        panel_CS.add(textField_CS);
        panel_CS.add(checkBox_CS);
        panel_CS.add(button_CS);
        // Adding Park Car panel and contents
        label1_PC = new JLabel();
        label1_PC.setText("Enter parking slot ID (an uppercase letter followed by 2 digits) for this car to park");
        label2_PC = new JLabel();
        label2_PC.setText("Enter owner name");
        panel_PC = new JPanel();
        panel_PC.setLayout(new BoxLayout(panel_PC, BoxLayout.Y_AXIS));
        panel_PC.setBorder(new TitledBorder("Park A Car"));
        panel_PC.setVisible(false);
        panel_PC.setBackground(Color.gray);
        panel_PC.setBounds(0, 0, 100, 100);
        contentsPanel.add(panel_PC);

        button_PC = new JButton("Park Car");
        button_PC.addActionListener(this);
        textField1_PC = new JTextField();
        textField1_PC.setPreferredSize(new Dimension(250, 40));
        textField2_PC = new JTextField();
        textField2_PC.setPreferredSize(new Dimension(250, 40));
        checkBox_PC = new JCheckBox("Is the car a staff Car?");
        checkBox_PC.setBounds(100, 100, 50, 50);
        checkBox_PC.addActionListener(this);
        panel_PC.add(label1_PC);
        panel_PC.add(textField1_PC);
        panel_PC.add(label2_PC);
        panel_PC.add(textField2_PC);
        panel_PC.add(checkBox_PC);
        panel_PC.add(button_PC);
        // buttons for showing every function's contents
        button1 = new JButton();
        button1.setBounds(200, 200, 200, 100);
        button1.setText("Create Slot");
        button1.setFocusable(false);
        button1.addActionListener(this);
        buttonPanel.add(button1);
        button2 = new JButton();
        button2.setBounds(400, 200, 200, 100);
        button2.setText("Park A Car");
        button2.setFocusable(false);
        button2.addActionListener(this);
        buttonPanel.add(button2);
        button3 = new JButton();
        button3.setBounds(600, 200, 200, 100);
        button3.addActionListener(this);
        button3.setText("Fina A Car");
        button3.setFocusable(false);
        buttonPanel.add(button3);
        button4 = new JButton();
        button4.setBounds(200, 300, 200, 100);
        button4.addActionListener(this);
        button4.setText("Delete A Car");
        button4.setFocusable(false);
        buttonPanel.add(button4);
        button5 = new JButton();
        button5.setBounds(400, 300, 200, 100);
        button5.addActionListener(this);
        button5.setText("Delete A Slot");
        button5.setFocusable(false);
        buttonPanel.add(button5);
        button6 = new JButton();
        button6.setBounds(600, 300, 200, 100);
        button6.addActionListener(this);
        button6.setText("See All Slots");
        button6.setFocusable(false);
        buttonPanel.add(button6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("yoyo actionPerformed");
        if (e.getSource() == button_CS) {
            // System.out.println(textField_CS.getText());
            CarPark.CreateSlot(arr, textField_CS.getText(), checkBox_CS.isSelected());
        }
        if (e.getSource() == button_PC) {
            // System.out.println(textField1_PC.getText());
            CarPark.ParkACar(arr, textField1_PC.getText(), textField2_PC.getText(), checkBox_CS.isSelected());
        }
        if (e.getSource() == button1) {
            System.out.println("Show Create Slot contents");
            panel_CS.setVisible(true);
            panel_PC.setVisible(false);
        }
        if (e.getSource() == button2) {
            System.out.println("Show Park Car contents");
            panel_PC.setVisible(true);
            panel_CS.setVisible(false);
        }
    }
}