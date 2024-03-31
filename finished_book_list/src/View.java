import java.awt.*;
import javax.swing.*;

public class View extends JFrame{
    private Container contentPane;
    private JPanel updatePanel;
    private JPanel showPanel;

    public View(){
        setTitle("Finished Book List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(contentPane = new ShowPanel());


        setSize(400,700);
        setVisible(true);
    }
}
