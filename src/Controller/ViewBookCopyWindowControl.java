package Controller;

import DataAccess.BookCopyPersistantDAO;
import DataAccess.GuarantorPersistantDAO;
import Model.BookCopy;
import Model.Guarantor;
import View.AppDetails;
import View.ViewBookCopyWindow;
import View.ViewGuarantorWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Wishwa
 */
public class ViewBookCopyWindowControl {

    BookCopyPersistantDAO copy;
    ViewBookCopyWindow window;

    public ViewBookCopyWindowControl(ViewBookCopyWindow window) {
        copy = new BookCopyPersistantDAO();
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

        window.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchId();
            }
        });

        window.getBtnUpdateBookCopy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateId();
            }
        });

        window.getBtnDeleteBookCopy().addActionListener(new ActionListener() {
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

        if (window.getCheckBookCopyId().isSelected()) {
            int Id = Integer.parseInt(window.getTxtSearchBookCopy().getText());
            BookCopy searchdata = copy.searchBookCopyById(Id);
            if (searchCheckForNull(searchdata)) {
                try {
                    window.getTblSearch().getModel().setValueAt(searchdata.getBookcopyId(), 0, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.getBookcopyName(), 0, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.getBookId(), 0, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.isBookcopyStatus(), 0, 3);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (window.getCheckBookCopyName().isSelected()) {
            String Name = window.getTxtSearchBookCopy().getText();
            ArrayList<BookCopy> searchdata = copy.searchBookCopyByName(Name);
            if (searchCheckForNull(searchdata)) {
                for (int i = 0; i < searchdata.size(); i++) {
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getBookcopyId(), i, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getBookcopyName(), i, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getBookId(), i, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).isBookcopyStatus(), i, 3);

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
        int bookcopyId = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);
        String bookcopyName = (String) window.getTblSearch().getModel().getValueAt(rowNum, 1);
        String bookId = (String) window.getTblSearch().getModel().getValueAt(rowNum, 2);
        boolean status = (boolean) window.getTblSearch().getModel().getValueAt(rowNum, 3);

        BookCopy updatedata = new BookCopy(bookcopyId, bookcopyName, status, bookId);
        if (updateCheckForNull(updatedata)) {
            copy.updateBookCopy(updatedata);
        }
    }

    private void deleteId() {
        int rowNum = window.getTblSearch().getSelectedRow();
        int Id = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);

        if (copy.removeBookCopy(Id)) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry deleted", "Successful", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry not deleted", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        }
    }

}
