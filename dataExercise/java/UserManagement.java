import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManagement {
    Connection connetion = DatabaseConnetion.getConnection();
    //    Vector totalList  = new Vector();
    //get the information of login-in personal
    public static database.Users LoginStaff  =new database.Users();
    //
    public boolean CheckPassword(String password){
        if (password.equals(LoginStaff.getUserpwd()) ){
            return true;
        }else {
            return  false;
        }
    }
    //Find if the user exists in the database
    public boolean Query(database.Users user, String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getUserpwd());
        statement.setString(3,user.getState());
        ResultSet rs =statement.executeQuery();
        String username;
        int userpwd;
        String userUnit;
        String userState;
        int userID;
        do  {
            rs.next();
            try {
//                username = rs.getString("name");
//                userpwd = rs.getInt("password");
                userUnit = rs.getString("unit");
//                userState =rs.getString("state");
                userID=rs.getInt("id");
                LoginStaff =user;
                LoginStaff.setOrganizationalUnits(userUnit);
                LoginStaff.setId(userID);
            }catch (Exception SQLException){
                return false;
            }
            return true;

        }while (rs.next());

    }

    public ArrayList ReturnUser( String sql) throws SQLException {
        ArrayList arrayList =new ArrayList();
        PreparedStatement statement=connetion.prepareStatement(sql);
        ResultSet rs =statement.executeQuery();
        int i= 0;
        while (rs.next()){
            String[] list  = new String[7];
            list[0]=String.valueOf(rs.getInt("id"));
            list[1]=(rs.getString("name"));
            list[2]=rs.getString("password");
            list[3]=(rs.getString("unit"));
            list[4]=(rs.getString("state"));
            arrayList.add(list);
            i++;
        }
        return arrayList;

    }

    //add the new users in database
    public void add(database.Users users, String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1,users.getUsername());
        statement.setString(2,users.getUserpwd());
        statement.setString(3,users.getOrganizationalUnits());
        statement.setString(4,users.getState());
        statement.executeUpdate();
        statement.close();
    }
    //Reduce the money of the unit to which the user belongs
    public void DeductMoney(String unit,int credit) throws SQLException {

        String sql ="UPDATE unit set credit = credit -"+ credit+" WHERE unit = "+unit;
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }
    //add the money of the unit to which the user belongs
    public void AddMoney(String unit,int credit) throws SQLException {
        String sql ="UPDATE unit set credit = credit +"+ credit+" WHERE unit = "+unit;
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }
    // change the password of user
    public void ChangePassword(String password) throws SQLException {
        String sql = "UPDATE users set password = '"+password + "' WHERE name = '"+LoginStaff.getUsername()+"'";
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
        LoginStaff.setUserpwd(password);
    }

}
