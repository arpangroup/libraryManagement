
package Controller;

import DataAccess.BookCopyPersistantDAO;
import DataAccess.BookPersistantDAO;
import Model.Book;
import View.AddBookWindow;
import View.AppDetails;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author wijerath_ps13257
 */
public class AddBookCopyWindowControl {
  /*
    
    BookCopyPersistantDAO book;
    AddBookCopyWindow window;

    public AddBookCopyWindowControl(AddBookCopyWindow window) {

        book = new BookPersistantDAO();
        this.window = window;
        initialize();
        control();
    }

    public void control() {

        window.getBtnSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize();
                // SignUp();
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
                //signupGuarantorPage();
            }
        });

    }

    private void Home() {
        window.dispose();

    }

  
//    private void addBookCopyPage() {
//
//        // window.dispose();
//        AddBookCopyWindow newWindow = new AddBookCopyWindow();
//        AddBookCopyWindowControl controller = new AddBookCopyWindowControl(newWindow);
//        newWindow.setVisible(true);
//        window.dispose();
//    }
     
    private void SignUp() throws ParseException {

        String id = window.getTxtId().getText();
        String name = window.getTxtName().getText();
        String isbn = window.getTxtISBN().getText();
        String author = window.getTxtAuthor().getText();
        String publisher = window.getTxtPublisher().getText();
        int noBooks = Integer.parseInt(window.getTxtNumBooks().getText());
        String language = window.getTxtLanguage().getText();

        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date addDate = format.parse(window.getTxtLanguage().getText());

       
        Book book=new Book(id, name, isbn, author, publisher, noBooks, language, (java.sql.Date) addDate);
          this.book.addBook(book);
        if (book != null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Book Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else {

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

                    }
                }
            }).start();

        } catch (Exception e) {
        }
    }
    */

}
