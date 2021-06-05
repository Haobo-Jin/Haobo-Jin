
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralUsersAccount {

    public JFrame userFrame;

    private JMenuBar menu;

    ///// Menu Account /////

    // 我把Irene的‘account’，改成了我的‘Account’
    private JMenu Account;
    // 在Personal + _ + Information
    private JMenuItem Personal_Information;

    private JMenuItem ModifyPassword;
    // 我加入了我的Selling
    private JMenuItem Selling;
    private JMenuItem SellerProcessing;

    private JMenuItem BuyerProcess;

    private JMenuItem LogOut;

    // Trading Menu
    private JMenu trading;
    // 首字母改成了大写
    private JMenuItem HistoryRecords;

    // Shop Menu
    private JMenu Shop;
    private JMenuItem Shopping;

    // 导入Peter的MenuItem 和 Menu

    public GeneralUsersAccount() {
        //userAccountFrame(userFrame.getName());

        //// Personal Menu
        Account.add(Personal_Information);
        Account.add(ModifyPassword);
        Account.add(Selling);
        Account.add(SellerProcessing);
        Account.add(BuyerProcess);
        Account.addSeparator();
        Account.add(LogOut);

        //// Trading Menu
        trading.add(HistoryRecords);

        //// Shop Menu
        Shop.add(Shopping);

        //// sub Menu into GUI
        menu.add(Account);
        menu.add(trading);
        menu.add(Shop);


    }

    private JFrame userAccountFrame(String name) {
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
        // Account
        Account = new JMenu("Account");
        Personal_Information = new JMenuItem("Personal Information");
        ModifyPassword = new JMenuItem("Modify password");
        Selling = new JMenuItem("Selling");
        LogOut = new JMenuItem("Log Out");
        // Trading
        trading = new JMenu("Trading");
        HistoryRecords = new JMenuItem("History Records");
        // Shop
        Shop = new JMenu("Shop");
        Shopping = new JMenuItem("Shopping");

        userFrame.setJMenuBar(menu);



        // let this user frame be visible
        userFrame.setVisible(true);

        return userFrame;
    }

    /**
     * setup the various listener
     */
    private void action(final String name) {
        LogOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.setVisible(false);


            }
        });

        // Personal Information Interface
        Personal_Information.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // close the administrator account
                userFrame.dispose();
                // call the PersonalInformation Interface
                Personal_Information PersonalInfor_ = new Personal_Information();
                PersonalInfor_.PersonalInformation_run();

                // change back to the home page

            }
        });

        // ModifyPassword Interface
        ModifyPassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.dispose();
                ModifyPassword ModifyPassword_ = new ModifyPassword();
                ModifyPassword_.ModifyPassword_run();

                // change to the password modifying interface

            }
        });

        // Selling Interface
        Selling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // let the administrator account hide
                userFrame.dispose();
                Sellings selling_ = new Sellings();
                selling_.Selling_run();
                // change to the password modifying interface

            }
        });
        //// Selling Process
        MenuItem SellerProcess = new MenuItem("Seller Process");
        SellerProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFrame.dispose();
                SellerProcessing SellerProcess_ = new SellerProcessing();
                SellerProcess_.SellerProcessing_run();
            }
        });
        //// Buying Process
        MenuItem BuyerProcess = new MenuItem("Buyer Process");
        BuyerProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFrame.dispose();
                BuyerProcessing BuyerProcess_ = new BuyerProcessing();
                BuyerProcess_.BuyerProcessing_run();
            }
        });



        // History Interface
        HistoryRecords.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                userFrame.setVisible(false);
                HistoryRecords history_ = new HistoryRecords();
                history_.History_run();

                // change to the password modifying interface

            }
        });

        // Shopping Interface
        Shopping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFrame.dispose();
                Shopping shopping_ = new Shopping();
                shopping_.Shopping_run();
            }
        });

    }
}
