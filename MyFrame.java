
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {
    JLabel label_CS;
    JPanel panel_CS;
    JButton button_CS;
    JCheckBox checkBox_CS;
    JTextField textField;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    ArrayList<ParkingSlot> arr = new ArrayList<ParkingSlot>();

    MyFrame() {
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
        panel_CS = new JPanel();
        label_CS = new JLabel();
        label_CS.setText("Create A Slot");
        panel_CS.setVisible(false);
        panel_CS.add(label_CS);
        panel_CS.setBackground(Color.red);
        panel_CS.setBounds(0, 0, 100, 100);
        this.add(panel_CS);
        button_CS = new JButton("Create A Slot");
        button_CS.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setBackground(Color.yellow);
        checkBox_CS = new JCheckBox("Is the parking slot for staff?");
        checkBox_CS.setBounds(100, 100, 50, 50);
        checkBox_CS.addActionListener(this);
        panel_CS.add(button_CS);
        panel_CS.add(textField);
        panel_CS.add(checkBox_CS);
        // buttons
        button1 = new JButton();
        button1.setBounds(200, 200, 200, 100);
        // button1.addActionListener(e -> CarPark.CreateSlot(arr));
        button1.setText("Create Slot");
        button1.setFocusable(false);
        button1.addActionListener(this);
        this.add(button1);
        JButton button2 = new JButton();
        button2.setBounds(400, 200, 200, 100);
        button2.addActionListener(e -> CarPark.ParkACar(arr));
        button2.setText("Park A Car");
        button2.setFocusable(false);
        this.add(button2);
        JButton button3 = new JButton();
        button3.setBounds(600, 200, 200, 100);
        button3.addActionListener(e -> CarPark.FindACar(arr));
        button3.setText("Fina A Car");
        button3.setFocusable(false);
        this.add(button3);
        JButton button4 = new JButton();
        button4.setBounds(200, 300, 200, 100);
        button4.addActionListener(e -> CarPark.DeleteACar(arr));
        button4.setText("Delete A Car");
        button4.setFocusable(false);
        this.add(button4);
        JButton button5 = new JButton();
        button5.setBounds(400, 300, 200, 100);
        button5.addActionListener(e -> CarPark.DeleteSlot(arr));
        button5.setText("Delete A Slot");
        button5.setFocusable(false);
        this.add(button5);
        JButton button6 = new JButton();
        button6.setBounds(600, 300, 200, 100);
        button6.addActionListener(e -> CarPark.GetAllSlots(arr));
        button6.setText("See All Slots");
        button6.setFocusable(false);
        this.add(button6);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("yoyo actionPerformed");
        if (e.getSource() == button_CS) {
            System.out.println(textField.getText());
            CarPark.CreateSlot(arr, textField.getText(), checkBox_CS.isSelected());
        }
        if (e.getSource() == button1) {
            System.out.println("Show Create Slot contents");
            panel_CS.setVisible(true);
        }
    }
}