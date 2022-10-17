
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
    JButton button10;
    JTextField textField;

    MyFrame() {
        button10 = new JButton("Submit");
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setBackground(Color.yellow);
        button10.addActionListener(this);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
        this.add(button10);
        this.add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("yoyo actionPerformed");
        if (e.getSource() == button10) {
            System.out.println(textField.getText());
        }
    }
}