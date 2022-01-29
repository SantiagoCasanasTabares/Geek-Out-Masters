package myProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is used for ...
 * @autor Luisa Maria Cardenas Lopez 1823494 cardenas.luisa@correounivalle.edu.co
 * @autor Santiago Casañas Tabares 2025301 santiago.casanas@correpunivalle.edu.co
 * @autor Jesus Adrian Peña Guetio 2025513 jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:28/01/2022
 */

public class Dado {
    private int cara;
    private String caraDado;

    public Dado(){
    }

    public Dado(int cara){
        this.cara = cara;
    }

    public int getCara(){
        return this.cara;
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