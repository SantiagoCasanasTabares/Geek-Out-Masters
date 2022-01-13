package myProject;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFondo extends JPanel  {

    private JButton boton;
    private ImageIcon fondo, fondoTitulo, dados;
    private Header titulo;
    private JPanel dadosInactivos, dadosUsados;
    private JLabel dadoSinUso;


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


        //set up components
        fondoTitulo = new ImageIcon(getClass().getResource("/recursos/titulo.jpg"));
        titulo = new Header(fondoTitulo);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        this.add(titulo,constraints); //Change this line if you change JFrame Container's Layout


        //dados
        dados = new ImageIcon(getClass().getResource("/recursos/42.png"));
        dadoSinUso = new JLabel(dados);


        //dados Usados
        dadosUsados = new JPanel();
        dadosUsados.setPreferredSize(new Dimension(388, 260));
        TitledBorder titledBorder = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Dados Inactivos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        dadosUsados.setBorder(titledBorder);
        titledBorder.setTitleColor(Color.WHITE);
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
        dadosInactivos.setBorder(titledBorder);
        titledBorder.setTitleColor(Color.WHITE);
        dadosInactivos.setOpaque(false);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        //constraints.gridheight=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(dadosInactivos,constraints);




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

