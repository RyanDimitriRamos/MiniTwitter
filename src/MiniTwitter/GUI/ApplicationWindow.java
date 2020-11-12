package MiniTwitter.GUI;

import javax.swing.JFrame;
import java.awt.*;


public class ApplicationWindow extends JFrame {
    private static ApplicationWindow applicationWindow = null;

    private ApplicationWindow(String title){
        super(title);
    }

    public static ApplicationWindow getInstance(){
        if(applicationWindow == null){
            synchronized (ApplicationWindow.class){
                if(applicationWindow == null){
                    applicationWindow = new ApplicationWindow("Mini Twitter");
                    initialize();
                }
            }
        }
        return applicationWindow;
    }
    private static void initialize(){
        AdminControlPanel adminControlPanel = AdminControlPanel.getInstance();
        applicationWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applicationWindow.getContentPane().add(adminControlPanel); //adding the JPanel of the admin to the current JFrame
        applicationWindow.setSize(700,500);
        applicationWindow.setLayout(new BorderLayout());
        applicationWindow.add(adminControlPanel, BorderLayout.CENTER);
        applicationWindow.setLocationRelativeTo(null); //open the app at the center of the screen
        applicationWindow.setVisible(true);
    }
}
