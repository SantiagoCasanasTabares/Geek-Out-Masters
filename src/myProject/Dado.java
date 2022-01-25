package myProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dado {
    private int cara;
    private String caraDado;


    public Dado(){

        this.cara=cara;

    }

    public int getCara(){
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

    public void setCara(int cara) {
        this.cara = cara;
    }
}