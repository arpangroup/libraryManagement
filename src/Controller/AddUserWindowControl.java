package Controller;

import DataAccess.EmployeePersistantDAO;
import Model.Employee;
import View.AppDetails;
import View.AddUserWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Wishwa
 */
public class AddUserWindowControl {

    EmployeePersistantDAO emp;
    AddUserWindow window;

    public AddUserWindowControl(AddUserWindow window) {

        emp = new EmployeePersistantDAO();
        this.window = window;
        initialize();
        setID();
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

        window.getTxtContactNumber().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (!txtValidate(window.getTxtContactNumber().getText(), e.getKeyChar(), 10)) {
                    e.consume();
                }
            }
        });

    }

    private void Home() {
        window.dispose();

    }

    private void setID() {
        window.getLblId().setText(String.valueOf(emp.setId() + 1));
    }

    private void SignUp() {

        int id = Integer.parseInt(window.getLblId().getText());
        String name = window.getTxtName().getText();
        int contactno = Integer.parseInt(window.getTxtContactNumber().getText());
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

    private boolean txtValidate(String text, char c, int size) {
        if (!Character.isDigit(c)) {
            return false;
        }
        return ((text + c).length() <= size);
    }

    private boolean idValidate(char c) {
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
            e.printStackTrace();
        }
    }

}
