package Controller;

import DataAccess.BookPersistantDAO;
import Model.Book;
import View.AddBookCopyWindow;

import View.AddBookWindow;
import View.AppDetails;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wishwa
 */
public class AddBookWindowControl {

    BookPersistantDAO book;
    AddBookWindow window;

    public AddBookWindowControl(AddBookWindow window) {

        book = new BookPersistantDAO();
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
                    SignUp();
                } catch (ParseException ex) {
                    Logger.getLogger(AddBookWindowControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        window.getBtnHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home();
            }
        });

        window.getBtnAddBookCopy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookCopyPage();
            }
        });

    }

    private void Home() {
        window.dispose();

    }

    private void addBookCopyPage() {

        // window.dispose();
        AddBookCopyWindow newWindow = new AddBookCopyWindow();
        AddBookCopyWindowControl controller = new AddBookCopyWindowControl(newWindow);
        newWindow.setVisible(true);
        window.dispose();
    }

    private void SignUp() throws ParseException {

        int id = Integer.parseInt(window.getTxtId().getText());
        String name = window.getTxtName().getText();
        String isbn = window.getTxtISBN().getText();
        String author = window.getTxtAuthor().getText();
        String publisher = window.getTxtPublisher().getText();
        int noBooks = Integer.parseInt(window.getTxtNumBooks().getText());
        String language = window.getTxtLanguage().getText();

        Book book = new Book(id, name, isbn, author, publisher, noBooks, language);
        this.book.addBook(book);
        if (book != null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Book Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "Book not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
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
