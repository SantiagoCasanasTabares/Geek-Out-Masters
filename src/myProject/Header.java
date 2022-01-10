package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a kind of JLabel used to create a personalized Header for the project
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version @version v.1.0.0 date:21/11/2021
 */
public class Header extends JLabel {



    /**
     * Constructor of the Header class
     * @param icon image in the tittle
     */
    public Header(Icon icon){
        this.setIcon(icon);
        this.setSize(getWidth(), getHeight());
        this.setForeground(new Color(255,255,255));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
