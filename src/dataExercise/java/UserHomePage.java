import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserHomePage extends JFrame{
    // 设置字体
    private  Font Ft = new Font("Times New Roman", Font.BOLD,15);

    private MenuItem HistoryRecords;
    private MenuItem Shopping;
    private MenuItem PersonalInformation;



    public UserHomePage()
    {

        /////// 设置 GUI
        // 窗口名称
        Frame f = new Frame("User Interface");
        // 窗口大小
        f.setBounds(500, 225, 550, 450);
        f.setLayout(null);
        // set up the background images
        ((JComponent) getContentPane()).setOpaque(false);
        // input the path of the background images
        ImageIcon img = new ImageIcon("images//b67010b625b6038ae5baac895c79e3e.jpg");
        // let the images be a label
        JLabel imgLabel = new JLabel(img);
        getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        // set up the location and the size of the background images
        imgLabel.setBounds(0, 0, 550, 450);

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
                f.dispose();
                Shopping shopping_ = new Shopping();
                shopping_.Shopping_run();
            }
        });
        ////出售
        MenuItem Selling = new MenuItem("Selling");
        Selling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
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
                f.dispose();
                Personal_Information PersonalInfor_ = new Personal_Information();
                PersonalInfor_.PersonalInformation_run();
            }
        });
        // 更改密码
        MenuItem ModifyPassword = new MenuItem("Modify Password");
        ModifyPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                ModifyPassword ModifyPassword_ = new ModifyPassword();
                ModifyPassword_.ModifyPassword_run();

            }
        });
        // 资产
        MenuItem Assert = new MenuItem("Assert");
        Assert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
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
                f.dispose();
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
                f.dispose();
                __CurrentTrades__ currentTrades_ = new __CurrentTrades__();
                currentTrades_.Current_run();
            }
        });
        // 历史记录
        HistoryRecords = new MenuItem("History Records");
        HistoryRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
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

        // initially the label objects
        JLabel personalInformationLabel = new JLabel("Personal Information");
        JLabel userIDLabel = new JLabel("user ID: " );
        JLabel userNameLabel = new JLabel("user name: " );
        JLabel userAccountTypeLabel = new JLabel("account type: " );
        JLabel userTypeLabel = new JLabel("Organizational unit: " );

        // set up the objects' size and the location
        personalInformationLabel.setBounds(145, 80, 400, 30);
        personalInformationLabel.setFont(new Font("Arial", Font.BOLD, 25));
        //personalInformationLabel.setForeground(Color.WHITE);
        f.add(personalInformationLabel);

        userIDLabel.setBounds(150, 145, 200, 30);
        userIDLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //userIDLabel.setForeground(Color.WHITE);
        f.add(userIDLabel);

        userNameLabel.setBounds(150, 185, 200, 30);
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //userNameLabel.setForeground(Color.WHITE);
        f.add(userNameLabel);

        userAccountTypeLabel.setBounds(150, 225, 200, 30);
        userAccountTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //userAccountTypeLabel.setForeground(Color.WHITE);
        f.add(userAccountTypeLabel);

        userTypeLabel.setBounds(150, 265, 200, 30);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //userTypeLabel.setForeground(Color.WHITE);
        f.add(userTypeLabel);
        ///////////////////////////////////////////////////////////////////////////////////////




        ////////// 设置GUI /////////

        //显示菜单 Bar
        f.setMenuBar(mb);
        // 窗口可见
        f.setVisible(true);
        // 窗口不可缩放
        setResizable(false);
        // 设置GUI界面关闭的那个东西
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });


    }

    public static void main(String args[]){

        new UserHomePage();


    }

}
