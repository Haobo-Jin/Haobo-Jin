import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitManagement {
    Connection connetion = DatabaseConnetion.getConnection();
    ArrayList totalList = new ArrayList();
    String[][] assertList =new String[10][];
    //return unit in database as array list
    public  ArrayList UnitList() throws SQLException {
        totalList.clear();
        String sql ="select unit from unit";
        PreparedStatement statement = connetion.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        ArrayList list = new ArrayList();
        while (rs.next()) {
            list.add(rs.getString("unit"));
        }

        return list;
    }


    public void Delete(String sql) throws SQLException {
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    //change or add the user's data
    public void UpdateOrAdd(database.OrientationUnit unit, String sql) throws SQLException {
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, unit.getUnit());
        statement.setInt(2, unit.getCredit());
        statement.setString(3, unit.getAssertName());
        statement.executeUpdate();
        statement.close();

    }
    //return assert hold by unit as list
    public String[][] returnAssert(String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int i= 0;
        while (rs.next()){
            String[] list  = new String[3];
            list[0]= rs.getString("unit");
            list[1]=(rs.getString("assertname"));
            list[2]=rs.getString("assertNumber");
            assertList[i]=list;
            i++;
        }
        return assertList;
    }
    //Add the user's purchase record to the database
    public  void Buy(String[] asserts,int Number ) throws SQLException {
        TradeManagement currentTrades =new TradeManagement();
        //add purchase recording in currentTrades class
        currentTrades.AddBuyProcessing(asserts);
        //modify the number of assert unit hold
        String unit= UserManagement.LoginStaff.getOrganizationalUnits();
        String sql ="update unit set assertNumber ="+ Number+" where unit = " + unit +" assetname = "+ asserts[1];
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }
    //Add the user's sales record to the database
    public  void sell(String[] asserts,int Number) throws SQLException {
        TradeManagement currentTrades =new TradeManagement();
        //add sell recording in currentTrades class
        String sellerUnit= UserManagement.LoginStaff.getOrganizationalUnits();
        //modify the number of assert unit hold
        currentTrades.AddSellProcessing(asserts);
        String sql ="update unit set assertNumber ="+ Number+" where unit = '"+sellerUnit +"' AND assertname = '"+ asserts[1]+"'";
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }


}
