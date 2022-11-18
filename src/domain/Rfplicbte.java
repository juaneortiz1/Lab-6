package domain;
import java.awt.Color;
import java.util.ArrayList;
/**
 * Esta es una clase heredada de cell la cual genera una cell que se genera una
 * que dependiendo de si la cantidad de celulas a su alrededor en impar se activa 
 * @author: Sergio Gonzales - Juan Esteban Ortiz
 * @version: 10/10/2022
 */
public class Rfplicbte extends Cell 
{
    int row, column;
    AManufacturing am;
    boolean active;

    /**
     * Constructor for objects of class Rfplicbte
     */
    public Rfplicbte(AManufacturing am,int row, int column, boolean active)
    {        
        super(am, row, column, active);      
        this.color = color.BLUE;
        this.row = row;
        this.column = column;
        this.am = am;
        this.active = active;
    }
    /**
     * decide for objects of class Rfplicbte
     * coloca al rededore de la figura un vorde de Rfplicbte inactivos
     * esto para poderlos evaluar
     */
    @Override
    public void decide(){
        if(active){
            for(int i=-1; i < 2;i++){
                for (int j =-1; j < 2;j++){
                    if((i+row !=row || j+column != column) && am.isEmpty(i+row, j+column)){
                        Rfplicbte ajfjdk1 = new Rfplicbte(am, row+i, column+j, false);
                    }
                }
            }
        }
    }
     /**
     * determina si es valido activarla segun la cantidad de celulas que los rodean
     */   
    public void go(){
        if(am.countActive(row, column) %2 == 0  ){
            nextState=Artefact.INACTIVE;   
        }else{
            nextState=Artefact.ACTIVE;         
        } 
    }
    /**
     * convierte en null las que no sirven
     */ 
    public void go2(){
        if(nextState == Artefact.INACTIVE){
            am.setThing(row, column, null);
        }
    }
    /**
     * Guarda las nuevas creadas
     */ 
    public void go3(){
        Rfplicbte ajfjdk1 = new Rfplicbte(am, row, column, true);
    }
    
}
