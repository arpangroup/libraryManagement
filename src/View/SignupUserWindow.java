package View;

/**
 *
 * @author wijerath_ps13257
 */
public class SignupUserWindow extends javax.swing.JFrame {

    /**
     * Creates new form SignUpProject
     */
    public SignupUserWindow() {
        initComponents();

       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtClearance = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        lblAddUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, 32));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 219, 32));

        jLabel3.setText("Contact Number:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 32));
        jPanel1.add(txtContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 219, 32));

        jLabel4.setText("Address:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, 32));
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 219, 32));

        jLabel1.setText("User Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 90, 32));
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 219, 32));

        jLabel5.setText("Password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 32));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 219, 32));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 219, 32));

        jLabel6.setText("Id:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, 32));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 170, -1));

        lblTime.setText("Time:");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 114, 28));

        lblDate.setText("Date:");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 114, 28));

        jLabel7.setText("Clearance");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 90, 32));
        jPanel1.add(txtClearance, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 219, 32));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setText("Welcome: User name");
        jPanel2.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel2.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        lblAddUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddUser.setText("  Add User");
        jPanel2.add(lblAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 130, 52));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        //Btn Logic is moved to the Data Access
        //Call the method which is created in Controller - handle the error msgs and information msgs

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed


    }//GEN-LAST:event_btnHomeActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAddUser;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtClearance;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
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
     * @return the txtAddress
     */
    public javax.swing.JTextField getTxtAddress() {
        return txtAddress;
    }

    /**
     * @return the txtClearance
     */
    public javax.swing.JTextField getTxtClearance() {
        return txtClearance;
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
     * @return the txtPassword
     */
    public javax.swing.JTextField getTxtPassword() {
        return txtPassword;
    }

    /**
     * @return the txtUserName
     */
    public javax.swing.JTextField getTxtUserName() {
        return txtUserName;
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
     * @return the lblWelcome
     */
  
}
