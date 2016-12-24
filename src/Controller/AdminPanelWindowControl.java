package Controller;

import DataAccess.EmployeePersistantDAO;
import View.AddBookWindow;
import View.AdminPanelWindow;
import View.AppDetails;
import View.AddMemberWindow;
import View.BorrowBookWindow;
import View.ReturnBookWindow;
import View.ViewUserWindow;
import View.AddUserWindow;
import View.ViewBookWindow;
import View.ViewMemberWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Wishwa
 */
public class AdminPanelWindowControl {

    EmployeePersistantDAO emp;
    AdminPanelWindow window;

    public AdminPanelWindowControl(AdminPanelWindow window) {
        emp = new EmployeePersistantDAO();
        this.window = window;
        initialize();
        securityControl();
        control();
    }

    public void control() {

        window.getBtnAddUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupUserPage();
                /*
                    Replace the exception with the relavent action methods
                 */
            }
        });

        window.getBtnSearchUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUserPage();
                /*
                    Replace the exception with the relavent action methods
                 */
            }
        });

        window.getBtnAddBook().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookPage();

                /*
                    Replace the exception with the relavent action methods
                 */
            }

        });

        window.getBtnSearchBook().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBookPage();
                /*
                    Replace the exception with the relavent action methods
                 */
            }
        });

        window.getBtnAddMember().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupMemberPage();
                /*
                    Replace the exception with the relavent action methods
                 */
            }
        });

        window.getBtnSearchMember().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMemberPage();
                /*
                    Replace the exception with the relavent action methods
                 */
            }
        });

        window.getBtnBorrowBook().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowPage();
            }
        });

        window.getBtnReturnBook().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnPage();
            }
        });
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

    private void securityControl() {
        String access = AppDetails.loggedOnUser.getUserAccess().toLowerCase();
        if (access.equals("admin")) {
        } else {
            window.getBtnAddUser().setEnabled(false);
            window.getBtnAddBook().setEnabled(false);
        }

    }

    private void signupUserPage() {

        // window.dispose();
        AddUserWindow newWindow = new AddUserWindow();
        AddUserWindowControl controller = new AddUserWindowControl(newWindow);
        newWindow.setVisible(true);
    }

    private void searchUserPage() {
        // window.dispose();
        ViewUserWindow newWindow = new ViewUserWindow();
        ViewUserWindowControl controller = new ViewUserWindowControl(newWindow);
        newWindow.setVisible(true);

    }

    private void signupMemberPage() {

        // window.dispose();
        AddMemberWindow newWindow = new AddMemberWindow();
        AddMemberWindowControl controller = new AddMemberWindowControl(newWindow);
        newWindow.setVisible(true);
    }

    private void viewMemberPage() {
        // window.dispose();
        ViewMemberWindow newWindow = new ViewMemberWindow();
        ViewMemberWindowControl controller = new ViewMemberWindowControl(newWindow);
        newWindow.setVisible(true);

    }

    private void addBookPage() {

        // window.dispose();
        AddBookWindow newWindow = new AddBookWindow();
        AddBookWindowControl controller = new AddBookWindowControl(newWindow);
        newWindow.setVisible(true);
    }

    private void viewBookPage() {
        // window.dispose();
        ViewBookWindow newWindow = new ViewBookWindow();
        ViewBookWindowControl controller = new ViewBookWindowControl(newWindow);
        newWindow.setVisible(true);

    }

    private void borrowPage() {
        // window.dispose();
        BorrowBookWindow newWindow = new BorrowBookWindow();
        BorrowBookWindowControl controller = new BorrowBookWindowControl(newWindow);
        newWindow.setVisible(true);

    }

    private void returnPage() {
        // window.dispose();
        ReturnBookWindow newWindow = new ReturnBookWindow();
        ReturnBookWindowControl controller = new ReturnBookWindowControl(newWindow);
        newWindow.setVisible(true);

    }

}
