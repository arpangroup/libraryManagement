/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Wishwa
 */
public class ViewBookWindow extends javax.swing.JFrame {

    /**
     * Creates new form ViewBookWindow
     */
    public ViewBookWindow() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        lblSearchUser = new javax.swing.JLabel();
        lblSearchFrom = new javax.swing.JLabel();
        checkBookId = new javax.swing.JCheckBox();
        checkBookName = new javax.swing.JCheckBox();
        txtSearchBook = new javax.swing.JTextField();
        btnSearchBook = new javax.swing.JButton();
        btnViewBookCopy = new javax.swing.JButton();
        btnDeleteBook = new javax.swing.JButton();
        btnUpdateBook = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        lblSearchUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearchUser.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchUser.setText("View Book");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSearchUser)
                .addContainerGap(745, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblSearchUser)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        lblSearchFrom.setText("Search By");
        getContentPane().add(lblSearchFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 60, 30));

        buttonGroup1.add(checkBookId);
        checkBookId.setSelected(true);
        checkBookId.setText("Book Id");
        checkBookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBookIdselectionChanged(evt);
            }
        });
        getContentPane().add(checkBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 70, 77, -1));

        buttonGroup1.add(checkBookName);
        checkBookName.setText("Book Name");
        getContentPane().add(checkBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 70, 103, -1));
        getContentPane().add(txtSearchBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 105, 264, -1));

        btnSearchBook.setText("Search");
        btnSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBookActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 102, 106, -1));

        btnViewBookCopy.setText("View Book Copy");
        getContentPane().add(btnViewBookCopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 147, -1));

        btnDeleteBook.setText("Delete");
        btnDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 371, 165, -1));

        btnUpdateBook.setText("Update");
        btnUpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 371, 167, -1));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 93, 132, -1));

        lblWelcome.setText("Welcome: User name");
        getContentPane().add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, -1, -1));

        lblDate.setText("Date:");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 90, 20));

        lblTime.setText("Time:");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 90, 20));

        tblSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Book Id", "Book Name", "ISBN", "Book Author", "Book Publisher", "No.Books", "Language"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSearch);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, 639, 190));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 93, 10, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBookIdselectionChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBookIdselectionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBookIdselectionChanged

    private void btnSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookActionPerformed

        //Query is created in Data Access
        //Logic is in Controller
    }//GEN-LAST:event_btnSearchBookActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookActionPerformed

    }//GEN-LAST:event_btnDeleteBookActionPerformed

    private void btnUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookActionPerformed

    }//GEN-LAST:event_btnUpdateBookActionPerformed

    public JButton getBtnDeleteBook() {
        return btnDeleteBook;
    }

    public JButton getBtnHome() {
        return btnHome;
    }

    public JButton getBtnSearchBook() {
        return btnSearchBook;
    }

    public JButton getBtnUpdateBook() {
        return btnUpdateBook;
    }

    public JButton getBtnViewBookCopy() {
        return btnViewBookCopy;
    }

    public JCheckBox getCheckBookId() {
        return checkBookId;
    }

    public JCheckBox getCheckBookName() {
        return checkBookName;
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

    public JTextField getTxtSearchBook() {
        return txtSearchBook;
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteBook;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearchBook;
    private javax.swing.JButton btnUpdateBook;
    private javax.swing.JButton btnViewBookCopy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkBookId;
    private javax.swing.JCheckBox checkBookName;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblSearchFrom;
    private javax.swing.JLabel lblSearchUser;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTextField txtSearchBook;
    // End of variables declaration//GEN-END:variables
}
