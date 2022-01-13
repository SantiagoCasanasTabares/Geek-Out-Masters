package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFondo extends JPanel  {

    private JButton boton;
    private ImageIcon fondo, fondoTitulo;
    private Header titulo;

    public PanelFondo() {
        init();
        fondo = new ImageIcon(getClass().getResource("/recursos/fondo.jpg"));
        setOpaque(false);
        this.setSize(776, 571);
        repaint();



    }

    private void init() {
        //set up layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //set up components
        fondoTitulo = new ImageIcon(getClass().getResource("/recursos/titulo.jpg"));
        titulo = new Header(fondoTitulo);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=0;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(titulo,constraints); //Change this line if you change JFrame Container's Layout

        boton = new JButton("boton");
        constraints.gridx=1;
        constraints.gridy=1;
        this.add(boton,constraints);

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

    }
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==boton) {
                JOptionPane.showMessageDialog(null, "hola");
            }

        }
    }


}

