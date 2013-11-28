/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador.dominio;

/**
 *
 * @author ar00112343
 */
public class Descriptor {
    
    private String id;
    private String descripcion;

    public Descriptor(){

    };
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

}
