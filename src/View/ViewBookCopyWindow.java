/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wijerath_ps13257
 */
public class ViewBookCopyWindow extends javax.swing.JFrame {

    /**
     * Creates new form ViewBookCopyWindow
     */
    public ViewBookCopyWindow() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();
        checkBookCopyId = new javax.swing.JCheckBox();
        checkBookCopyName = new javax.swing.JCheckBox();
        txtSearchBookCopy = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnUpdateBookCopy = new javax.swing.JButton();
        btnDeleteBookCopy = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        lblSearchFrom = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblSearchUser = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book Copy Id", "Book Copy Name", "Book Id", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSearch);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 440, 140));

        buttonGroup1.add(checkBookCopyId);
        checkBookCopyId.setSelected(true);
        checkBookCopyId.setText("Book Copy Id");
        checkBookCopyId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBookCopyIdselectionChanged(evt);
            }
        });
        getContentPane().add(checkBookCopyId, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 70, 100, -1));

        buttonGroup1.add(checkBookCopyName);
        checkBookCopyName.setText("Book Copy Name");
        checkBookCopyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBookCopyNameActionPerformed(evt);
            }
        });
        getContentPane().add(checkBookCopyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 140, -1));
        getContentPane().add(txtSearchBookCopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, 311, -1));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 102, 106, -1));

        btnUpdateBookCopy.setText("Update");
        btnUpdateBookCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookCopyActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateBookCopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 209, 30));

        btnDeleteBookCopy.setText("Delete");
        btnDeleteBookCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookCopyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteBookCopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, 30));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 100, 110, -1));

        lblSearchFrom.setText("Search By");
        getContentPane().add(lblSearchFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 60, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        lblSearchUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearchUser.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchUser.setText("View Book Copy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSearchUser)
                .addContainerGap(495, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblSearchUser)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        lblWelcome.setText("Welcome: User name");
        jPanel1.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        lblDate.setText("Date:");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 90, 20));

        lblTime.setText("Time:");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 90, 20));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 106, 10, 240));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteBookCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookCopyActionPerformed

    }//GEN-LAST:event_btnDeleteBookCopyActionPerformed

    private void btnUpdateBookCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookCopyActionPerformed

    }//GEN-LAST:event_btnUpdateBookCopyActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        //Query is created in Data Access
        //Logic is in Controller
    }//GEN-LAST:event_btnSearchActionPerformed

    private void checkBookCopyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBookCopyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBookCopyNameActionPerformed

    private void checkBookCopyIdselectionChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBookCopyIdselectionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBookCopyIdselectionChanged

    public JButton getBtnDeleteBookCopy() {
        return btnDeleteBookCopy;
    }

    public JButton getBtnHome() {
        return btnHome;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnUpdateBookCopy() {
        return btnUpdateBookCopy;
    }

    public JCheckBox getCheckBookCopyId() {
        return checkBookCopyId;
    }

    public JCheckBox getCheckBookCopyName() {
        return checkBookCopyName;
    }

    public JLabel getLblDate() {
        return lblDate;
    }

    public JLabel getLblTime() {
        return lblTime;
    }

    public JLabel getLblWelcome() {
        return lblWelcome;
    }

    public JTable getTblSearch() {
        return tblSearch;
    }

    public JTextField getTxtSearchBookCopy() {
        return txtSearchBookCopy;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteBookCopy;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateBookCopy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkBookCopyId;
    private javax.swing.JCheckBox checkBookCopyName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblSearchFrom;
    private javax.swing.JLabel lblSearchUser;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTextField txtSearchBookCopy;
    // End of variables declaration//GEN-END:variables
}
