import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ViewPanel extends JPanel {
    private JScrollPane scrollPane;
    private JPanel listPanel;
    private List<BookData> bookList;

    public ViewPanel(List<BookData> bookList) {
        this.bookList = bookList;
        initializeComponents();
        populateListPanel();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void populateListPanel() {
        listPanel.removeAll();

        for (BookData book : bookList) {
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BorderLayout());

            JLabel titleLabel = new JLabel(book.getName());
            JLabel dateLabel = new JLabel("-");
            if(book.getDate()!=null){
                dateLabel = new JLabel(new SimpleDateFormat("yyyy.mm.dd").format(book.getDate()));
            }

            bookPanel.add(titleLabel, BorderLayout.WEST);
            bookPanel.add(dateLabel, BorderLayout.EAST);

            listPanel.add(bookPanel);
        }

        listPanel.revalidate();
        listPanel.repaint();
    }


    public void addBook(BookData bookData){
        if(bookData == null)
            return;
        bookList.addFirst(bookData);
        populateListPanel();
    }
}