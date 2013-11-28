/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador.form;

import cotizador.dominio.Descriptor;
import cotizador.dominio.cotizacion;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author ar00112343
 */
public class CotizadorForm extends ActionForm {

    private String accion;
    private String descripcion;
    private String observaciones;
    private String ambiente;
    private int cantidad;
    private int precio;
    private String naturaleza;
    private int indice;
    private String idDetalle;
    private int idProducto;
    private String nombre;
    private ArrayList<cotizacion> lista; 
    private ArrayList<Descriptor> listaAmbientes;
    private ArrayList<Descriptor> listaNaturaleza;
    private HashMap<String,String> productos;
    private HashMap<String,String> ambientes;
    private int sistemaOperativo;
    private int memoria;
    private int procesador;
    private int disco;
    private int raid;
    private String usuario;
    private int total; 
    private String moneda;
    private String simbolo;
    private String perfil;
    private String pgi;
    private String clarity;
    private String muestraMant;
    private int meses;
    
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
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
     * @return the naturaleza
     */
    public String getNaturaleza() {
        return naturaleza;
    }

    /**
     * @param naturaleza the naturaleza to set
     */
    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    /**
     * @return the filas
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param filas the filas to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return the lista
     */
    public ArrayList<cotizacion> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<cotizacion> lista) {
        this.lista = lista;
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
     * @return the productos
     */
    public HashMap<String,String> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(HashMap<String,String> productos) {
        this.productos = productos;
    }

    /**
     * @return the ambientes
     */
    public HashMap<String,String> getAmbientes() {
        return ambientes;
    }

    /**
     * @param ambientes the ambientes to set
     */
    public void setAmbientes(HashMap<String,String> ambientes) {
        this.ambientes = ambientes;
    }

    /**
     * @return the idDetalle
     */
    public String getIdDetalle() {
        return idDetalle;
    }

    /**
     * @param idDetalle the idDetalle to set
     */
    public void setIdDetalle(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the sistemaOperativo
     */
    public int getSistemaOperativo() {
        return sistemaOperativo;
    }

    /**
     * @param sistemaOperativo the sistemaOperativo to set
     */
    public void setSistemaOperativo(int sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * @return the memoria
     */
    public int getMemoria() {
        return memoria;
    }

    /**
     * @param memoria the memoria to set
     */
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    /**
     * @return the procesador
     */
    public int getProcesador() {
        return procesador;
    }

    /**
     * @param procesador the procesador to set
     */
    public void setProcesador(int procesador) {
        this.procesador = procesador;
    }

    /**
     * @return the disco
     */
    public int getDisco() {
        return disco;
    }

    /**
     * @param disco the disco to set
     */
    public void setDisco(int disco) {
        this.disco = disco;
    }

    /**
     * @return the raid
     */
    public int getRaid() {
        return raid;
    }

    /**
     * @param raid the raid to set
     */
    public void setRaid(int raid) {
        this.raid = raid;
    }

    /**
     * @return the listaAmbientes
     */
    public ArrayList<Descriptor> getListaAmbientes() {
        return listaAmbientes;
    }

    /**
     * @param listaAmbientes the listaAmbientes to set
     */
    public void setListaAmbientes(ArrayList<Descriptor> listaAmbientes) {
        this.listaAmbientes = listaAmbientes;
    }

    /**
     * @return the listaNaturaleza
     */
    public ArrayList<Descriptor> getListaNaturaleza() {
        return listaNaturaleza;
    }

    /**
     * @param listaNaturaleza the listaNaturaleza to set
     */
    public void setListaNaturaleza(ArrayList<Descriptor> listaNaturaleza) {
        this.listaNaturaleza = listaNaturaleza;
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
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the pgi
     */
    public String getPgi() {
        return pgi;
    }

    /**
     * @param pgi the pgi to set
     */
    public void setPgi(String pgi) {
        this.pgi = pgi;
    }

    /**
     * @return the clarity
     */
    public String getClarity() {
        return clarity;
    }

    /**
     * @param clarity the clarity to set
     */
    public void setClarity(String clarity) {
        this.clarity = clarity;
    }

    /**
     * @return the muestraMant
     */
    public String getMuestraMant() {
        return muestraMant;
    }

    /**
     * @param muestraMant the muestraMant to set
     */
    public void setMuestraMant(String muestraMant) {
        this.muestraMant = muestraMant;
    }

    /**
     * @return the meses
     */
    public int getMeses() {
        return meses;
    }

    /**
     * @param meses the meses to set
     */
    public void setMeses(int meses) {
        this.meses = meses;
    }

    
}
