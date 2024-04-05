import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.sql.*;

public class MainFrame extends JFrame {
    private ShowPanel showPanel;
    private Container contentPane;
    private Vector<BookData> bookDataList;
    private DbConnector conn;
    private String accountAddress = "C:\\Users\\dkswj\\Desktop\\프로젝트 Finished Book List\\finished_book_list\\src\\account.json";

    public MainFrame() {
        this(null);
    }

    public MainFrame(String args) {
        setTitle("읽은 책 목록 관리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 700);
        this.showPanel = new ShowPanel();
        this.contentPane = showPanel;
        setContentPane(this.showPanel);

        this.bookDataList = new Vector<BookData>();
        if (args != null) {
            this.accountAddress = args;
        }
        conn = new DbConnector(this.accountAddress);
        ResultSet resultSet = conn.excuteQuery("select * from booklist;");
        try {
            while (resultSet.next()) {
                this.bookDataList.add(new BookData(resultSet.getString(1), resultSet.getString(2)));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < this.bookDataList.size(); i++) {
            this.showPanel.addBookList(this.bookDataList.elementAt(i));
        }
        setVisible(true);
    }
}
