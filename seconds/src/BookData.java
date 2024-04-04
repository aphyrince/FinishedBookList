import javax.swing.JComponent;

public class BookData {
    private String name;
    private String date;
    private boolean changed;
    private JComponent connectedComponent;

    public BookData(String name) {
        this(name, null,null);
    }

    public BookData(String name, String date) {
        this(name,date,null);
    }
    public BookData(String name, String date, JComponent component) {
        this.name = name;
        this.date = date;
        this.changed = false;
        this.connectedComponent = component;
    }

    public void setName(String name) {
        if (this.name.equals(name)) {
            return;
        }
        this.name = name;
        this.changed = true;
    }
    public String getName(){
        return this.name;
    }
    public void setDate(String date){
        if(this.date != null && this.date.equals(date)){
            return;
        }
        this.date = date;
        this.changed = true;
    }
    public String getDate(){
        return this.date;
    }
    public void setConnectedComponent(JComponent component){
        this.connectedComponent = component;
    }
    public JComponent getConnectedComponent(){
        return this.connectedComponent;
    }
    public boolean isChanged(){
        return this.changed;
    }
}
