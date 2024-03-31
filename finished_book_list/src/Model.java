import java.sql.*;
/*
 * connect db, get data, set data to db, close db
 */
public class Model {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql//localhost:3306/finishedbooklist";
    private String user = "root";
    private String password = "root";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public Model(){
        try{
            Class.forName(driver);
            System.out.println("드라이버 로드 성공");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공");

            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
