import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Index extends JFrame {
    private final String DataPath = "C:\\Users\\dkswj\\Desktop\\피니시드북스_프로젝트\\finished_book_list\\src\\data.csv";
    private Container contentPanel;
    private ViewPanel viewPanel;
    private ControllPanel controllPanel;
    private DataController dataController;
    private List<String[]> dataList;

    public Index(){
        super("읽은 책 목록");
        init();
    }

    private void init(){
        contentPanel = getContentPane();
        contentPanel.setLayout(new BorderLayout());
        viewPanel = new ViewPanel();
        controllPanel = new ControllPanel();
        dataController = new DataController(DataPath);
        dataList = dataController.getDataList();

        contentPanel.add(viewPanel,BorderLayout.CENTER);
        contentPanel.add(controllPanel,BorderLayout.NORTH);

        viewPanel.setBookColumn(dataList);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 700);
        contentPanel.setSize(400, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
