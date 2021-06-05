import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeManagement {
    Connection connetion =DatabaseConnetion.getConnection();
    String[][] tradeList = new String[50][5];
    public String[][] ShowCTrade(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int i= 0;
        while (rs.next()){
            String[] list  = new String[7];
            list[0]=rs.getString("BUYorSELL");
            list[1]=(rs.getString("unit"));
            list[2]=(rs.getString("assetname"));
            list[3]=Integer.toString(rs.getInt("quantity"));
            list[4]=Integer.toString(rs.getInt("price"));
            list[5]=(rs.getString("datetime"));
            tradeList[i]=list;
            i++;
        }
        return tradeList;
    }

    public void UpdateOrDelete(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    public void Add(String[] trades,String buyer) throws SQLException {
        String sql = "insert into currentTrades (BUYorSELL,unit,assetname,quantity,price,datetime) " + "values(?,?,?,?,?,?)";
        Date d = new java.util.Date();
        java.sql.Date date = new java.sql.Date(d.getTime());//会丢失时分秒
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1,buyer);
        statement.setString(2,trades[0]);
        statement.setString(3,trades[1]);
        statement.setInt(4,Integer.parseInt(trades[2]));
        statement.setInt(5,Integer.parseInt(trades[3]));
        statement.setDate(6, (java.sql.Date) date);
        statement.executeUpdate();
        statement.close();
    }
    public  void  Return(String buyer,String assertName) throws SQLException {
        String sql="delete from current trades where organisational unit = "+buyer+ " and asset name= " +assertName;
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }
    public void  accept(String buyer,String seller,String assertName,int price) throws SQLException {
        String sql="delete from current trades where organisational unit = "+buyer+ " and asset name= " +assertName +" and BUY/SELL =buy";
        PreparedStatement firstStatement=connetion.prepareStatement(sql);
        firstStatement.executeUpdate();
        firstStatement.close();
        sql="delete from current trades where organisational unit = "+seller+ " and asset name= " +assertName +" and BUY/SELL =sell";
        PreparedStatement thirdStatement=connetion.prepareStatement(sql);
        thirdStatement.executeUpdate();
        thirdStatement.close();
        UserManagement userManagement= new UserManagement();
        userManagement.AddMoney(price);
        userManagement.DeductMoney(buyer,price);
    }



}
