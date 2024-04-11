import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import java.sql.*;

public class FinishedBookList extends JFrame implements MouseListener, KeyListener, ListSelectionListener {
    private JList list;
    private JButton addButton;
    private JButton delButton;
    private JButton updButton;
    private JTextField inputField;

    private DefaultListModel model;
    private JScrollPane scroll;

    public FinishedBookList() {
        super("Finished Book List");
        init();
    }

    private void init() {
        this.model = new DefaultListModel();
        this.list = new JList(model);
        inputField = new JTextField(33);
        addButton = new JButton("추가");
        delButton = new JButton("제거");
        updButton = new JButton("수정");

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inputField.addKeyListener(this);
        addButton.addMouseListener(this);
        delButton.addMouseListener(this);
        list.addListSelectionListener(this);

        JPanel topPanel = new JPanel(new FlowLayout(10, 10, FlowLayout.LEFT));
        topPanel.add(inputField);
        topPanel.add(addButton);
        topPanel.add(delButton);
        topPanel.add(updButton);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding

        scroll = new JScrollPane(list);
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        getAllBookList();

        this.add(topPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 400);
        setLocationRelativeTo(null);
        ;
        setVisible(true);
    }

    public void getAllBookList() {
        DbConnector conn = new DbConnector(
                "C:\\Users\\dkswj\\Desktop\\프로젝트 Finished Book List\\finished_book_list\\src\\account.json");
        ResultSet resultSet = conn.excuteQuery("select * from booklist;");
        try{
            while (resultSet.next()) {
                model.addElement(resultSet.getString("bookname"));
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { // 이거 없으면 mouse 눌릴 때, 땔 때 각각 한번씩 호출되서 총 두번 호출
            System.out.println("selected : " + list.getSelectedValue());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            addItem();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == addButton) {
            addItem();
        }
        if (e.getSource() == delButton) {
            int selected = list.getSelectedIndex();
            removeItem(selected);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void addItem() {
        String inputText = inputField.getText();
        if (inputText == null || inputText.length() == 0) {
            return;
        }
        model.addElement(inputText);
        inputField.setText("");
        inputField.requestFocus(true);

        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    }

    public void removeItem(int index) {
        if (index < 0) {
            if (model.size() == 0)
                return;
            index = 0;
        }
        model.remove(index);
    }
}