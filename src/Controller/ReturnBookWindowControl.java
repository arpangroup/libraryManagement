package Controller;

import DataAccess.FinePersistantDAO;
import DataAccess.ReturnBookPersistantDAO;
import Model.Fine;
import Model.ReturnBook;
import View.AppDetails;
import View.ReturnBookWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
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
    FinePersistantDAO fn;
    ReturnBookWindow window;
    int bkId = 0;
    int mbId = 0;
    int fineDays = 0;
    ReturnBook returnBook;
    Fine fine;

    public ReturnBookWindowControl(ReturnBookWindow window) {

        rtn = new ReturnBookPersistantDAO();
        fn = new FinePersistantDAO();
        this.window = window;
        initialize();
        setIDRtn();
        setIDFine();
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

                    System.out.println("return id: " + Integer.parseInt(window.getLblId().getText()));

                    if (fineDays * 10 > 0) {
                        System.out.println("Condition checked");
                        Fine fine = new Fine(0, fineDays, fineDays * 10, Integer.parseInt(window.getLblId().getText()));
                        fn.addFine(fine);
                    }

                    getFines();
                    
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

        window.getTxtReturnBookCopyId().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!txtValidate(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        window.getTxtReturnMemberId().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!txtValidate(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

    }

    private void Home() {
        window.dispose();

    }

    private void setIDRtn() {
        window.getLblId().setText(String.valueOf(rtn.setId() + 1));
    }

    private void setIDFine() {
        fn.setId();

    }

    private void info() {

        try {
            bkId = Integer.parseInt(window.getTxtReturnBookCopyId().getText());
            mbId = Integer.parseInt(window.getTxtReturnMemberId().getText());
            returnBook = rtn.validate(bkId, mbId);
        } catch (NumberFormatException ee) {
            ee.printStackTrace();
            JOptionPane.showMessageDialog(window.getComponent(0), "Not Valid Details!", "Unsuccessful", JOptionPane.WARNING_MESSAGE);

        }

        if (returnBook.getBkcName() == null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Book Copy Not Exist!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else if (returnBook.getMbrName() == null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Not Exist!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else if (returnBook.isMbrStatus() == false) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Blacklisted!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
        } else if (returnBook.getBrwDate()== null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Already returned!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
        } else {

            window.getLblReturnBookName().setText("Book Name: " + returnBook.getBkcName());
            window.getLblReturnMemberName().setText("Member Name: " + returnBook.getMbrName());
            window.getLblReturnBorrowDate().setText("Borrow Date: " + returnBook.getBrwDate());
            LocalDate today = LocalDate.now();
            LocalDate brDate = (LocalDate) returnBook.getBrwDate().toLocalDate();
            LocalDate expireDate = brDate.plus(2, ChronoUnit.WEEKS);

            if (brDate.getDayOfYear() > expireDate.getDayOfYear()) {
                int val1 = 365 - today.getDayOfYear();
                int val2 = expireDate.getDayOfYear();
                fineDays = val1 + val2;
                if (fineDays < 14) {
                    fineDays = 0;
                }
            } else {
                fineDays = today.getDayOfYear() - expireDate.getDayOfYear();
            }
            /**
             * getDayOfYear() gives the day from 1st of it's yr.if the period is
             * between two years error will occur
             *
             * corrected
             */

            double fineAmount = fineDays * 10;
            window.getLblReturnExpireDate().setText("Expire Date: " + expireDate);
            window.getLblReturnFineAmount().setText("Fine Amount: " + fineAmount);
            window.getLblReturnIssuedOfficer().setText("Issued Officer: " + returnBook.getBorrowedEmployeeId());

            JOptionPane.showMessageDialog(window.getComponent(0), "Validated", "Successful", JOptionPane.INFORMATION_MESSAGE);

            window.getBtnSubmit().setEnabled(true);

        }

    }

    private void addReturn() throws ParseException {

        int returnId = 0;
        java.sql.Date addDate = null;
        int bookcopyId = Integer.parseInt(window.getTxtReturnBookCopyId().getText());
        int memberId = Integer.parseInt(window.getTxtReturnMemberId().getText());
        int employeeId = AppDetails.loggedOnUser.getUserId();

        ReturnBook returnbook = new ReturnBook(returnId, addDate, bookcopyId, memberId, employeeId);

        rtn.addReturn(returnbook);
        if (returnbook != null) {

            JOptionPane.showMessageDialog(window.getComponent(0), "Return Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            window.getBtnSubmit().setEnabled(false);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "Return not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getFines() {

        int memberId = Integer.parseInt(window.getTxtReturnMemberId().getText());
        List<Fine> fines = fn.fineOnMember(memberId);
        DefaultTableModel dtm = (DefaultTableModel) window.getTblFine().getModel();
        dtm.getDataVector().clear();
        for (Fine ff : fines){
            Object[] temp = new Object[]{
                ff.getBookcopyName(),
                ff.getReturnDay(),
                ff.getOverdueDays(),
                ff.getFineAmount()
            };
            dtm.addRow(temp);
        }
        if (fineDays > 30) fn.blacklistMember(bkId);
        
        dtm.fireTableDataChanged();
    }

    private void setFree() {
        fn.removeBlacklistMember(bkId);
    }

    private boolean txtValidate(char c) {
        return Character.isDigit(c);
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
