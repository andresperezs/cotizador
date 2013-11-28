/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abm.naturalezas.dominio;


/**
 *
 * @author ar00112343
 */
public class Naturaleza {
    
    private int id;
    private String descripcion;

    public Naturaleza(){

    };
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

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

}
