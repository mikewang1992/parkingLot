
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
    JLabel label3_PC;
    JPanel panel_PC;
    JButton button_PC;
    JCheckBox checkBox_PC;
    JTextField textField1_PC;
    JTextField textField2_PC;
    JTextField textField3_PC;
    JLabel label_FC;
    JPanel panel_FC;
    JPanel panel_FC_bottom;
    JButton button_FC;
    JTextField textField_FC;
    // JLabel label_FC_out;
    JLabel label_DC;
    JPanel panel_DC;
    JButton button_DC;
    JTextField textField_DC;
    JLabel label_DS;
    JPanel panel_DS;
    JButton button_DS;
    JTextField textField_DS;
    JLabel label_GS;
    JPanel panel_GS;
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
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(0, 0, 1000, 1000);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new TitledBorder("ParkingLot System"));
        this.add(mainPanel);
        // set top button Panel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0, 128, 255));
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        // set contents Panel
        contentsPanel = new JPanel();
        contentsPanel.setBackground(Color.lightGray);
        mainPanel.add(contentsPanel, BorderLayout.CENTER);
        // Adding Create Slot panel and contents
        label_CS = new JLabel();
        label_CS.setText("Enter parking slot ID to create (an uppercase letter followed by 2 digits)");
        panel_CS = new JPanel();
        panel_CS.setLayout(new BoxLayout(panel_CS, BoxLayout.Y_AXIS));
        panel_CS.setBorder(new TitledBorder("Create Slot"));
        panel_CS.setVisible(false);
        panel_CS.add(label_CS);
        panel_CS.setBackground(new Color(255, 128, 0));
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
        label2_PC.setText("Enter car registration (an uppercase letter followed by 4 digits)");
        label3_PC = new JLabel();
        label3_PC.setText("Enter owner name");
        panel_PC = new JPanel();
        panel_PC.setLayout(new BoxLayout(panel_PC, BoxLayout.Y_AXIS));
        panel_PC.setBorder(new TitledBorder("Park A Car"));
        panel_PC.setVisible(false);
        panel_PC.setBackground(new Color(255, 128, 0));
        panel_PC.setBounds(0, 0, 100, 100);
        contentsPanel.add(panel_PC);
        button_PC = new JButton("Park Car");
        button_PC.addActionListener(this);
        textField1_PC = new JTextField();
        textField1_PC.setPreferredSize(new Dimension(250, 40));
        textField2_PC = new JTextField();
        textField2_PC.setPreferredSize(new Dimension(250, 40));
        textField3_PC = new JTextField();
        textField3_PC.setPreferredSize(new Dimension(250, 40));
        checkBox_PC = new JCheckBox("Is the car a staff Car?");
        checkBox_PC.setBounds(100, 100, 50, 50);
        checkBox_PC.addActionListener(this);
        panel_PC.add(label1_PC);
        panel_PC.add(textField1_PC);
        panel_PC.add(label2_PC);
        panel_PC.add(textField2_PC);
        panel_PC.add(label3_PC);
        panel_PC.add(textField3_PC);
        panel_PC.add(checkBox_PC);
        panel_PC.add(button_PC);
        // Adding Fina Car panel and contents
        label_FC = new JLabel();
        label_FC.setText("Enter car registration (an uppercase letter followed by 4 digits)");
        panel_FC = new JPanel();
        panel_FC.setLayout(new BoxLayout(panel_FC, BoxLayout.Y_AXIS));
        panel_FC.setBorder(new TitledBorder("Fina A Car"));
        panel_FC.setVisible(false);
        panel_FC.setBackground(new Color(255, 128, 0));
        panel_FC.setBounds(0, 0, 100, 100);
        contentsPanel.add(panel_FC);
        button_FC = new JButton("Find Car");
        button_FC.addActionListener(this);
        textField_FC = new JTextField();
        textField_FC.setPreferredSize(new Dimension(250, 40));
        panel_FC.add(label_FC);
        panel_FC.add(textField_FC);
        panel_FC.add(button_FC);
        panel_FC_bottom = new JPanel();
        panel_FC_bottom.setLayout(new BoxLayout(panel_FC_bottom, BoxLayout.Y_AXIS));
        panel_FC.add(panel_FC_bottom);
        // Adding Delete Car panel and contents
        label_DC = new JLabel();
        label_DC.setText("Enter car registration to remove (an uppercase letter followed by 4 digits)");
        panel_DC = new JPanel();
        panel_DC.setLayout(new BoxLayout(panel_DC, BoxLayout.Y_AXIS));
        panel_DC.setBorder(new TitledBorder("Delete A Car"));
        panel_DC.setVisible(false);
        panel_DC.setBackground(new Color(255, 128, 0));
        panel_DC.setBounds(0, 0, 100, 100);
        contentsPanel.add(panel_DC);
        button_DC = new JButton("Delete Car");
        button_DC.addActionListener(this);
        textField_DC = new JTextField();
        textField_DC.setPreferredSize(new Dimension(250, 40));
        panel_DC.add(label_DC);
        panel_DC.add(textField_DC);
        panel_DC.add(button_DC);
        // Adding Delete Slot panel and contents
        label_DS = new JLabel();
        label_DS.setText("Enter parking slot ID to delete (an uppercase letter followed by 2 digits)");
        panel_DS = new JPanel();
        panel_DS.setLayout(new BoxLayout(panel_DS, BoxLayout.Y_AXIS));
        panel_DS.setBorder(new TitledBorder("Delete A Slot"));
        panel_DS.setVisible(false);
        panel_DS.setBackground(new Color(255, 128, 0));
        panel_DS.setBounds(0, 0, 100, 100);
        contentsPanel.add(panel_DS);
        button_DS = new JButton("Delete Slot");
        button_DS.addActionListener(this);
        textField_DS = new JTextField();
        textField_DS.setPreferredSize(new Dimension(250, 40));
        panel_DS.add(label_DS);
        panel_DS.add(textField_DS);
        panel_DS.add(button_DS);
        // Adding Show All slot panel and contents
        label_GS = new JLabel();
        label_GS.setText("Showing All Slots");
        panel_GS = new JPanel();
        panel_GS.setLayout(new BoxLayout(panel_GS, BoxLayout.Y_AXIS));
        panel_GS.setBorder(new TitledBorder("Showing All Slots"));
        panel_GS.setVisible(false);
        panel_GS.setBackground(new Color(255, 128, 0));
        panel_GS.setBounds(0, 0, 100, 100);
        contentsPanel.add(panel_GS);
        panel_GS.add(label_GS);
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
            CarPark.ParkACar(arr, textField1_PC.getText(), textField2_PC.getText(), textField3_PC.getText(),
                    checkBox_PC.isSelected());
        }
        if (e.getSource() == button_FC) {
            Object[] FindACar = CarPark.FindACar(arr, textField_FC.getText());
            System.out.println(FindACar[0]);
            System.out.println(FindACar[1]);
            System.out.println(FindACar[2]);
            panel_FC_bottom.removeAll();
            panel_FC.revalidate();
            panel_FC.repaint();
            if (!FindACar[1].equals(null)) {
                JLabel label_FC_out1 = new JLabel();
                JLabel label_FC_out2 = new JLabel();
                JLabel label_FC_out3 = new JLabel();
                label_FC_out1.setText("Found the car registration: " + FindACar[0]);
                label_FC_out2.setText("The car is parking in the slot: " + FindACar[1]);
                label_FC_out3.setText("Parking time length: " + FindACar[2]);
                panel_FC_bottom.add(label_FC_out1);
                panel_FC_bottom.add(label_FC_out2);
                panel_FC_bottom.add(label_FC_out3);
                panel_FC.setVisible(false);
                panel_FC.setVisible(true);
            }
            // CarPark.FindACar(arr, textField_FC.getText());
        }
        if (e.getSource() == button_DC) {
            // System.out.println(textField_CS.getText());
            CarPark.DeleteACar(arr, textField_DC.getText());
        }
        if (e.getSource() == button_DS) {
            // System.out.println(textField_CS.getText());
            CarPark.DeleteSlot(arr, textField_DS.getText());
        }
        if (e.getSource() == button1) {
            System.out.println("Show Create Slot contents");
            textField_CS.setText("");
            checkBox_CS.setSelected(false);
            panel_CS.setVisible(true);
            panel_PC.setVisible(false);
            panel_FC.setVisible(false);
            panel_DC.setVisible(false);
            panel_DS.setVisible(false);
            panel_GS.setVisible(false);
        }
        if (e.getSource() == button2) {
            System.out.println("Show Park Car contents");
            textField1_PC.setText("");
            textField2_PC.setText("");
            textField3_PC.setText("");
            checkBox_PC.setSelected(false);
            panel_PC.setVisible(true);
            panel_CS.setVisible(false);
            panel_FC.setVisible(false);
            panel_DC.setVisible(false);
            panel_DS.setVisible(false);
            panel_GS.setVisible(false);
        }
        if (e.getSource() == button3) {
            System.out.println("Show Fina Car contents");
            textField_FC.setText("");
            panel_FC_bottom.removeAll();
            panel_FC.revalidate();
            panel_FC.repaint();
            panel_CS.setVisible(false);
            panel_PC.setVisible(false);
            panel_FC.setVisible(true);
            panel_DC.setVisible(false);
            panel_DS.setVisible(false);
            panel_GS.setVisible(false);
        }
        if (e.getSource() == button4) {
            System.out.println("Show Delete Car contents");
            textField_DC.setText("");
            panel_PC.setVisible(false);
            panel_CS.setVisible(false);
            panel_FC.setVisible(false);
            panel_DC.setVisible(true);
            panel_DS.setVisible(false);
            panel_GS.setVisible(false);
        }
        if (e.getSource() == button5) {
            System.out.println("Show Delete Slot contents");
            textField_DS.setText("");
            panel_CS.setVisible(false);
            panel_PC.setVisible(false);
            panel_FC.setVisible(false);
            panel_DC.setVisible(false);
            panel_DS.setVisible(true);
            panel_GS.setVisible(false);
        }
        if (e.getSource() == button6) {
            System.out.println("Show All Slot contents");
            panel_CS.setVisible(false);
            panel_PC.setVisible(false);
            panel_FC.setVisible(false);
            panel_DC.setVisible(false);
            panel_DS.setVisible(false);
            panel_GS.setVisible(true);

            panel_GS.removeAll();
            if (arr.size() <= 0) {
                label_GS.setText("Currently no Slot in the parking Slot system");
                panel_GS.add(label_GS);
            }
            panel_GS.revalidate();
            panel_GS.repaint();
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
                JLabel label_GS1 = new JLabel();
                JLabel label_GS2 = new JLabel();
                JLabel label_GS3 = new JLabel();
                JLabel label_GS4 = new JLabel();
                JLabel label_GS5 = new JLabel();
                JPanel panel_GS_item = new JPanel();
                // panel_GS_item.setLayout(new FlowLayout());
                panel_GS_item.setLayout(new BoxLayout(panel_GS_item, BoxLayout.Y_AXIS));
                if (arr.get(i).getSlot().getRegistration().length() > 0) {
                    label_GS1.setText("Registration: " + arr.get(i).getSlot().getRegistration());
                    label_GS2.setText("Own: " + arr.get(i).getSlot().getOwner());
                    label_GS3.setText("Parking Time: " + arr.get(i).getSlot().getFormatted_ParkTime());
                    label_GS4.setText("Staying Time: " + arr.get(i).getSlot().Duration_Formatted());
                } else {
                    label_GS1.setText("No Car is currently parking");
                }
                if (arr.get(i).getforStaff()) {
                    // label_GS5.setText("staff parking");
                    panel_GS_item.setBorder(new TitledBorder(arr.get(i).getparkingID() + " - staff parking"));
                    panel_GS_item.setBackground(new Color(128, 0, 255));
                } else {
                    // label_GS5.setText("non staff parking");
                    panel_GS_item.setBorder(new TitledBorder(arr.get(i).getparkingID() + " - non staff parking"));
                    panel_GS_item.setBackground(new Color(0, 255, 64));
                }
                panel_GS_item.add(label_GS1);
                panel_GS_item.add(label_GS2);
                panel_GS_item.add(label_GS3);
                panel_GS_item.add(label_GS4);
                panel_GS_item.add(label_GS5);
                panel_GS_item.setSize(500, 500);
                panel_GS.add(panel_GS_item);
            }
            panel_GS.setVisible(false);
            panel_GS.setVisible(true);
        }
    }
}