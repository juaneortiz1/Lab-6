package tests;
import domain.*;
import org.junit.jupiter.api.*;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Write a description of class AManufacturingTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCell
{
    @Test
    public void deberiaCrearCelulaViva(){
        AManufacturing am = new AManufacturing();
        assertEquals(am.getThing(1,1).isActive(), true);
    }

    @Test
    public void deberiaMostarCelulaEnTrestiempos(){
        AManufacturing am = new AManufacturing();
        assertEquals(am.getThing(1,1).isActive(), true);        
        assertEquals(am.getThing(2,2).isActive(), true);
        
        am.ticTac();
        
        assertEquals(am.getThing(1,1).isActive(), true);
        assertEquals(am.getThing(2,2).isActive(), true);
        
        am.ticTac();

        assertEquals(am.getThing(1,1).isActive(), false);
        assertEquals(am.getThing(2,2).isActive(), false);
        
        am.ticTac();

        assertEquals(am.getThing(1,1).isActive(), false);
        assertEquals(am.getThing(2,2).isActive(), false);
    }
    
    @Test
    public void deberiaEstarMuertaCelulaPRUEBATICKTACK(){
        AManufacturing am = new AManufacturing();
        for(int i = 0; i < 5; i++){
            am.ticTac();
        }
        assertEquals(am.getThing(1,1).isActive(), false);
    }

    @Test
    public void deberiaestrablancoContornoDosClick(){
        AManufacturing am = new AManufacturing();
        am.ticTac();
        am.ticTac();
        assertEquals(am.getThing(31,31).isActive(), false);
    }
    
/*
    @Test
    public void deberiaCopiarEstadoMimo(){
        AManufacturing am = new AManufacturing();
        for(int i = 0; i < 6; i++){
            am.ticTac();
        }
        assertEquals(am.getThing(3,3).isActive(), false);
        assertEquals(am.getThing(3,4).isActive(), true);
        assertEquals(am.getThing(3,5).isActive(), false);

        am.ticTac();

        assertEquals(am.getThing(3,3).isActive(), false);
        assertEquals(am.getThing(3,4).isActive(), false);
        assertEquals(am.getThing(3,5).isActive(), true);

        am.ticTac();

        assertEquals(am.getThing(3,3).isActive(), true);
        assertEquals(am.getThing(3,4).isActive(), false);
        assertEquals(am.getThing(3,5).isActive(), false);
    }
*/
    @Test
    public void deberiaCrearKriptonita(){
        AManufacturing am = new AManufacturing();

        assertEquals(am.getThing(0,0).getColor(), Color.GREEN);
        assertEquals(am.getThing(49,49).getColor(), Color.GREEN);
        assertEquals(am.getThing(0,49).getColor(), Color.GREEN);
        assertEquals(am.getThing(49,0).getColor(), Color.GREEN);

        assertEquals(am.getThing(0,0).isActive(), true);
        assertEquals(am.getThing(49,49).isActive(), true);
        assertEquals(am.getThing(0,49).isActive(), true);
        assertEquals(am.getThing(49,0).isActive(), true);
    }

    @Test
    public void deberiaColocarKriptonitaAlrededorDeLasEsquinas(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(1,0).isActive(), false);
        assertEquals(am.getThing(0,1).isActive(), false);
        
        assertEquals(am.getThing(0,48).isActive(), false);
        assertEquals(am.getThing(1,48).isActive(), false);
        assertEquals(am.getThing(1,49).isActive(), false);
        
        assertEquals(am.getThing(49,48).isActive(), false);
        assertEquals(am.getThing(48,48).isActive(), false);
        assertEquals(am.getThing(48,49).isActive(), false);
        
        assertEquals(am.getThing(48,0).isActive(), false);
        assertEquals(am.getThing(48,1).isActive(), false);
        assertEquals(am.getThing(49,1).isActive(), false);
    }

    @Test
    public void deberiaReplicarseKriptonita(){
        AManufacturing am = new AManufacturing();
        am.ticTac();
        am.ticTac();
        assertEquals(am.getThing(1,0).isActive(), true);
        assertEquals(am.getThing(0,1).isActive(), true);
        
        assertEquals(am.getThing(0,48).isActive(), true);
        assertEquals(am.getThing(1,48).isActive(), true);
        assertEquals(am.getThing(1,49).isActive(), true);
        
        assertEquals(am.getThing(49,48).isActive(), true);
        assertEquals(am.getThing(48,48).isActive(), true);
        assertEquals(am.getThing(48,49).isActive(), true);
        
        assertEquals(am.getThing(48,0).isActive(), true);
        assertEquals(am.getThing(48,1).isActive(), true);
        assertEquals(am.getThing(49,1).isActive(), true);
    }

    
    @Test
    public void deberiaMostrarKriptonitaDespuesDeTresClick(){
        AManufacturing am = new AManufacturing();
        am.ticTac();
        am.ticTac();
        am.ticTac();
        assertEquals(am.getThing(0,0).isActive(), true);
        assertEquals(am.getThing(1,0).isActive(), true);
        assertEquals(am.getThing(2,0).isActive(), true);
        assertEquals(am.getThing(3,0).isActive(), false);
        assertEquals(am.getThing(0,1).isActive(), true);
        assertEquals(am.getThing(1,1).isActive(), false);
        assertEquals(am.getThing(2,1).isActive(), true);
        assertEquals(am.getThing(3,1).isActive(), false);
        assertEquals(am.getThing(0,2).isActive(), true);
        assertEquals(am.getThing(1,2).isActive(), true);
        assertEquals(am.getThing(2,2).isActive(), false);
        assertEquals(am.getThing(3,2).isActive(), false);
        assertEquals(am.getThing(0,3).isActive(), false);
        assertEquals(am.getThing(1,3).isActive(), false);
        assertEquals(am.getThing(2,3).isActive(), false);
        
        
        assertEquals(am.getThing(49,0).isActive(), true);
        assertEquals(am.getThing(48,0).isActive(), true);
        assertEquals(am.getThing(47,0).isActive(), true);
        assertEquals(am.getThing(46,0).isActive(), false);
        assertEquals(am.getThing(49,1).isActive(), true);
        assertEquals(am.getThing(48,1).isActive(), true);
        assertEquals(am.getThing(47,1).isActive(), true);
        assertEquals(am.getThing(46,1).isActive(), false);
        assertEquals(am.getThing(49,2).isActive(), true);
        assertEquals(am.getThing(48,2).isActive(), true);
        assertEquals(am.getThing(47,2).isActive(), true);
        assertEquals(am.getThing(46,2).isActive(), false);
        assertEquals(am.getThing(49,3).isActive(), false);
        assertEquals(am.getThing(48,3).isActive(), false);
        assertEquals(am.getThing(47,3).isActive(), false);
        assertEquals(am.getThing(46,3).isActive(), false);   
        
        assertEquals(am.getThing(0,49).isActive(), true);
        assertEquals(am.getThing(1,49).isActive(), true);
        assertEquals(am.getThing(2,49).isActive(), true);
        assertEquals(am.getThing(3,49).isActive(), false);
        assertEquals(am.getThing(0,48).isActive(), true);
        assertEquals(am.getThing(1,48).isActive(), true);
        assertEquals(am.getThing(2,48).isActive(), true);
        assertEquals(am.getThing(3,48).isActive(), false);
        assertEquals(am.getThing(0,47).isActive(), true);
        assertEquals(am.getThing(1,47).isActive(), true);
        assertEquals(am.getThing(2,47).isActive(), true);
        assertEquals(am.getThing(3,47).isActive(), false);
        assertEquals(am.getThing(0,46).isActive(), false);
        assertEquals(am.getThing(1,46).isActive(), false);
        assertEquals(am.getThing(2,46).isActive(), false);
        assertEquals(am.getThing(3,46).isActive(), false);
        
        assertEquals(am.getThing(49,49).isActive(), true);
        assertEquals(am.getThing(48,49).isActive(), true);
        assertEquals(am.getThing(47,49).isActive(), true);
        assertEquals(am.getThing(46,49).isActive(), false);
        assertEquals(am.getThing(49,48).isActive(), true);
        assertEquals(am.getThing(48,48).isActive(), true);
        assertEquals(am.getThing(47,48).isActive(), true);
        assertEquals(am.getThing(46,48).isActive(), false);
        assertEquals(am.getThing(49,47).isActive(), true);
        assertEquals(am.getThing(48,47).isActive(), true);
        assertEquals(am.getThing(47,47).isActive(), true);
        assertEquals(am.getThing(46,47).isActive(), false);
        assertEquals(am.getThing(49,46).isActive(), false);
        assertEquals(am.getThing(48,46).isActive(), false);
        assertEquals(am.getThing(47,46).isActive(), false);
        assertEquals(am.getThing(46,46).isActive(), false); 
    }
    
    @Test
    public void deberiaMostrarChessDespuesDeUnClick(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(10,10).isActive(), true);
        assertEquals(am.getThing(9,9).isActive(), false);
        assertEquals(am.getThing(9,11).isActive(), false);
        assertEquals(am.getThing(11,9).isActive(), false);
        assertEquals(am.getThing(11,11).isActive(), false);
        
        assertEquals(am.getThing(40,40).isActive(), true);
        assertEquals(am.getThing(39,39).isActive(), false);
        assertEquals(am.getThing(39,41).isActive(), false);
        assertEquals(am.getThing(41,39).isActive(), false);
        assertEquals(am.getThing(41,41).isActive(), false);
        
    }
    
    @Test
    public void probartresClicsRfplicbte(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(41,21).isActive(), true);       
        assertEquals(am.getThing(38,19).isActive(), true);

        
    }
/*    @Test 
    public void deberiaZombieInfectarCelulasCercanas(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(11,11).getColor(), Color.RED);
        assertEquals(am.getThing(9,9).getColor(), Color.RED);
        assertEquals(am.getThing(10,11).getColor(), Color.RED);
        assertEquals(am.getThing(12,11).getColor(), Color.RED);
        assertEquals(am.getThing(13,11).getColor(), Color.RED);
    }
    
    @Test
    public void deberiaMatarZombiesCercanos(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(35,20).isActive(), true);
        assertEquals(am.getThing(35,20).getColor(), Color.CYAN);
        
        assertEquals(am.getThing(34,20).isActive(), false);
        assertEquals(am.getThing(34,21).isActive(), false);
        assertEquals(am.getThing(35,21).isActive(), false);
        assertEquals(am.getThing(34,19).isActive(), false);
        assertEquals(am.getThing(35,19).isActive(), false);
    }*/
}
