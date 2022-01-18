package myProject;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Dado> dadosActivos,dadosUsados,dadosInactivos;
    private String caraDado;
    private Dado dadoSeleccionado1, dadoSeleccionado2;
    private int valorCaraOpuesta;

    public Model(){
        dadosActivos = new ArrayList<Dado>();
        dadosInactivos = new ArrayList<Dado>();
        dadosUsados = new ArrayList<Dado>();
        dadoSeleccionado1 = new Dado();
        dadoSeleccionado2 = new Dado();
    }

    public void tiroInicial(){
        for(int i=0;i<7;i++){
            dadosActivos.get(i).getCara();
        }
    }

    public void accionesDeLasCaras(){
        if (valorDeLaCara(dadoSeleccionado1)=="Meeple"){
            dadoSeleccionado2.getCara();
        }else if(valorDeLaCara(dadoSeleccionado1)=="Nave"){
            dadosInactivos.add(dadoSeleccionado2);
        }else if(valorDeLaCara(dadoSeleccionado1)=="Superheroe"){
            caraOpuesta(dadoSeleccionado2);
        }/*else if(){

        }else if(){

        }else if(){

        }*/
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

}

