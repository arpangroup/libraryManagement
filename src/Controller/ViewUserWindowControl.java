package Controller;

import DataAccess.EmployeePersistantDAO;
import Model.Employee;
import View.AdminPanelWindow;
import View.AppDetails;
import View.ViewUserWindow;
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
public class ViewUserWindowControl {

    EmployeePersistantDAO emp;
    ViewUserWindow window;

    public ViewUserWindowControl(ViewUserWindow window) {
        emp = new EmployeePersistantDAO();
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

        window.getBtnSearchUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchId();
            }
        });

        window.getBtnUpdateUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateId();
            }
        });

        window.getBtnDeleteUser().addActionListener(new ActionListener() {
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
     //   new AdminPanelWindow().setVisible(true);
    }

    private void SearchId() {

        for (int i = window.getTblSearch().getRowCount() - 1; i >= 0; i--) {
            for (int j = window.getTblSearch().getColumnCount() - 1; j >= 0; j--) {
                window.getTblSearch().getModel().setValueAt(null, i, j);
            }
        }

        if (window.getCheckUserId().isSelected()) {
            int Id = Integer.parseInt(window.getTxtSearchUser().getText());
            Employee searchdata = emp.searchEmployeeById(Id);
            if (searchCheckForNull(searchdata)) {
                try {
                    window.getTblSearch().getModel().setValueAt(searchdata.getUserId(), 0, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.getUserName(), 0, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.getUserContactNo(), 0, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.getUserAddress(), 0, 3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (window.getCheckName().isSelected()) {
            String Name = window.getTxtSearchUser().getText();
            ArrayList<Employee> searchdata = emp.searchEmployeeByName(Name);
            if (searchCheckForNull(searchdata)) {
                for (int i = 0; i < searchdata.size(); i++) {
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getUserId(), i, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getUserName(), i, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getUserContactNo(), i, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getUserAddress(), i, 3);
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
        int userid = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);
        String name = (String) window.getTblSearch().getModel().getValueAt(rowNum, 1);
        String contactNo = (String) window.getTblSearch().getModel().getValueAt(rowNum, 2);
        String address = (String) window.getTblSearch().getModel().getValueAt(rowNum, 3);
        String username = null;
        String password = null;
        String access = null;

        Employee updatedata = new Employee(userid, name, contactNo, address, username, password, access);
        if (updateCheckForNull(updatedata)) {
            emp.updateEmployee(updatedata);
        }
    }

    private void deleteId() {
        int rowNum = window.getTblSearch().getSelectedRow();
        int userid = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);

        if (emp.deleteEmployee(userid)) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry deleted", "Successful", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry not deleted", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        }
    }

}
