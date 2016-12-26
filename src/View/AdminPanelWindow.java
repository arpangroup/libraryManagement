/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;

public class AdminPanelWindow extends javax.swing.JFrame {
    
    public AdminPanelWindow() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btnAddBook = new javax.swing.JButton();
        btnAddMember = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        btnViewBook = new javax.swing.JButton();
        btnViewMember = new javax.swing.JButton();
        btnViewUser = new javax.swing.JButton();
        btnBorrowBook = new javax.swing.JButton();
        btnReturnBook = new javax.swing.JButton();
        btnGetReport = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddBook.setText("Add Book");
        getContentPane().add(btnAddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 133, 43));

        btnAddMember.setText("Add Member");
        getContentPane().add(btnAddMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 88, 133, 43));

        btnAddUser.setText("Add User");
        getContentPane().add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 88, 133, 43));

        btnViewBook.setText("View Book");
        getContentPane().add(btnViewBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 159, 133, 43));

        btnViewMember.setText("View Member");
        getContentPane().add(btnViewMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 159, 133, 43));

        btnViewUser.setText("View User");
        getContentPane().add(btnViewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 159, 133, 43));

        btnBorrowBook.setText("Borrow Book");
        getContentPane().add(btnBorrowBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 133, 43));

        btnReturnBook.setText("Return Book");
        getContentPane().add(btnReturnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 133, 43));

        btnGetReport.setText("Get Report");
        getContentPane().add(btnGetReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 167, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, 541, 10));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setText("Welcome: User name");
        jPanel2.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading.setText("   Admin Panel");
        jPanel2.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 202, 20));

        lblDate.setText("Date:");
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 11, 114, 28));

        lblTime.setText("Time:");
        jPanel2.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 45, 114, 28));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 541, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/llogo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 170, 340));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnAddMember;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnBorrowBook;
    private javax.swing.JButton btnGetReport;
    private javax.swing.JButton btnReturnBook;
    private javax.swing.JButton btnViewBook;
    private javax.swing.JButton btnViewMember;
    private javax.swing.JButton btnViewUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnAddBook
     */
    public javax.swing.JButton getBtnAddBook() {
        return btnAddBook;
    }

    /**
     * @return the btnAddMember
     */
    public javax.swing.JButton getBtnAddMember() {
        return btnAddMember;
    }

    /**
     * @return the btnAddUser
     */
    public javax.swing.JButton getBtnAddUser() {
        return btnAddUser;
    }

    /**
     * @return the btnGetReport
     */
    public javax.swing.JButton getBtnGetReport() {
        return btnGetReport;
    }

    /**
     * @return the btnSearchBook
     */
    public javax.swing.JButton getBtnSearchBook() {
        return btnViewBook;
    }

    /**
     * @return the btnSearchMember
     */
    public javax.swing.JButton getBtnSearchMember() {
        return btnViewMember;
    }

    /**
     * @return the btnSearchUser
     */
    public javax.swing.JButton getBtnSearchUser() {
        return btnViewUser;
    }

    /**
     * @return the lblDate
     */
    public javax.swing.JLabel getLblDate() {
        return lblDate;
    }

    /**
     * @return the lblTime
     */
    public javax.swing.JLabel getLblTime() {
        return lblTime;
    }

    /**
     * @return the lblWelcome
     */
    public javax.swing.JLabel getLblWelcome() {
        return lblWelcome;
    }

    public JButton getBtnBorrowBook() {
        return btnBorrowBook;
    }

    public JButton getBtnReturnBook() {
        return btnReturnBook;
    }
    
    
}
