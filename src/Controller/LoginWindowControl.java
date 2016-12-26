package Controller;

import DataAccess.EmployeePersistantDAO;
import Model.Employee;
import View.AdminPanelWindow;
import View.AppDetails;
import View.LoginWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wishwa
 */
public class LoginWindowControl implements Serializable {

    EmployeePersistantDAO emp;
    LoginWindow window;
    ArrayList<Employee> Elist = null;
    String filename = "E:\\asgn\\check1.txt";

    public LoginWindowControl(LoginWindow window) {
        emp = new EmployeePersistantDAO();
        this.window = window;
    }

    private void login() {
        String username = window.getTxtUsername().getText();
        String password = String.valueOf(window.getTxtPassword().getPassword());
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

    public void serialize(ArrayList<Employee> Elist, String filename) {
        try {
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(new FileOutputStream(filename));
                out.writeObject(Elist);
                System.out.println("testing serialize "+Elist);

            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginWindowControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Employee> deserialize(String filename) throws ClassNotFoundException, IOException {
        ArrayList<Employee> eList = null;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filename));

        } catch (Exception ex) {
            System.out.println("method");
            ex.printStackTrace();

        }
        eList = (ArrayList<Employee>) in.readObject();
        in.close();
        return eList;
    }

    public void control() {
        window.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
                serialize(Elist, filename);
                ArrayList<Employee> eListnw = null;
                try {
                    eListnw = (ArrayList<Employee>) deserialize(filename);

                } catch (ClassNotFoundException | IOException ex) {
                    System.out.println("control");
                    Logger.getLogger(LoginWindowControl.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

}
