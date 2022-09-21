
package mindtech.proyecto.entidades;

public class MensajeResponse {

    private String mensaje;
    private Object object;

    public MensajeResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public MensajeResponse() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

