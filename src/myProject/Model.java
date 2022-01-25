package myProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private Dado dado, dadoSeleccionado1, dadoSeleccionado2, dadoRelanzado, añadirDado;
    private boolean ganoPartida, terminoRonda;
    private int  estado, puntos, ronda, estadoRonda, dadoSalvado, stringPuntos, stringRonda, valorCaraOpuesta, conteoCuatroDos, conteoDragon;
    private String estadoToStringRonda[], estadoToStringPuntos[];
    private List<Dado> dadosActivos,dadosUsados,dadosInactivos;
    Random aleatorio=new Random();

    public Model(){
        //tiroInicial();
        ronda=1;
        dado=new Dado();
        estadoToStringRonda = new String[1];
        estadoToStringPuntos = new String[1];
        ganoPartida=false;
        terminoRonda=false;
        dadoSalvado=0;
        dadosActivos = new ArrayList();
        dadosInactivos = new ArrayList();
        dadosUsados = new ArrayList();


        //Creacion de dados activos
        for (int i = 0; i<7; i++){
            Dado dadoTemporal = new Dado();
            dadosActivos.add(dadoTemporal);
        }

        //Creacion de dados inactivos
        for (int i = 0; i<3; i++){
            Dado dadoTemporal = new Dado();
            //dadoTemporal.setCara(aleatorio.nextInt(6)+1);
            dadosInactivos.add(dadoTemporal);
        }
        dadosUsados = new ArrayList<Dado>();
        dadoSeleccionado1 = new Dado();
        dadoSeleccionado2 = new Dado();
        añadirDado = new Dado();
        dadoRelanzado = new Dado();


    }

    /**
     *Para saber si la ronda ha finalizado
     *
     */
    public void terminaRonda(){
        if(conteoCaraCuatroDos()==dadosActivos.size()){
            terminoRonda=true;
            estadoRonda=1; //la ronda termino porque solo habia dados con cara "42"
            ronda++;
            dadoSalvado += conteoCaraCuatroDos();
        }else if(conteoDragones()==dadosActivos.size()){
            terminoRonda=true;
            estadoRonda=2; //la ronda termino porque solo habia dados con cara "dragon"
            ronda++;
        }else if(conteoCaraCuatroDos()+conteoDragones()==dadosActivos.size()){
            terminoRonda=true;
            estadoRonda=3; //la ronda termino porque solo hay dados con cara "42" y "dragon"
            ronda++;
        }else if(dadosActivos.size()==1  && dadosInactivos.size()==0){
            terminoRonda=true;
            estadoRonda=4; //la ronda termino porque solo hay un dado en la seccion de dados activos, siendo este ultimo un corazon y la seccion de dados inactivos esta vacia
            ronda++;
        }else if(dadosActivos.size()==1 && dadosActivos.get(0).getCara() != 4){
            terminoRonda=true;
            estadoRonda=5; //la ronda termino porque solo hay un dado ya sea "meeple", "superheroe" o "nave".
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
            puntosAcumulados();
            dadosActivos.clear();
            dadosUsados.clear();
            dadosInactivos.clear();
            tiroInicial();
            stringPuntos=1;
            estado=1;
            determinarRondaToString();
        }else if((estadoRonda==2 || estadoRonda==3) && ronda<5){
            puntos=0;
            dadoSalvado=0;
            dadosActivos.clear();
            dadosUsados.clear();
            dadosInactivos.clear();
            tiroInicial();
            stringPuntos=1;
            estado=2;
            determinarRondaToString();
        }else if(ganoPartida()){
            stringRonda=6;
            stringPuntos=2;
        }else if(ganoPartida()==false && ronda==5){
            stringRonda=7;
            stringPuntos=2;
        }
    }

    /**
     * Para igualar el stringRonda al numero de ronda que se esta jugando, y asi usar el switch para decir la ronda
     */
    public void determinarRondaToString() {
        if(estado== 1 ||estado==2){
            stringRonda=ronda;
        }
    }

    /**
     * getter de los dados activos
     * @return
     */
    public List<Dado> getDadosActivos() {
        return dadosActivos;
    }

    public List<Dado> getDadosInactivos() {
        return dadosInactivos;
    }

    /**
     * Inicializa los dados activos y los dados inactivos
     */
    public void tiroInicial(){
        for(int i=0;i<dadosActivos.size();i++){
            dadosActivos.get(i).setCara(aleatorio.nextInt(6)+1);
            //dadosActivos.add(dadosActivos.get(i));
        }
        /*for(int j=0; j<dadosInactivos.size();j++){
            dadosInactivos.add(dadosInactivos.get(j));
        }*/
    }

    /**
     * Midfica el puntaje dde acuedo a los dados que se hayan salvado a lo largo de la partida
     * @return puntos
     */
    public int puntosAcumulados() {
        if(dadoSalvado==1) {
            puntos=1;
        }else if (dadoSalvado==2) {
            puntos=3;
        }else if (dadoSalvado==3) {
            puntos=6;
        }else if (dadoSalvado==4) {
            puntos=10;
        }else if (dadoSalvado==5) {
            puntos=15;
        }else if (dadoSalvado==6) {
            puntos=21;
        }else if (dadoSalvado==7) {
            puntos=28;
        }else if (dadoSalvado==8) {
            puntos=36;
        }else if (dadoSalvado==9) {
            puntos=45;
        }else if (dadoSalvado==10) {
            puntos=55;
        }
        return puntos;
    }

    /**
     * para ir sumando los dados salvados cuando se gana la ronda
     */
    public void dadosSalvados(){
        terminaRonda();
        if(terminoRonda==true && estadoRonda==1){
            dadoSalvado += conteoCaraCuatroDos();
        }
    }

    /**
     * Para saber cuando se gana la partida
     * @return boolean
     */
    public boolean ganoPartida() {
        if (puntosAcumulados()>30) {
            return true;
        }else{
            return false;
        }
    }


    /**
     * Para realizar las acciones de cada cara del dado
     */
    public void accionesDeLasCaras(){

        if (dado.valorDeLaCara(dadoSeleccionado1)=="Meeple"){
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);
            relanzarDado(dadoSeleccionado2);

        }else if(dado.valorDeLaCara(dadoSeleccionado1)=="Nave"){
            dadosInactivos.add(dado);
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);

        }else if(dado.valorDeLaCara(dadoSeleccionado1)=="Superheroe"){
            caraOpuesta(dadoSeleccionado2);
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);

        }else if(dado.valorDeLaCara(dadoSeleccionado1)=="Corazon"){
            dadoExtra();
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);
        }
    }


    /**
     * funciona como superheroe para asi voltear un dado
     * @param dadoAVoltear
     * @return valor de la cara opuesta del dado - cara contraria del dado
     */
    public int caraOpuesta(Dado dadoAVoltear){
        valorCaraOpuesta=dadoAVoltear.getCara();

        if(dado.valorDeLaCara(dadoAVoltear)=="Meeple"){
            valorCaraOpuesta=2;
        }else if(dado.valorDeLaCara(dadoAVoltear)=="Nave"){
            valorCaraOpuesta=1;
        }else if(dado.valorDeLaCara(dadoAVoltear)=="Superheroe"){
            valorCaraOpuesta=5;
        }else if(dado.valorDeLaCara(dadoAVoltear)=="Corazon"){
            valorCaraOpuesta=6;
        }else if(dado.valorDeLaCara(dadoAVoltear)=="Dragon"){
            valorCaraOpuesta=3;
        }else if(dado.valorDeLaCara(dadoAVoltear)=="42"){
            valorCaraOpuesta=4;
        }
        return valorCaraOpuesta;
    }

    //meeple
    public void relanzarDado(Dado dadoARelanzar) {
        dadosActivos.set(dadoARelanzar.getCara(), dadoRelanzado);

    }

    //corazon
    public void dadoExtra() {
        dadosActivos.add(añadirDado);
        dadosInactivos.remove(0);
    }


    //dragon
    public int conteoDragones() {
        for (int i=0;i<dadosActivos.size();i++){
            if(dadosActivos.get(i).getCara()==5){
                conteoDragon++;
            }
        }
        return conteoDragon;
    }

    //sirve para contar cuantos 42 hay en los dados activos al finalizar la ronda
    public int conteoCaraCuatroDos() {
        for (int i=0;i<dadosActivos.size();i++){
            if(dadosActivos.get(i).getCara()==6){
                conteoCuatroDos++;
            }
        }
        return conteoCuatroDos;
    }



    public String[] getEstadoToStringRonda() {
        switch (stringRonda) {
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
        switch (stringPuntos) {
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