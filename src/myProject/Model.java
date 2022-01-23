package myProject;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Dado dado;
    private boolean ganoPartida, terminoRonda;
    private int valorCaraOpuesta, estado, puntos, ronda, estadoRonda, dadoSalvado;
    private String estadoToStringRonda[], estadoToStringPuntos[];

    public Model(){
        tiroInicial();
        ronda=1;
        dado=new Dado();
        estadoToStringRonda = new String[1];
        estadoToStringPuntos = new String[1];
        ganoPartida=false;
        terminoRonda=false;
        dadoSalvado=0;
    }

    /**
     *
     */
    public void terminaRonda(){
        if(dado.conteoCaraCuatroDos()==dado.dadosActivos.size()){
            terminoRonda=true;
            estadoRonda=1; //la ronda termino porque solo habia dados con cara "42"
            ronda++;
        }else if(dado.conteoDragones()==dado.dadosActivos.size()){
            terminoRonda=true;
            estadoRonda=2; //la ronda termino porque solo habia dados con cara "dragon"
            ronda++;
        }else if(dado.conteoCaraCuatroDos()+dado.conteoDragones()==dado.dadosActivos.size()){
            terminoRonda=true;
            estadoRonda=3;//la ronda termino porque solo hay dados con cara "42" y "dragon"
            ronda++;
        }else if(dado.dadosActivos.size()==1  && dado.dadosInactivos.size()==0){
            terminoRonda=true;
            estadoRonda=4;//la ronda termino porque solo hay un dado en la seccion de dados activos, siendo este ultimo un corazon y la seccion de dados inactivos esta vacia
            ronda++;
        }else if(dado.dadosActivos.size()==1 && dado.dadosActivos.get(0).getCara() != 4){
            terminoRonda=true;
            estadoRonda=5;//la ronda termino porque solo hay un dado ya sea "meeple", "superheroe" o "nave".
            ronda++;
        }else{
            terminoRonda=false;
        }
    }

    /**
     * estado 1: termino la ronda y gano puntos
     * estado 2: termino la ronda y perdio puntos
     * estado 3: gano la partida
     * estado 4: perdio la partida
     */
    public void determinarEstado() {
        terminaRonda();
        if(ronda<5 && estadoRonda==1){
            puntosAcumulados(dado.conteoCaraCuatroDos());
            dado.dadosActivos.clear();
            dado.dadosUsados.clear();
            dado.dadosInactivos.clear();
            tiroInicial();
        }else if((estadoRonda==2 || estadoRonda==3) && ronda<5){
            puntos=0;
            dado.dadosActivos.clear();
            dado.dadosUsados.clear();
            dado.dadosInactivos.clear();
            tiroInicial();
        }else if(puntos>30){}
    }

    public void tiroInicial(){
        for(int i=0;i<dado.dadosActivos.size();i++){
           dado.dadosActivos.get(i).getCara();
           dado.dadosActivos.add(dado.dadosActivos.get(i));
        }for(int j=0; j<dado.dadosInactivos.size();j++){
            dado.dadosInactivos.add(dado.dadosInactivos.get(j));
        }
    }

    public int puntosAcumulados(int cuantosCuatroDos) {
        cuantosCuatroDos = dadoSalvado;

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

    public void dadosSalvados(){
        terminaRonda();
        if(terminoRonda==true && estadoRonda==1){
            dadoSalvado += dado.conteoCaraCuatroDos();
        }
    }

    /*public boolean ganoPartida(int puntaje) {
        puntaje=puntos;
        if (puntaje>30) {
            return true;
        }else{
            return false;
        }
    }*/



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

