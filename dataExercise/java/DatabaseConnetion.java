import java.sql.*;

public class DatabaseConnetion {
    public  static Connection connection;
    //Use the driver to access the database
    public DatabaseConnetion() {
        String URL =
                "jdbc:mysql://localhost:3306/302 database?characterEncoding=utf8";
        //database username
        String username = "root";
        //database password
        String password = "root";
        //连接sql

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connect driver
            connection = DriverManager.getConnection(URL,password,username);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    //get connection
    public static  Connection getConnection(){
        if (connection == null) {
            new DatabaseConnetion();
        }
        return connection;
    }


}
