package Controller;

import DataAccess.MemberPersistantDAO;
import Model.Member;
import View.AppDetails;
import View.AddGuarantorWindow;
import View.AddMemberWindow;
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
public class AddMemberWindowControl {

    MemberPersistantDAO mem;
    AddMemberWindow window;

    public AddMemberWindowControl(AddMemberWindow window) {

        mem = new MemberPersistantDAO();
        this.window = window;
        setID();
        initialize();
        control();
    }

    public void control() {

        window.getBtnSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        window.getTxtContactNumber().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (!txtValidate(window.getTxtContactNumber().getText(),e.getKeyChar(),10)) {
                    e.consume();
                }
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

        int id = Integer.parseInt(window.getLblId().getText());
        String name = window.getTxtName().getText();
        String contactno = window.getTxtContactNumber().getText();
        String address = window.getTxtAddress().getText();
        boolean memberStatus = window.getCheckMemberStatus().isSelected();

        Member member = new Member(id, name, contactno, address, memberStatus);
        mem.addMember(member);

        if (member != null) {
            JOptionPane.showMessageDialog(window.getComponent(0), "Member Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(window.getComponent(0), "Member not Added!", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean txtValidate(String text, char c,int size) {
        if (!Character.isDigit(c)) return false;
        return ((text + c).length() <= size);
    }
    
      private boolean idValidate(char c) {
        return Character.isDigit(c);
    }

       private void setID() {
        window.getLblId().setText(String.valueOf(mem.setId() + 1));
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
