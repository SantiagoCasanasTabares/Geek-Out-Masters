package myProject;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFondo extends JPanel  {

    private static final String AYUDA = "Aquí se explicará el juego.";

    private JButton salir, ayuda, inicio;
    private ImageIcon fondo, fondoTitulo, dados;
    private Header titulo;
    private JButton dado1,dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private JPanel dadosInactivos, dadosUsados, dadosEnJuego, panelResultados;
    private Escucha escucha;
    private JTextArea mensajeSalida, Puntaje;


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

        //set up components

        //dados
        dados = new ImageIcon(getClass().getResource("/recursos/42.png"));
        dado1 = new JButton();
        dado1.setIcon(dados);
        dado1.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado2 = new JButton();
        dado2.setIcon(dados);
        dado2.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado3 = new JButton();
        dado3.setIcon(dados);
        dado3.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado4 = new JButton();
        dado4.setIcon(dados);
        dado4.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado5 = new JButton();
        dado5.setIcon(dados);
        dado5.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado6 = new JButton();
        dado6.setIcon(dados);
        dado6.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado7 = new JButton();
        dado7.setIcon(dados);
        dado7.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado8 = new JButton();
        dado8.setIcon(dados);
        dado8.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado9 = new JButton();
        dado9.setIcon(dados);
        dado9.setMargin(new Insets(0, 0, 0, 0));
        //--------------------
        dado10 = new JButton();
        dado10.setIcon(dados);
        dado10.setMargin(new Insets(0, 0, 0, 0));


        //titulo
        fondoTitulo = new ImageIcon(getClass().getResource("/recursos/titulo.jpg"));
        titulo = new Header(fondoTitulo);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        this.add(titulo,constraints); //Change this line if you change JFrame Container's Layout



        //dados Usados
        dadosUsados = new JPanel();
        dadosUsados.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledBorderUsados = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados usados", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosUsados.setBorder(titledBorderUsados);
        titledBorderUsados.setTitleColor(Color.WHITE);
        dadosUsados.setOpaque(false);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        //constraints.gridheight=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(dadosUsados, constraints);



        //dados inactivos
        dadosInactivos = new JPanel();
        dadosInactivos.setPreferredSize(new Dimension(388,260));
        TitledBorder titledInactivos = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados inactivos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosInactivos.setBorder(titledInactivos);
        titledInactivos.setTitleColor(Color.WHITE);
        dadosInactivos.setOpaque(false);
        dadosInactivos.add(dado1);
        dadosInactivos.add(dado2);
        dadosInactivos.add(dado3);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(dadosInactivos,constraints);

        //dados en juego
        dadosEnJuego = new JPanel();
        dadosEnJuego.setPreferredSize(new Dimension(388,260));
        TitledBorder titledDadosJuego = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados en juego", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosEnJuego.setBorder(titledDadosJuego);
        titledDadosJuego.setTitleColor(Color.WHITE);
        dadosEnJuego.setOpaque(false);
        dadosEnJuego.add(dado4);
        dadosEnJuego.add(dado5);
        dadosEnJuego.add(dado6);
        dadosEnJuego.add(dado7);
        dadosEnJuego.add(dado8);
        dadosEnJuego.add(dado9);
        dadosEnJuego.add(dado10);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(dadosEnJuego,constraints);

        //Mensaje de inicio
        mensajeSalida = new JTextArea(12, 31);
        mensajeSalida.setText(AYUDA);
        JScrollPane scroll = new JScrollPane(mensajeSalida);
        mensajeSalida.setEditable(false);

        //panel de resultados
        panelResultados = new JPanel();
        panelResultados.setPreferredSize(new Dimension(388,260));
        TitledBorder titledPanelResultados = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Resultados", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        panelResultados.setBorder(titledPanelResultados);
        titledPanelResultados.setTitleColor(Color.WHITE);
        panelResultados.setOpaque(false);
        panelResultados.add(scroll, BorderLayout.CENTER);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelResultados,constraints);

        //puntaje
        Puntaje = new JTextArea(6, 31);



        //boton de salir
        salir = new JButton("salir");
        salir.addActionListener(escucha);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        add(salir, constraints);


        //ayuda
        ayuda = new JButton("ayuda");
        ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        add(ayuda, constraints);

        //inicio
        inicio = new JButton("Inicio");
        inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inicio.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        add(inicio, constraints);






    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

    }
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==ayuda) {
                JOptionPane.showMessageDialog(null, "hola");

                    }else if (e.getSource()==salir) {
                        System.exit(0);

                         }else if (e.getSource()==inicio) {
                            panelResultados.removeAll();
                            panelResultados.add(mensajeSalida);
                            panelResultados.add(Puntaje);
                            mensajeSalida.setText("Aquí se dicen la ronda que va");
                            mensajeSalida.setRows(6);
                            Puntaje.setText("Aquí se dirá el puntaje que lleva el jugador");
            }

        }
    }


}

