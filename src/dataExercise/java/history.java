import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class history extends JFrame {
    private DefaultTableModel HistoryTableModel = null;
    private JTable HistoryTable = null;
    private MenuItem History;
    private MenuItem Shopping;




    public history(){

        //



        //////////////////////////////// MENU /////////////////////////////////
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
        //// 历史记录
        History = new MenuItem("History");
        History.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                history history_ = new history();
                history_.History_run();
            }
        });
        //////// 个人资料菜单
        Menu PersonalSetting = new Menu("Personal Setting");
        //// 更改个人资料
        Menu changeDetail = new Menu("Change Detail");
        // 更改密码
        MenuItem changePass = new MenuItem("Change Passwords");
        // 更改用户名
        MenuItem changeName = new MenuItem("Change User Name");
        // 资产
        MenuItem Assert = new MenuItem("Assert");
        //// 拥有物品
        Menu OwnedGoods = new Menu("Owned Goods");
        // 设置个人物品
        MenuItem SetOwnedGoods = new MenuItem("Set Owned Goods");
        // 添加个人物品
        MenuItem AddOwnedGoods = new MenuItem("Add Owned Goods");
        MenuItem LogOut = new MenuItem("Log Out");

        //// 小菜单导入进大菜单
        // 商城的
        Shop.add(Shopping);
        Shop.add(Selling);
        Shop.add(History);
        // 个人的
        PersonalSetting.add(changeDetail);
        changeDetail.add(changePass);
        changeDetail.add(changeName);
        PersonalSetting.add(Assert);
        PersonalSetting.add(OwnedGoods);
        PersonalSetting.addSeparator();
        PersonalSetting.add(LogOut);
        OwnedGoods.add(SetOwnedGoods);
        OwnedGoods.add(AddOwnedGoods);

        ///////////////////////////////////////////////////////////////////////////////

        ///////////////////// History 的表格 /////////////////////////////////
        // 表格里列的标题
        String[] Titles = {"Name", "Amount","Price","Type","Seller","Buyer","Date"};
        // 表格里的数据（从database导入）
        String [][]TheData={{"w","5","100","LongMenMoney","Doctor","John","2020/2/12"}};
        HistoryTableModel = new DefaultTableModel(TheData,Titles);
        // 生成表格
        HistoryTable = new JTable(HistoryTableModel);
        // 添加滑动框那个东西
        JScrollPane srp  = new JScrollPane(HistoryTable);
        // 把表格放在中心
        getContentPane().add(srp,BorderLayout.CENTER);

        ///////////////////// Label //////////////////////
        // 加入一个label
        final JPanel HistoryRLabel = new JPanel();
        // 设定位置
        getContentPane().add(HistoryRLabel,BorderLayout.NORTH);
        // label的名字是交易记录
        HistoryRLabel.add(new JLabel("Purchase History"));
        HistoryRLabel.setOpaque(true);
        HistoryRLabel.setBackground(Color.PINK);

        // 导入表格
        srp.setViewportView(HistoryTable);


        /*
        // 背景图片
        ImageIcon backgroud = new ImageIcon("BG1.jpg");
        JLabel label = new JLabel(backgroud);
        label.setBounds(0,-100,550, 450);
        JPanel myPanel = (JPanel)this.getContentPane();
        myPanel.setOpaque(false);
        myPanel.setLayout(new FlowLayout());
        this.getLayeredPane().setLayout(null);
        myPanel.add(HistoryRLabel);
        myPanel.add(srp);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        */

        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// GUI 设置 /////////////////////////////////////
        // 命名题目
        /////// 设置 GUI
        // 命名题目
        setTitle("History");
        // 设置大小和位置
        setBounds(500, 225, 550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.cyan);

        //// 菜单导入GUI
        mb.add(Shop);
        mb.add(PersonalSetting);
        ////////// 设置GUI /////////

        //显示菜单 Bar
        setMenuBar(mb);

        // 窗口不可缩放
        setResizable(true);
        ///////////////////////////////////////////////////////////////////////////////
    }
    public static void History_run(){
        history jTableDefaultTableModelTest = new history();
        jTableDefaultTableModelTest.setVisible(true);
    }

    public static void main(String[] args) {

        History_run();


    }

}