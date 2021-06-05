import java.sql.*;

public class DatabaseConnetion {
    public  static Connection connection;

    public DatabaseConnetion() {
        String URL =
                "jdbc:mysql://localhost:3306/302 database?characterEncoding=utf8";
        //数据库用户名
        String username = "root";
        //数据库密码
        String password = "root";
        //连接sql

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,password,username);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



    public static  Connection getConnection(){
        if (connection == null) {
            new DatabaseConnetion();
        }
        return connection;
    }


}
