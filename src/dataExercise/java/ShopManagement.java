import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShopManagement {


    private void setGoodsList () throws SQLException {
        Connection connetion =DatabaseConnetion.getConnection();
        String sql="select * from shopping";
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int i= 0;
        while (rs.next()){
            Goods goods =new Goods();
            ArrayList list  = new ArrayList();
            goods.setId(rs.getInt("id"));
            goods.setGoodsname(rs.getString("name"));
            goods.setGoodsstyle(rs.getString("style"));
            goods.setGoodsnumber(rs.getInt("number "));
            goods.setGoodPrice(rs.getInt("price"));
        }

    }





}
