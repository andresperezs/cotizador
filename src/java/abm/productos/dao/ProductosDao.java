/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abm.productos.dao;

import abm.productos.action.ProductosAction;
import abm.productos.dominio.Producto;
import abm.productos.form.ProductosForm;
import dao.DbUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ar00112343
 */
public class ProductosDao {
    
    String region = "";
    
    public ProductosDao(String moneda){
        region = moneda;
    }
    
    public ArrayList<Producto> getLista() {
        
        DbUtil util = new DbUtil(region);
        ArrayList<Producto> lista = new ArrayList<Producto>();
        ResultSet rs = util.getResult("select producto_id,descripcion,precio,naturaleza_id,estado"
                + " from productos where estado ='A' order by descripcion asc");        
        
        try {
            while(rs.next()){
        
               Producto prod =  new Producto();
               prod.setId(rs.getInt(1));
               prod.setDescripcion(rs.getString(2));
               prod.setPrecio(rs.getInt(3));
               prod.setNaturaleza(rs.getInt(4));
               prod.setEstado(rs.getString(5));
               lista.add(prod);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            Logger.getLogger(ProductosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public boolean borrar(int indice) {
        
        DbUtil util = new DbUtil(region);
        
        return util.ejecutar("update productos set estado = 'C' where producto_id='"+indice+"'");        
        
    }

    public HashMap<String, String> getNaturalezas() {
        
        DbUtil util = new DbUtil(region);
        HashMap<String, String> naturalezas = new HashMap<String, String>();
        
        ResultSet rs = util.getResult("select id,descripcion from naturaleza order by id asc ");        
        
        try {
            while(rs.next()){
        
               naturalezas.put(rs.getString(1), rs.getString(2));
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            Logger.getLogger(ProductosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return naturalezas;
    }

    public boolean saveProducto(ProductosForm prod) {
        
        DbUtil util = new DbUtil(region);
        ResultSet rs = util.getResult("select nvl(max(to_number(producto_id)),0)+1 from productos");
        int id = 1;
        try {
            rs.next();
            id=rs.getInt(1);
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        util = new DbUtil(region);
        boolean retorno = util.ejecutar("insert into productos values("+id + ",'"+prod.getNombre()+"',"+prod.getPrecio()+",'"+prod.getNaturaleza()+"','A','"+prod.getTipo()+"')");     
        util.closeConnection();
        return retorno;
    }
    
    public boolean updateProducto(ProductosForm prod) {
        
        DbUtil util = new DbUtil(region);
         
        boolean retorno = util.ejecutar("update productos set descripcion='"+prod.getNombre()+"',"
                + "precio="+prod.getPrecio()+",naturaleza_id='"+prod.getNaturaleza()+"',tipo='"+prod.getTipo()+"' where producto_id="+prod.getIndice());     
        util.closeConnection();
        return retorno;
    }

    public Producto getProductoById(int indice) {
        
        DbUtil util = new DbUtil(region);
        Producto prod =  new Producto();
        
        ResultSet rs = util.getResult("select * from productos where producto_id='"+indice+"'");        
        
        try {
            while(rs.next()){
        
               prod.setId(rs.getInt(1));
               prod.setDescripcion(rs.getString(2));
               prod.setPrecio(rs.getInt(3));
               prod.setNaturaleza(rs.getInt(4));
               prod.setEstado(rs.getString(5));    
               prod.setTipo(rs.getString(6));   
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            Logger.getLogger(ProductosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prod;   
        
    }
    
    public HashMap<String, String> getProductos() {
        
        DbUtil util = new DbUtil(region);
        HashMap<String, String> productos = new HashMap<String, String>();
        
        ResultSet rs = util.getResult("select producto_id,descripcion from productos order by producto_id asc ");        
        
        try {
            while(rs.next()){
        
               productos.put(rs.getString(1), rs.getString(2));
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            Logger.getLogger(ProductosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productos;
            
    }
    
    public float getPrecioByDesc(String descripcion){
        DbUtil util = new DbUtil(region);
        ResultSet rs = util.getResult("select precio from productos where descripcion='"+descripcion+"'");        
        float precio = 0;
        
        try {
            while(rs.next()){
                
               precio =rs.getFloat("precio");
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            Logger.getLogger(ProductosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return precio;
        
    
    }
    
    public int getIdByDesc(String descripcion){
        DbUtil util = new DbUtil(region);
        ResultSet rs = util.getResult("select producto_id from productos where descripcion='"+descripcion+"'");        
        int id = 0;
        
        try {
            while(rs.next()){
                
               id =rs.getInt("producto_id");
            }
        rs.close();util.closeConnection();    
        } catch (SQLException ex) {
            Logger.getLogger(ProductosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
        
    
    }
    
    public float getCapexDesaBase(boolean esOracle) {
        
        float resultado=0;
        
        if(esOracle)
            resultado = getPrecioByDesc("Instalación y Configuración  de Base de Datos Oracle");
        else
            resultado = getPrecioByDesc("Instalación y Configuración  de Base de SQL");
        
        return resultado;
    }
}
