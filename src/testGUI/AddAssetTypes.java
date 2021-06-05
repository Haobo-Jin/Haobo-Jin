import javax.swing.*;
import java.awt.*;

public class AddAssetTypes {

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

    JTextField organizationalUnit;
    JTextField credits;
    JTextField assetNames;

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
        imgLabel.setBounds(0, 0, 550, 450);

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

        JLabel title = new JLabel("Add new Asset Types");
        JLabel assetNamesLabel = new JLabel("new asset name: ");

        assetNames = new JTextField();

        JButton addButton = new JButton("add");

        // set up the objects' size and the location
        title.setBounds(155, 80, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        assetNamesLabel.setBounds(110, 165, 200, 30);
        assetNamesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        assetNamesLabel.setForeground(Color.WHITE);

        assetNames.setBounds(250, 165, 180, 30);
        addButton.setBounds(225, 255, 100, 30);

        // add these objects to the frame
        adminFrame.add(title);
        adminFrame.add(assetNamesLabel);
        adminFrame.add(assetNames);
        adminFrame.add(addButton);

        adminFrame.setVisible(true);

        return adminFrame;
    }

//    public static void main(String[] args) {
//        AddAssetTypes addAssetTypes = new AddAssetTypes();
//        addAssetTypes.createGUI();
//    }
}
