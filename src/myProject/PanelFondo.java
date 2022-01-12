package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelFondo extends JPanel {

    private ImageIcon imagenFondo;

    public PanelFondo() {
        this.setSize(776, 571);
        imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondo.jpg"));
    }



    @Override
    public void paint(Graphics fondo){
        fondo.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);//si quito esta linea no muestra fondo

        super.paint(fondo);
    }

}
