import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShowPanel extends JPanel{
    private JScrollPane scrollPane;
    private JList list;
    private JLabel count;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;

    private Font countFont;
    private Font listFont;

    private int finishedBookCount;

    public ShowPanel(){
        setSize(400,700);
        setLayout(new FlowLayout());

        list = new JList<>();
        scrollPane = new JScrollPane(list);
        count = new JLabel("읽은 책 수 : ");
        addButton = new JButton("추가");
        deleteButton = new JButton("제거");
        updateButton = new JButton("수정");
        buttonPanel = new JPanel(new FlowLayout());

        countFont = new Font(Font.SANS_SERIF,Font.PLAIN,30);
        count.setFont(countFont);
        listFont = new Font(Font.SANS_SERIF,Font.PLAIN,20);

        addButton.addActionListener(new AddButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        updateButton.addActionListener(new UpdateButtonListener());


        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        
        this.add(count);
        this.add(scrollPane);
        this.add(buttonPanel);
    }

    public int getFinishedBookCount(){
        return finishedBookCount;
    }
    public void setFinishedBookCount(int count){
        this.finishedBookCount = count;
    }
    class AddButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    class DeleteButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    class UpdateButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
