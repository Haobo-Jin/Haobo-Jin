import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnedGoods extends JFrame {
    private DefaultTableModel OwnGoodsTableModel = null;
    private JTable OwnGoodsTable = null;
    private MenuItem HistoryRecords;
    private MenuItem Shopping;
    private JScrollPane srp_OGT;

    public OwnedGoods(){

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
        ///////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// GUI 设置 /////////////////////////////////////
        // 窗口名称
        setTitle("Own Goods");
        // 设置大小和位置
        setBounds(500, 225, 550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.cyan);

        ////////// 设置GUI /////////

        //显示菜单 Bar
        setMenuBar(mb);

        // 窗口不可缩放
        setResizable(true);
        ///////////////////////////////////////////////////////////////////////////////
        /*
        // 表格里列的标题
        String[] Titles = {"Item Name", "Amount","Item Price($)","Type","Owner"};
        // 表格里的数据（从database导入）
        // 这里的buyer直接写用户的名字就好
        String [][]GoodsData={
                {"FWater","8000","4","Water","User Name"},
                {"Python Tutorial","4500","89","Book","User Name"},
                {"SSK Note Book","2000","5","Book","User Name"},
                {"USB 4G","4020","20","USB","User Name"},
                {"Ruler","519","5","Tool","User Name"}};
        OwnGoodsTableModel = new DefaultTableModel(GoodsData,Titles);
        // 生成表格
        OwnGoodsTable = new JTable(OwnGoodsTableModel);
        // 添加滑动框那个东西
        JScrollPane srp  = new JScrollPane(OwnGoodsTable);
        // 把表格放在中心
        getContentPane().add(srp,BorderLayout.CENTER);

        ///////////////////// Label //////////////////////
        // 加入一个label
        final JPanel OwnGoodsLabel = new JPanel();
        // 设定位置
        getContentPane().add(OwnGoodsLabel,BorderLayout.NORTH);
        // label的名字是交易记录
        OwnGoodsLabel.add(new JLabel("Own Goods\n"));
        OwnGoodsLabel.setOpaque(true);
        OwnGoodsLabel.setBackground(Color.ORANGE);

        // 导入表格
        srp.setViewportView(OwnGoodsTable);*/
        Own_Goods_Table();
        // 导入表格
        srp_OGT.setViewportView(OwnGoodsTable);
    }
    public void Own_Goods_Table(){
        // 表格里列的标题
        String[] Titles = {"Item Name", "Amount","Item Price($)","Type","Owner"};
        String [][]GoodsData={
                {"FWater","8000","4","Water","User Name"},
                {"Python Tutorial","4500","89","Book","User Name"},
                {"SSK Note Book","2000","5","Book","User Name"},
                {"USB 4G","4020","20","USB","User Name"},
                {"Ruler","519","5","Tool","User Name"}};
        OwnGoodsTableModel = new DefaultTableModel(GoodsData,Titles);
        // 生成表格
        OwnGoodsTable = new JTable(OwnGoodsTableModel);
        // 添加滑动框那个东西
        srp_OGT  = new JScrollPane(OwnGoodsTable);
        // 把表格放在中心
        getContentPane().add(srp_OGT,BorderLayout.CENTER);

        ///////////////////// Label //////////////////////
        // 加入一个label
        final JPanel OwnGoodsLabel = new JPanel();
        // 设定位置
        getContentPane().add(OwnGoodsLabel,BorderLayout.NORTH);
        // label的名字是交易记录
        OwnGoodsLabel.add(new JLabel("Own Goods\n"));
        OwnGoodsLabel.setOpaque(true);
        OwnGoodsLabel.setBackground(Color.ORANGE);


    }
    public static void OwnGoods_run(){
        OwnedGoods jTableDefaultTableModelTest = new OwnedGoods();
        jTableDefaultTableModelTest.setVisible(true);}
}
