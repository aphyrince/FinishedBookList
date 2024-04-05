import java.sql.*;

public class App {
    public static void main(String[] args) {
        DbConnector conn = new DbConnector("C:\\Users\\dkswj\\Desktop\\프로젝트 Finished Book List\\finished_book_list\\src\\account.json");
        ResultSet resultSet = conn.excuteQuery("select * from booklist;");
        
        try{
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+" \\ "+ resultSet.getString(2));
            }
            System.out.println(resultSet);
        }catch(Exception e){
            e.printStackTrace();
        }

        conn.close();
    }
}
