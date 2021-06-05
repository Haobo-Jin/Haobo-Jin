

import javax.swing.*;
import java.awt.*;

public class Home {
    Users user = GetUserInformation();
    public Home (JFrame frame) {
        // initially the label objects
        JLabel personalInformationLabel = new JLabel("Personal Information");
        JLabel userIDLabel = new JLabel("user ID: " + user.getId());
        JLabel userNameLabel = new JLabel("user name: " + user.getUsername());
        JLabel userAccountTypeLabel = new JLabel("account type: " + user.getUserAccountType());
        JLabel userTypeLabel = new JLabel("Organizational unit: " + user.getOrganizationalUnits());

        // set up the objects' size and the location
        personalInformationLabel.setBounds(145, 80, 400, 30);
        personalInformationLabel.setFont(new Font("Arial",Font.BOLD, 25));
        personalInformationLabel.setForeground(Color.WHITE);

        userIDLabel.setBounds(150, 145, 200, 30);
        userIDLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userIDLabel.setForeground(Color.WHITE);

        userNameLabel.setBounds(150, 185, 200, 30);
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userNameLabel.setForeground(Color.WHITE);

        userAccountTypeLabel.setBounds(150, 225, 200, 30);
        userAccountTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userAccountTypeLabel.setForeground(Color.WHITE);

        userTypeLabel.setBounds(150, 265, 200, 30);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userTypeLabel.setForeground(Color.WHITE);

        // add these objects to the frame
        frame.add(personalInformationLabel);
        frame.add(userIDLabel);
        frame.add(userNameLabel);
        frame.add(userAccountTypeLabel);
        frame.add(userTypeLabel);

        // 查看個人資料 有個人ID, 名字, 帳戶類型(一般帳戶 or IT管理團員帳戶), 所屬組織單位名稱
        // 一般用戶與管理團隊帳戶皆有這個功能
    }
    private Users GetUserInformation(){
        Users loginStaff = UserManagement.LoginStaff;
        return loginStaff;
    }
}
