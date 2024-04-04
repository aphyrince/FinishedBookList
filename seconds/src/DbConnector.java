import java.io.Reader;
import java.sql.*;

import org.json.simple.*;

public class DbConnector {
    private String accountInfoAddress;
    private Connection connection;
    private String url;
    private String user;
    private String password;

    // 계정 정보가 담긴 json파일의 주소 String accountInfoAddress
    public DbConnector(String accountInfoAddress){
        try{
            this.accountInfoAddress = accountInfoAddress;
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.setAccountInfo();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet excuteQuery(String query){
        this.connection = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = this.connection.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        this.connection.close();
        return resultSet;
    }
    public void excuteUpdate(String query){
        this.connection = DriverManager.getConnection(url, user, password);
        this.connection.createStatement().executeUpdate(query);
        this.connection.close();
    }

    //mysql 액세스를 위한 url, userId, userPassword를 읽어오는 함수
    // account.json에서 읽어옴
    private void setAccountInfo(){
        try{
            JsonParser parser = new JsonParser();
            Reader reader = new FileReader(this.accountInfoAddress);
            JSONObject jsonObject = (JSONObject)parser.parse(reader);
            reader.close();
            this.url = (String) jsonObject.get("url");
            this.user = (String) jsonObject.get("user");
            this.password = (String) jsonObject.get("password");

            System.out.println(this.url);
            System.out.println(this.user);
            System.out.println(this.password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
