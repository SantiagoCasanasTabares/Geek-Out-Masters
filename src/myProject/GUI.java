package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame  {

    private static final String AYUDA = "Aqí se explicará el juego.";

    private Header headerProject;
    private ImageIcon fondoTitulo, imagenFondo;
    private PanelFondo fondo;
    private JButton salir;
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("geek out");
        this.setSize(770,630);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout

//----------------------------------------------------------------------------------------------------------------------

        //Create Listener Object and Control Object
        escucha = new Escucha();

//----------------------------------------------------------------------------------------------------------------------
        //Set up JComponents


        //titulo
        fondoTitulo = new ImageIcon(getClass().getResource("/recursos/titulo.jpg"));
        headerProject = new Header(fondoTitulo);
        this.add(headerProject, BorderLayout.NORTH);

        //fondo
        fondo = new PanelFondo();
        this.add(fondo, BorderLayout.CENTER);
        this.pack();







    }

    @Override
    public void paint(Graphics fondo) {
        imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondo.jpg"));
        fondo.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);

        super.paintComponents(fondo);
    }




    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends MouseAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==fondo.boton){
                System.exit(0);
            }
        }
    }
}
