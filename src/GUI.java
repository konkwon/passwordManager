import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TabbedPane extends JFrame {
    JTabbedPane tabs;
    addPanel addTab;
    managePanel manageTab;
    loginTable table = new loginTable();

    private JPanel panel = new JPanel();
    private JLabel labelWeb = new JLabel("Website");
    private JLabel labelUser = new JLabel("Username");
    private JLabel labelPass = new JLabel("Password");
    private JTextField webTextField = new JTextField(15);
    private JTextField userTextField = new JTextField(15);
    private JTextField passTextField = new JTextField(15);
    private JButton addButton = new JButton("Add");

    TabbedPane() {
        super("Password Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        addTab = new addPanel();
        manageTab = new managePanel();

        tabs.addTab("Add", addTab);
        tabs.addTab("Manage", manageTab);
        


        getContentPane().add(tabs);
    }


    class addPanel extends JPanel {
        addPanel() {
            SpringLayout addLayout = new SpringLayout();

            addLayout.putConstraint(SpringLayout.WEST, labelWeb, 96, SpringLayout.WEST, panel);
            addLayout.putConstraint(SpringLayout.NORTH, labelWeb, 8, SpringLayout.NORTH, panel);
            addLayout.putConstraint(SpringLayout.WEST, labelUser, 96, SpringLayout.WEST, panel);
            addLayout.putConstraint(SpringLayout.NORTH, labelUser, 24, SpringLayout.NORTH, labelWeb);
            addLayout.putConstraint(SpringLayout.WEST, labelPass, 96, SpringLayout.WEST, panel);
            addLayout.putConstraint(SpringLayout.NORTH, labelPass, 24, SpringLayout.NORTH, labelUser);
            addLayout.putConstraint(SpringLayout.WEST, webTextField, 24, SpringLayout.EAST, labelWeb);
            addLayout.putConstraint(SpringLayout.NORTH, webTextField, 5, SpringLayout.NORTH, panel);
            addLayout.putConstraint(SpringLayout.WEST, userTextField, 12, SpringLayout.EAST, labelUser);
            addLayout.putConstraint(SpringLayout.NORTH, userTextField, 24, SpringLayout.NORTH, webTextField);
            addLayout.putConstraint(SpringLayout.WEST, passTextField, 14, SpringLayout.EAST, labelPass);
            addLayout.putConstraint(SpringLayout.NORTH, passTextField, 24, SpringLayout.NORTH, userTextField);
            addLayout.putConstraint(SpringLayout.WEST, addButton, 256, SpringLayout.WEST, panel);
            addLayout.putConstraint(SpringLayout.NORTH, addButton, 40, SpringLayout.NORTH, passTextField);
            addButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    addActionPerformed(e);
                }
            });

            setLayout(addLayout);
            add(labelWeb);
            add(webTextField);
            add(labelUser);
            add(userTextField);
            add(labelPass);
            add(passTextField);
            add(addButton);

        }
    }

    class managePanel extends JPanel {
        JPanel backgroundPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(backgroundPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton removeButton = new JButton("Remove");
        JButton saveButton = new JButton("Save");
        SpringLayout manageLayout = new SpringLayout();
        
        managePanel() {
            table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "ID", "Website", "Username", "Password"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, true, true, true
                };
            });

            scrollPane.setViewportView(table);
            if (table.getColumnModel().getColumnCount() > 0) {
                table.getColumnModel().getColumn(0).setResizable(false);
                table.getColumnModel().getColumn(0).setPreferredWidth(5);
                table.getColumnModel().getColumn(1).setResizable(false);
                table.getColumnModel().getColumn(2).setResizable(false);
                table.getColumnModel().getColumn(3).setResizable(false);
            }
            setLayout(manageLayout);
            manageLayout.putConstraint(SpringLayout.NORTH, scrollPane,32, SpringLayout.NORTH, saveButton);
            manageLayout.putConstraint(SpringLayout.WEST, scrollPane, 8, SpringLayout.WEST, backgroundPanel);
            manageLayout.putConstraint(SpringLayout.WEST, saveButton, 8, SpringLayout.WEST, backgroundPanel);
            manageLayout.putConstraint(SpringLayout.NORTH, saveButton, 8, SpringLayout.NORTH, backgroundPanel);
            manageLayout.putConstraint(SpringLayout.WEST, removeButton,72, SpringLayout.WEST, saveButton);
            manageLayout.putConstraint(SpringLayout.NORTH, removeButton, 8, SpringLayout.NORTH, backgroundPanel);
            setLayout(manageLayout);
            add(saveButton);
            add(removeButton);
            add(scrollPane);

        }   
    }

    class addInfo {
        String website;
        String username;
        String password;
    
        addInfo(String web, String id, String pass) {
            website = web;
            username = id;
            password = pass;
        }
    }

    addInfo addData[] = new addInfo[10];
    int i = 0;

    private void addActionPerformed(java.awt.event.ActionEvent e) {
        addData[i] = new addInfo(webTextField.getText(), userTextField.getText(), passTextField.getText());
        i++;
        updateTable();
    }

    // private void removeActionPerformed(java.awt.event.ActionEvent e) {

    // }

    private void updateTable() {
        int j = 0;

        for (j = 0 ; j < 20 ; j++) {
            table.setValueAt("", j, 0);
            table.setValueAt("", j, 1);
            table.setValueAt("", j, 2);
            table.setValueAt("", j, 3);
        }

        for (j = 0 ; j < i ; j++) {
            table.setValueAt(j + 1, j, 0);
            table.setValueAt(addData[j].website, j, 1);
            table.setValueAt(addData[j].username, j, 2);
            table.setValueAt(addData[j].password, j, 3);
        }
    }      

    class GUI {
        public static void main(String args[]) throws Exception {
            TabbedPane frame = new TabbedPane();
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        }
    }
}