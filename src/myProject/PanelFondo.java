package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFondo extends JPanel  {

    private ImageIcon imagenFondo;
    public JButton boton;

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

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            PanelFondo miProjectGUI = new PanelFondo();
        });
    }


}

