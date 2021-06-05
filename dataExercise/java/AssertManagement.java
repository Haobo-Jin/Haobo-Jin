import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssertManagement {
    Connection connetion = DatabaseConnetion.getConnection();
    //add new assert to database
    public void Add(String asserts) throws SQLException {
        String sql="insert into assert(name) values(?)";
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1,asserts);
        statement.executeUpdate();
        statement.close();
    }
    //Query whether this assert exists
    public boolean Query(String asserts, String sql) throws SQLException {
        PreparedStatement statement=connetion.prepareStatement(sql);
        statement.setString(1, asserts);
        ResultSet rs =statement.executeQuery();
        String assertName;
        //if assert type is not exit in database,translater will throw the exception and return false.
        do  {
            rs.next();
            try {
                assertName = rs.getString("name");
            }catch (Exception SQLException){
                return false;
            }
            return true;

        }while (rs.next());

    }
}
