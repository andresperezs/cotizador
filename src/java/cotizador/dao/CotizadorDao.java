/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador.dao;

import cotizador.action.CotizadorAction;
import cotizador.dominio.cotizacion;
import cotizador.form.CotizadorForm;
import dao.DbUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ar00112343
 */
public class CotizadorDao {
    
    String region = "";
    
    public CotizadorDao(String moneda){
        region = moneda;
    }

    public HashMap<String, String> getProductos() {
        
        DbUtil util = new DbUtil(region);
        HashMap<String, String> productos = new LinkedHashMap<String, String>();
        
        ResultSet rs = util.getResult("select producto_id,descripcion from productos where estado='A' order by descripcion asc ");        
        
        try {
            while(rs.next()){
        
               productos.put(rs.getString(1), rs.getString(2));
               
            }
        rs.close();util.closeConnection();  
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return productos;
            
    }
    
    public String getMuestraMant() {
        
        DbUtil util = new DbUtil(region);
        
        ResultSet rs = util.getResult("select count(*) cant from parametros where descripcion ='verMant' and valor='S' ");        
        
        try {
            while(rs.next()){
        
               return rs.getString(1);
               
            }
        rs.close();util.closeConnection();      
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
        return "N";
            
    }

    public HashMap<String, String> getLicencias(String tipo) {
        
        DbUtil util = new DbUtil(region);
        HashMap<String, String> productos = new LinkedHashMap<String, String>();
        
        ResultSet rs = util.getResult("select producto_id,descripcion from productos where tipo='"+tipo+"' order by producto_id asc ");        
        
        try {
            while(rs.next()){
        
               productos.put(rs.getString(1), rs.getString(2));
               
            }
        rs.close();util.closeConnection();      
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
        return productos;
            
    }
    
    public HashMap<String, String> getRaid() {
        
        HashMap<String, String> productos = new HashMap<String, String>();
        
        productos.put("1", "RAID 1");
        productos.put("5", "RAID 5");
        productos.put("6", "RAID 6");
        
        return productos;
            
    }
    
    public HashMap<String, String> getAmbientes() {
        
        DbUtil util = new DbUtil(region);
        HashMap<String, String> ambientes = new LinkedHashMap<String, String>();
        
        ResultSet rs = util.getResult("select ambiente_id,descripcion from ambientes order by ambiente_id asc ");        
        
        try {
            while(rs.next()){
        
               ambientes.put(rs.getString(1), rs.getString(2));
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            System.out.println(ex);      
        }
        
        return ambientes;
            
    }

    public ArrayList<cotizacion> getListaCotizaciones(String nombre) {
        
        DbUtil util = new DbUtil(region);
        ArrayList<cotizacion> lista = new ArrayList<cotizacion>();
        ResultSet rs = util.getResult("select nombre,cotizacion_id,pgi,clarity from cotizaciones_cabecera where nombre like '%"+nombre+"%' order by nombre");        
        
        try {
            while(rs.next()){
        
               cotizacion cot =  new cotizacion();
               cot.setNombre(rs.getString(1));
               cot.setId(rs.getString(2));
               cot.setPgi(rs.getString(3));
               cot.setClarity(rs.getString(4));
               lista.add(cot);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
           System.out.println(ex);      
        }
        
        return lista;
    }
    
    public void setInfo(int id,CotizadorForm form) {
        
        DbUtil util = new DbUtil(region);
        ResultSet rs = util.getResult("select nombre,pgi,clarity from cotizaciones_cabecera where cotizacion_id= "+id+" order by nombre");        
        
        try {
            while(rs.next()){
        
              
               form.setNombre(rs.getString(1));
               form.setPgi(rs.getString(2));
               form.setClarity(rs.getString(3));
               
            }
            rs.close();util.closeConnection();     
        } catch (SQLException ex) {
           System.out.println(ex);      
        }
        
    }
    
     public ArrayList<cotizacion> getListaDetalles(int indice) {
        
        DbUtil util = new DbUtil(region);
        ArrayList<cotizacion> lista = new ArrayList<cotizacion>();
        ResultSet rs = util.getResult("select a.descripcion,cantidad,p.descripcion,n.descripcion,"
                + " observaciones,precio * meses,c.cotizacion_id,(cotizacion_id||p.producto_id||ambiente),"
                + " decode(tipo,'Fisico',(select precio from productos where descripcion like 'Instalaci%n y Configuraci%n  Equipo Fisico'),0) "
                + " precio_desa,meses from cotizaciones_detalle c, productos "
                + " p,naturaleza n,ambientes a where c.producto_id = p.producto_id and "
                + "p.naturaleza_id = n.id and c.ambiente=a.ambiente_id and cotizacion_id='"+indice+"'");        
        
        try {
            while(rs.next()){
        
               cotizacion cot =  new cotizacion();
               cot.setAmbiente(rs.getString(1));
               cot.setCantidad(rs.getInt(2));
               cot.setDescripcion(rs.getString(3));
               cot.setNaturaleza(rs.getString(4));
               cot.setObservaciones(rs.getString(5));
               cot.setMeses(rs.getInt(10));
               
               if(rs.getString(4).contains("COMPRAHARDWARE")){
                    cot.setPrecioCapexHW(rs.getInt(6));  
               }else               
               if(rs.getString(4).contains("COMPRASOFTWARE")){
                    cot.setPrecioCapSW(rs.getInt(6));  
               }else               
               if(rs.getString(4).contains("DESA")){
                    cot.setPrecioCapexDesa(rs.getInt(6));  
               }else               
               if(rs.getString(4).contains("TELEF")){
                    cot.setPrecioTelefonia(rs.getInt(6));  
               }else               
               if(rs.getString(4).contains("FORMACION")){
                    cot.setPrecioFormacion(rs.getInt(6));   
               }else               
               if(rs.getString(4).contains("VIAJES")){
                    cot.setPrecioViajes(rs.getInt(6));  
               }else               
               if(rs.getString(4).contains("OUTSOURCING")){
                    cot.setPrecioOut(rs.getInt(6));       
               }else 
                    cot.setPrecioOpexMT(rs.getInt(6));  
                
               cot.setId(rs.getString(7));
               cot.setIdDetalle(rs.getString(8));
               cot.setVirtual("N");
               lista.add(cot);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        util = new DbUtil(region);
        rs = util.getResult("select a.descripcion,cantidad,(('Equipo virtual de '||to_char(procesador)||' Proc, "
                + "'||to_char(memoria)||' GB de Memoria, '||to_char(disco)||' GB de Storage ')) descripcion,'MULTIPLE','',"
                + "precio_capex_soft,precio_opex_mant,id_cotizacion,id,meses, p.descripcion,precio_capex_desa,precio_capex_hw,precio_opex_out from "
                + " virtual v,ambientes a, productos p where id_cotizacion='"+indice+"' and v.ambiente=a.ambiente_id "
                + " and p.producto_id = id_so and memoria <> 0 "
                + "union all "
                + "select a.descripcion,cantidad,(('Base de datos de '||to_char(disco)||' GB de Storage ')) descripcion,'MULTIPLE','',"
                + "precio_capex_soft,precio_opex_mant,id_cotizacion,id,meses, p.descripcion,precio_capex_desa,precio_capex_hw,precio_opex_out from "
                + " virtual v,ambientes a, productos p where id_cotizacion='"+indice+"' and v.ambiente=a.ambiente_id "
                + " and p.producto_id = id_so and memoria = 0 and disco <> 0 " 
                + " union all "
                + "select a.descripcion, decode(id_so,34,1,cantidad) cantidad,case when tipo ='Fisico' or tipo ='Comunicaciones' or tipo like '%SO%' then p.descripcion else "
                + "(('Backup de '||to_char(cantidad)||' GB ')) end descripcion ,'MULTIPLE','',"
                + "precio_capex_soft,precio_opex_mant,id_cotizacion,id,meses, "
                + " case when tipo ='Fisico' or tipo ='Comunicaciones' or tipo like '%SO%' then v.observaciones else p.descripcion end ,precio_capex_desa,precio_capex_hw,precio_opex_out from "
                + " virtual v,ambientes a, productos p where id_cotizacion='"+indice+"' and v.ambiente=a.ambiente_id "
                + " and p.producto_id = id_so and memoria = 0 and disco = 0 ");
       
        try {
            while(rs.next()){
        
               cotizacion cot =  new cotizacion();
               cot.setAmbiente(rs.getString(1));
               cot.setCantidad(rs.getInt(2));
               cot.setDescripcion(rs.getString(3));
               cot.setNaturaleza(rs.getString(4));
               cot.setObservaciones(rs.getString(11));
               cot.setPrecioCapSW(rs.getInt(6));  
               cot.setPrecioOpexMT(rs.getInt(7));  
               cot.setPrecioCapexDesa(rs.getInt(12));  
               cot.setPrecioCapexHW(rs.getInt(13));  
               cot.setPrecioOut(rs.getInt(14));  
               cot.setId(rs.getString(8));
               cot.setIdDetalle(rs.getString(9));
               cot.setMeses(rs.getInt(10));
               cot.setVirtual("S");
               lista.add(cot);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
        
        return lista;
    }
     
     public cotizacion getDetalle(int indice,String idDetalle) {
        
        DbUtil util = new DbUtil(region);
        cotizacion cot =  new cotizacion();
        
        ResultSet rs = util.getResult("select ambiente,cantidad,p.descripcion,n.descripcion,"
                + " observaciones,precio,c.cotizacion_id,(cotizacion_id||p.producto_id||ambiente),p.producto_id,meses from cotizaciones_detalle c, productos "
                + " p,naturaleza n where c.producto_id = p.producto_id and "
                + "p.naturaleza_id = n.id and cotizacion_id='"+indice+"' and (cotizacion_id||p.producto_id||ambiente)='"+idDetalle+"'");        
        
        try {
            while(rs.next()){
        
               cot.setAmbiente(rs.getString(1));
               cot.setCantidad(rs.getInt(2));
               cot.setDescripcion(rs.getString(3));
               cot.setNaturaleza(rs.getString(4));
               cot.setObservaciones(rs.getString(5));
               cot.setPrecio(rs.getInt(6));  
               cot.setId(rs.getString(7));
               cot.setIdDetalle(rs.getString(8));
               cot.setIdProducto(rs.getInt(9));      
               cot.setMeses(rs.getInt(10));   
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return cot;
    }
     
    public cotizacion getDetalleVirtual(CotizadorForm form,int indice,String idDetalle) {
        
        DbUtil util = new DbUtil(region);
        cotizacion cot =  new cotizacion();
        
        ResultSet rs = util.getResult("select cantidad,procesador,memoria,disco,ambiente,id_so,meses from "
                + " virtual v where id_cotizacion='"+indice+"' and id="+idDetalle);        
        
        try {
            while(rs.next()){
        
               form.setCantidad(rs.getInt(1));
               form.setProcesador(rs.getInt(2));
               form.setMemoria(rs.getInt(3));
               form.setDisco(rs.getInt(4));
               form.setAmbiente(rs.getString(5));
               form.setIdProducto(rs.getInt(6));
               form.setMeses(rs.getInt(7));
            }
        rs.close();util.closeConnection(); 
        } catch (SQLException ex) {
            Logger.getLogger(CotizadorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cot;
    } 
    
    public int getIdCotizacion() {
        
        DbUtil util = new DbUtil(region);
        int resultado = 1;
        
        ResultSet rs = util.getResult(" select max(to_number(cotizacion_id))+1 from cotizaciones_cabecera  ");        
        
        try {
            while(rs.next()){
        
              resultado = rs.getInt(1);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            Logger.getLogger(CotizadorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
            
    }
     
     public int getIdVirtual() {
        
        DbUtil util = new DbUtil(region);
        int resultado = 1;
        
        ResultSet rs = util.getResult("select nvl(max(to_number(id)),0)+1 from  virtual");        
        
        try {
            while(rs.next()){
        
              resultado = rs.getInt(1);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return resultado;
            
    }
     
    public int getIdCotizacionActual() {
        
        DbUtil util = new DbUtil(region);
        int resultado = 1;
        
        ResultSet rs = util.getResult(" select max(cotizacion_id) from cotizaciones_cabecera ");        
        
        try {
            while(rs.next()){
        
              resultado = rs.getInt(1);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return resultado;
            
    }

    public boolean ejecutar(String string) {
        
        DbUtil util = new DbUtil(region);
        boolean retorno = util.ejecutar(string); 
        util.closeConnection();
        return retorno;
    }

    public boolean existeId(String id) {
        
        DbUtil util = new DbUtil(region);
        int resultado=0;
        if(id.equals(""))
            return false;
        
        ResultSet rs = util.getResult(" select count(*) "
                + "from cotizaciones_detalle where (cotizacion_id||producto_id||ambiente)="+id);        
        
        try {
            while(rs.next()){
        
              resultado = rs.getInt(1);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
        if(resultado > 0)
            return true;
        
        return false;
    }

    public String getTablaProductos(String usuario) {
        
        DbUtil util = new DbUtil(region);
        String resultado = "";
        
        ResultSet rs = util.getResult(" select ('productos_'||max(moneda)) from moneda where usuario='"+usuario+"'");        
        
        try {
            while(rs.next()){
        
              resultado = rs.getString(1);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
        return resultado;
    }
    
    public String getSimboloMoneda() {
        
        DbUtil util = new DbUtil(region);
        String resultado = "";
        
        ResultSet rs = util.getResult(" select valor from parametros where descripcion ='moneda'");        
        
        try {
            while(rs.next()){
        
              resultado = rs.getString(1);
               
            }
        rs.close();util.closeConnection();     
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
        return resultado;
    }
}
