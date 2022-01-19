package myProject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Dado> dadosActivos,dadosUsados,dadosInactivos;
    private String caraDado;
    private Dado dadoSeleccionado1, dadoSeleccionado2;
    private int valorCaraOpuesta, estado, puntos;
    private String estadoToStringRonda[], estadoToStringPuntos[];

    public Model(){
        dadosActivos = new ArrayList<Dado>();
        dadosInactivos = new ArrayList<Dado>();
        dadosUsados = new ArrayList<Dado>();
        dadoSeleccionado1 = new Dado();
        dadoSeleccionado2 = new Dado();
        tiroInicial();
        estado=1;
        estadoToStringRonda = new String[1];
        estadoToStringPuntos = new String[1];



    }

    public void tiroInicial(){
        for(int i=0;i<dadosActivos.size();i++){
            dadosActivos.get(i).getCara();
            System.out.println(dadosActivos.get(i).toString());
            System.out.println("1");
        }
    }




    public void accionesDeLasCaras(){
        if (valorDeLaCara(dadoSeleccionado1)=="Meeple"){
            dadoSeleccionado2.getCara();
        }else if(valorDeLaCara(dadoSeleccionado1)=="Nave"){
            dadosInactivos.add(dadoSeleccionado2);
        }else if(valorDeLaCara(dadoSeleccionado1)=="Superheroe"){
            caraOpuesta(dadoSeleccionado2);
        }
    }

    public String valorDeLaCara(Dado dado){
        if(dado.getCara()==1){
            caraDado= "Meeple";
        }else if(dado.getCara()==2){
            caraDado= "Nave";
        }else if(dado.getCara()==3){
            caraDado= "Superheroe";
        }else if(dado.getCara()==4){
            caraDado= "Corazon";
        }else if(dado.getCara()==5){
            caraDado= "Dragon";
        }else if(dado.getCara()==6){
            caraDado= "42";
        }
        return caraDado;
    }

    private int caraOpuesta(Dado dado2){
        valorCaraOpuesta=dado2.getCara();

        if(valorDeLaCara(dado2)=="Meeple"){
            valorCaraOpuesta=2;
        }else if(valorDeLaCara(dado2)=="Nave"){
            valorCaraOpuesta=1;
        }else if(valorDeLaCara(dado2)=="Superheroe"){
            valorCaraOpuesta=5;
        }else if(valorDeLaCara(dado2)=="Corazon"){
            valorCaraOpuesta=6;
        }else if(valorDeLaCara(dado2)=="Dragon"){
            valorCaraOpuesta=3;
        }else if(valorDeLaCara(dado2)=="42"){
            valorCaraOpuesta=4;
        }
        return valorCaraOpuesta;
    }

    public void mostrarDados() {
        for(int i=0;i<dadosActivos.size();i++) {
            System.out.println(dadosActivos.get(i).toString());
        }
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
