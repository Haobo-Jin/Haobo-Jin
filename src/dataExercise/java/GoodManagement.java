import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GoodManagement {
    Connection connetion =DatabaseConnetion.getConnection();
    String[][]  goodsList= new String[10][5];

    public String[][] ShowGood(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int i= 0;
        while (rs.next()){
            String[] list  = new String[7];
            int id=rs.getInt("id");
            list[0]=Integer.toString(id);
            list[1]=(rs.getString("name"));
            list[2]=(rs.getString("style"));
            list[3]=Integer.toString(rs.getInt("number"));
            list[4]=Integer.toString(rs.getInt("price"));
            list[5]=(rs.getString("state"));
            list[6]=(rs.getString("holder"));
            goodsList[i]=list;
            i++;
        }
        return goodsList;
    }




    public void Delete(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }


    public void Update(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    public void Add(String[] goods, String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1,goods[0]);
        statement.setString(2,goods[1]);
        statement.setInt(3,Integer.parseInt(goods[2]));
        statement.setInt(4,Integer.parseInt(goods[3]));
        statement.setString(5,goods[4]);
        statement.setString(6,goods[5]);
        statement.executeUpdate();
        statement.close();
    }
}
