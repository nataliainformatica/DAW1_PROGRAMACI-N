package es.avellaneda.excepciones;

public class NotRegisteredException extends RuntimeException{

    public NotRegisteredException(String msg){
        super(msg);
    }

}
