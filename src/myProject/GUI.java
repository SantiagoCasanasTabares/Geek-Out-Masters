package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private static final String AYUDA = "Aqí se explicará el juego.";

    private Header headerProject;
    private Panel panel;
    private ImageIcon fondoTitulo;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("geek out");
        this.setSize(770,535);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*Container contentpane = getContentPane();
        panel = new Panel();
        contentpane.add(panel);*/



    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout

        //Create Listener Object and Control Object
        //Set up JComponents

        //titulo
        fondoTitulo = new ImageIcon(getClass().getResource("/recursos/titulo.jpg"));
        headerProject = new Header(fondoTitulo);
        this.add(headerProject, BorderLayout.NORTH);


        //fondo

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
    private class Escucha {

    }
}
