import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class TradeManagement {
    Connection connetion = DatabaseConnetion.getConnection();
    String[][] tradeList = new String[50][5];

    //return all of the trade in database
    public String[][] ShowCTrade(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int i= 0;
        while (rs.next()){
            String[] list  = new String[7];
            list[0]=rs.getString("BUYorSELL");
            list[1]=(rs.getString("sellUnit"));
            list[2]=rs.getString("buyUnit");
            list[3]=(rs.getString("assetname"));
            list[4]=Integer.toString(rs.getInt("quantity"));
            list[5]=Integer.toString(rs.getInt("price"));
            list[6]=(rs.getString("datetime"));
            tradeList[i]=list;
            i++;
        }
        return tradeList;
    }
    //
    public void UpdateOrDelete(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }
    //Add new purchase record
    public void AddBuyProcessing(String[] trades) throws SQLException {
        String sql = "insert into currentTrades (BUYorSELL,sellUnit,buyUnit,assetname,quantity,price,datetime) " + "values(?,?,?,?,?,?,?)";
        //get current data
        Date d = new Date();
        String state="buy";
        String unit = UserManagement.LoginStaff.getOrganizationalUnits();
        java.sql.Date date = new java.sql.Date(d.getTime());
        //convert datetime to sql format
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
    //Add new cell record
    public void AddSellProcessing(String[] trades) throws SQLException {
        String sql = "insert into currentTrades (BUYorSELL,sellUnit,buyUnit,assetname,quantity,price,datetime) " + "values(?,?,?,?,?,?,?)";
        //get current data
        Date d = new Date();
        //convert datetime to sql format
        java.sql.Date date = new java.sql.Date(d.getTime());
        PreparedStatement statement=connetion.prepareStatement(sql);
        String assertState="sell";
        String unit = UserManagement.LoginStaff.getOrganizationalUnits();
        statement.setString(1,assertState);
        statement.setString(2,trades[0]);
        statement.setString(3,"none");
        statement.setString(4,trades[1]);
        statement.setInt(5,Integer.parseInt(trades[2]));
        statement.setInt(6,Integer.parseInt(trades[3]));
        statement.setDate(7, (java.sql.Date) date);
        statement.executeUpdate();
        statement.close();
    }

    public  void  Return(String[] trade) throws SQLException {
        String sql="update currentTrades SET BUYorSELL ='refuse' where  BUYorSELL= 'buy' and sellUnit = '"+trade[1] +"'and buyUnit = '"+trade[2] +"' and assetname='"+trade[3]+"'and quantity ='" +trade[4] +"'" ;
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
        sql="update unit SET assertNumber =assertNumber+'"+trade[4]+"'  where Unit = '"+trade[1] +"'and assertname='"+trade[3]+"'";
        statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
        JOptionPane.showMessageDialog(null, "successful");
    }
    public void  Accept(String[] trade) throws SQLException {
        String sql= "select quantity from currentTrades where  BUYorSELL= 'sell' and sellUnit = '"+trade[1] +"'and buyUnit = '"+trade[2] +"' and assetname='"+trade[3]+"'and quantity ='" +trade[4] +"'and price ='" +trade[5] +"'" ;
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int originalQuantity=0;
        while (rs.next()){
            originalQuantity=rs.getInt("quantity");
        }
        if (originalQuantity==Integer.parseInt(trade[4])){
            sql="update currentTrades SET BUYorSELL ='complete' where  BUYorSELL= 'buy' and sellUnit = '"+trade[1] +"'and buyUnit = '"+trade[2] +"' and assetname='"+trade[3]+"'and quantity ='" +trade[4] +"'and price ='" +trade[5] +"'"  ;
            PreparedStatement firstStatement=connetion.prepareStatement(sql);
            firstStatement.executeUpdate();
            firstStatement.close();
            sql="delete from currentTrades where  BUYorSELL= 'buy' and sellUnit = '"+trade[1] +"'and buyUnit = '"+trade[2] +"' and assetname='"+trade[3]+"'and quantity ='" +trade[4] +"'and price ='" +trade[5] +"'" ;
            PreparedStatement thirdStatement=connetion.prepareStatement(sql);
            thirdStatement.executeUpdate();
            thirdStatement.close();
            int price = Integer.parseInt(trade[4])*Integer.parseInt(trade[5]);
            UserManagement userManagement= new UserManagement();
            userManagement.AddMoney(trade[1],price);
            userManagement.DeductMoney(trade[2],price);
        }
        else{
            sql="update currentTrades SET BUYorSELL ='complete' where  BUYorSELL= 'sell' and sellUnit = '"+trade[1] +"'and buyUnit = '"+trade[2] +"' and assetname='"+trade[3]+"'and quantity ='" +trade[4] +"'and price ='" +trade[5] +"'" ;
            PreparedStatement firstStatement=connetion.prepareStatement(sql);
            firstStatement.executeUpdate();
            firstStatement.close();
            sql="update currentTrades SET quantity=quantity- "+trade[4]+"  where  BUYorSELL= 'buy' and sellUnit = '"+trade[1] +"'and buyUnit = '"+trade[2] +"' and assetname='"+trade[3]+"'and quantity ='" +trade[4] +"'and price ='" +trade[5] +"'" ;
            PreparedStatement thirdStatement=connetion.prepareStatement(sql);
            thirdStatement.executeUpdate();
            thirdStatement.close();
            int price = Integer.parseInt(trade[4])*Integer.parseInt(trade[5]);
            UserManagement userManagement= new UserManagement();
            userManagement.AddMoney(trade[1],price);
            userManagement.DeductMoney(trade[2],price);
            HistoryManagement historyManagement=new HistoryManagement();
            historyManagement.AddHistory(trade);
        }
    }




}
