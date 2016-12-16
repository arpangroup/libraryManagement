
package Controller;

import DataAccess.MemberPersistantDAO;
import Model.Member;
import View.AppDetails;
import View.AddGuarantorWindow;
import View.AddMemberWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Wishwa
 */
public class AddMemberWindowControl {

    MemberPersistantDAO emp;
    AddMemberWindow window;

    public AddMemberWindowControl(AddMemberWindow window) {

        emp = new MemberPersistantDAO();
        this.window = window;
        initialize();
        control();
    }

    public void control() {

        window.getBtnSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //initialize();
                SignUp();
            }
        });

        window.getBtnHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home();
            }
        });
        
         window.getBtnAddGuarantor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupGuarantorPage();
            }
        });

    }

    private void Home() {
        window.dispose();

    }
    
       private void signupGuarantorPage() {

       // window.dispose();
        AddGuarantorWindow newWindow = new AddGuarantorWindow();
        AddGuarantorWindowControl controller = new AddGuarantorWindowControl(newWindow);
        newWindow.setVisible(true);
        window.dispose();
    }
    

    private void SignUp() {

        int id = Integer.parseInt(window.getTxtId().getText());
        String name = window.getTxtName().getText();
        String contactno = window.getTxtContactNumber().getText();
        String address = window.getTxtAddress().getText();
       

        Member member = new Member(id, name, contactno, address);
        emp.addMember(member);

        if (member != null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "Member not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
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

                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


