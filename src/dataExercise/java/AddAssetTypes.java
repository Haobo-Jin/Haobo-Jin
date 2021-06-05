

import javax.swing.*;
import java.awt.*;

public class AddAssetTypes extends AdminAccount {
    JTextField assetNames;

    public AddAssetTypes() {
        super();
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
    }

    // 這個class是用來增加新的資產類型 屬於管理員的function
}
