package Controller;

import DataAccess.MemberPersistantDAO;
import Model.Employee;
import Model.Member;
import View.AppDetails;
import View.ViewGuarantorWindow;
import View.ViewMemberWindow;
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
public class ViewMemberWindowControl {

    MemberPersistantDAO emp;
    ViewMemberWindow window;

    public ViewMemberWindowControl(ViewMemberWindow window) {
        emp = new MemberPersistantDAO();
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

        window.getBtnViewGuarantor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewGuarantorPage();
            }
        });

    }

    private void Home() {

        window.dispose();
    }

    private void viewGuarantorPage() {
        // window.dispose();
        ViewGuarantorWindow newWindow = new ViewGuarantorWindow();
        ViewGuarantorWindowControl controller = new ViewGuarantorWindowControl(newWindow);
        newWindow.setVisible(true);
        window.dispose();

    }

    private void SearchId() {

        for (int i = window.getTblSearch().getRowCount() - 1; i >= 0; i--) {
            for (int j = window.getTblSearch().getColumnCount() - 1; j >= 0; j--) {
                window.getTblSearch().getModel().setValueAt(null, i, j);
            }
        }

        if (window.getCheckMemberId().isSelected()) {
            int Id = Integer.parseInt(window.getTxtSearchUser().getText());
            Member searchdata = emp.searchMemberById(Id);
            if (searchCheckForNull(searchdata)) {
                try {
                    window.getTblSearch().getModel().setValueAt(searchdata.getMemberId(), 0, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.getMemberName(), 0, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.getMemberContactNo(), 0, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.getMemberAddress(), 0, 3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (window.getCheckMemberName().isSelected()) {
            String Name = window.getTxtSearchUser().getText();
            ArrayList<Member> searchdata = emp.searchMemberByName(Name);
            if (searchCheckForNull(searchdata)) {
                for (int i = 0; i < searchdata.size(); i++) {
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getMemberId(), i, 0);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getMemberName(), i, 1);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getMemberContactNo(), i, 2);
                    window.getTblSearch().getModel().setValueAt(searchdata.get(i).getMemberAddress(), i, 3);
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

        Member updatedata = new Member(Id, Name, ContactNo, Address);
        if (updateCheckForNull(updatedata)) {
            emp.updateMember(updatedata);
        }
    }

    private void deleteId() {
        int rowNum = window.getTblSearch().getSelectedRow();
        int Id = (int) window.getTblSearch().getModel().getValueAt(rowNum, 0);

        if (emp.deleteMember(Id)) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry deleted", "Successful", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(window.getComponent(0), "Entry not deleted", "Unsuccessful", JOptionPane.ERROR_MESSAGE);

        }
    }

}
