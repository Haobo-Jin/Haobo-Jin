import javax.swing.*;
import java.awt.*;

public class PersonalInformation {

    public JFrame userFrame;

    private JMenuBar menu;

    private JMenu account;

    private JMenuItem personalInformation;

    private JMenuItem modifyPassword;

    private JMenuItem logOut;

    private JMenu trading;

    private JMenuItem currentTrades;

    private JMenuItem historyRecords;

    Users user = new Users();

    public JFrame createGUI() {
        userFrame = new JFrame("Welcome back user ");

        // setup the frame size and its location
        userFrame.setBounds(500, 225, 550, 450);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLayout(null);

        // set up the background images
        ((JComponent) userFrame.getContentPane()).setOpaque(false);
        // input the path of the background images
        ImageIcon img = new ImageIcon("images//b67010b625b6038ae5baac895c79e3e.jpg");
        // let the images be a label
        JLabel imgLabel = new JLabel(img);
        userFrame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        // set up the location and the size of the background images
        imgLabel.setBounds(0, 0, 550, 450);

        menu = new JMenuBar();
        account = new JMenu("Account");
        personalInformation = new JMenuItem("Personal information");
        modifyPassword = new JMenuItem("Modify password");
        logOut = new JMenuItem("Log out");
        trading = new JMenu("Trading");
        currentTrades = new JMenuItem("Current Trades");
        historyRecords = new JMenuItem("History Records");

        userFrame.setJMenuBar(menu);

        account.add(personalInformation);
        account.add(modifyPassword);
        account.add(logOut);

        trading.add(currentTrades);
        trading.add(historyRecords);

        menu.add(account);
        menu.add(trading);

        Home home = new Home(userFrame);

        userFrame.setVisible(true);

        return userFrame;
    }

//        public static void main(String[] args) {
//        PersonalInformation personalInformation = new PersonalInformation();
//        personalInformation.createGUI();
//    }
}

