
/**
 * Project1: Application is the Console (Text Based) Interface class including the main() method and handling all inputs and outputs
 * 
 * @author WANJYUN WANG <103801303>
 * @version JDK 1.8.0_341
 * @date Created on 8 sepetember 2022
 */
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Application extends JPanel {
    JPanel panel = new JPanel();

    public static void main(String[] args) {
        ArrayList<ParkingSlot> arr = new ArrayList<ParkingSlot>();
        System.out
                .println(
                        "What would you like to do today? 1=CreateSlot, 2=ParkACar, 3=FindACar, 4=DeleteAcar, 5=DeleteSlot, 6=GetAllSlots");
        MyFrame frame = new MyFrame();
        // JFrame frame = new JFrame();
        // frame.setSize(1000, 1000);
        // frame.setLayout(null);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setVisible(true);

        JButton button1 = new JButton();
        button1.setBounds(200, 200, 200, 100);
        button1.addActionListener(e -> CarPark.CreateSlot(arr));
        button1.setText("Create Slot");
        button1.setFocusable(false);
        frame.add(button1);
        JButton button2 = new JButton();
        button2.setBounds(400, 200, 200, 100);
        button2.addActionListener(e -> CarPark.ParkACar(arr));
        button2.setText("Park A Car");
        button2.setFocusable(false);
        frame.add(button2);
        JButton button3 = new JButton();
        button3.setBounds(600, 200, 200, 100);
        button3.addActionListener(e -> CarPark.FindACar(arr));
        button3.setText("Fina A Car");
        button3.setFocusable(false);
        frame.add(button3);
        JButton button4 = new JButton();
        button4.setBounds(200, 300, 200, 100);
        button4.addActionListener(e -> CarPark.DeleteACar(arr));
        button4.setText("Delete A Car");
        button4.setFocusable(false);
        frame.add(button4);
        JButton button5 = new JButton();
        button5.setBounds(400, 300, 200, 100);
        button5.addActionListener(e -> CarPark.DeleteSlot(arr));
        button5.setText("Delete A Slot");
        button5.setFocusable(false);
        frame.add(button5);
        JButton button6 = new JButton();
        button6.setBounds(600, 300, 200, 100);
        button6.addActionListener(e -> CarPark.GetAllSlots(arr));
        button6.setText("See All Slots");
        button6.setFocusable(false);
        frame.add(button6);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("parking lot system");
        panel.add(label);
        panel.setBackground(Color.red);
        panel.setBounds(0, 0, 100, 100);
        frame.add(panel);
    }
}