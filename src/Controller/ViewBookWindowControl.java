package Controller;

import DataAccess.BookPersistantDAO;
import Model.Book;
import View.AppDetails;
import View.ViewBookWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author wijerath_ps13257
 */
public class ViewBookWindowControl {

    BookPersistantDAO book;
    ViewBookWindow window;

    public ViewBookWindowControl(ViewBookWindow window) {
        book = new BookPersistantDAO();
        this.window = window;
        initialize();
        control();
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
            e.printStackTrace();
        }
    }

    public void control() {

        window.getBtnSearchBook().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchId();
            }
        });

        window.getBtnUpdateBook().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateId();
            }
        });

        window.getBtnDeleteBook().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteId();
            }
        });

        window.getBtnHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home();
            }
        });

        /*
        window.getBtnViewBookCopy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBookCopyPage();
            }
        });*/
    }

    private void Home() {

        window.dispose();
    }

    private void SearchId() {

        for (int i = window.getTblSearch().getRowCount() - 1; i >= 0; i--) {
            for (int j = window.getTblSearch().getColumnCount() - 1; j >= 0; j--) {
                window.getTblSearch().getModel().setValueAt(null, i, j);
            }
        }

        if (window.getCheckBookId().isSelected()) {
            String Id = window.getTxtSearchBook().getText();
            Book searchdata = book.searchBookById(Id);
            if (searchCheckForNull(searchdata)) {
                try {
                    window.getTblSearch().getModel().setValueAt(searchdata.getBookId(), 0, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.getBookName(), 0, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.getIsbn(), 0, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.getAuthor(), 0, 3);
                    window.getTblSearch().getModel().setValueAt(searchdata.getPublisher(), 0, 4);
                    window.getTblSearch().getModel().setValueAt(searchdata.getNoBooksAvailable(), 0, 5);
                    window.getTblSearch().getModel().setValueAt(searchdata.getLanguage(), 0, 6);
                    window.getTblSearch().getModel().setValueAt(searchdata.getAddDate(), 0, 7);
                } catch (Exception ex) {
                }
            }
        } else if (window.getCheckBookName().isSelected()) {
            String Name = window.getTxtSearchBook().getText();
            ArrayList<Book> searchdata = book.searchBookByName(Name);
            if (searchCheckForNull(searchdata)) {
                for (int i = 0; i < searchdata.size(); i++) {
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getBookId(), i, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getBookName(), i, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getIsbn(), i, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getAuthor(), i, 3);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getPublisher(), i, 4);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getNoBooksAvailable(), i, 5);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getLanguage(), i, 6);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getAddDate(), i, 7);
                }
            }
        }
    }

    private boolean searchCheckForNull(Object data) {
        if (data != null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry Found!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(window.getComponent(0), "Entry Not Found", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private boolean updateCheckForNull(Object data) {
        if (data != null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry Updated!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(window.getComponent(0), "Entry is not Updated", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private void updateId() {

        int rowNum = window.getTblSearch().getSelectedRow();
        String userid = (String) window.getTblSearch().getModel().getValueAt(rowNum, 0);
        String name = (String) window.getTblSearch().getModel().getValueAt(rowNum, 1);
        String isbn = (String) window.getTblSearch().getModel().getValueAt(rowNum, 2);
        String author = (String) window.getTblSearch().getModel().getValueAt(rowNum, 3);
        String publisher = (String) window.getTblSearch().getModel().getValueAt(rowNum, 4);
        int noBooks = (int) window.getTblSearch().getModel().getValueAt(rowNum, 5);
        int language = (int) window.getTblSearch().getModel().getValueAt(rowNum, 6);
        Date addDate = (Date) window.getTblSearch().getModel().getValueAt(rowNum, 7);

        Book updatedata = new Book(userid, name, isbn, author, publisher, noBooks, name, (java.sql.Date) addDate);
        if (updateCheckForNull(updatedata)) {
            book.updateBook(updatedata);
        }
    }

    private void deleteId() {
        int rowNum = window.getTblSearch().getSelectedRow();
        int userid = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);

        if (book.removeBook(userid)) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry deleted", "Successful", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry not deleted", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        }
    }

}
