
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddUser extends AdminAccount {
    JTextField userName;
    JTextField password;
    JTextField userUnit;

    public AddUser() {
        super();
        JLabel addUserLabel = new JLabel("Add user");
        JLabel userNameLabel = new JLabel("user name: ");
        JLabel passwordLabel = new JLabel("password: ");
        JLabel userTypeLabel = new JLabel("organizational unit: ");

        userName = new JTextField();
        password = new JTextField();
        userUnit = new JTextField();

        JButton createButton = new JButton("create");

        // set up the objects' size and the location
        addUserLabel.setBounds(205, 80, 400, 30);
        addUserLabel.setFont(new Font("Arial", Font.BOLD, 25));
        addUserLabel.setForeground(Color.WHITE);

        userNameLabel.setBounds(145, 150, 100, 30);
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 13));
        userNameLabel.setForeground(Color.WHITE);

        passwordLabel.setBounds(145, 190, 100, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        passwordLabel.setForeground(Color.WHITE);

        userTypeLabel.setBounds(145, 230, 150, 30);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 13));
        userTypeLabel.setForeground(Color.WHITE);

        userName.setBounds(275, 150, 180, 30);
        password.setBounds(275, 190, 180, 30);
        userUnit.setBounds(275, 230, 180, 30);
        createButton.setBounds(215, 305, 90, 30);

        // add these objects to the frame
        adminFrame.add(addUserLabel);
        adminFrame.add(userNameLabel);
        adminFrame.add(passwordLabel);
        adminFrame.add(userTypeLabel);
        adminFrame.add(userName);
        adminFrame.add(password);
        adminFrame.add(userUnit);
        adminFrame.add(createButton);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Add();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }


    private void Add() throws SQLException {
        Users user=new Users();
        String userNameText = userName.getText();
        int passwordText = Integer.parseInt(password.getText());
        String userUnitText = userUnit.getText();
        if(userNameText.equals("") || passwordText==0 || userUnitText.equals("")) {
            //为空，弹出提示框
            JOptionPane.showMessageDialog(null,"The input field cannot be empty !");
        } else {
            String sql;
            ArrayList UnitList;
            user.setUsername(userNameText);
            user.setUserpwd(passwordText);
            user.setOrganizationalUnits(userUnitText);
            user.setState("general users");
            UnitList = new UnitManagement().UnitList();
            if (UnitList.contains(userUnitText)){
                UserManagement management=new UserManagement();
                sql="insert into users(name,password,unit,state) values(?,?,?,?)";
                management.add(user,sql);
                FiledClear();
                //添加成功提示框
                JOptionPane.showMessageDialog(null, "Add successful");
            }else{
                JOptionPane.showMessageDialog(null,"Unit does not exist .");
                FiledClear();
            }


        }

    }
    private void FiledClear(){
        userName.setText("");
        password.setText("");
        userUnit.setText("");
    }
}
