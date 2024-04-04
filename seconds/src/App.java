import java.io.*;
import java.sql.*;

// import org.json.simple.*;

public class App {
    public static void main(String[] args) {
        System.out.println("hello world");
        // JsonParser parser = new JsonParser();
        try{
        Reader reader = new FileReader("C:\\Users\\dkswj\\Desktop\\프로젝트 Finished Book List\\finished_book_list\\src\\account.json");
        // System.out.println("hello"+reader.toString());
        reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        // DbConnector dbConn = new DbConnector("./account.json");
        // ResultSet resultSet = dbConn.excuteQuery("select * from finishedbooklist;");

        // while(resultSet.next()){
        //     System.out.print(resultSet.getString(1)+" : ");
        //     System.out.println(resultSet.getString(2));
        // }

        // Vector<BookData> bookDataList = new Vector<BookData>();
    }
}
