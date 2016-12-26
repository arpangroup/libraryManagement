package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;

/**
 *
 * @author wijerath_ps13257
 */
public class AddUserWindow extends javax.swing.JFrame {

    /**
     * Creates new form SignUpProject
     */
    public AddUserWindow() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtClearance = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblSearchUser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, 32));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 219, 32));
        jPanel1.add(txtContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 219, 32));
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 219, 32));
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 219, 32));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 219, 32));
        jPanel1.add(txtClearance, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 219, 32));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 170, -1));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jLabel3.setText("Contact Number:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 32));

        jLabel4.setText("Address:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, 32));

        jLabel1.setText("User Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 90, 32));

        jLabel5.setText("Password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 32));

        jLabel6.setText("Id:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, 32));

        jLabel7.setText("Clearance");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 90, 32));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setText("Welcome: User name");
        jPanel2.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 220, 30));

        lblTime.setText("Time:");
        jPanel2.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 114, 28));

        lblDate.setText("Date:");
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 114, 28));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        lblSearchUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearchUser.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchUser.setText("Add User");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSearchUser)
                .addContainerGap(529, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblSearchUser)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 614, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 10, 320));

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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblSearchUser;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtClearance;
    private javax.swing.JTextField txtContactNumber;
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

    public JLabel getLblId() {
        return lblId;
    }

    
  
}
