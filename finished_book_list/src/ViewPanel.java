import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.*;

public class ViewPanel extends JPanel{
    private JScrollPane scrollPane;
    private JPanel listPanel;

    public ViewPanel(){
        setBackground(Color.CYAN);
        setSize(400,600);
        setLayout(new FlowLayout());

        listPanel = new JPanel();
        listPanel.setLayout(new FlowLayout());
        scrollPane = new JScrollPane(listPanel);
        

        add(scrollPane);
    }

    public void setBookColumn(List<String[]> dataList){
        for(String[] str : dataList){
            if(str.length==1){
                add(new BookColumn(str[0], "null"));
            }
            else{
                add(new BookColumn(str[0], str[1]));
            }
        }
    }
    public void addBookColumn(String bookName, String date){
        add(new BookColumn(bookName, date));
    }
    public void updateBookColumn(String bookName, String date){

    }
    public void deleteBookColumn(String bookName){

    }
}
