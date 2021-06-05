

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddOrganizationalUnits extends AdminAccount {
    JTextField organizationalUnit;
    JTextField credits;
    JTextField assetNames;

    public AddOrganizationalUnits() {
        super();
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
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Add();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


    }
    private void Add() throws SQLException {
        OrientationUnit unit=new OrientationUnit();
        String unitText = organizationalUnit.getText();
        int credit = Integer.parseInt(credits.getText());
        String assetNamesText ;
        assetNamesText= assetNames.getText();
        unit.setUnit(unitText);
        unit.setAssertName(assetNamesText);
        unit.setCredit(credit);
        if(unitText.equals("") || credit==0 ) {
            //为空，弹出提示框
            JOptionPane.showMessageDialog(null,"请输入内容");
        } else {
            String sql="insert into unit(unit,credit,assetname) values(?,?,?)";

            UnitManagement management =new UnitManagement();
            management.UpdateOrAdd(unit,sql);
            organizationalUnit.setText("");
            credits.setText("");
            assetNames.setText("");
            //添加成功提示框
            JOptionPane.showMessageDialog(null, "添加成功");
        }
    }
}
