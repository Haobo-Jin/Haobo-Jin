import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Personal_Information extends JFrame {
    private MenuItem HistoryRecords;
    private MenuItem Shopping;
    public Personal_Information(){
        //////////////////////////////////////////////////////////////////////////////////////
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
        ////出售
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
        ///////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// GUI 设置 /////////////////////////////////////
        // 窗口名称
        setTitle("Personal Information");
        // 设置大小和位置
        setBounds(500, 225, 550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ////////// 设置GUI /////////

        //显示菜单 Bar
        setMenuBar(mb);

        // 窗口不可缩放
        setResizable(true);
        ///////////////////////////////////////////////////////////////////////////////
        // initially the label objects
        JLabel personalInformationLabel = new JLabel("Personal Information");
        JLabel userIDLabel = new JLabel("user ID: " );
        JLabel userNameLabel = new JLabel("user name: " );
        JLabel userAccountTypeLabel = new JLabel("account type: " );


        // set up the objects' size and the location
        personalInformationLabel.setBounds(145, 80, 400, 30);
        personalInformationLabel.setFont(new Font("Arial", Font.BOLD, 25));
        //personalInformationLabel.setForeground(Color.WHITE);
        add(personalInformationLabel);

        userIDLabel.setBounds(130, 135, 200, 30);
        userIDLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //userIDLabel.setForeground(Color.WHITE);
        add(userIDLabel);

        userNameLabel.setBounds(130, 175, 200, 30);
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //userNameLabel.setForeground(Color.WHITE);
        add(userNameLabel);

        userAccountTypeLabel.setBounds(130, 215, 200, 30);
        userAccountTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //userAccountTypeLabel.setForeground(Color.WHITE);
        add(userAccountTypeLabel);

        JLabel UnitName = new JLabel("Organizational Unit: ");
        UnitName.setBounds(130,255,200,30);
        UnitName.setFont(new Font("Arial",Font.BOLD,14));
        add(UnitName);

        JLabel CreditBalance = new JLabel("Credit Balance: ");
        CreditBalance.setBounds(130,295,200,30);
        CreditBalance.setFont(new Font("Arial",Font.BOLD,14));
        add(CreditBalance);

        JLabel b = new JLabel("");
        b.setBounds(0,0,1,1);
        add(b);
        ///////////////////////////////////////////////////////////////////////////////////////
    }
    public static void PersonalInformation_run(){
        Personal_Information jTableDefaultTableModelTest = new Personal_Information();
        jTableDefaultTableModelTest.setVisible(true);}
}
