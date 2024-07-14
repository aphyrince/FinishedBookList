import java.awt.BorderLayout;

import javax.swing.*;

public class BookColumn extends JPanel{
    private JLabel bookName;
    private JLabel date;

    public BookColumn(String bookName, String date){
        setSize(400,50);
        setLayout(new BorderLayout());

        this.bookName = new JLabel(bookName);
        this.date = new JLabel(date);

        add(this.bookName, BorderLayout.CENTER);
        add(this.date, BorderLayout.EAST);
    }

    public String getBookName(){
        return bookName.getText();
    }
    public void setBookName(String newBookName){
        bookName.setText(newBookName);
    }
    public String getDate(){
        return date.getText();
    }
    public void setDate(String newDate){
        date.setText(newDate);
    }
}
