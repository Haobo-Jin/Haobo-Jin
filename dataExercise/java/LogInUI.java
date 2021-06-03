

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class LogInUI extends JFrame {

    public JFrame logInFrame;

    private JTextField userName;

    private JTextField password;

    private JComboBox userType;

    private JButton logInButton;


    public LogInUI() {

        makeLogInFrame();
        setFieldsEditable(true);

        // add listeners to interactive components
        addButtonListeners(new ButtonListener());

    }

    private JFrame makeLogInFrame() {
        logInFrame = new JFrame("Trading Platform Login Interface");
        logInFrame.setBounds(450, 200, 550, 350);
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.setLayout(null);

        JLabel logInLabel = new JLabel("Welcome to the Trading Platform !");
        JLabel userNameLabel = new JLabel("user name:　");
        JLabel passwordLabel = new JLabel("password: ");
        JLabel userTypeLabel = new JLabel("user type: ");

        userName = new JTextField(20);
        password = new JTextField(20);
        userType = new JComboBox(new String[]{"IT Administration team", "general users"});
        setFieldsEditable(false);

        logInButton = new JButton("LogIn");

        // setup the location of label
        logInLabel.setBounds(115, 30, 400, 30);
        logInLabel.setFont(new Font("Arial", Font.BOLD, 20));
        userNameLabel.setBounds(110, 80, 100, 30);
        passwordLabel.setBounds(110, 120, 100, 30);
        userTypeLabel.setBounds(110, 160, 100, 30);
        userName.setBounds(200, 80, 180, 30);
        password.setBounds(200, 120, 180, 30);
        userType.setBounds(200, 160, 155, 30);
        logInButton.setBounds(235, 225, 100, 30);

        logInFrame.add(logInLabel);
        logInFrame.add(userNameLabel);
        logInFrame.add(passwordLabel);
        logInFrame.add(userTypeLabel);
        logInFrame.add(userName);
        logInFrame.add(password);
        logInFrame.add(userType);
        logInFrame.add(logInButton);

        logInFrame.setVisible(true);

        return logInFrame;
    }

    /**
     * Adds a listener to the logIn buttons
     */
    private void addButtonListeners(ActionListener listener) {
        logInButton.addActionListener(listener);
    }

    /**
     * Sets the text in the address text fields to the empty string.
     */
    private void clearFields() {
        userName.setText("");
        password.setText("");
    }

    /**
     * Sets whether or not the address fields are editable.
     */
    private void setFieldsEditable(boolean editable) {
        userName.setEditable(editable);
        password.setEditable(editable);
    }

    private class ButtonListener implements ActionListener {

        /**
         * @see ActionListener#actionPerformed(ActionEvent)
         */
        String sql;

        public void actionPerformed(ActionEvent e) {
            String userNameText = userName.getText();
            int passwordText = Integer.parseInt(password.getText());
            Users user = new Users();
            user.setUsername(userNameText);
            user.setUserpwd(passwordText);
            String state = (String) userType.getSelectedItem();
            user.setState(state);
            sql = "select * from users where name=? and password=? and state=?";
            CheckThePasswordAndLogIn(user, sql);


        }

        private void CheckThePasswordAndLogIn(Users user, String sql) {
            try {
                UserManagement userManagement = new UserManagement();
                //login platform
                if (userManagement.Query(user, sql)) {
                    JOptionPane.showMessageDialog(null, "login successful");
                    LogInProcess(user.getState());
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password or username ");
                    userName.setText("");
                    password.setText("");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        private void LogInProcess(String state) {
            if (state.equals("IT Administration team")) {
                logInFrame.setVisible(false);
                new AdminAccount();
//                new PersonalInformation();
            } else {
                logInFrame.setVisible(false);
                new UserAccount();
            }
        }
    }
}



