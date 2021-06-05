package database;

public class OrientationUnit {
    private String unit;
    private int credit;
    private  String assertName;
    private String assertNumber;
    public void setUnit(String unit) { this.unit = unit; }

    public void setCredit(int credit) { this.credit = credit; }

    public String getUnit() { return unit; }

    public int getCredit() { return credit; }

    public void setAssertName(String assertName) { this.assertName = assertName; }

    public String getAssertName() { return assertName; }
    public String getAssertNumber(){
        return  assertNumber;
    }
    public void  setAssertNumber(int assertNumber){
        this.assertName=assertName;
    }
}
