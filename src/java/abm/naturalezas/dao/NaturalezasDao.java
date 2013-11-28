/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abm.naturalezas.dao;

import abm.naturalezas.dao.*;
import abm.naturalezas.action.NaturalezasAction;
import abm.naturalezas.dominio.Naturaleza;
import abm.naturalezas.form.NaturalezasForm;
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
public class NaturalezasDao {
    
    String region = "";
    
    public NaturalezasDao(String moneda){
        region = moneda;
    }
    
    public ArrayList<Naturaleza> getLista() {
        
        DbUtil util = new DbUtil(region);
        ArrayList<Naturaleza> lista = new ArrayList<Naturaleza>();
        ResultSet rs = util.getResult("select id,descripcion"
                + " from naturaleza order by descripcion asc");        
        
        try {
            while(rs.next()){
        
               Naturaleza prod =  new Naturaleza();
               prod.setId(rs.getInt(1));
               prod.setDescripcion(rs.getString(2));
               lista.add(prod);
               
            }
            rs.close();util.closeConnection(); 
        } catch (SQLException ex) {
            Logger.getLogger(NaturalezasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public boolean borrar(int indice) {
        
        DbUtil util = new DbUtil(region);
        
        return util.ejecutar("delete from naturaleza where id='"+indice+"'");        
        
    }

    public boolean saveNaturaleza(NaturalezasForm prod) {
        
        DbUtil util = new DbUtil(region);
        ResultSet rs = util.getResult("select nvl(max(to_number(id)),0)+1 from naturaleza");
        int id = 1;
        try {
            rs.next();
            id=rs.getInt(1);
            rs.close();util.closeConnection(); 
        } catch (SQLException ex) {
            Logger.getLogger(NaturalezasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return util.ejecutar("insert into naturaleza values("+id + ",'"+prod.getNombre()+"')");     
       
    }
    
    public boolean updateNaturaleza(NaturalezasForm nat) {
        
        DbUtil util = new DbUtil(region);
         
        boolean retorno = util.ejecutar("update naturaleza set descripcion='"+nat.getNombre()+"' where id="+nat.getIndice());     
        util.closeConnection();
        return retorno;
    }

    public Naturaleza getNaturalezaById(int indice) {
        
        DbUtil util = new DbUtil(region);
        Naturaleza prod =  new Naturaleza();
        
        ResultSet rs = util.getResult("select * from naturaleza where id='"+indice+"'");        
        
        try {
            while(rs.next()){
        
               prod.setId(rs.getInt(1));
               prod.setDescripcion(rs.getString(2));         
            }
            rs.close();util.closeConnection(); 
        } catch (SQLException ex) {
            Logger.getLogger(NaturalezasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prod;   
        
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
            Logger.getLogger(NaturalezasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return naturalezas;
            
    }
    
}
