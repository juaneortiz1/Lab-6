package domain;
import java.awt.Color;

/**
 * Esta es una clase heredada de cell la cual genera una cell que imita el estado
 * de sus celulas
 * @author: Sergio Gonzales - Juan Esteban Ortiz
 * @version: 10/10/2022
 */
public class Mimo extends Cell
{
    private AManufacturing aManufacturing;
    private int row,column;
    private int seguro;
    /**
     * Crea un Mimo
     */
    public Mimo(AManufacturing am,int row, int column, boolean active)
    {
        
        super(am,row,column,active);
        color=Color.ORANGE;
    }

    @Override
    public void decide(){
        if(aManufacturing.getThing(row-1,column) != null && seguro == 0){
            nextState=(aManufacturing.getThing(row-1,column).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row-1,column+1)!= null && seguro == 1){
            nextState=(aManufacturing.getThing(row-1,column+1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row,column+1)!= null && seguro == 2){
            nextState=(aManufacturing.getThing(row,column+1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row+1,column+1)!= null && seguro == 3){
            nextState=(aManufacturing.getThing(row+1,column+1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row+1,column)!= null && seguro == 4){
            nextState=(aManufacturing.getThing(row+1,column).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);           
        }
        else if(aManufacturing.getThing(row+1,column-1)!= null && seguro == 5){
            nextState=(aManufacturing.getThing(row-1,column-1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row,column-1)!= null && seguro == 6){
            nextState=(aManufacturing.getThing(row,column-1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);           
        }
        else if(aManufacturing.getThing(row-1,column-1)!= null && seguro == 7){
            nextState=(aManufacturing.getThing(row-1,column-1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);                    
        }
        if( seguro == 7){
            seguro = -1;
        }
        seguro +=1;
    }
}