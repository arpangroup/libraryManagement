package Controller;

import DataAccess.BorrowBookPersistantDAO;
import Model.BorrowBook;
import View.AppDetails;
import View.BorrowBookWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wishwa
 */
public class BorrowBookWindowControl {

    BorrowBookPersistantDAO brw;
    BorrowBookWindow window;
    int bkId = 0;
    int mbId = 0;

    public BorrowBookWindowControl(BorrowBookWindow window) {

        brw = new BorrowBookPersistantDAO();
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
                    addBrw();
                    brw.updateStatus(bkId);
                } catch (ParseException ex) {
                    Logger.getLogger(BorrowBookWindowControl.class.getName()).log(Level.SEVERE, null, ex);
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

        window.getTxtBookCopyId().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!txtValidate(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        window.getTxtMemberId().addKeyListener(new KeyAdapter() {
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

    private void info() {

        try {
            bkId = Integer.parseInt(window.getTxtBookCopyId().getText());
            mbId = Integer.parseInt(window.getTxtMemberId().getText());
            brw.validate(bkId, mbId);
        } catch (NumberFormatException ee) {

            JOptionPane.showMessageDialog(window.getComponent(0), "Not Valid Details!", "Unsuccessful", JOptionPane.WARNING_MESSAGE);

        }

        if (brw.getBkcName() == null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Book Copy Not Exist!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else if (brw.getMbrName() == null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Not Exist!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else if (brw.isMbrStatus() == false) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Blacklisted!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        } else {
            window.getLblBookName().setText("Book Name: " + brw.getBkcName());
            window.getLblMemberName().setText("Member Name: " + brw.getMbrName());
            // brw.updateStatus(bkId);
            JOptionPane.showMessageDialog(window.getComponent(0), "Validated", "Successful", JOptionPane.INFORMATION_MESSAGE);

            window.getBtnSubmit().setEnabled(true);

        }

    }

    private boolean txtValidate(char c) {
        return Character.isDigit(c);
    }

    private void addBrw() throws ParseException {

        int borrowId = 0;
        Date addDate = null;
        int bookcopyId = Integer.parseInt(window.getTxtBookCopyId().getText());
        int memberId = Integer.parseInt(window.getTxtMemberId().getText());
        int employeeId = AppDetails.loggedOnUser.getUserId();

        BorrowBook borrowbook = new BorrowBook(borrowId, (java.sql.Date) addDate, bookcopyId, memberId, employeeId);

        brw.addBorrow(borrowbook);
        if (borrowbook != null) {

            window.getLblId().setText(String.valueOf(brw.getBrwId(bookcopyId, memberId)));
            JOptionPane.showMessageDialog(window.getComponent(0), "Borrow Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "Borrow not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
        }
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
