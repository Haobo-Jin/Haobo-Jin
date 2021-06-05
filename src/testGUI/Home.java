import javax.swing.*;
import java.awt.*;

public class Home {
    public Home (JFrame frame) {
        // initially the label objects
        JLabel personalInformationLabel = new JLabel("Personal Information");
        JLabel userIDLabel = new JLabel("user ID: 111");
        JLabel userNameLabel = new JLabel("user name: peter");
        JLabel userAccountTypeLabel = new JLabel("account type: general users");
        JLabel userTypeLabel = new JLabel("Organizational unit: abc unit");

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
    }
}
