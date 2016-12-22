package Controller;

import DataAccess.FinePersistantDAO;
import DataAccess.ReturnBookPersistantDAO;
import Model.ReturnBook;
import View.AppDetails;
import View.ReturnBookWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wishwa
 */
public class ReturnBookWindowControl {

    ReturnBookPersistantDAO rtn;
    FinePersistantDAO fine;
    ReturnBookWindow window;
    int bkId = 0;
    int mbId = 0;
    int fineDays = 0;

    public ReturnBookWindowControl(ReturnBookWindow window) {

        rtn = new ReturnBookPersistantDAO();
        fine = new FinePersistantDAO();
        this.window = window;
        initialize();
        window.getBtnSubmit().setEnabled(false);
        control();
    }

    public void control() {

        window.getBtnSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addReturn();
                    rtn.updateStatus(bkId);
                } catch (ParseException ex) {
                    Logger.getLogger(ReturnBookWindowControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        window.getBtnHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home();
            }
        });

        window.getBtnValidate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info();
            }
        });

        window.getBtnGrant().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setFree();
            }
        });

    }

    private void Home() {
        window.dispose();

    }

    private void info() {

        try {
            bkId = Integer.parseInt(window.getTxtReturnBookCopyId().getText());
            mbId = Integer.parseInt(window.getTxtReturnMemberId().getText());
            rtn.validate(bkId, mbId);
        } catch (NumberFormatException ee) {

            JOptionPane.showMessageDialog(window.getComponent(0), "Not Valid Details!", "Unsuccessful", JOptionPane.WARNING_MESSAGE);

        }

        if (rtn.getBkcName() == null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Book Copy Not Exist!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else if (rtn.getMbrName() == null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Not Exist!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else if (rtn.isMbrStatus() == false) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Blacklisted!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else {

            window.getLblReturnBookName().setText("Book Name: " + rtn.getBkcName());
            window.getLblReturnMemberName().setText("Member Name: " + rtn.getMbrName());
            window.getLblReturnBorrowDate().setText("Borrow Date: " + rtn.getRtnDate());
            LocalDate today = LocalDate.now();
            LocalDate expireDate = today.plus(2, ChronoUnit.WEEKS);
            fineDays = today.getDayOfYear() - rtn.getRtnDate().toLocalDate().getDayOfYear();
            double fineAmount = fineDays * 10;
            window.getLblReturnExpireDate().setText("Expire Date: " + expireDate);
            window.getLblReturnFineAmount().setText("Fine Amount: " + fineAmount);
            window.getLblReturnIssuedOfficer().setText("Issued Officer: " + rtn.getEmpId());

            JOptionPane.showMessageDialog(window.getComponent(0), "Validated", "Successful", JOptionPane.INFORMATION_MESSAGE);

            window.getBtnSubmit().setEnabled(true);

        }

    }

    private void addReturn() throws ParseException {

        int returnId = 0;
        Date addDate = null;
        int bookcopyId = Integer.parseInt(window.getTxtReturnBookCopyId().getText());
        int memberId = Integer.parseInt(window.getTxtReturnMemberId().getText());
        int employeeId = AppDetails.loggedOnUser.getUserId();

        ReturnBook returnbook = new ReturnBook(returnId, addDate, bookcopyId, memberId, employeeId);

        rtn.addReturn(returnbook);
        if (returnbook != null) {

            window.getLblId().setText(String.valueOf(rtn.getRtnId(bookcopyId, memberId)));
            JOptionPane.showMessageDialog(window.getComponent(0), "Return Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "Return not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getFines() {

        int memberId = Integer.parseInt(window.getTxtReturnMemberId().getText());
        Vector vector = new Vector();

        vector.add(fine.getBookcopyName());
        vector.add(fine.getReturnDay());
        vector.add(fine.getFineDays());
        vector.add(fine.getFineAmount());

        DefaultTableModel dtm = (DefaultTableModel) window.getTblFine().getModel();
        dtm.addRow(vector);

        if (fineDays > 30) {
            fine.blacklistMember(bkId);
        }

    }

    private void setFree() {
        fine.removeBlacklistMember(bkId);
    }

    private void initialize() {

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Date d = new Date();
                        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
                        String stDate = sd.format(d);
                        String strTime = d.toString();
                        String[] time = strTime.split(" ");
                        window.getLblTime().setText(time[3]);
                        window.getLblDate().setText(stDate);
                        window.getLblWelcome().setText("Welcome: " + AppDetails.loggedOnUser.getUserName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }).start();

        } catch (Exception e) {
        }
    }

}
