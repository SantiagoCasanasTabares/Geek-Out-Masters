package myProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for ...
 * @autor Luisa Maria Cardenas Lopez 1823494 cardenas.luisa@correounivalle.edu.co
 * @autor Santiago Casañas Tabares 2025301 santiago.casanas@correpunivalle.edu.co
 * @autor Jesus Adrian Peña Guetio 2025513 jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:28/01/2022
 */

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
    private List<Dado> dadosActivos, dadosUtilizados, dadosInactivos;
    private Header titulo;
    private JPanel dadosInactivosPanel, dadosUsadosPanel, dadosEnJuego, panelResultados;
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

        //set up Escucha and Action Listener
        escucha = new Escucha();
        model = new Model();
        dadosActivosJlabel = new ArrayList();
        dadosInactivosJlabel = new ArrayList();
        dadosUsadosJlabel = new ArrayList();

        //botones
        salir = new JButton("salir");
        ayuda = new JButton("ayuda");

        //paneles
        dadosUsadosPanel = new JPanel();
        dadosInactivosPanel = new JPanel();
        dadosEnJuego = new JPanel();
        panelResultados = new JPanel();

        imagenDado = new ImageIcon(getClass().getResource("/recursos/dado.png"));
        icono = new ImageIcon(this.imagenDado.getImage().getScaledInstance(80, 80, 60));

        //LISTAS DE DADOS
        dadosActivos = model.getDadosActivos();
        dadosUtilizados = model.getDadosUsados();
        dadosInactivos = model.getDadosInactivos();


        //titulo
        fondoTitulo = new ImageIcon(getClass().getResource("/recursos/titulo.jpg"));
        titulo = new Header(fondoTitulo);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.add(titulo, constraints); //Change this line if you change JFrame Container's Layout


        //creación de labels para panel de dados activos
        for (int i = 0; i < 7; i++) {
            JLabel labelTemp = new JLabel();
            labelTemp.addMouseListener(escucha);
            labelTemp.setCursor( new Cursor(Cursor.HAND_CURSOR));
            labelTemp.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            labelTemp.setBorder(new EmptyBorder(0,15,0,15));
            dadosActivosJlabel.add(labelTemp);
        }

        //PINTAR DADOS INICIALES
        pintarDados(dadosActivos, dadosActivosJlabel);

        //PANEL DADOS USADOS
        dadosUsadosPanel.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledBorderUsados = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados usados", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosUsadosPanel.setBorder(titledBorderUsados);
        titledBorderUsados.setTitleColor(Color.WHITE);
        dadosUsadosPanel.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        //constraints.gridheight=1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(dadosUsadosPanel, constraints);

        //inicializacion de dados inactivos
        for (int i = 0; i < 3; i++) {
            JLabel labelTemp = new JLabel();
            labelTemp.setIcon(icono);
            dadosInactivosJlabel.add(labelTemp);
        }

        //PANEL DADOS INACTIVOS
        dadosInactivosPanel.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledInactivos = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados inactivos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosInactivosPanel.setBorder(titledInactivos);
        titledInactivos.setTitleColor(Color.WHITE);
        dadosInactivosPanel.setOpaque(false);

        agregarLabelsPanel(dadosInactivosJlabel, dadosInactivosPanel);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(dadosInactivosPanel, constraints);


        //PANEL DADOS EN JUEGO
        dadosEnJuego.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledDadosJuego = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados en juego", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosEnJuego.setBorder(titledDadosJuego);
        titledDadosJuego.setTitleColor(Color.WHITE);
        dadosEnJuego.setOpaque(false);

        //agregamos labels al panel de Dados en juego
        agregarLabelsPanel(dadosActivosJlabel, dadosEnJuego);

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

        //PANEL DE RESULTADOS
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
        salir.addActionListener(escucha);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(salir, constraints);


        //ayuda
        ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ayuda.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(ayuda, constraints);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

    }

    //pinta los dados ingresados
    public void agregarLabelsPanel(ArrayList<JLabel> labels, JPanel panel){
        for (int i = 0; i < labels.size(); i++) {
            panel.add(labels.get(i));
        }
    }

    //pinta los dados ingresados
    public void pintarDados(List<Dado> dados, ArrayList<JLabel> labels){
        for (int i = 0; i < dados.size(); i++) {
            imagenDado = new ImageIcon(getClass().getResource("/recursos/" + dados.get(i).getCara() + ".png"));
            labels.get(i).setIcon(imagenDado);
        }
    }

    private class Escucha implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, AYUDA);

            } else if (e.getSource() == salir) {
                System.exit(0);
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
            for(int i = 0; i < dadosActivosJlabel.size(); i++) {
                if (dadosActivosJlabel.get(i) == e.getSource()) {
                    //usar dado
                    model.usarDado(dadosActivos.get(i));
                    //quitamos icono del label
                    dadosActivosJlabel.get(i).setIcon(null);
                    //quitamos label del panel
                    dadosEnJuego.remove(dadosActivosJlabel.get(i));
                    //quitamos el label
                    dadosActivosJlabel.remove(i);
                    //actualizamos nuestras variables para pintar las de nuevo y actualizar el tablero
                    dadosUtilizados = model.getDadosUsados();
                    dadosActivos = model.getDadosActivos();
                    dadosInactivos = model.getDadosInactivos();

                    JLabel labelUsadoTemp = new JLabel();
                    dadosUsadosJlabel.add(labelUsadoTemp);
                    agregarLabelsPanel(dadosUsadosJlabel, dadosUsadosPanel);


                    //JLabel labelInactivoTemp = new JLabel();
                    //dadosInactivosPanel.add(labelInactivoTemp);

                    agregarLabelsPanel(dadosUsadosJlabel, dadosUsadosPanel);
                    pintarDados(dadosUtilizados, dadosUsadosJlabel);
                    //pintarDados(dadosInactivos, dadosInactivosJlabel);
                    pintarDados(dadosActivos, dadosActivosJlabel);
                }
            }
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