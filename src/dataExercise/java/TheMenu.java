import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheMenu extends JFrame{
    private MenuItem HistoryRecords;
    private MenuItem Shopping;
    public TheMenu(){
        // Peter's Interface

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

        //// Selling Process
        MenuItem SellerProcess = new MenuItem("Seller Process");
        SellerProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SellerProcessing SellerProcess_ = new SellerProcessing();
                SellerProcess_.SellerProcessing_run();
            }
        });
        //// Buying Process
        MenuItem BuyerProcess = new MenuItem("Buyer Process");
        BuyerProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BuyerProcessing BuyerProcess_ = new BuyerProcessing();
                BuyerProcess_.BuyerProcessing_run();
            }
        });
        // 退出按钮
        MenuItem LogOut = new MenuItem("Log Out");


        /////// 交易信息
        Menu Trading = new Menu("Trading");

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
        Account.add(Selling);
        Account.add(SellerProcess);
        Account.add(BuyerProcess);
        Account.addSeparator();
        Account.add(LogOut);


        //// 菜单导入GUI
        mb.add(Shop);
        mb.add(Account);
        mb.add(Trading);
        ///////////////////////////////////////////////////////////////////////////////////////

    }
}
