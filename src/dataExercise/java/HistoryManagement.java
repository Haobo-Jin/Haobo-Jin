import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class HistoryManagement {

    Connection connetion =DatabaseConnetion.getConnection();
    String[][]  historyList= new String[10][5];

    public String[][] ShowHistory(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int i= 0;
        while (rs.next()){
            String[] list  = new String[7];
            int id=rs.getInt("id");
            list[0]=Integer.toString(id);
            list[1]=(rs.getString("name"));
            list[2]=(rs.getString("style"));
            list[3]=Integer.toString(rs.getInt("amount"));
            list[4]=Integer.toString(rs.getInt("price"));
            list[5]=(rs.getString("buyer"));
            historyList[i]=list;
            i++;
        }
        return historyList;
    }


    public void Add(String[] goods) throws SQLException {
        String sql="insert into history(name,style,number,price,state,holder)" + "values(?,?,?,?,?,?)";
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setInt(1,Integer.parseInt(goods[0]));
        statement.setString(2,goods[1]);
        statement.setString(3,goods[2]);
        statement.setInt(4,Integer.parseInt(goods[3]));
        statement.setInt(5,Integer.parseInt(goods[4]));
        statement.setString(6,goods[5]);
        statement.executeUpdate();
        statement.close();
    }
}
