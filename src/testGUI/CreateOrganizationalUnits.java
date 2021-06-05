import javax.swing.*;
import java.awt.*;

public class CreateOrganizationalUnits {

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

        JLabel title = new JLabel("Create New Organizational Unit");
        JLabel organizationalUnitLabel = new JLabel("organizational unit: ");
        JLabel creditsLabel = new JLabel("number of credits: ");
        JLabel assetNamesLabel = new JLabel("asset name: ");


        organizationalUnit = new JTextField();
        credits = new JTextField();
        assetNames = new JTextField();

        JButton createButton = new JButton("create");

        // set up the objects' size and the location
        title.setBounds(100, 80, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);

        organizationalUnitLabel.setBounds(110, 130, 200, 30);
        organizationalUnitLabel.setFont(new Font("Arial", Font.BOLD, 14));
        organizationalUnitLabel.setForeground(Color.WHITE);

        creditsLabel.setBounds(110, 170, 170, 30);
        creditsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        creditsLabel.setForeground(Color.WHITE);

        assetNamesLabel.setBounds(110, 210, 200, 30);
        assetNamesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        assetNamesLabel.setForeground(Color.WHITE);

        organizationalUnit.setBounds(250, 130, 180, 30);
        credits.setBounds(250, 170, 180, 30);
        assetNames.setBounds(250, 210, 180, 30);
        createButton.setBounds(215, 280, 90, 30);

        // add these objects to the frame
        adminFrame.add(title);
        adminFrame.add(organizationalUnitLabel);
        adminFrame.add(creditsLabel);
        adminFrame.add(assetNamesLabel);
        adminFrame.add(organizationalUnit);
        adminFrame.add(credits);
        adminFrame.add(assetNames);
        adminFrame.add(createButton);

        adminFrame.setVisible(true);

        return adminFrame;
    }

//    public static void main(String[] args) {
//        CreateOrganizationalUnits createOrganizationalUnits = new CreateOrganizationalUnits();
//        createOrganizationalUnits.createGUI();
//    }
}