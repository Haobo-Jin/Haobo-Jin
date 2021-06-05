import javax.swing.*;
import java.awt.*;

public class AddUser {
    public JFrame adminFrame;

    private JMenuBar menu;

    private JMenu account;

    private JMenu function;

    private JMenuItem personalInformation;

    private JMenuItem modifyPassword;

    private JMenuItem logOut;

    private JMenuItem addUser;

    private JMenuItem createOrganizationalUnit;

    private JMenuItem addAssetTypes;

    JTextField userName;
    JTextField password;
    JTextField userType;

    public JFrame createGUI() {
        JFrame adminFrame = new JFrame("Welcome back administrator: ");

        // setup the frame size and its location
        adminFrame.setBounds(500, 225, 550, 450);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLayout(null);

        // set up the background images
        ((JComponent) adminFrame.getContentPane()).setOpaque(false);
        // input the path of the background images
        ImageIcon img = new ImageIcon("images//b67010b625b6038ae5baac895c79e3e.jpg");
        // let the images be a label
        JLabel imgLabel = new JLabel(img);
        adminFrame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        // set up the location and the size of the background images
        imgLabel.setBounds(0,0,550, 450);

        menu = new JMenuBar();
        account = new JMenu("Account");

        personalInformation = new JMenuItem("Personal information");
        modifyPassword = new JMenuItem("Modify password");
        logOut = new JMenuItem("Log out");
        function = new JMenu("Function");

        addUser = new JMenuItem("Add user");
        createOrganizationalUnit = new JMenuItem("Create new Organizational Units");
        addAssetTypes = new JMenuItem("Add new asset types");

        adminFrame.setJMenuBar(menu);

        account.add(personalInformation);
        account.add(modifyPassword);
        account.add(logOut);

        function.add(addUser);
        function.add(createOrganizationalUnit);
        function.add(addAssetTypes);

        menu.add(account);
        menu.add(function);

        JLabel addUserLabel = new JLabel("Add user");
        JLabel userNameLabel = new JLabel("user name: ");
        JLabel passwordLabel = new JLabel("password: ");
        JLabel userTypeLabel = new JLabel("organizational unit: ");

        userName = new JTextField();
        password = new JTextField();
        userType = new JTextField();

        JButton createButton = new JButton("create");

        // set up the objects' size and the location
        addUserLabel.setBounds(205, 80, 400, 30);
        addUserLabel.setFont(new Font("Arial", Font.BOLD, 25));
        addUserLabel.setForeground(Color.WHITE);

        userNameLabel.setBounds(145, 150, 100, 30);
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 13));
        userNameLabel.setForeground(Color.WHITE);

        passwordLabel.setBounds(145, 190, 100, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        passwordLabel.setForeground(Color.WHITE);

        userTypeLabel.setBounds(145, 230, 150, 30);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 13));
        userTypeLabel.setForeground(Color.WHITE);

        userName.setBounds(275, 150, 180, 30);
        password.setBounds(275, 190, 180, 30);
        userType.setBounds(275, 230, 180, 30);
        createButton.setBounds(215, 305, 90, 30);

        // add these objects to the frame
        adminFrame.add(addUserLabel);
        adminFrame.add(userNameLabel);
        adminFrame.add(passwordLabel);
        adminFrame.add(userTypeLabel);
        adminFrame.add(userName);
        adminFrame.add(password);
        adminFrame.add(userType);
        adminFrame.add(createButton);

        adminFrame.setVisible(true);

        return adminFrame;
    }

//    public static void main(String[] args) {
//        AddUser addUser = new AddUser();
//        addUser.createGUI();
//    }
}