package domain;
import java.util.*;
import java.awt.Color;

/**
 * Esta es una clase se encarga de íntar una cuadricula según lo que indique la
 * variable size, pintando en esta objetos con diferentes comportamientos y atributos
 * @author: Sergio Gonzales - Juan Esteban Ortiz
 * @version: 10/10/2022
 */
public class AManufacturing{
    static private int SIZE=50;
    private Thing[][] lattice;
    /**
     * Crea un Amanufacturing
     */
    public AManufacturing() {
        lattice=new Thing[SIZE][SIZE];
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                lattice[r][c]=null;
            }
        }
        someThings();
    }
    /**
     * Retorna el tamaño de la cuadricula
     */
    public int getSize(){ 
        return SIZE;
    }
    /**
     * Retorna una matriz tipo Thing
     * @param r
     * @param c
     */
    public Thing getThing(int r,int c){
        return lattice[r][c];
    }
    /**
     * Establece un objeto Thing en una posicion de la matriz tipo Thing
     * @param r
     * @param c
     * @param e
     */
    public void setThing(int r, int c, Thing e){
        lattice[r][c]=e;
    }
    /**
     * Crea los objetos tipo Thing que inicialmente estaran en la cuadricula
     * Amanufacturing
     */
    public void someThings() {
        Cell simba = new Cell(this, 1, 1, true);
        Cell dala = new Cell(this, 2, 2, true);
        chess negro = new chess(this, 10, 10, true);
        chess blanco = new chess(this, 40, 40, true);
        Kriptonita uone = new Kriptonita(this, 0, 0, true);
        Kriptonita two = new Kriptonita(this, 49, 0, true);
        Kriptonita three = new Kriptonita(this, 0, 49, true);
        Kriptonita four = new Kriptonita(this, 49, 49, true);
        Rfplicbte ajfdk = new Rfplicbte(this, 40, 20, true);
        Rfplicbte ad = new Rfplicbte(this, 39, 20, true);
        Rfplicbte addfdk = new Rfplicbte(this, 40, 19, true);
        contorno Juanes = new contorno(this, 30, 30, true);
        contorno Sergio = new contorno(this, 30, 29, true);
        Kriptonita test1 = new Kriptonita(this, 2, 2, false);
    /*Mimo dalda = new Mimo(this, 15, 15, true);
        Mimo dalfdlda = new Mimo(this, 14, 15, true);
        Mimo dalfdflda = new Mimo(this, 16, 15, true);*/
    }
    /**
     * Retorna un numero que cuenta la cantidad de objetos activos alrededor del
     * objeto actual
     */  
    public int neighborsActive(int r, int c){
        int num=0;
        for(int dr=-1; dr<2;dr++){
            for (int dc=-1; dc<2;dc++){
                if ((dr!=0 || dc!=0) && inLatice(r+dr,c+dc) && (lattice[r+dr][c+dc]!=null) &&  (lattice[r+dr][c+dc].isActive())) 
                    num++;
            }
        }
        return (inLatice(r,c) ? num : 0);
    } 
    /**
     * Retorna un numero que cuenta la cantidad de objetos activos no null alrededor del
     * objeto actual
     */  
        public int countActive(int r, int c){
        int num=0;
        for(int dr=-1; dr<2;dr++){
            for (int dc=-1; dc<2;dc++){
                if (inLatice(r+dr,c+dc) && (lattice[r+dr][c+dc]!=null) &&  (lattice[r+dr][c+dc].getActive())) 
                    num++;
            }
        }
        return (inLatice(r,c) ? num : 0);
    } 
    /**
     * Retorna true si llegase a estar vacio el espacio dentro de la cuadricula
     * actual, sino false
     * @param r
     * @param c
     */  
    public boolean getActiveS(int r, int c){
        return (lattice[r][c].getActive() ? true : false);
    }
  
    
    public boolean isEmpty(int r, int c){
        return (inLatice(r,c) && lattice[r][c]==null);
    }    
    /**
     * Retorna true si llegase a estar ocupado por un objeto el espacio en la
     * cuadricula actual
     * @param r
     * @param c
     */     
    public boolean inLatice(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }
    /**
    * Metodo que funciona como una acción la cual hace que se recorra la 
    * cuadricula en busca de objetos tipo thing,al encontrarlos los acciona una
    * vez con el metodo change
    */  
    public void ticTac(){
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].decide();
                }    
            }
        }

        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].go();
                }    
            }
        }
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].go2();
                }    
            }
        }
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].go3();
                }    
            }
        }
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].change();
                }    
            }
        }
    }

}
