import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class HistoryManagement {

    Connection connetion = DatabaseConnetion.getConnection();
    String[][]  historyList= new String[10][5];
    //output the history data in database as the array
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
        statement.close();
        return historyList;
    }

    //add new history recording
    public void AddHistory(String[] trades) throws SQLException {
        String sql = "insert into histroy (sellUnit,buyUnit,assertname,amount,price,datetime) " + "values(?,?,?,?,?,?,?)";
        Date d = new Date();
        String state="buy";
        String unit = UserManagement.LoginStaff.getOrganizationalUnits();
        java.sql.Date date = new java.sql.Date(d.getTime());//会丢失时分秒
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1,state);
        statement.setString(2,unit);
        statement.setString(3,trades[0]);
        statement.setString(4,trades[1]);
        statement.setInt(5,Integer.parseInt(trades[2]));
        statement.setInt(6,Integer.parseInt(trades[3]));
        statement.setDate(7, (java.sql.Date) date);
        statement.executeUpdate();
        statement.close();
    }
}
