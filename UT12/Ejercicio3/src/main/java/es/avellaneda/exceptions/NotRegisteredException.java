package es.avellaneda.exceptions;

import es.avellaneda.model.Usuario;

public class NotRegisteredException  extends Exception{
    private Usuario usuario; 
    

    public NotRegisteredException(Usuario usuario,String msg){
        super(msg);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }   

}
