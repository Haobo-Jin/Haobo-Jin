import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.Executor;

public class UserManagement {
    Connection connetion =DatabaseConnetion.getConnection();
//    Vector totalList  = new Vector();
    public static Users LoginStaff  ;

    public boolean Query(Users user, String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setInt(2, user.getUserpwd());
        statement.setString(3,user.getState());
        ResultSet rs =statement.executeQuery();
        String username;
        int userpwd;
        String userUnit;
        do  {
            rs.next();
            try {
                username = rs.getString("name");
                userpwd = rs.getInt("password");
                userUnit = rs.getString("unit");
                LoginStaff =user;
            }catch (Exception SQLException){
                return false;
            }
            return true;

        }while (rs.next());

    }


    public void add(Users users,String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1,users.getUsername());
        statement.setInt(2,users.getUserpwd());
        statement.setString(3,users.getOrganizationalUnits());
        statement.setString(4,users.getState());
        statement.executeUpdate();
        statement.close();

    }
    public void DeductMoney(String unit,int credit) throws SQLException {

        String sql ="UPDATE unit set credit = credit -"+ credit+" WHERE unit = "+unit;
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }
    public void AddMoney(int credit) throws SQLException {
        String unit = LoginStaff.getOrganizationalUnits();
        String sql ="UPDATE unit set credit = credit +"+ credit+" WHERE unit = "+unit;
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    public void UpdateOrDelete(Users users, String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

}
