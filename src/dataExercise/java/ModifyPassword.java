import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModifyPassword extends JFrame{
    JTextField oldPassword;
    JTextField newPassword;
    JTextField checkNewPassword;
    private MenuItem HistoryRecords;
    private MenuItem Shopping;

    public ModifyPassword(){
        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// GUI 设置 /////////////////////////////////////
        // 命名题目
        setTitle("Modify Password");
        // 设置大小和位置
        setBounds(500, 225, 550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////// Menu 设置 //////////////////////////////////////
        // 设置Bar
        MenuBar mb = new MenuBar();
        //////// 商城菜单
        Menu Shop = new Menu("Shop");
        ////购物
        Shopping = new MenuItem("Shopping");
        Shopping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Shopping shopping_ = new Shopping();
                shopping_.Shopping_run();
            }
        });
        /////出售
        MenuItem Selling = new MenuItem("Selling");
        Selling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Sellings selling_ = new Sellings();
                selling_.Selling_run();
            }
        });

        //////// 个人资料菜单
        Menu Account = new Menu("Account");
        //// 更改个人资料
        MenuItem Personal_Information = new MenuItem("Personal Information");
        Personal_Information.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Personal_Information PersonalInfor_ = new Personal_Information();
                PersonalInfor_.PersonalInformation_run();
            }
        });
        // 更改密码
        MenuItem ModifyPassword = new MenuItem("Modify Password");
        ModifyPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ModifyPassword ModifyPassword_ = new ModifyPassword();
                ModifyPassword_.ModifyPassword_run();

            }
        });
        // 资产
        MenuItem Assert = new MenuItem("Assert");
        Assert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ___Assert___ Assert_ = new ___Assert___();
                Assert_.Assert_run();
            }
        });
        //

        //// 拥有物品
        MenuItem OwnedGoods = new MenuItem("Owned Goods");
        OwnedGoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OwnedGoods OwnGood_ = new OwnedGoods();
                OwnGood_.OwnGoods_run();
            }
        });
        // 退出按钮
        MenuItem LogOut = new MenuItem("Log Out");


        /////// 交易信息
        Menu Trading = new Menu("Trading");
        // 当前的交易
        MenuItem CurrentTrades = new MenuItem("Current Trades");
        CurrentTrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                __CurrentTrades__ currentTrades_ = new __CurrentTrades__();
                currentTrades_.Current_run();
            }
        });
        // 历史记录
        HistoryRecords = new MenuItem("History Records");
        HistoryRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HistoryRecords history_ = new HistoryRecords();
                history_.History_run();
            }
        });

        //// 小菜单导入进大菜单
        // 商城的
        Shop.add(Shopping);


        //// 交易
        Trading.add(HistoryRecords);

        //// 个人的
        Account.add(Personal_Information);
        Account.add(ModifyPassword);
        Account.add(OwnedGoods);
        Account.add(Selling);
        Account.addSeparator();
        Account.add(LogOut);


        //// 菜单导入GUI
        mb.add(Shop);
        mb.add(Account);
        mb.add(Trading);
        ////////// 设置GUI /////////

        //显示菜单 Bar
        setMenuBar(mb);

        // 窗口不可缩放
        setResizable(true);
        ///////////////////////////////////////////////////////////////////////////////////////

        JLabel modifiedPasswordLabel = new JLabel("Modify password");
        JLabel oldPasswordLabel = new JLabel("Original password: ");
        JLabel newPasswordLabel = new JLabel("New password: ");
        JLabel checkNewPasswordLabel = new JLabel("Check new password: ");

        oldPassword = new JTextField();
        newPassword = new JTextField();
        //checkNewPassword = new JTextField();




        JButton a = new JButton("");

        // set up the objects' size and the location
        modifiedPasswordLabel.setBounds(165, 80, 400, 30);
        modifiedPasswordLabel.setFont(new Font("Arial",Font.BOLD, 25));
        //modifiedPasswordLabel.setForeground(Color.WHITE);
        modifiedPasswordLabel.setForeground(Color.BLACK);


        oldPasswordLabel.setBounds(80, 150, 200, 30);
        oldPasswordLabel.setFont(new Font("Arial",Font.BOLD, 14));
        //oldPasswordLabel.setForeground(Color.WHITE);
        oldPasswordLabel.setForeground(Color.BLACK);


        newPasswordLabel.setBounds(80, 190, 200, 30);
        newPasswordLabel.setFont(new Font("Arial",Font.BOLD, 14));
        //newPasswordLabel.setForeground(Color.WHITE);
        newPasswordLabel.setForeground(Color.BLACK);

        JTextField newPass = new JTextField();
        newPass.setBounds(260,190,180,30);
        add(newPass);


        checkNewPasswordLabel.setBounds(74, 230, 220, 30);
        checkNewPasswordLabel.setFont(new Font("Arial",Font.BOLD, 14));
        //checkNewPasswordLabel.setForeground(Color.WHITE);
        checkNewPasswordLabel.setForeground(Color.BLACK);

        // Chek the new password
        JTextField checkNewPass = new JTextField();
        checkNewPass.setBounds(260,230,180,30);
        add(checkNewPass);

        oldPassword.setBounds(260, 150, 180, 30);
        newPassword.setBounds(1, 1, 1, 1);
        //checkNewPassword.setBounds(260, 230, 180, 30);
        a.setBounds(1, 1, 1, 1);

        JLabel ChecktheNew = new JLabel();
        ChecktheNew.setBounds(260,220,20,5);

        // 按下这个按钮，确认更改密码
        JButton submit = new JButton("Submit");
        submit.setBounds(210,295,100,30);
        add(submit);

        add(modifiedPasswordLabel);
        add(oldPasswordLabel);
        add(newPasswordLabel);
        add(checkNewPasswordLabel);
        add(oldPassword);
        add(newPassword);

    }
    public static void ModifyPassword_run() {
        ModifyPassword jTableDefaultTableModelTest = new ModifyPassword();
        jTableDefaultTableModelTest.setVisible(true);
    }
/*
    public static void main(String[] args) {
        ModifyPassword_run();
    }*/
}
