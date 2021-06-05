

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserAccount {
    public JFrame userFrame;

    private JMenuBar menu;

    private JMenu account;

    private JMenuItem personalInformation;

    private JMenuItem modifyPassword;

    private JMenuItem logOut;

    private JMenu trading;

    private JMenuItem currentTrades;

    private JMenuItem historyRecords;

    public UserAccount() {
        AdministratorAccountFrame("302 assignment");

        account.add(personalInformation);
        account.add(modifyPassword);
        account.add(logOut);

        trading.add(currentTrades);
        trading.add(historyRecords);

        menu.add(account);
        menu.add(trading);
        action();
    }

    private JFrame AdministratorAccountFrame(String name) {
        userFrame = new JFrame("Welcome back user " + name); // 連接database寫出這帳戶的使用者名字

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

        Home home = new Home(userFrame);

        // let this user frame be visible
        userFrame.setVisible(true);

        return userFrame;
    }

    /**
     * setup the various listener
     */
    private void action() {
        logOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.setVisible(false);

                LogIn.main(null);
            }
        });

        personalInformation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.setVisible(false);

                // change back to the home page
                new UserAccount();
            }
        });

        modifyPassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.setVisible(false);

                // change to the password modifying interface
                new ModifyPassword();
            }
        });

        currentTrades.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.setVisible(false);

                // change to the password modifying interface
            }
        });

        historyRecords.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.setVisible(false);

                // change to the password modifying interface
                new HistoryRecords();
            }
        });

    }
}
