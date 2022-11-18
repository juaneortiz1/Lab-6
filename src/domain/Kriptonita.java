package domain;
import java.awt.Color;

/**
 * Esta es una claseusa Thing la kriptonita se reproduce siempre y sol es activada si tiene 
 * algo al lado
 * @author: Sergio Gonzales - Juan Esteban Ortiz
 * @version: 10/10/2022
 */
public class Kriptonita extends Artefact implements Thing
{
    protected char nextState;
    protected Color color;
    private AManufacturing am;
    private boolean active;
    private int row,column;
    /**
     * Constructor for objects of class kriptonita
     */
    public Kriptonita(AManufacturing am,int row, int column, boolean active){
        this.am = am;
        this.row = row;
        this.column = column;
        state=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        nextState=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        am.setThing(row,column,(Thing)this);
        color=color.green;
        this.active = active;
    }
    /**
     * genera alrededor de si mismo kriptonita inactiva
     */
    @Override
    public void decide(){ 
        if(nextState == Artefact.ACTIVE){
            if(am.neighborsActive(row, column) > 0){
                nextState = Artefact.ACTIVE;
            }
            for(int i=row-1; i < row + 2;i++){
                for (int j = column-1; j < column + 2;j++){
                    if(am.isEmpty(i, j)){
                        Kriptonita uone = new Kriptonita(am,i,j,false);
                        uone.nextState = Artefact.INACTIVE;
                    }
                }
            }
        }
        else{
            nextState=(getSteps() > 0 ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
    }
    /**
     * Revisa un segundo despues
     */
    public void go(){
        if(nextState == Artefact.ACTIVE){
            if(am.neighborsActive(row, column) > 0){
                nextState = Artefact.ACTIVE;
            }
            for(int i=row-1; i < row + 2;i++){
                for (int j = column-1; j < column + 2;j++){
                    if(am.isEmpty(i, j)){
                        Kriptonita uone = new Kriptonita(am,i,j,false);
                        uone.nextState = Artefact.INACTIVE;
                    }
                }
            }
        }
        else{
            nextState=(getSteps() > 0 ? Artefact.ACTIVE:Artefact.INACTIVE);
        }    
    }
    /**
     * cambia la figura a un circulo
     */
    public int shape(){
         return 1;
    }
    
    /**Change its actual state
     */
    public final void change(){
        step();
        state=nextState;
    }
    
    /**Returns the color
    @return 
     */
    public final Color getColor(){
        return color;
    }
}
