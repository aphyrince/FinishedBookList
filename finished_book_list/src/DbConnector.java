import java.io.FileReader;
import java.io.Reader;
import java.sql.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class DbConnector {
    private String accountInfoAddress;
    private Connection connection;
    private String url;
    private String user;
    private String password;

    // 계정 정보가 담긴 json파일의 주소 String accountInfoAddress
    public DbConnector(String accountInfoAddress) {
        try {
            this.accountInfoAddress = accountInfoAddress;
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.setAccountInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet excuteQuery(String query) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            Statement stmt = this.connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void excuteUpdate(String query) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            this.connection.createStatement().executeUpdate(query);
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // mysql 액세스를 위한 url, userId, userPassword를 읽어오는 함수
    // account.json에서 읽어옴
    private void setAccountInfo() {
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader(this.accountInfoAddress);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            reader.close();
            this.url = (String) jsonObject.get("url");
            this.user = (String) jsonObject.get("user");
            this.password = (String) jsonObject.get("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
