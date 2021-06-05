import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAccount {

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

    public AdminAccount() {
        adminFrame=new JFrame();
        AdministratorAccountFrame("302 assignment");
        account.add(personalInformation);
        account.add(modifyPassword);
        account.add(logOut);

        function.add(addUser);
        function.add(createOrganizationalUnit);
        function.add(addAssetTypes);

        menu.add(account);
        menu.add(function);
        action();

    }

    private JFrame AdministratorAccountFrame(String name) {
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

        // create initial menu and menu items
        menu = new JMenuBar();

        account = new JMenu("Account");
        personalInformation = new JMenuItem("Personal information");
        modifyPassword = new JMenuItem("Modify password");
        logOut = new JMenuItem("Log out");

        function = new JMenu("Function");
        addUser = new JMenuItem("Add user");
        createOrganizationalUnit = new JMenuItem("Create new Organizational Units");
        addAssetTypes = new JMenuItem("Add new asset types");

        Home home = new Home(adminFrame);

        adminFrame.setJMenuBar(menu);

        adminFrame.setVisible(true);

        return adminFrame;
    }

    /**
     * setup the various listener
     */
    private void action() {
        logOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                adminFrame.setVisible(false);

                LogIn.main(null);
            }
        });

        personalInformation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                adminFrame.setVisible(false);

                // change back to the home page
                new AdminAccount();
            }
        });

        modifyPassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                adminFrame.setVisible(false);

                // change to the password modifying interface
                new ModifyPassword();
            }
        });

        addUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                adminFrame.setVisible(false);

                //
                new AddUser();
            }
        });

        createOrganizationalUnit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // let the administrator account hide
                adminFrame.setVisible(false);

                //
                new AddOrganizationalUnits();
            }
        });

        addAssetTypes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //
                adminFrame.setVisible(false);

                //
                new AddAssetTypes();
            }
        });


    }


}
