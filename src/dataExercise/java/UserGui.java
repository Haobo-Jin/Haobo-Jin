import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserGui extends JFrame{
    // 设置字体
    private  Font Ft = new Font("Times New Roman", Font.BOLD,15);

    private MenuItem History;
    private MenuItem Shopping;


    public UserGui()
    {

        /////// 设置 GUI
        // 窗口名称
        Frame f = new Frame("User Interface");
        // 窗口大小
        f.setBounds(500, 225, 550, 450);



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
        //// 历史记录
        History = new MenuItem("History");
        History.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
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

        //// 菜单导入GUI
        mb.add(Shop);
        mb.add(PersonalSetting);





        //////// Label

        int userID = 123456;
        String userName = "John";
        ////// 用户姓名Label
        Label User_Name = new Label("User Name:");
        // 设置位置
        User_Name.setBounds(160,100,100,20);
        // 设置字体
        User_Name.setFont(Ft);
        f.add(User_Name);

        ////// 用户ID Label
        Label User_ID = new Label("User ID:");
        User_ID.setBounds(160,130,100,20);
        User_ID.setFont(Ft);
        f.add(User_ID);

        ////// 用户种类
        Label User_Type = new Label("User Type:");
        User_Type.setBounds(160,160,100,20);
        User_Type.setFont(Ft);
        f.add(User_Type);

        // 公司余额
        Label Unit_Balance = new Label("Unit Balance:");
        Unit_Balance.setBounds(160,190,100,20);
        Unit_Balance.setFont(Ft);
        f.add(Unit_Balance);

        // 拥有的物品
        Label Own_Goods = new Label("Own Goods Amount:");
        Own_Goods.setBounds(160,220,180,20);
        Own_Goods.setFont(Ft);
        f.add(Own_Goods);

        /////////////////////////////
        ////////// GUI 跳转






        ////////// 设置GUI /////////
        f.setLayout(null);
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

        new UserGui();

    }

}
