import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class loginTable extends JTable{
    private JTable logTable = new JTable();

    loginTable() {
    logTable.setModel(new javax.swing.table.DefaultTableModel(
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

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        // logTable.addMouseListener(new MouseAdapter() {
        //     public void mouseClicked(MouseEvent evt) {
        //         jTable1MouseClicked(evt);
        //     }
        // }
        // );;
    }
}
