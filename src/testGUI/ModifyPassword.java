import javax.swing.*;
import java.awt.*;

public class ModifyPassword {
    public JFrame userFrame;

    private JMenuBar menu;

    private JMenu account;

    private JMenuItem personalInformation;

    private JMenuItem modifyPassword;

    private JMenuItem logOut;

    private JMenu trading;

    private JMenuItem currentTrades;

    private JMenuItem historyRecords;

    JTextField oldPassword;
    JTextField newPassword;
    JTextField checkNewPassword;

    public JFrame createGUI() {
        userFrame = new JFrame("Welcome back user ");

        // setup the frame size and its location
        userFrame.setBounds(500, 225, 550, 450);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLayout(null);

        // set up the background images
        ((JComponent) userFrame.getContentPane()).setOpaque(false);
        // input the path of the background images
        ImageIcon img = new ImageIcon("images//b67010b625b6038ae5baac895c79e3e.jpg");
        // let the images be a label
        JLabel imgLabel = new JLabel(img);
        userFrame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        // set up the location and the size of the background images
        imgLabel.setBounds(0, 0, 550, 450);

        menu = new JMenuBar();
        account = new JMenu("Account");
        personalInformation = new JMenuItem("Personal information");
        modifyPassword = new JMenuItem("Modify password");
        logOut = new JMenuItem("Log out");
        trading = new JMenu("Trading");
        currentTrades = new JMenuItem("Current Trades");
        historyRecords = new JMenuItem("History Records");

        userFrame.setJMenuBar(menu);

        account.add(personalInformation);
        account.add(modifyPassword);
        account.add(logOut);

        trading.add(currentTrades);
        trading.add(historyRecords);

        menu.add(account);
        menu.add(trading);

        JLabel modifiedPasswordLabel = new JLabel("Modify password");
        JLabel oldPasswordLabel = new JLabel("original password: ");
        JLabel newPasswordLabel = new JLabel("new password: ");
        JLabel checkNewPasswordLabel = new JLabel("check new password: ");

        oldPassword = new JTextField();
        newPassword = new JTextField();
        checkNewPassword = new JTextField();

        JButton submitButton = new JButton("submit");

        // set up the objects' size and the location
        modifiedPasswordLabel.setBounds(165, 80, 400, 30);
        modifiedPasswordLabel.setFont(new Font("Arial",Font.BOLD, 25));
        modifiedPasswordLabel.setForeground(Color.WHITE);

        oldPasswordLabel.setBounds(100, 150, 200, 30);
        oldPasswordLabel.setFont(new Font("Arial",Font.BOLD, 14));
        oldPasswordLabel.setForeground(Color.WHITE);

        newPasswordLabel.setBounds(100, 190, 200, 30);
        newPasswordLabel.setFont(new Font("Arial",Font.BOLD, 14));
        newPasswordLabel.setForeground(Color.WHITE);

        checkNewPasswordLabel.setBounds(100, 230, 210, 30);
        checkNewPasswordLabel.setFont(new Font("Arial",Font.BOLD, 14));
        checkNewPasswordLabel.setForeground(Color.WHITE);

        oldPassword.setBounds(260, 150, 180, 30);
        newPassword.setBounds(260, 190, 180, 30);
        checkNewPassword.setBounds(260, 230, 180, 30);
        submitButton.setBounds(205, 295, 100, 30);

        // add these objects to the frame
        userFrame.add(modifiedPasswordLabel);
        userFrame.add(oldPasswordLabel);
        userFrame.add(newPasswordLabel);
        userFrame.add(checkNewPasswordLabel);
        userFrame.add(oldPassword);
        userFrame.add(newPassword);
        userFrame.add(checkNewPassword);
        userFrame.add(submitButton);

        userFrame.setVisible(true);

        return userFrame;
    }

        public static void main(String[] args) {
        ModifyPassword modifyPassword = new ModifyPassword();
        modifyPassword.createGUI();
    }
}
