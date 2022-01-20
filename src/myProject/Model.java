package myProject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    public List<Dado> dadosActivos,dadosUsados,dadosInactivos;
    private Dado dado;
    private int valorCaraOpuesta, estado, puntos, ronda;
    private String estadoToStringRonda[], estadoToStringPuntos[];

    public Model(){
        dadosActivos = new ArrayList<Dado>();
        dadosInactivos = new ArrayList<Dado>();
        dadosUsados = new ArrayList<Dado>();
        //dadoSeleccionado1 = new Dado();
        //dadoSeleccionado2 = new Dado();
        tiroInicial();
        estado=1;
        ronda=0;
        estadoToStringRonda = new String[1];
        estadoToStringPuntos = new String[1];



    }

    public void tiroInicial(){
        for(int i=0;i<dadosActivos.size();i++){
            dadosActivos.get(i).getCara();

        }
    }

    public int puntosAcumulados(int cuantosCuatroDos) {
        cuantosCuatroDos = dado.conteoCuatroDos;

        if(cuantosCuatroDos==1) {
            puntos=1;
        }else if (cuantosCuatroDos==2) {
            puntos=3;
        }else if (cuantosCuatroDos==3) {
            puntos=6;
        }else if (cuantosCuatroDos==4) {
            puntos=10;
        }else if (cuantosCuatroDos==5) {
            puntos=15;
        }else if (cuantosCuatroDos==6) {
            puntos=21;
        }else if (cuantosCuatroDos==7) {
            puntos=28;
        }else if (cuantosCuatroDos==8) {
            puntos=36;
        }else if (cuantosCuatroDos==9) {
            puntos=45;
        }else if (cuantosCuatroDos==10) {
            puntos=55;
        }
        return puntos;
    }




    public String[] getEstadoToStringRonda() {
        switch (estado) {
            case 1: estadoToStringRonda[0] = "             RONDA DE JUEGO               "+
                    "Te encuentras en la ronda 1 de Juego, aun "+
                    "tienes 4 rondas mas para lograr 30 puntos.";
                break;
            case 2: estadoToStringRonda[0] = "             RONDA DE JUEGO               "+
                    "Te encuentras en la ronda 2 de Juego, aun "+
                    "tienes 3 rondas mas para lograr 30 puntos.";
                break;
            case 3: estadoToStringRonda[0] = "             RONDA DE JUEGO               "+
                    "Te encuentras en la ronda 3 de Juego, aun "+
                    "tienes 2 rondas mas para lograr 30 puntos.";
                break;
            case 4: estadoToStringRonda[0] = "             RONDA DE JUEGO               "+
                    "Te encuentras en la ronda 4 de Juego, solo "+
                    "tienes 1 ronda mas para lograr 30 puntos.";
                break;
            case 5: estadoToStringRonda[0] = "             RONDA DE JUEGO               "+
                    "Te encuentras en la ronda 5 de Juego, es "+
                    " la ultima ronda para conseguir 30 puntos";
                break;
            case 6: estadoToStringRonda[0] = "             RONDA DE JUEGO               "+
                    "FELICITAIONES!! Ganaste al conseguir "+puntos+" puntos";
                break;
            case 7: estadoToStringRonda[0] = "             RONDA DE JUEGO               "+
                    "Perdiste, solo conseguiste "+puntos+" Y no te quedan "+
                    "mas rondas de juego.";
                break;

        }
        return estadoToStringRonda;
    }

    public String[] getEstadoToStringPuntos() {
        switch (estado) {
            case 1: estadoToStringPuntos[0] = "                      PUNTAJE                    "+
                    "Tienes un tienes un acumulado de "+puntos+" puntos.";
                break;
            case 2: estadoToStringPuntos[0] = "                 PUNTAJE                  "+
                    "Conseguiste un acumulado de "+puntos+" puntos a lo "
                    +"largo del juego. ";
                break;

        }
        return estadoToStringPuntos;
    }

}
