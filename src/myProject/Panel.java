package myProject;

import javax.swing.*;

public class Panel extends JPanel {

    JLabel fondo;

    public Panel() {
        fondo = new JLabel(new ImageIcon(getClass().getResource("/recursos/fondo.jpg")));
        this.add(fondo);
    }

}
