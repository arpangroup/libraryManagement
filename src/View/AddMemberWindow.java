/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Wishwa
 */
public class AddMemberWindow extends javax.swing.JFrame {

    /**
     * Creates new form SignUpMemberWindow
     */
    public AddMemberWindow() {
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

        btnHome = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        lblAddUser = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnAddGuarantor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 170, -1));

        lblWelcome.setText("Welcome: User name");
        getContentPane().add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblAddUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddUser.setText(" Add Member");
        getContentPane().add(lblAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 52));

        lblDate.setText("Date:");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 114, 28));

        lblTime.setText("Time:");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 114, 28));

        jLabel6.setText("Id:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 90, 32));

        jLabel2.setText("Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, 32));

        jLabel3.setText("Contact Number:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 32));

        jLabel4.setText("Address:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 90, 32));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 219, 32));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 219, 32));
        getContentPane().add(txtContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 219, 32));
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 219, 32));

        btnAddGuarantor.setText("Add Guarantor");
        getContentPane().add(btnAddGuarantor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 130, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        //Btn Logic is moved to the Data Access
        //Call the method which is created in Controller - handle the error msgs and information msgs
    }//GEN-LAST:event_btnSubmitActionPerformed

    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGuarantor;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddUser;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnHome
     */
    public javax.swing.JButton getBtnHome() {
        return btnHome;
    }

    /**
     * @return the btnSubmit
     */
    public javax.swing.JButton getBtnSubmit() {
        return btnSubmit;
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

    /**
     * @return the txtAddress
     */
    public javax.swing.JTextField getTxtAddress() {
        return txtAddress;
    }

    /**
     * @return the txtContactNumber
     */
    public javax.swing.JTextField getTxtContactNumber() {
        return txtContactNumber;
    }

    /**
     * @return the txtId
     */
    public javax.swing.JTextField getTxtId() {
        return txtId;
    }

    /**
     * @return the txtName
     */
    public javax.swing.JTextField getTxtName() {
        return txtName;
    }

    /**
     * @return the btnAddGuarantor
     */
    public javax.swing.JButton getBtnAddGuarantor() {
        return btnAddGuarantor;
    }
}