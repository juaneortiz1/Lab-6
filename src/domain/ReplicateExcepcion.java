package domain;

public class ReplicateExcepcion extends Exception{
    public final static String OPCION = "Opción en construcción";

    /**
     *
     * @param message, mensaje que sale por pantalla, al atrapar la excepcion
     */
    public ReplicateExcepcion(String message){
        super(message);
    }
}
