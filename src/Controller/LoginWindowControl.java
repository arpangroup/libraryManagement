package Controller;

import DataAccess.EmployeePersistantDAO;
import Model.Employee;
import View.AdminPanelWindow;
import View.AppDetails;
import View.LoginWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Wishwa
 */
public class LoginWindowControl {

    EmployeePersistantDAO emp;
    LoginWindow window;

    public LoginWindowControl(LoginWindow window) {
        emp = new EmployeePersistantDAO();
        this.window = window;
    }

    private void login() {
        String username = window.getTxtUsername().getText();
        String password = window.getTxtPassword().getText();
        try {
            Employee e = emp.loginEmployee(username, password);
            if (emp.loginEmployee(username, password) != null) {
                AppDetails.loggedOnUser = e;
                AdminPanelWindow newWindow = new AdminPanelWindow();
                AdminPanelWindowControl newController = new AdminPanelWindowControl(newWindow);
                window.dispose();
                newWindow.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(window.getComponent(0), "Username or password not match!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void control() {
        window.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

}
