package myProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PanelFondo extends JPanel {

    private static final String AYUDA = "Bienvenido a Geek Out Masters"
            + "\nEl objetivo de este juego es conseguir la mayor cantidad de puntos"
            + "\njuntando dados cuya cara visible es la cara 42."
            + "\nGeek Out Masters no es solo suerte, también importa la estrategia"
            + "\nya que una vez que se lanzan los dados TODAS las caras deberán ejecutarse:"
            + "\nLas Naves Espaciales los eliminarán."
            + "\nLos Superhéroes revelarán su lado oculto."
            + "\nPor suerte, los Corazones nos brindarán un dado extra"
            + "\nPero también están los Dragones, quienes causan pérdida."
            + "\nEl juego está compuesto por:"
            + "\n¡10 dados de Geek Out!, 1 ayuda memoria, 1 Tarjeta de puntuación.";

    private JButton salir, ayuda, inicio;
    private ImageIcon fondo, fondoTitulo, dados, imagenDado;
    private Icon icono;
    private Model model;
    //private Dado dado;
    private Header titulo;
    private JPanel dadosInactivos, dadosUsados, dadosEnJuego, panelResultados;
    private Escucha escucha;
    private JTextArea mensajeSalida, Puntaje;
    private ArrayList<JLabel> dadosActivosJlabel, dadosInactivosJlabel, dadosUsadosJlabel;


    public PanelFondo() {
        init();
        fondo = new ImageIcon(getClass().getResource("/recursos/fondo.jpg"));
        setOpaque(false);
        this.setSize(getWidth(), getHeight());
        repaint();

    }

    private void init() {
        //set up layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //dado = new Dado();

        //set up Escucha and Action Listener
        escucha = new Escucha();
        model = new Model();

        //set up components

        //titulo
        fondoTitulo = new ImageIcon(getClass().getResource("/recursos/titulo.jpg"));
        titulo = new Header(fondoTitulo);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.add(titulo, constraints); //Change this line if you change JFrame Container's Layout

        //inicializacion de dados activos
        imagenDado = new ImageIcon(getClass().getResource("/recursos/dado.png"));
        icono = new ImageIcon(this.imagenDado.getImage().getScaledInstance(80, 80, 60));
        dadosActivosJlabel = new ArrayList();
        dadosInactivosJlabel = new ArrayList();
        dadosUsadosJlabel = new ArrayList();

        for (int i = 0; i < 7; i++) {
            JLabel labelTemp = new JLabel();
            labelTemp.setIcon(icono);
            dadosActivosJlabel.add(labelTemp);
        }


        //dados Usados
        dadosUsados = new JPanel();
        dadosUsados.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledBorderUsados = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados usados", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosUsados.setBorder(titledBorderUsados);
        titledBorderUsados.setTitleColor(Color.WHITE);
        dadosUsados.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        //constraints.gridheight=1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(dadosUsados, constraints);

        //inicializacion de dados inactivos
        for (int i = 0; i < 3; i++) {
            JLabel labelTemp = new JLabel();
            labelTemp.setIcon(icono);
            dadosInactivosJlabel.add(labelTemp);
        }

        //dados inactivos
        dadosInactivos = new JPanel();
        dadosInactivos.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledInactivos = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados inactivos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosInactivos.setBorder(titledInactivos);
        titledInactivos.setTitleColor(Color.WHITE);
        dadosInactivos.setOpaque(false);

        for (int i = 0; i < dadosInactivosJlabel.size(); i++) {
            dadosInactivos.add(dadosInactivosJlabel.get(i));
        }

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(dadosInactivos, constraints);

        //dados en juego
        dadosEnJuego = new JPanel();
        dadosEnJuego.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledDadosJuego = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados en juego", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosEnJuego.setBorder(titledDadosJuego);
        titledDadosJuego.setTitleColor(Color.WHITE);
        dadosEnJuego.setOpaque(false);

        for (int i = 0; i < dadosActivosJlabel.size(); i++) {
            dadosEnJuego.add(dadosActivosJlabel.get(i));
        }

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(dadosEnJuego, constraints);

        //Mensaje de inicio
        mensajeSalida = new JTextArea(12, 31);
        mensajeSalida.setText(AYUDA);
        JScrollPane scroll = new JScrollPane(mensajeSalida);
        mensajeSalida.setEditable(false);

        //panel de resultados
        panelResultados = new JPanel();
        panelResultados.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledPanelResultados = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Resultados", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        panelResultados.setBorder(titledPanelResultados);
        titledPanelResultados.setTitleColor(Color.WHITE);
        panelResultados.setOpaque(false);
        panelResultados.add(scroll, BorderLayout.CENTER);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelResultados, constraints);

        //puntaje
        Puntaje = new JTextArea(7, 25);


        //boton de salir
        salir = new JButton("salir");
        salir.addActionListener(escucha);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(salir, constraints);


        //ayuda
        ayuda = new JButton("ayuda");
        ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ayuda.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(ayuda, constraints);

        //inicio
        inicio = new JButton("Inicio");
        inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inicio.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(inicio, constraints);


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

    }

    private class Escucha implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, AYUDA);

            } else if (e.getSource() == salir) {
                System.exit(0);

            } else if (e.getSource() == inicio) {
                model.tiroInicial();
                List<Dado> dadosActivos = model.getDadosActivos();
                List<Dado> dadosInactivos = model.getDadosInactivos();

                //pinta las caras de los dados Activos
                for (int i = 0; i < dadosActivos.size(); i++) {
                    imagenDado = new ImageIcon(getClass().getResource("/recursos/" + dadosActivos.get(i).getCara() + ".png"));
                    dadosActivosJlabel.get(i).setIcon(imagenDado);
                    dadosActivosJlabel.get(i).addMouseListener(escucha);
                    dadosActivosJlabel.get(i).setCursor( new Cursor(Cursor.HAND_CURSOR));
                    dadosActivosJlabel.get(i).setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    dadosActivosJlabel.get(i).setBorder(new EmptyBorder(0,15,0,15));
                }

                panelResultados.removeAll();
                panelResultados.add(mensajeSalida);
                panelResultados.add(Puntaje);
                mensajeSalida.setText(model.getEstadoToStringRonda()[0]);
                mensajeSalida.setRows(6);
                mensajeSalida.setColumns(25);
                Puntaje.setText(model.getEstadoToStringPuntos()[0]);
            }
        }


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}