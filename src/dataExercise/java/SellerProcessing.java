import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SellerProcessing extends BuyerProcessing{
    private DefaultTableModel SellerProcessTableModel = null;
    private JTable SellerProcessTable = null;
    private JTextField Text_Date;
    private JTextField Text_AssertName;
    private JTextField Text_Number;
    private JTextField Text_Price;
    private JTextField Text_State;
    private JTextField Text_Buyer;
    private JTextField Text_Appraisal;
    private MenuItem HistoryRecords;
    private MenuItem Shopping;

    public SellerProcessing(){
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
        Account.add(BuyerProcess);
        Account.add(SellerProcess);
        Account.addSeparator();
        Account.add(LogOut);


        //// 菜单导入GUI
        mb.add(Shop);
        mb.add(Account);
        mb.add(Trading);
        ///////////////////////////////////////////////////////////////////////////////////////


        ///////////////////////////////////////////////////////////////////////////////
        //////////////////////// 第一个表格 //////////////////////////////////

        // 表格里列的标题
        String[] Titles = {"Date","Name","Number","Offer $","State","Buyer","Appraisal $"};
        // 表格里的数据
        String [][]TheData={{"2020/1/12","WaHaHa","10","30","Processing","Mike","28"}};
        SellerProcessTableModel = new DefaultTableModel(TheData,Titles);
        // 生成表格
        SellerProcessTable = new JTable(SellerProcessTableModel);
        // 添加滑动框那个东西
        JScrollPane srp  = new JScrollPane(SellerProcessTable);
        // 把表格放在中心
        getContentPane().add(srp,BorderLayout.CENTER);

        // 设置鼠标单击
        SellerProcessTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SellerProcessTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                // 获取选中行
                int selectedRow = SellerProcessTable.getSelectedRow();
                Object Col_Id = SellerProcessTableModel.getValueAt(selectedRow, 0);
                Object Col_Name = SellerProcessTableModel.getValueAt(selectedRow, 1);
                Object Col_number = SellerProcessTableModel.getValueAt(selectedRow,2);
                Object Col_Price = SellerProcessTableModel.getValueAt(selectedRow,3);
                Object Col_State = SellerProcessTableModel.getValueAt(selectedRow,4);
                Object Col_holder = SellerProcessTableModel.getValueAt(selectedRow,5);
                Object Col_Appraisal = SellerProcessTableModel.getValueAt(selectedRow,6);

                // 可以给每一行输入东西
                Text_Date.setText(Col_Id.toString());
                Text_AssertName.setText(Col_Name.toString());
                Text_Number.setText(Col_number.toString());
                Text_Price.setText(Col_Price.toString());
                Text_State.setText(Col_State.toString());
                Text_Buyer.setText(Col_holder.toString());
                Text_Appraisal.setText(Col_Appraisal.toString());

            }
        });
        srp.setViewportView(SellerProcessTable);

        ///////////////////////////////////////////////////////////////////////////////////////


        // 把Table 放进GUI
        final JPanel panel = new JPanel();
        // 把标签都放在下面
        //getContentPane().add(panel,BorderLayout.NORTH);
        // Set the Button and the location of Buttons
        final JPanel Buttons = new JPanel();
        getContentPane().add(Buttons,BorderLayout.SOUTH);


        //
        JLabel Id_Get = new JLabel();
        Id_Get.setSize(5,5);

        // 加小框框
        Text_Date = new JTextField(3);
        Text_AssertName = new JTextField(3);
        Text_Number = new JTextField(3);
        Text_Price = new JTextField(3);
        Text_State = new JTextField(3);
        Text_Buyer = new JTextField(3);
        Text_Appraisal = new JTextField(3);


        panel.add(new JLabel("ID: "));
        panel.add(Text_Date);
        panel.add(new JLabel("Name:"));
        panel.add(Text_AssertName);
        panel.add(new JLabel("Style:"));
        panel.add(new JLabel("Number:"));
        panel.add(Text_Number);
        panel.add(new JLabel("Total Prices: "));
        panel.add(Text_Price);
        panel.add(new JLabel("state:"));
        panel.add(Text_State);
        panel.add(new JLabel("Buyer:"));
        panel.add(Text_Buyer);
        panel.add(new JLabel("Appraisal"));
        panel.add(Text_Appraisal);

        // Add the Refused Button
        final JButton RefusedButton = new JButton("Refused Button");
        RefusedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get The Select Row
                int selectedRow = SellerProcessTable.getSelectedRow();
                // Get the Values for each row
                String [] rowValues = {Text_Date.getText(), Text_AssertName.getText(),
                        Text_Number.getText(), Text_Price.getText(),
                        Text_State.getText(), Text_Buyer.getText(),Text_Appraisal.getText(),
                        Text_Appraisal.getText()};

                if(selectedRow != 1){
                    // If tap the Refused Button, the processing Item state will become Refused
                    JLabel ProcessRefusedState = new JLabel("Refused");
                    SellerProcessTable.setValueAt(ProcessRefusedState.getText(),selectedRow,4);
                    // And Buyer will receive the noticed about the Seller refused the order at Buyer Process interface
                }

            }
        });
        Buttons.add(RefusedButton);

        // Add the Confirm Button
        final JButton ConfirmButton = new JButton("Confirm");
        ConfirmButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                // Get the select row
                int selectedRow = SellerProcessTable.getSelectedRow();
                // Get the Values for each row
                String [] rowValues = {Text_Date.getText(), Text_AssertName.getText(),
                        Text_Number.getText(), Text_Price.getText(),
                        Text_State.getText(), Text_Buyer.getText(),Text_Appraisal.getText()};

                if(selectedRow!=-1)
                {
                    // (1). If tap the Confirm button, the state of the processing Item become Done
                    // which means this order has been confirmed.
                    JLabel ProcessDoneState = new JLabel("Done");
                    SellerProcessTable.setValueAt(ProcessDoneState.getText(),selectedRow,4);

                    // (2). And the order will goes to the History Interface

                    // (3). Then this Order will disappear in Seller Processing Page
                    // SellerProcessTable.remove(selectedRow);

                    // (4). After Confirm the Unit Credit will decrease as the sold prices
                    // And the Amount of Item will decrease as the sold Amount.
                }
            }
        });
        // Add Confirm Button In Gui
        Buttons.add(ConfirmButton);



        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// GUI 设置 /////////////////////////////////////
        // 窗口名称
        setTitle("Seller Order Process");
        // 设置大小和位置
        setBounds(500, 225, 550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.cyan);

        //// 菜单导入GUI
        mb.add(Shop);
        mb.add(Account);
        mb.add(Trading);
        ////////// 设置GUI /////////

        //显示菜单 Bar
        setMenuBar(mb);

        // 窗口不可缩放
        setResizable(true);
        ///////////////////////////////////////////////////////////////////////////////

    }
    public static void SellerProcessing_run(){
        SellerProcessing jTableDefaultTableModelTest = new SellerProcessing();
        jTableDefaultTableModelTest.setVisible(true);
    }

/*
    public static void main(String[] args) {
        SellerProcessing_run();

    }*/
}
