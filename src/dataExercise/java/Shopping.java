import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Shopping extends JFrame {
    private DefaultTableModel ShopTableModel = null;
    private JTable ShopTable = null;
    private JButton addButton = null;
    private JTextField Text_Id;
    private JTextField Text_Name;
    private JTextField Text_Style;
    private JTextField Text_Number;
    private JTextField Text_Price;
    private JTextField Text_State;
    private JTextField Text_Holder;
    private MenuItem HistoryRecords;
    private MenuItem Shopping;
    private DefaultTableModel ShopTableModel1 = null;
    private JTable ShopTable1 = null;

    {
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


        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// GUI 设置 /////////////////////////////////////
        // 命名题目
        setTitle("Shopping");
        // 设置大小和位置
        setBounds(500, 225, 550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///////////////////////////////////////////////////////////////////////////////
        //////////////////////// 第一个表格 //////////////////////////////////

        // 表格里列的标题
        String[] Titles = {"Id","Name","Style","Number","Price","State","Holder"};
        TradeManagement tradeManagement=new TradeManagement();
        // 表格里的数据
        String [][]TheData= new String[0][];
        String sql="select * from currentTrades WHERE BUYorSELL ='sell'";
        try {
            TheData = tradeManagement.ShowCTrade(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ShopTableModel = new DefaultTableModel(TheData,Titles);
        // 生成表格
        ShopTable = new JTable(ShopTableModel);
        // 添加滑动框那个东西
        JScrollPane srp  = new JScrollPane(ShopTable);
        // 把表格放在中心
        getContentPane().add(srp,BorderLayout.CENTER);

        // 设置鼠标单击
        ShopTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ShopTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                // 获取选中行
                int selectedRow = ShopTable.getSelectedRow();
                Object Col_Id = ShopTableModel.getValueAt(selectedRow, 0);
                Object Col_Name = ShopTableModel.getValueAt(selectedRow, 1);
                Object Col_Style = ShopTableModel.getValueAt(selectedRow, 2);
                Object Col_number = ShopTableModel.getValueAt(selectedRow,3);
                Object Col_Price = ShopTableModel.getValueAt(selectedRow,4);
                Object Col_State = ShopTableModel.getValueAt(selectedRow,5);
                Object Col_holder = ShopTableModel.getValueAt(selectedRow,6);

                // 可以给每一行输入东西
                Text_Id.setText(Col_Id.toString());
                Text_Name.setText(Col_Name.toString());
                Text_Style.setText(Col_Style.toString());
                Text_Number.setText(Col_number.toString());
                Text_Price.setText(Col_Price.toString());
                Text_State.setText(Col_State.toString());
                Text_Holder.setText(Col_holder.toString());

            }
        });
        srp.setViewportView(ShopTable);

        ///////////////////////////////////////////////////////////////////////////////////////


        // 把Table 放进GUI
        final JPanel panel = new JPanel();
        // 把标签都放在下面
        //getContentPane().add(panel,BorderLayout.NORTH);
        // 放button的位置
        final JPanel Buttons = new JPanel();
        getContentPane().add(Buttons,BorderLayout.SOUTH);


        //
        JLabel Id_Get = new JLabel();
        Id_Get.setSize(5,5);

        // 加小框框
        Text_Id = new JTextField(3);
        Text_Name = new JTextField(3);
        Text_Style = new JTextField(3);
        Text_Number = new JTextField(3);
        Text_Price = new JTextField(3);
        Text_State = new JTextField(3);
        Text_Holder = new JTextField(3);


        panel.add(new JLabel("ID: "));
        panel.add(Text_Id);
        panel.add(new JLabel("Name:"));
        panel.add(Text_Name);
        panel.add(new JLabel("Style:"));
        panel.add(Text_Style);
        panel.add(new JLabel("Number:"));
        panel.add(Text_Number);
        panel.add(new JLabel("$: "));
        panel.add(Text_Price);
        panel.add(new JLabel("state:"));
        panel.add(Text_State);
        panel.add(new JLabel("holder:"));
        panel.add(Text_Holder);

        // 购买键
        // 购买以后那个物品就会消失
        final JButton BuyButton = new JButton("Buy");
        BuyButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                // 获得选中的那一行
                int selectedRow = ShopTable.getSelectedRow();
                String[] rowValues1 = {Text_Id.getText(), Text_Name.getText(),Text_Style.getText(),
                        Text_Number.getText(),Text_Price.getText(),Text_State.getText(),Text_Holder.getText()};
                if(selectedRow!=-1)
                {

                    // Jump out a new Gui window
                    // Create a new little gui when user want to buy something
                    // Name of Gui
                    JFrame AmountChoose = new JFrame("Amount choose");
                    // set the location of gui
                    AmountChoose.setLocation(570,350);
                    // Set the size of the little Gui
                    AmountChoose.setSize(400,250);
                    // set the visible
                    AmountChoose.setVisible(true);
                    AmountChoose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    //ItemWantToBuy.setBounds(20,0,200,20);
                    JLabel AskAmount = new JLabel("Enter the quantity you want to buy" );
                    AskAmount.setBounds(105,50,200,20);
                    AmountChoose.add(AskAmount);

                    // User to tap the amount they want to buy
                    final JTextField Text_AmountOfItem = new JTextField();
                    Text_AmountOfItem.setBounds(140,95,100,30);
                    AmountChoose.add(Text_AmountOfItem);

                    final JPanel AmountLabel = new JPanel();
                    AmountLabel.add(new JLabel());
                    AmountChoose.getContentPane().add(AmountLabel,BorderLayout.CENTER);

                    final JTextField getTheResult = new JTextField(3);
                    int number = Integer.parseInt(Text_Number.getText());
                    int inputNumber=0;
                    try {
                        inputNumber = Integer.parseInt(Text_AmountOfItem.getText());
                    }catch (Exception exception){

                        JOptionPane.showMessageDialog(null, "must be digital");
                        Text_AmountOfItem.setText("");
                    }
                    UnitManagement unitManagement=new UnitManagement();
                    try {
                        int remainingNumber =number-inputNumber;
                        unitManagement.Buy(rowValues1,remainingNumber);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }



                    /*if (number==inputNumber){
                        String holder = Text_Holder.getText();
                        String sql = "update goods set holder="+ holder+", state = no selling where id = "+id;
                        try {
                            management.Update(sql);
*//*                            UserManagement.DeductMoney(Integer.parseInt(Text_Price.getText()));
                            UserManagement.AddMoney(Text_State.getText(),Integer.parseInt(Text_Price.getText()));*//*
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                    }else if (number>inputNumber){
                        int  remainingAmount=inputNumber-number;
                        String sql = "update goods set number = "+ remainingAmount+"where id = "+id;
                        try {
                            management.Update(sql);
                            sql="insert into goods(name,style,number,price,state,holder)" + "values(?,?,?,?,?,?)";
                            rowValues1[5]="no selling";
                            management.Add(rowValues1,sql);
*//*                            UserManagement.DeductMoney(Integer.parseInt(Text_Price.getText()));
                            UserManagement.AddMoney(Text_State.getText(),Integer.parseInt(Text_Price.getText()));*//*
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Cannot exceed the existing quantity ");
                        Text_AmountOfItem.setText("");
                    }*/


                    // get the button for user to tap ok
                    final JPanel AskAmountButton = new JPanel();
                    JButton Ok_Button = new JButton("OK");
                    Ok_Button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            String ItemsAmount = Text_Number.getText();
                            String BuyAmount = Text_AmountOfItem.getText();
                            int ItemNum = Integer.parseInt(ItemsAmount);
                            int BuyNum = Integer.parseInt(BuyAmount);
                            int TheResult;
                            TheResult = ItemNum - BuyNum;
                            String OutPutResult = Integer.toString(TheResult);
                            getTheResult.setText(OutPutResult);
                            ShopTable.setValueAt(getTheResult.getText(),selectedRow,3);
                            AmountChoose.dispose();

                        }
                    });


                    AskAmountButton.add(Ok_Button);
                    AmountChoose.getContentPane().add(AskAmountButton,BorderLayout.SOUTH);





                }
            }
        });
        // 添加button
        Buttons.add(BuyButton);

        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// GUI 设置 /////////////////////////////////////
        // 窗口名称
        setTitle("Selling");
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

    public static void Shopping_run(){
        Shopping jTableDefaultTableModelTest = new Shopping();
        jTableDefaultTableModelTest.setVisible(true);
    }
    /*

    public static void main(String[] args) {
       Shopping_run();

    }*/




}
