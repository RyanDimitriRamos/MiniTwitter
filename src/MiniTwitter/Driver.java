package MiniTwitter;


import MiniTwitter.GUI.ApplicationWindow;

public class Driver {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationWindow applicationWindow = ApplicationWindow.getInstance();
            }
        });
    }
}
