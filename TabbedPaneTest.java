package Package_TabbedPane;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;

class TabbedPaneTest {

    @Test
        void testframe(){
        JFrame frame = new JFrame("TabbedPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        assertNotNull(frame);
        assertEquals(JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());
        assertTrue(frame.isVisible());



    }
    @Test
    void TesTbackgroundpanel(){
        JPanel backgroundPanel = new JPanel();
        assertNotNull(backgroundPanel);
    }

    @Test
    void testTabbedpane(){
        JTabbedPane tabbedPane = new JTabbedPane();
        assertEquals(JTabbedPane.WRAP_TAB_LAYOUT, tabbedPane.getTabLayoutPolicy());

    }

    @Test
    void testredpanel(){
        JPanel redPanel = new JPanel();
        redPanel.setLayout(new GridLayout(1, 3));
        redPanel.setBackground(Color.ORANGE);
        assertNotNull(redPanel);
        assertEquals(Color.ORANGE, redPanel.getBackground());
        assertEquals(GridLayout.class, redPanel.getLayout().getClass());
    }

    @Test
    void testBorders(){
        Border labelBorder = BorderFactory.createTitledBorder("Labels");
        assertNotNull(labelBorder);
        assertTrue(labelBorder instanceof TitledBorder);
        assertEquals("Labels",((TitledBorder) labelBorder).getTitle());

        Border textFieldBorder = BorderFactory.createTitledBorder("Text Fields");
        assertNotNull(textFieldBorder);
        assertTrue(textFieldBorder instanceof  TitledBorder);
        assertEquals("Text Fields",((TitledBorder) textFieldBorder).getTitle());

        Border emptyBorder = BorderFactory.createTitledBorder("");
        assertNotNull(emptyBorder);
        assertTrue(emptyBorder instanceof TitledBorder);
        assertEquals("",((TitledBorder) emptyBorder).getTitle());
    }

    @Test
    void testlabelpanel(){
        JPanel labelPanel = new JPanel(new GridLayout(3, 1));
        Border labelBorder = BorderFactory.createTitledBorder("Labels");
        labelPanel.setBorder(labelBorder);
        assertNotNull(labelPanel);
        assertNotNull(labelBorder);
        assertEquals(labelBorder, labelPanel.getBorder());
        assertEquals(GridLayout.class, labelPanel.getLayout().getClass());

    }
    @Test
    void Textfields(){
        JPanel textFieldPanel = new JPanel(new GridLayout(3, 1));
        Border textFieldBorder = BorderFactory.createTitledBorder("Text Fields");
        textFieldPanel.setBorder(textFieldBorder);

        JTextField nameField = new JTextField();
        JTextField typeField = new JTextField();
        JTextField authorField = new JTextField();

        assertNotNull(textFieldPanel);
        assertNotNull(textFieldBorder);
        assertNotNull(nameField);
        assertNotNull(typeField);
        assertNotNull(authorField);
        assertEquals(new Dimension(150, 20), nameField.getPreferredSize());
        assertEquals(new Dimension(150, 20), typeField.getPreferredSize());
        assertEquals(new Dimension(150, 20), authorField.getPreferredSize());
        }

        @Test
    void testredpanelcomponents(){
            JPanel redPanel = new JPanel();
            JPanel labelPanel = new JPanel();
            JPanel textFieldPanel = new JPanel();
            JPanel emptyPanel = new JPanel();
            redPanel.add(labelPanel);
            redPanel.add(textFieldPanel);
            redPanel.add(emptyPanel);
            assertEquals(3, redPanel.getComponentCount());
            assertEquals(labelPanel, redPanel.getComponent(0));
            assertEquals(textFieldPanel, redPanel.getComponent(1));
            assertEquals(emptyPanel, redPanel.getComponent(2));

        }
        @Test
    void testMessagebutton() {
            JButton messageButton = new JButton("Show Message");
            messageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Click calculate to enter the name and age");
                }
            });
            assertNotNull(messageButton.getActionListeners());
            assertEquals("Show Message", messageButton.getText());
        }

