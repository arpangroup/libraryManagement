package Controller;

import DataAccess.GuaranterPersistantDAO;
import Model.Guaranter;
import View.AppDetails;
import View.ViewGuaranterWindow;
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
public class ViewGuaranterWindowControl {

    GuaranterPersistantDAO emp;
    ViewGuaranterWindow window;

    public ViewGuaranterWindowControl(ViewGuaranterWindow window) {
        emp = new GuaranterPersistantDAO();
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

    public void control() {

        window.getBtnSearchGuarantor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchId();
            }
        });

        window.getBtnUpdateGuarantor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateId();
            }
        });

        window.getBtnDeleteGuarantor().addActionListener(new ActionListener() {
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

        if (window.getCheckGuarantorId().isSelected()) {
            int Id = Integer.parseInt(window.getTxtSearchGuarantor().getText());
            Guaranter searchdata = emp.searchGuarantorById(Id);
            if (searchCheckForNull(searchdata)) {
                try {
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuaranterId(), 0, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuaranterName(), 0, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuaranterContactNo(), 0, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuaranterAddress(), 0, 3);
                    window.getTblSearch().getModel().setValueAt(searchdata.getFk_memberId(), 0, 4);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (window.getCheckGuarantorName().isSelected()) {
            String Name = window.getTxtSearchUser().getText();
            ArrayList<Guaranter> searchdata = emp.searchGuarantorByName(Name);
            if (searchCheckForNull(searchdata)) {
                for (int i = 0; i < searchdata.size(); i++) {
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuaranterId(), i, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuaranterName(), i, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuaranterContactNo(), i, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuaranterAddress(), i, 3);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getFk_memberId(), i, 4);

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
        int Id = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);
        String Name = (String) window.getTblSearch().getModel().getValueAt(rowNum, 1);
        String ContactNo = (String) window.getTblSearch().getModel().getValueAt(rowNum, 2);
        String Address = (String) window.getTblSearch().getModel().getValueAt(rowNum, 3);
        String fk_memberId = (String) window.getTblSearch().getModel().getValueAt(rowNum, 4);

        Guaranter updatedata = new Guaranter(Id, Name, ContactNo, Address, fk_memberId);
        if (updateCheckForNull(updatedata)) {
            emp.updateGuarantor(updatedata);
        }
    }

    private void deleteId() {
        int rowNum = window.getTblSearch().getSelectedRow();
        int Id = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);

        if (emp.deleteGuaranter(Id)) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry deleted", "Successful", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry not deleted", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        }
    }

}
