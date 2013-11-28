/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador.dominio;

/**
 *
 * @author ar00112343
 */
public class cotizacion {
    
    private String id;
    private int idProducto;
    private String descripcion;
    private String observaciones;
    private String ambiente;
    private int cantidad;
    private int precio;
    private int precioCapSW;
    private int precioOpexMT;
    private int precioCapexDesa;
    private int precioCapexHW;
    private int precioViajes;
    private int precioFormacion;
    private int precioTelefonia;
    private int precioOut;
    private String naturaleza;
    private String nombre;
    private int filas;
    private String idDetalle;
    private int meses;
    private String virtual;
    private String pgi;
    private String clarity;

    public cotizacion(){

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
    public int getFilas() {
        return filas;
    }

    /**
     * @param filas the filas to set
     */
    public void setFilas(int filas) {
        this.filas = filas;
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
     * @return the precioOpex
     */
   

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

    /**
     * @return the virtual
     */
    public String getVirtual() {
        return virtual;
    }

    /**
     * @param virtual the virtual to set
     */
    public void setVirtual(String virtual) {
        this.virtual = virtual;
    }

    /**
     * @return the precioCapSW
     */
    public int getPrecioCapSW() {
        return precioCapSW;
    }

    /**
     * @param precioCapSW the precioCapSW to set
     */
    public void setPrecioCapSW(int precioCapSW) {
        this.precioCapSW = precioCapSW;
    }

    /**
     * @return the precioOpexMT
     */
    public int getPrecioOpexMT() {
        return precioOpexMT;
    }

    /**
     * @param precioOpexMT the precioOpexMT to set
     */
    public void setPrecioOpexMT(int precioOpexMT) {
        this.precioOpexMT = precioOpexMT;
    }

    /**
     * @return the precioCapexDesa
     */
    public int getPrecioCapexDesa() {
        return precioCapexDesa;
    }

    /**
     * @param precioCapexDesa the precioCapexDesa to set
     */
    public void setPrecioCapexDesa(int precioCapexDesa) {
        this.precioCapexDesa = precioCapexDesa;
    }

    /**
     * @return the precioCapexHW
     */
    public int getPrecioCapexHW() {
        return precioCapexHW;
    }

    /**
     * @param precioCapexHW the precioCapexHW to set
     */
    public void setPrecioCapexHW(int precioCapexHW) {
        this.precioCapexHW = precioCapexHW;
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
     * @return the precioViajes
     */
    public int getPrecioViajes() {
        return precioViajes;
    }

    /**
     * @param precioViajes the precioViajes to set
     */
    public void setPrecioViajes(int precioViajes) {
        this.precioViajes = precioViajes;
    }

    /**
     * @return the precioFormacion
     */
    public int getPrecioFormacion() {
        return precioFormacion;
    }

    /**
     * @param precioFormacion the precioFormacion to set
     */
    public void setPrecioFormacion(int precioFormacion) {
        this.precioFormacion = precioFormacion;
    }

    /**
     * @return the precioTelefonia
     */
    public int getPrecioTelefonia() {
        return precioTelefonia;
    }

    /**
     * @param precioTelefonia the precioTelefonia to set
     */
    public void setPrecioTelefonia(int precioTelefonia) {
        this.precioTelefonia = precioTelefonia;
    }

    /**
     * @return the precioOut
     */
    public int getPrecioOut() {
        return precioOut;
    }

    /**
     * @param precioOut the precioOut to set
     */
    public void setPrecioOut(int precioOut) {
        this.precioOut = precioOut;
    }
}
