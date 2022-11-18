package domain;
import java.awt.Color;

/**
 * Esta es una clase heredada de cell la cual genera una cell que se genera una
 * cadena de cell verticalmente hacia abajo hasta donde llega al tope de la
 * cuadricula, haciendo que se vuelva inactiva en cadena hasta la cell estudiante 
 * original
 * @author: Sergio Gonzales - Juan Esteban Ortiz
 * @version: 10/10/2022
 */
public class Estudiante extends Cell{
    private int row,column;
    private AManufacturing am;
    boolean active;
    public Estudiante(AManufacturing am,int row, int column, boolean active)
    {
       super(am, row, column, active);      
       this.row = row;
       this.column = column;
       this.am = am;
       this.active = active;
       this.color = color.RED;
    }
    /**
     * decide for objects of class Estudiante
     */
    @Override
    public void decide(){
        if(active){
            for(int i=-1; i < 2;i++){
                for (int j =-1; j < 2;j++){
                    if((i+row !=row || j+column != column) && am.isEmpty(i+row, j+column)){
                        Cell ajfjdk1 = new Cell(am, row+i, column+j, false);
                    }
                }
            }
        }

    }
}