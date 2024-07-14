import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class ControllPanel extends JPanel{
    private JTextField inputField;
    private JButton addButton;

    public ControllPanel(){
        setLayout(new FlowLayout());
        setBackground(Color.YELLOW);
        inputField = new JTextField(25);
        addButton = new JButton("+");

        inputField.setSize(300, 50);
        addButton.setSize(50,50);

        setSize(400,100);
        add(inputField);
        add(addButton);
    }
}
