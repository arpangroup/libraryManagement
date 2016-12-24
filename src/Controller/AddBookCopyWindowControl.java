package Controller;

import DataAccess.BookCopyPersistantDAO;
import Model.BookCopy;
import View.AddBookCopyWindow;
import View.AppDetails;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wijerath_ps13257
 */
public class AddBookCopyWindowControl {

    BookCopyPersistantDAO copy;
    AddBookCopyWindow window;

    public AddBookCopyWindowControl(AddBookCopyWindow window) {

        copy = new BookCopyPersistantDAO();
        this.window = window;
        initialize();
        control();
    }

    public void control() {

        window.getBtnSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    initialize();
                    setID();
                    SignUp();
                } catch (ParseException ex) {
                    Logger.getLogger(AddBookCopyWindowControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        window.getBtnHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home();
            }
        });

    }

    private void Home() {
        window.dispose();

    }

    private void SignUp() throws ParseException {

        int bookcopyId = Integer.parseInt(window.getTxtBookCopyId().getText());
        String bookcopyName = window.getTxtBookCopyName().getText();
        boolean state = window.getCheckBookCopyStatus().isSelected();
        int bookId = Integer.parseInt(window.getTxtBookId().getText());

        BookCopy bookcopy = new BookCopy(bookcopyId, bookcopyName, state, bookId);
        this.copy.addBookCopy(bookcopy);
        if (bookcopy != null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Book Copy Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "Book Copy not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setID() {
        window.getLblId().setText(String.valueOf(copy.setId() + 1));
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
