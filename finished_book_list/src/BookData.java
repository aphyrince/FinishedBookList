import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookData {
    private String name;
    private Date date;

    public BookData(String rawData) {
        String[] tmpStr = rawData.split(",");
        this.name = tmpStr[0];
        this.date = null;
        if(tmpStr.length > 1){
            try {
                this.date = new SimpleDateFormat("yyyy.mm.dd").parse(tmpStr[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public BookData(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public void setDate(Date newDate) {
        this.date = newDate;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", name, date);
    }
}
