import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

    public class MenuClass {
       CardLayout TheCard;
        JPanel panel;
        JPanel DisplayPanel;
        MenuClass() {

                MenuClass() {
                    MenuClass() {
            this.MenuFrame();
        }

        public JFrame MenuFrame() {
            JFrame mFrame = new JFrame("Menu");
            TheCard = new CardLayout();
            panel = new JPanel(TheCard);

            mFrame.setSize(600, 500);
            mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mFrame.setLocationRelativeTo(null);

            mFrame.add(this.MenuBar(), BorderLayout.NORTH);
            mFrame.add(panel, BorderLayout.CENTER);
            panel.add(createMainPanel(), "MainPanel");
            panel.add(createFileDetailsPanel(), "DetailsPanel");

            mFrame.setVisible(true);

            return mFrame;
        }

        public JMenuBar MenuBar() {
            JMenuBar mBar = new JMenuBar();

            JMenu FileMenu = new JMenu("File");
            JMenu EditMenu = new JMenu("Edit");
            JMenu HelpMenu = new JMenu("Help");

            mBar.add(FileMenu);
            mBar.add(EditMenu);
            mBar.add(HelpMenu);

            JMenuItem item1 = new JMenuItem("New");
            JMenuItem item2 = new JMenuItem("Open");
            JMenuItem item3 = new JMenuItem("Info");
            JMenuItem item4 = new JMenuItem("Save");
            JMenuItem item5 = new JMenuItem("Close");
            item1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    TheCard.show(panel, "DetailsPanel"); // Switch to details panel
                }
            });
            item1.setMnemonic(KeyEvent.VK_N);
            item2.setMnemonic(KeyEvent.VK_O);
            item3.setMnemonic(KeyEvent.VK_I);
            item4.setMnemonic(KeyEvent.VK_S);
            item5.setMnemonic(KeyEvent.VK_C);
            item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);

                }
            });


            FileMenu.add(item1);
            FileMenu.add(item2);
            FileMenu.add(item3);
            FileMenu.add(item4);
            FileMenu.add(item5);

            FileMenu.setMnemonic(KeyEvent.VK_F);
            EditMenu.setMnemonic(KeyEvent.VK_E);
            HelpMenu.setMnemonic(KeyEvent.VK_H);

            return mBar;
        }

        private JPanel createMainPanel() {
            JPanel mainPanel = new JPanel();
            mainPanel.add(new JLabel("Click File, New to add another File"),BorderLayout.CENTER);

            return mainPanel;
        }

        private JPanel createFileDetailsPanel() {
            JPanel detailsPanel = new JPanel();
            detailsPanel.setLayout(new GridLayout(5, 2));

            detailsPanel.add(new JLabel("FILE NAME:"));
            JTextField nameField = new JTextField();
            detailsPanel.add(nameField);

            detailsPanel.add(new JLabel("FILE TYPE:"));
            JTextField TypeField = new JTextField();
            detailsPanel.add(TypeField);

            detailsPanel.add(new JLabel("AUTHOR:"));
            JTextField authorField = new JTextField();
            detailsPanel.add(authorField);

            JButton saveButton = new JButton("SAVE");
            saveButton.setBackground(Color.orange);
            saveButton.setFont(new Font("Arial", Font.BOLD, 30));
            saveButton.setFocusPainted(false);

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String type = TypeField.getText();
                    String author = authorField.getText();
                    JOptionPane.showMessageDialog(detailsPanel, "Details Submitted:\nFileName: " + name + "\nFileType: " + type + "\nAuthor: " + author);
                }
            });
            detailsPanel.add(saveButton, BorderLayout.SOUTH);

            return detailsPanel;
        }
    }

}
