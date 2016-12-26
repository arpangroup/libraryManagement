/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Wishwa
 */
public class AddBookWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddBookWindow
     */
    public AddBookWindow() {
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

        txtName = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        txtNumBooks = new javax.swing.JTextField();
        txtLanguage = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnAddBookCopy = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblSearchUser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 219, 20));
        getContentPane().add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 219, 20));
        getContentPane().add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 219, 20));
        getContentPane().add(txtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 219, 20));
        getContentPane().add(txtNumBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 219, 20));
        getContentPane().add(txtLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 219, -1));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 170, -1));

        btnAddBookCopy.setText("Add Book Copy");
        getContentPane().add(btnAddBookCopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 130, 30));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        jLabel4.setText("Author:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 20));

        jLabel3.setText("ISBN:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 20));

        jLabel2.setText("Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 20));

        jLabel6.setText("Id:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, 20));

        jLabel7.setText("Publisher:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 20));

        jLabel5.setText("No. of Books:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 90, 20));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Language:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 20));
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 220, 20));

        lblTime.setText("Time:");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 218, 114, 20));

        lblDate.setText("Date:");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 114, 20));

        lblWelcome.setText("Welcome: User name");
        jPanel1.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        lblSearchUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearchUser.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchUser.setText("Add Book");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSearchUser)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblSearchUser)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 10, 240));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        //Btn Logic is moved to the Data Access
        //Call the method which is created in Controller - handle the error msgs and information msgs
    }//GEN-LAST:event_btnSubmitActionPerformed

    public JButton getBtnAddBookCopy() {
        return btnAddBookCopy;
    }

    public JButton getBtnHome() {
        return btnHome;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
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

   
    public JTextField getTxtAuthor() {
        return txtAuthor;
    }

    public JTextField getTxtISBN() {
        return txtISBN;
    }


    public JTextField getTxtLanguage() {
        return txtLanguage;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtNumBooks() {
        return txtNumBooks;
    }

    public JTextField getTxtPublisher() {
        return txtPublisher;
    }

    public JLabel getLblId() {
        return lblId;
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBookCopy;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblSearchUser;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtLanguage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumBooks;
    private javax.swing.JTextField txtPublisher;
    // End of variables declaration//GEN-END:variables
}
