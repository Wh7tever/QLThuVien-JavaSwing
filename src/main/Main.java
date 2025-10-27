package main;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import view.LibraryForm;

public class Main {
public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryForm().setVisible(true);
            }
        });
    }
}