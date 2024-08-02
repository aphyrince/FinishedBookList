import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Index extends JFrame {
    private ViewPanel viewPanel;
    private ControllPanel controllPanel;
    private DataController dataController;

    private List<BookData> bookList;

    public Index(){
        super("읽은 책 목록");
        init();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                dataController.saveData();
            }
        });
    }

    private void init(){
        dataController = new DataController();
        bookList = dataController.getBookList();
        
        viewPanel = new ViewPanel(bookList);
        controllPanel = new ControllPanel(viewPanel);

        add(viewPanel,BorderLayout.CENTER);
        add(controllPanel,BorderLayout.NORTH);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
