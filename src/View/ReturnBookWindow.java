
package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Wishwa
 */
public class ReturnBookWindow extends javax.swing.JFrame {

    /**
     * Creates new form ReturnBookCopyWindow
     */
    public ReturnBookWindow() {
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
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        Information = new javax.swing.JPanel();
        lblReturnBookName = new javax.swing.JLabel();
        lblReturnBorrowDate = new javax.swing.JLabel();
        lblReturnMemberName = new javax.swing.JLabel();
        lblReturnExpireDate = new javax.swing.JLabel();
        lblReturnFineAmount = new javax.swing.JLabel();
        lblReturnIssuedOfficer = new javax.swing.JLabel();
        txtReturnBookCopyId = new javax.swing.JTextField();
        txtReturnMemberId = new javax.swing.JTextField();
        btnValidate = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFine = new javax.swing.JTable();
        btnGrant = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblSearchUser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setText("Welcome: User name");
        getContentPane().add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));

        lblDate.setText("Date:");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 114, 28));

        lblTime.setText("Time:");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 114, 28));

        Information.setBorder(javax.swing.BorderFactory.createTitledBorder("  Return Information"));

        lblReturnBookName.setText("Book Name:");

        lblReturnBorrowDate.setText("Borrowed Date:");

        lblReturnMemberName.setText("Member Name:");

        lblReturnExpireDate.setText("Expired On:");

        lblReturnFineAmount.setText("Fine Amount:");

        lblReturnIssuedOfficer.setText("Issued Officer:");

        javax.swing.GroupLayout InformationLayout = new javax.swing.GroupLayout(Information);
        Information.setLayout(InformationLayout);
        InformationLayout.setHorizontalGroup(
            InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblReturnBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReturnFineAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReturnExpireDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReturnBorrowDate, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(lblReturnMemberName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReturnIssuedOfficer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InformationLayout.setVerticalGroup(
            InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationLayout.createSequentialGroup()
                .addComponent(lblReturnBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblReturnMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReturnBorrowDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReturnExpireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReturnFineAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReturnIssuedOfficer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        getContentPane().add(Information, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));
        getContentPane().add(txtReturnBookCopyId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 111, -1));
        getContentPane().add(txtReturnMemberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 111, -1));

        btnValidate.setText("Validate");
        getContentPane().add(btnValidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 90, -1));

        btnSubmit.setText("Submit");
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 191, 90, -1));

        btnHome.setText("Home");
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        jLabel2.setText("Member Id:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 153, 113, 20));

        jLabel6.setText("Book Copy Id:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 127, 113, 20));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 101, 111, 20));

        jLabel8.setText("Return Id:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 101, 123, 20));

        tblFine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book Name", "Return Date", "Overdue Days", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFine);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 300, 87));

        btnGrant.setText("Grant");
        getContentPane().add(btnGrant, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 90, -1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        lblSearchUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearchUser.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchUser.setText("Return Book");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSearchUser)
                .addContainerGap(720, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblSearchUser)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, 200));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents




    public JButton getBtnHome() {
        return btnHome;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JButton getBtnValidate() {
        return btnValidate;
    }

    public JLabel getLblDate() {
        return lblDate;
    }

    public JLabel getLblReturnBookName() {
        return lblReturnBookName;
    }

    public JLabel getLblReturnBorrowDate() {
        return lblReturnBorrowDate;
    }

    public JLabel getLblReturnExpireDate() {
        return lblReturnExpireDate;
    }

    public JLabel getLblReturnFineAmount() {
        return lblReturnFineAmount;
    }

    public JLabel getLblReturnIssuedOfficer() {
        return lblReturnIssuedOfficer;
    }

    public JLabel getLblReturnMemberName() {
        return lblReturnMemberName;
    }

    public JLabel getLblTime() {
        return lblTime;
    }

    public JLabel getLblWelcome() {
        return lblWelcome;
    }

    public JTextField getTxtReturnBookCopyId() {
        return txtReturnBookCopyId;
    }

    public JTextField getTxtReturnMemberId() {
        return txtReturnMemberId;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public JTable getTblFine() {
        return tblFine;
    }

    public JButton getBtnGrant() {
        return btnGrant;
    }
    
    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Information;
    private javax.swing.JButton btnGrant;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnValidate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblReturnBookName;
    private javax.swing.JLabel lblReturnBorrowDate;
    private javax.swing.JLabel lblReturnExpireDate;
    private javax.swing.JLabel lblReturnFineAmount;
    private javax.swing.JLabel lblReturnIssuedOfficer;
    private javax.swing.JLabel lblReturnMemberName;
    private javax.swing.JLabel lblSearchUser;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblFine;
    private javax.swing.JTextField txtReturnBookCopyId;
    private javax.swing.JTextField txtReturnMemberId;
    // End of variables declaration//GEN-END:variables
}
