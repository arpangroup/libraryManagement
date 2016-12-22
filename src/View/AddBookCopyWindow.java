
package View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author wijerath_ps13257
 */
public class AddBookCopyWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddBookCopyWindow
     */
    public AddBookCopyWindow() {
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

        lblWelcome = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAddBookCopy = new javax.swing.JLabel();
        txtBookCopyId = new javax.swing.JTextField();
        txtBookCopyName = new javax.swing.JTextField();
        txtBookId = new javax.swing.JTextField();
        checkBookCopyStatus = new javax.swing.JCheckBox();
        btnSubmit = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setText("Welcome: User name");
        getContentPane().add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblTime.setText("Time:");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 114, 28));

        lblDate.setText("Date:");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 114, 28));

        jLabel6.setText("Book Copy Id:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, 20));

        jLabel2.setText("Book Copy Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 20));

        jLabel3.setText("Book Id:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 20));

        lblAddBookCopy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddBookCopy.setText(" Add Book Copy");
        getContentPane().add(lblAddBookCopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 52));
        getContentPane().add(txtBookCopyId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 219, 20));
        getContentPane().add(txtBookCopyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 219, 20));
        getContentPane().add(txtBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 219, 20));

        checkBookCopyStatus.setText("Status");
        getContentPane().add(checkBookCopyStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, -1));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 170, -1));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        //Btn Logic is moved to the Data Access
        //Call the method which is created in Controller - handle the error msgs and information msgs
    }//GEN-LAST:event_btnSubmitActionPerformed

    public JButton getBtnHome() {
        return btnHome;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JCheckBox getCheckBookCopyStatus() {
        return checkBookCopyStatus;
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

    public JTextField getTxtBookCopyId() {
        return txtBookCopyId;
    }

    public JTextField getTxtBookCopyName() {
        return txtBookCopyName;
    }

    public JTextField getTxtBookId() {
        return txtBookId;
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JCheckBox checkBookCopyStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddBookCopy;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtBookCopyId;
    private javax.swing.JTextField txtBookCopyName;
    private javax.swing.JTextField txtBookId;
    // End of variables declaration//GEN-END:variables
}
