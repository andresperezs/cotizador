/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abm.productos.form;

import abm.productos.dominio.Producto;
import java.util.ArrayList;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author ar00112343
 */
public class ProductosForm extends ActionForm{
    
    private String accion;
    private ArrayList<Producto> lista;
    private int indice;
    private int id;
    private String nombre;
    private int precio;
    private int naturaleza;
    private String tipo;
    private String usuario;
    private String region;
    private String perfil;
    
    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the lista
     */
    public ArrayList<Producto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<Producto> lista) {
        this.lista = lista;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the naturaleza
     */
    public int getNaturaleza() {
        return naturaleza;
    }

    /**
     * @param naturaleza the naturaleza to set
     */
    public void setNaturaleza(int naturaleza) {
        this.naturaleza = naturaleza;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    
}
