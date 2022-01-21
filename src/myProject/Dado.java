package myProject;

import java.util.List;
import java.util.Random;

public class Dado {
    private int cara;
    private String caraDado;
    private Dado dadoSeleccionado1, dadoSeleccionado2, dadoRelanzado, añadirDado = new Dado();
    public int valorCaraOpuesta, puntos, conteoCuatroDos;
    public List<Dado> dadosActivos,dadosUsados,dadosInactivos;



    public int getCara(){
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
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


    public void accionesDeLasCaras(){
        if (valorDeLaCara(dadoSeleccionado1)=="Meeple"){
            relanzarDado(dadoSeleccionado2);
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);
        }else if(valorDeLaCara(dadoSeleccionado1)=="Nave"){
            dadosInactivos.add(dadoSeleccionado2);
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);
        }else if(valorDeLaCara(dadoSeleccionado1)=="Superheroe"){
            caraOpuesta(dadoSeleccionado2);
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);
        }else if(valorDeLaCara(dadoSeleccionado1)=="Corazon"){
            dadoExtra();
            dadosActivos.remove(dadoSeleccionado1);
            dadosUsados.add(añadirDado);
        }
    }



    public int caraOpuesta(Dado dadoAVoltear){
        valorCaraOpuesta=dadoAVoltear.getCara();

        if(valorDeLaCara(dadoAVoltear)=="Meeple"){
            valorCaraOpuesta=2;
        }else if(valorDeLaCara(dadoAVoltear)=="Nave"){
            valorCaraOpuesta=1;
        }else if(valorDeLaCara(dadoAVoltear)=="Superheroe"){
            valorCaraOpuesta=5;
        }else if(valorDeLaCara(dadoAVoltear)=="Corazon"){
            valorCaraOpuesta=6;
        }else if(valorDeLaCara(dadoAVoltear)=="Dragon"){
            valorCaraOpuesta=3;
        }else if(valorDeLaCara(dadoAVoltear)=="42"){
            valorCaraOpuesta=4;
        }
        return valorCaraOpuesta;
    }

    //meeple
    public void relanzarDado(Dado dadoARelanzar) {
        dadoRelanzado = new Dado();
        dadosActivos.set(dadoARelanzar.getCara(), dadoRelanzado);

    }

    //corazon
    public void dadoExtra() {
        dadosActivos.add(añadirDado);
        dadosInactivos.remove(0);
    }


    //dragon
    public void pierdepuntos() {
        puntos=0;
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




}

