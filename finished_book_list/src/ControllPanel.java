import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ControllPanel extends JPanel {
    private JTextField inputField;
    private JButton addButton;
    private ViewPanel viewPanel;

    public ControllPanel(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;

        setLayout(new BorderLayout());
        setSize(400, 150);

        inputField = new JTextField(30);
        addButton = new JButton("+");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (inputText.trim().isEmpty())
                return;
                inputField.setText("");
                String[] bookDetails = inputText.split(",");
                BookData newBookData = null;
                if (bookDetails.length == 2) {
                    newBookData = new BookData(inputText);
                } else if (bookDetails.length == 1) {
                    newBookData = new BookData(inputText, null);
                }
                
                viewPanel.addBook(newBookData);
            }
        });

        add(inputField,BorderLayout.WEST);
        add(addButton, BorderLayout.EAST);
    }
}
