package Controller;

import DataAccess.GuarantorPersistantDAO;
import Model.Guarantor;
import View.AppDetails;
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
public class ViewGuarantorWindowControl {

    GuarantorPersistantDAO emp;
    ViewGuarantorWindow window;

    public ViewGuarantorWindowControl(ViewGuarantorWindow window) {
        emp = new GuarantorPersistantDAO();
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
            Guarantor searchdata = emp.searchGuarantorById(Id);
            if (searchCheckForNull(searchdata)) {
                try {
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuarantorId(), 0, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuarantorName(), 0, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuarantorContactNo(), 0, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.getGuarantorAddress(), 0, 3);
                    window.getTblSearch().getModel().setValueAt(searchdata.getFk_memberId(), 0, 4);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (window.getCheckGuarantorName().isSelected()) {
            String Name = window.getTxtSearchUser().getText();
            ArrayList<Guarantor> searchdata = emp.searchGuarantorByName(Name);
            if (searchCheckForNull(searchdata)) {
                for (int i = 0; i < searchdata.size(); i++) {
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuarantorId(), i, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuarantorName(), i, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuarantorContactNo(), i, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getGuarantorAddress(), i, 3);
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

        Guarantor updatedata = new Guarantor(Id, Name, ContactNo, Address, fk_memberId);
        if (updateCheckForNull(updatedata)) {
            emp.updateGuarantor(updatedata);
        }
    }

    private void deleteId() {
        int rowNum = window.getTblSearch().getSelectedRow();
        int Id = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);

        if (emp.deleteGuarantor(Id)) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry deleted", "Successful", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry not deleted", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        }
    }

}
