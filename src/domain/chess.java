package domain;
import java.awt.Color;


/**
 * Esta es una clase usa thing  para generar un patron igual que en el ajedrez
 * @author: Sergio Gonzales - Juan Esteban Ortiz
 * @version: 10/10/2022
 */
public class chess extends Artefact implements Thing
{
  protected char nextState;
    protected Color color;
    private AManufacturing am;
    private int row,column;
    /**
     * Constructor for objects of class kriptonita
     */
    public chess(AManufacturing am,int row, int column, boolean active){
        this.am = am;
        this.row = row;
        this.column = column;
        state=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        nextState=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        am.setThing(row,column,(Thing)this);
        color=color.BLACK;
    }
    /**
 * Diagonal de si mismo genera chess inactivos y luego los activa
 */
    @Override
    public void decide(){
        if(nextState == Artefact.ACTIVE){
            if(am.neighborsActive(row, column) > 0){
                nextState = Artefact.ACTIVE;
            }
            for(int i=row-1; i < row + 2;i += 2){
                for (int j = column-1; j < column + 2;j += 2){
                    if(am.isEmpty(i, j)){
                        chess uone = new chess(am,i,j,false);
                        uone.nextState = Artefact.INACTIVE;
                    }
                }
            }
        }
        else{
            nextState=(getSteps() > 0 ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
    }
    
    /**Change its actual state
     */
    public final void change(){
        step();
        state=nextState;
    }
    
    public static void recorrer(){
    
    }
    
    /**Returns the color
    @return 
     */
    public final Color getColor(){
        return color;
    }
}

