package Controller;

import DataAccess.EmployeePersistantDAO;
import Model.Employee;
import View.AppDetails;
import View.SignupUserWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Wishwa
 */
public class AddUserWindowControl {

    EmployeePersistantDAO emp;
    SignupUserWindow window;

    public AddUserWindowControl(SignupUserWindow window) {

        emp = new EmployeePersistantDAO();
        this.window = window;
        initialize();
        control();
    }

    public void control() {

        window.getBtnSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize();
                SignUp();
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

    private void SignUp() {

        int id = Integer.parseInt(window.getTxtId().getText());
        String name = window.getTxtName().getText();
        String contactno = window.getTxtContactNumber().getText();
        String address = window.getTxtAddress().getText();
        String username = window.getTxtUserName().getText();
        String password = window.getTxtPassword().getText();
        String access = window.getTxtClearance().getText();

        Employee employee = new Employee(id, name, contactno, address, username, password, access);
        emp.addEmployee(employee);

        if (employee != null) {
            // System.out.println("added in controller");
            JOptionPane.showMessageDialog(window.getComponent(0), "User Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "User  not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
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
            e.printStackTrace();
        }
    }

}
