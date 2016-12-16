
package View;
            
/**
 *
 * @author Wishwa
 */
import Controller.LoginWindowControl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoginWindow mainWindow = new LoginWindow();
        LoginWindowControl controller = new LoginWindowControl(mainWindow);
        controller.control();
        mainWindow.setVisible(true);
        
    }
}

