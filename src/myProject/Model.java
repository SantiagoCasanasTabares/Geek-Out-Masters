package myProject;

public class Model {
    private Dado[] dadosActivos,dadosUsados,dadosInactivos;
    private String caraDado;
    private Dado dadoSeleccionado1, dadoSeleccionado2;

    public Model(){
        dadosActivos = new Dado[7];
        dadosInactivos = new Dado[3];
        dadosUsados = new Dado[0];
        dadoSeleccionado1 = new Dado();
        dadoSeleccionado2 = new Dado();
    }

    public void tiroInicial(){
        for(int i=0;i<dadosActivos.length;i++){
            dadosActivos[i].getCara();
        }
    }

    public void accionesDeLasCaras(){
        if (valorDeLaCara(dadoSeleccionado1)=="Meeple"){
            dadoSeleccionado2.getCara();
        }else if(valorDeLaCara(dadoSeleccionado1)=="Nave"){
            //dadosInactivos.add(dadoSeleccionado2);
        }else if(valorDeLaCara(dadoSeleccionado1)=="Superheroe"){
            dadoSeleccionado2.caraOpuesta();
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

    private int caraOpuesta(){

    }

}
