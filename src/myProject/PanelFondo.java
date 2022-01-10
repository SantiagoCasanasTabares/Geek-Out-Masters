package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelFondo extends JPanel {

    public PanelFondo() {
        this.setSize(776, 571);

    }

    @Override
    public void paint(Graphics fondo){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondo.jpg"));
        fondo.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);

        super.paint(fondo);
    }

}
