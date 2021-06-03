import java.util.Vector;

public class Users {
    private int id;

    private String username;

    private int userpwd;

    private String userAccountType;

    private int credits;

    private String organizationalUnits;

    private String  state;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserpwd() {
        return userpwd;
    }
    public void setUserpwd(int userpwd) {
        this.userpwd = userpwd;
    }

    public String getUserAccountType() {
        return userAccountType;
    }
    public void setUserUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }

    public String getOrganizationalUnits() {
        return organizationalUnits;
    }
    public void setOrganizationalUnits(String organizationalUnits) { this.organizationalUnits = organizationalUnits; }

    public int getCredits() {return credits; }
    public void setCredits(int credits) { this.credits = credits; }


    public void setState(String state) {this.state = state; }

    public String getState() {return state; }
}
