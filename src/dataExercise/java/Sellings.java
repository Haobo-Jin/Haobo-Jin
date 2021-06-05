import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

// Peter's Interface
public class Sellings extends JFrame{
    private DefaultTableModel SellTableModel = null;
    private JTable SellTable = null;
    private JButton addButton = null;

    private MenuItem HistoryRecords;
    private MenuItem Shopping;
// 导入own goods 的表格
    private DefaultTableModel OwnGoodsTableModel = null;
    private JTable OwnGoodsTable = null;
    private JScrollPane srp_OGT;
    private JTextField Text_ID_OGT;
    private JTextField Text_Name_OGT;
    private JTextField Text_Style_OGT;
    private JTextField Text_Number_OGT;
    private JTextField Text_Price_OGT;
    private JTextField Text_State_OGT;
    private JTextField Text_Holder_OGT;

    // 这边开始做 owngoods 的那个表格，就是拥有物品的表格

    public void Own_Goods_Table(){
        // 表格里列的标题
        String[] Titles = {"Id","Name","Style","Number","Price","State","Holder"};
        TradeManagement tradeManagement=new TradeManagement();
        // 表格里的数据
/*      String [][]tradeDate= new String[0][];
        String sql="select * from currentTrades  WHERE BUYorSELL ='buy'";
        try {
            tradeDate = tradeManagement.ShowCTrade(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        OwnGoodsTableModel = new DefaultTableModel(tradeDate,Titles);*/

        String [][]cellDate= new String[0][];
        UnitManagement unitManagement=new UnitManagement() ;
        /*String sql="select * from unit  WHERE unit =" + UserManagement.LoginStaff.getOrganizationalUnits();*/
        String sql="select * from unit  WHERE unit = 'ali'";
        try {
            cellDate = unitManagement.returnAssert(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        OwnGoodsTableModel = new DefaultTableModel(cellDate,Titles);
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
        // 这个表格的名字
        OwnGoodsLabel.add(new JLabel("      Selling              ||         Own Goods\n"));
        OwnGoodsLabel.setOpaque(true);
        OwnGoodsLabel.setBackground(Color.ORANGE);
        ///////////////////////////////////////////////////////////
        // 这边的文字是为了后面提取文字信息用的就是后面用到的getText（）那些的，
        // 就是方便直接提取表格里文字信息。

        // Label of Item ID
        Text_ID_OGT = new JTextField(3);
        // Label of Item Name
        Text_Name_OGT = new JTextField(3);
        // Label of Item Style
        Text_Style_OGT = new JTextField(3);
        // Label of Item Amount
        Text_Number_OGT = new JTextField(3);
        // Label of Item Price
        Text_Price_OGT = new JTextField(3);
        // Label of Item selling state
        Text_State_OGT = new JTextField(3);
        // Label of Item owner
        Text_Holder_OGT = new JTextField(3);


        // 设置鼠标单击的监听
        // 单击会得到《Own goods》这个表格里面每一行的信息。
        OwnGoodsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        OwnGoodsTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                // 获取选中行
                int selectedRow = OwnGoodsTable.getSelectedRow();
                Object Col_Id = OwnGoodsTableModel.getValueAt(selectedRow, 0);
                Object Col_Name = OwnGoodsTableModel.getValueAt(selectedRow, 1);
                Object Col_Style = OwnGoodsTableModel.getValueAt(selectedRow, 2);
                Object Col_Number = OwnGoodsTableModel.getValueAt(selectedRow,3);
                Object Col_Price = OwnGoodsTableModel.getValueAt(selectedRow,4);
                Object Col_State = OwnGoodsTableModel.getValueAt(selectedRow,5);
                Object Col_Holder = OwnGoodsTableModel.getValueAt(selectedRow,6);


                // 可以给每一行输入东西
                Text_ID_OGT.setText(Col_Id.toString());
                Text_Name_OGT.setText(Col_Name.toString());
                Text_Style_OGT.setText(Col_Style.toString());
                Text_Number_OGT.setText(Col_Number.toString());
                Text_Price_OGT.setText(Col_Price.toString());
                Text_State_OGT.setText(Col_State.toString());
                Text_Holder_OGT.setText(Col_Holder.toString());

            }
        });
    }

    public Sellings(){
        // 这边不用管就是menu的设置

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
        Account.add(Selling);
        Account.addSeparator();


        //// 菜单导入GUI
        mb.add(Shop);
        mb.add(Account);
        mb.add(Trading);
        ///////////////////////////////////////////////////////////////////////////////////////

        // 到这里开始， 我导入直接定义好的own goods 表格。


        /////////////////// 添加 owned goods 表格 ///////////////////////
        Own_Goods_Table();
        // 这里的EASt是设定表格在gui里面的位置
        getContentPane().add(srp_OGT,BorderLayout.CENTER);
        srp_OGT.setViewportView(OwnGoodsTable);
        //////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////


        // 把Table 放进GUI
        final JPanel panel = new JPanel();
        // 把标签都放在下面
        getContentPane().add(panel,BorderLayout.SOUTH);

        // Button设置位置

        //////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////// 按钮设置 //////////////////////////////////
        // 出售物品按钮
        final JButton SellButton = new JButton("Sell");
        SellButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Get the text from the Text field
                int selectedRow = OwnGoodsTable.getSelectedRow();
                String []rowValues = {Text_ID_OGT.getText(), Text_Name_OGT.getText(),
                        Text_Style_OGT.getText(), Text_Number_OGT.getText(),
                        Text_Price_OGT.getText(),Text_Price_OGT.getText(), Text_Holder_OGT.getText()};

                // Click button to sell the stuff
                // Check the select row exist or not
                if(selectedRow != -1){
                    // 出售物品以后 selling的那个表格就会多出一行，就是你选中行的信息
                    // SellTableModel.addRow(rowValues);
                    // int rowCount = SellTable.getRowCount() +1;

                    // Jump out a new Gui window
                    // Create a new little gui when user want to buy something
                    // Name of Gui
                    JFrame AmountAndPriceChoose = new JFrame("Amount & Price Set");
                    // set the location of gui
                    AmountAndPriceChoose.setLocation(570,350);
                    // Set the size of the little Gui
                    AmountAndPriceChoose.setSize(400,250);
                    // set the visible
                    AmountAndPriceChoose.setVisible(true);
                    AmountAndPriceChoose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    //////////////////////////////////////////////////////////
                    // Create a Label tell User to select the Item Amount that they want to sell
                    JLabel AskAmount = new JLabel("Decide the Amount you want to Sell" );
                    AskAmount.setBounds(0,50,200,20);
                    AmountAndPriceChoose.add(AskAmount);

                    // User to tap the amount they want to buy
                    // The Label store the Amount number that user want to sell
                    final JTextField Text_AmountOfItem = new JTextField();
                    Text_AmountOfItem.setBounds(240,50,100,30);
                    AmountAndPriceChoose.add(Text_AmountOfItem);

                    // Help the gui set
                    final JTextField Text_PriceChoice = new JTextField();

                    AmountAndPriceChoose.add(Text_PriceChoice);

                    // Help the gui set
                    final JPanel AmountLabel = new JPanel();
                    AmountLabel.add(new JLabel());
                    AmountAndPriceChoose.getContentPane().add(AmountLabel,BorderLayout.CENTER);

                    // create a Text Field to store the result after minus for Amount stuff
                    final JTextField getTheResult = new JTextField(3);

                    //////////////////////////////////////////////////////////
                    // Create a Label tell User to Decide their Price
                    JLabel AskPrice = new JLabel("Decide the Price you want to Sell");
                    AskPrice.setBounds(0,100,200,20);
                    AmountAndPriceChoose.add(AskPrice);

                    // Help the gui set
                    JLabel g = new JLabel("");
                    g.setBounds(0,0,2,2);
                    AmountAndPriceChoose.add(g);

                    // Create a Label to store the Price that users want to set
                    Text_PriceChoice.setBounds(240,95,100,30);


                    // get the button for user to tap ok to
                    final JPanel AskAmountButton = new JPanel();
                    JButton Ok_Button = new JButton("OK");
                    Ok_Button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            //////// === Set the Amount Choice === ////////
                            // Use the Total Amount minus the Amount that user want to sell //
                            // First, get the text field from Amount in table and User Amount
                            String ItemsAmount = Text_Style_OGT.getText();
                            String BuyAmount = Text_AmountOfItem.getText();
                            // Second, parse the String text(which integer inside) into Integer
                            int ItemNum = Integer.parseInt(ItemsAmount);
                            int SellNum = Integer.parseInt(BuyAmount);
                            int TheResult;

                            // Calculate it and get result
                            TheResult = ItemNum - SellNum;
                            // Pare the Integer type into String
                            String OutPutResult = Integer.toString(TheResult);
                            GoodManagement management=new GoodManagement();
                            String[] rowValues1= new String[]{Text_ID_OGT.getText(),Text_Name_OGT.getText(),String.valueOf(SellNum),Text_PriceChoice.getText()};
/*                            if (ItemNum==SellNum){
                                String holder = Text_Holder_OGT.getText();
                                String sql = "update goods set holder="+ holder+", state = no selling where id = "+id;
                                try {
                                    management.Update(sql);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }

                            }else if (ItemNum>SellNum){*/
                            String unit =rowValues1[0];
                            UnitManagement unitManagement=new UnitManagement();
                            try {
                                unitManagement.sell(rowValues1,TheResult,unit);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }



/*                            }else {
                                JOptionPane.showMessageDialog(null, "Cannot exceed the existing quantity ");
                                Text_AmountOfItem.setText("");
                            }*/
                            // Then store the String(which inside is integer) into the Text Field I've set already
                            getTheResult.setText(OutPutResult);
                            // Set the value
                            OwnGoodsTable.setValueAt(getTheResult.getText(),selectedRow,3);

                            //////// === Set the Amount Choice === ////////
                            // Change the price of selling Items  //
                            OwnGoodsTable.setValueAt(Text_PriceChoice.getText(),selectedRow,4);

                            // Change the state of the selling Items
                            JLabel SellingState = new JLabel("Selling");
                            OwnGoodsTable.setValueAt(SellingState.getText(),selectedRow,5);

                            // Close this little GUI
                            AmountAndPriceChoose.dispose();

                        }
                    });


                    AskAmountButton.add(Ok_Button);
                    AmountAndPriceChoose.getContentPane().add(AskAmountButton,BorderLayout.SOUTH);

                }
            }
        });
        // Add button to GUI
        panel.add(SellButton);

        // 下架
        // Delete Button
        final JButton removeButton = new JButton("Del");
        removeButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                // 获得选中的那一行
                int selectedRow = SellTable.getSelectedRow();
                // 删除那一行的信息
                String [] rowValues1 = {Text_ID_OGT.getText(), Text_Name_OGT.getText(),
                        Text_Style_OGT.getText(), Text_Number_OGT.getText(),
                        Text_Price_OGT.getText(),Text_Price_OGT.getText(), Text_Holder_OGT.getText()};

                if(selectedRow!=-1)
                {
                    // 删除选中的那一行
                    SellTableModel.removeRow(selectedRow);
                }
            }
        });
        // 添加button
        // panel.add(removeButton);


        //这边也不用管，设置窗口的

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
    public static void Selling_run(){
        Sellings jTableDefaultTableModelTest = new Sellings();
        jTableDefaultTableModelTest.setVisible(true);
    }
    /*
    public static void main(String[] args) {
        Selling_run();
    }

     */
}
