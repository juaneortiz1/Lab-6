/**
    * Metodo que funciona como una acción la cual hace que se recorra la 
    * cuadricula en busca de objetos tipo thing,al encontrarlos los acciona una
    * vez con el metodo change
    */
package domain;
import java.awt.Color;
/**
 * Esta interfaz es un conjunto de metodos comunes entres distintas clases como
 * cell, artefact y de mas.
 * @author: Sergio Gonzales - Juan Esteban Ortiz
 * @version: 10/10/2022
 */

public interface Thing{
    int ROUND = 1;
    int SQUARE = 2;
    /**
     * Este metodo verifica el estado del objeto
     */
    void decide();
    /**
     * metodo para un segundo mas tarde
     */
    default void go(){  
    };
    /**
     * metodo para un segundo mas tarde
     */
    default void go2(){
    };
    /**
     * metodo para un segundo mas tarde
     */
    default void go3(){
    };
    /**
     * Este metodo cambia el estado del objeto
     */
    default void change(){
    };
    /**
     * Este metodo retorna la figura del objeto
     */  
    default int shape(){
         return SQUARE;
    }
    /**
     * Este metodo retorna el color del objeto
     */  
    default Color getColor(){
        return Color.red;
    };
    /**
     * Este metodo retorna el estado actual del objeto
     */
    default boolean isActive(){
        return false;
    }
    /**
     * Este metodo retorna el estado actual del objeto
     */  
    default boolean getActive(){
        return true;
    }
}
