import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UnitManagement {
    Connection connetion = DatabaseConnetion.getConnection();
    ArrayList totalList = new ArrayList();
    String[][] assertList =new String[10][];
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


    public void UpdateOrAdd(OrientationUnit unit, String sql) throws SQLException {
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, unit.getUnit());
        statement.setInt(2, unit.getCredit());
        statement.setString(3, unit.getAssertName());
        statement.executeUpdate();
        statement.close();

    }
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
    public  void Buy(String[] asserts,int Number ) throws SQLException {
        TradeManagement currentTrades =new TradeManagement();
        currentTrades.Add(asserts,"buyer");
        String unit=UserManagement.LoginStaff.getOrganizationalUnits();
        String sql ="update unit set assertNumber ="+ Number+" where unit = " + unit +" assetname = "+ asserts[1];
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    public  void sell(String[] asserts,int Number,String unit ) throws SQLException {
        TradeManagement currentTrades =new TradeManagement();
        currentTrades.Add(asserts,"sell");
        String sql ="update unit set assertNumber ="+ Number+" where unit = '"+unit +"' AND assertname = '"+ asserts[1]+"'";
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }


}