// test carried out to show whether the action listener displays a mesage
@Test
        void testmessageactionlistener(){
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Click calculate to enter the name and age");
                }
            };
            actionListener.actionPerformed(null);

        }

        @Test
    void testCalculatebutton(){
            JButton calculationButton = new JButton("Calculate");
            calculationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter first number:"));
                    int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter second number:"));
                    int result = num1 + num2;
                    JOptionPane.showMessageDialog(null, "Result: " + result);
                }
            });

            assertNotNull(calculationButton.getActionListeners());
            assertEquals("Calculate", calculationButton.getText());
        }

        @Test
    void testcalculateActionlistener(){
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter first number:"));
                    int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter second number:"));
                    int result = num1 + num2;
                    JOptionPane.showMessageDialog(null, "Result: " + result);
                }

            };
            actionListener.actionPerformed(null);
        }

        @Test
    void testJmenu(){
            JPanel panel = new JPanel();
            JMenuBar menuBar = new JMenuBar();
            panel.add(menuBar);

            JMenu menu = new JMenu("Options");
            JMenu menu1 = new JMenu("Files");
            JMenu menu2 = new JMenu("Something");
            JMenu menu3 = new JMenu("A Menu");
            menuBar.add(menu);
            menuBar.add(menu1);
            menuBar.add(menu2);
            menuBar.add(menu3);

            assertEquals(4, menuBar.getMenuCount());

        }

        @Test
    void testmenuactionlisteners() {
            JPanel panel = new JPanel();
            JMenuItem menuItem1 = new JMenuItem("Rename File");
            JMenuItem menuItem2 = new JMenuItem("Delete File");
            menuItem1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(panel, "Rename selected");
                }
            });
            menuItem2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(panel, "Delete selected");
                }
            });

            assertNotNull(menuItem1);
            assertNotNull(menuItem2);
            assertEquals("Rename File", menuItem1.getText());
            assertEquals("Delete File", menuItem2.getText());

            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(panel, "Rename selected");
                }

            };
            actionListener.actionPerformed(null);

        }

        @Test
    void testMenuItem2actionlistenrer() {
        JPanel panel = new JPanel();
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(panel, "Delete selected");
                }
            };
            actionListener.actionPerformed(null);
        }

        @Test
        void testbluePanel() {

            JPanel bluePanel = new JPanel();
            bluePanel.setBackground(Color.BLUE);

            String[] columnNames = { "Name", "Reg. No" };
            Object[][] data = { { "Item 1", "Reg001" }, { "Item 2", "Reg002" }, { "Item 3", "Reg003" }, { "Item 4", "Reg004" } };
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(300, 100));
            bluePanel.add(scrollPane);

            assertNotNull(bluePanel);
            assertEquals(1, bluePanel.getComponentCount());
            assertTrue(bluePanel.getComponent(0) instanceof JScrollPane);
        }

        @Test
    void testyellowpanel(){
            JPanel yellowPanel = new JPanel();
            yellowPanel.setBackground(Color.YELLOW);

            yellowPanel.setLayout(new BorderLayout());

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Name");
            tableModel.addColumn("Age");
             JTable table = new JTable(tableModel);
            yellowPanel.add(new JScrollPane(table), BorderLayout.CENTER);

            assertNotNull(yellowPanel);
            assertNotNull(tableModel);
            assertNotNull(table);
            assertEquals(Color.YELLOW, yellowPanel.getBackground());
            assertEquals(2, tableModel.getColumnCount());
            assertEquals("Name", tableModel.getColumnName(0));
            assertEquals("Age", tableModel.getColumnName(1));


    }
        @Test
      void testAddbuttonactionlistener(){

            JPanel buttonPanel = new JPanel();
            DefaultTableModel tableModel = new DefaultTableModel();
            JButton addButton = new JButton("Add");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("Enter name:");
                    int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
                    tableModel.addRow(new Object[]{name, age});
                }
            });
            assertNotNull(buttonPanel);
            assertNotNull(tableModel);
            assertNotNull(addButton.getActionListeners());
            assertEquals("Add", addButton.getText());

            ActionListener actionListener= new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("Enter name:");
                    int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
                    tableModel.addRow(new Object[]{name, age});
                }
            };
            actionListener.actionPerformed(null);
      }

        @Test
        void testClearbuttonactionlistener() {
            DefaultTableModel tableModel = new DefaultTableModel();
            JButton clearButton = new JButton("Clear");
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to clear the list?", "Confirm",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        tableModel.setRowCount(0);
                    }
                }
            });
            assertNotNull(clearButton.getActionListeners());
            assertEquals("Clear", clearButton.getText());

            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to clear the list?", "Confirm",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        tableModel.setRowCount(0);
                    }
                }
            };
            actionListener.actionPerformed(null);

        }


        @Test
    void testBlackpanel() {
            JPanel blackPanel = new JPanel();
            blackPanel.setBackground(new Color(114, 204, 204));
            blackPanel.setLayout(new BorderLayout());
            assertNotNull(blackPanel);
            assertEquals(new Color(114, 204, 204), blackPanel.getBackground());

            JButton returnButton = new JButton("Return to Form");
            assertNotNull(returnButton);
            assertEquals("Return to Form", returnButton.getText());

            JButton exitButton = new JButton("Exit");
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            assertNotNull(exitButton.getActionListeners());
            assertEquals("Exit", exitButton.getText());
        }
        @Test
        void testactionlistener(){
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };
            actionListener.actionPerformed(null);
        }
        @Test
                void testBlackbuttonpanel(){
            JPanel BlackbuttonPanel = new JPanel();
            BlackbuttonPanel.setLayout(new FlowLayout());
            assertNotNull(BlackbuttonPanel);

            JButton exitButton = new JButton();
            JButton returnButton = new JButton();
            BlackbuttonPanel.add(returnButton);
            BlackbuttonPanel.add(exitButton);

            assertEquals(2, BlackbuttonPanel.getComponentCount());
            assertTrue(BlackbuttonPanel.getComponent(0) instanceof JButton);
            assertTrue(BlackbuttonPanel.getComponent(1) instanceof JButton);

        }


}














