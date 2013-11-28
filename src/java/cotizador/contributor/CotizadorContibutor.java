/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador.contributor;

import abm.productos.dao.ProductosDao;
import abm.productos.dominio.Producto;
import com.logs.CotizadorLog;
import cotizador.dao.CotizadorDao;
import cotizador.dominio.Descriptor;
import cotizador.form.CotizadorForm;
import dao.DbUtil;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author ar00112343
 */
public class CotizadorContibutor {
    
    public CotizadorContibutor(){

    };
    
    public boolean insertarVirtual(ActionMapping mapping, HttpServletRequest request, CotizadorForm form) {
                
        Calendar cal = Calendar.getInstance();  
        
        int id = form.getIndice(); 
        int mes = 12 - cal.get(cal.MONTH)+1; //zero-based  
        float precioOpex = 0;
        float precioCapexSoft = 0;
        float precioCapexHW = 0;
        float precioOutsourcing =0;
        float precioCapexDesa = 0;
        int precioSto = 0;
        boolean retorno = false;
        
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
                
        ProductosDao daoProd = new ProductosDao(form.getMoneda());
        Producto so = daoProd.getProductoById(form.getSistemaOperativo());
        
        precioCapexSoft = so.getPrecio();
                
        if(so == null || so.getDescripcion() == null)
            precioOpex = 0;
        else if(so.getDescripcion().contains("Win"))
            precioOpex = precioCapexSoft * ((float)0.2);
        else if(so.getDescripcion().contains("Hat")){
            precioOpex = precioCapexSoft ;
            precioCapexSoft = 0;
        }
        
            //RACK
        if(form.getDescripcion().equals("rack")){   
            
            form.setSistemaOperativo(daoProd.getIdByDesc("Unidad de Rack"));
            form.setDescripcion(""); 
            form.setMemoria(0); 
            form.setDisco(0); 
            precioOpex = 0;
            precioCapexSoft = 0;
            precioCapexDesa = 0;
            precioCapexHW = 0;
            precioOutsourcing = form.getMeses() * daoProd.getPrecioByDesc("Unidad de Rack");
            mes = form.getMeses();
            
            // BACKUP
        }else if(form.getMemoria() == 0 && form.getDisco() == 0){           
            
            form.setSistemaOperativo(daoProd.getIdByDesc("Backup x GB Capex"));
            
            precioOpex = 0;
            precioCapexSoft = 0;
            precioCapexDesa = 0;
            
            precioCapexHW = (form.getCantidad() * daoProd.getPrecioByDesc("Backup x GB Capex"));                    
        
        // VIRTUAL            
        } else if(form.getMemoria() != 0){
            
            precioCapexDesa = daoProd.getPrecioByDesc("Instalación y Configuración  Equipo Virtual");
        
            float precioMemoria = daoProd.getPrecioByDesc("Equipo Virtual 1 GB de Memoria");
            float raid1 =  daoProd.getPrecioByDesc("Disco VMAX Raid 1 x GB Miami");
            float raid5 = daoProd.getPrecioByDesc("Disco VMAX Raid 5 x GB Miami");
            float raid6 = daoProd.getPrecioByDesc("Disco VMAX Raid 6 x GB Miami");

            if(form.getRaid()==1)
                precioSto = ((Float)(form.getDisco() * raid1)).intValue();
            else if(form.getRaid()==5)
                precioSto = ((Float)(form.getDisco() * raid5)).intValue();
            else 
                precioSto = ((Float)(form.getDisco() * raid6)).intValue();

            float precioProc = daoProd.getPrecioByDesc("Procesador Virtual") * form.getProcesador();
            precioCapexHW = ((Float)(precioMemoria * form.getMemoria() + precioSto + precioProc)).intValue();
        
        // STORAGE
        }else{
            
            float raid1 =  daoProd.getPrecioByDesc("Disco VMAX Raid 1 x GB Miami");
            float raid5 = daoProd.getPrecioByDesc("Disco VMAX Raid 5 x GB Miami");
            float raid6 = daoProd.getPrecioByDesc("Disco VMAX Raid 6 x GB Miami");
            
            if(form.getRaid()==1)
                precioSto = ((Float)(form.getDisco() * raid1)).intValue();
            else if(form.getRaid()==5)
                precioSto = ((Float)(form.getDisco() * raid5)).intValue();
            else 
                precioSto = ((Float)(form.getDisco() * raid6)).intValue();
            
            precioCapexHW = precioSto;
        } 
        
        if(so.getDescripcion() != null && so.getDescripcion().equalsIgnoreCase("Sin Licencia")){
            
            precioOpex = 0;
            precioCapexSoft = 0;
            
        }
        
        if(form.getIdDetalle() == null || form.getIdDetalle().equals("")){
                retorno = dao.ejecutar("insert into virtual values(" + dao.getIdVirtual() + "," + id + ",'"
                + form.getMemoria() + "','" + form.getProcesador() + "','" + form.getDisco() + "'," + form.getRaid()
                + "," + form.getSistemaOperativo() + "," + precioCapexSoft + "," + precioOpex + "," + precioCapexDesa + ","
                + precioCapexHW + "," + form.getAmbiente() + "," + (mes) + "," + form.getCantidad() + ",'"+form.getObservaciones()+"'," + precioOutsourcing + ")");
        }else{
                dao.ejecutar("delete from virtual where id ='"+form.getIdDetalle()+"'");
                retorno = dao.ejecutar("insert into virtual values(" + form.getIdDetalle() + "," + id + ",'"
                + form.getMemoria() + "','" + form.getProcesador() + "','" + form.getDisco() + "'," + form.getRaid()
                + "," + form.getSistemaOperativo() + "," + precioCapexSoft + "," + precioOpex + "," + precioCapexDesa + ","
                + precioCapexHW + "," + form.getAmbiente() + "," + (mes) + "," + form.getCantidad() + ",'"+form.getObservaciones()+"'," + precioOutsourcing + ")");
        }  
                
        return retorno;
    }
    
    public void exportar(HttpServletRequest request, CotizadorForm cotizadorForm,HttpServletResponse res) {
       
            DbUtil dbUtil = new DbUtil(cotizadorForm.getMoneda());
            try {
            
            Connection con = dbUtil.getConnection();
            
            CotizadorLog.getInstance().log("ok conexion base - reporte");
            InputStream template = request.getSession().getServletContext().getResourceAsStream("/reportes/cotizacionesReport.jrxml");
               
            int id = cotizadorForm.getIndice();
            HashMap map = new HashMap();
            map.put("id",id); 
            map.put("nombre",cotizadorForm.getDescripcion()); 
            map.put("total",String.valueOf(cotizadorForm.getTotal())); 
            CotizadorLog.getInstance().log("indice - reporte" + id);
            res.setContentType( "application/pdf" );  
            res.setHeader("Content-disposition","attachment; filename=" +"cotizacion.pdf" );
               
                ServletOutputStream servletOutputStream = res.getOutputStream();
                CotizadorLog.getInstance().log(template.toString());
                JasperDesign jasperDesign = JRXmlLoader.load(template);
                CotizadorLog.getInstance().log("post load");
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                CotizadorLog.getInstance().log("post compile");
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,map,con);
                CotizadorLog.getInstance().log("ok pre export");
                JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                CotizadorLog.getInstance().log("ok post export");
                servletOutputStream.flush();
                servletOutputStream.close(); 
                dbUtil.closeConnection();
                
            } catch (Exception ex) {
             
             dbUtil.closeConnection();
             CotizadorLog.getInstance().log("a- "+ex.getMessage());
             dbUtil.closeConnection();
             
             CotizadorLog.getInstance().log("error");
             CotizadorLog.getInstance().log(ex.getMessage());
            }  
       
    }
    
     public ArrayList<Descriptor> totales(ActionMapping mapping, HttpServletRequest request, CotizadorForm form) {
                
        DbUtil dao = new DbUtil(form.getMoneda());
        int total = 0 ;
        
        ResultSet rs = dao.getResult("select sum(precio ) precio, ambiente from ( "+
                     " select sum(precio * cantidad * meses) precio ,a.descripcion ambiente from "+
                     "  cotizaciones_detalle d,  ambientes a,productos p "+
                     " where d.producto_id=p.producto_id and d.ambiente=a.ambiente_id "+
                     " and cotizacion_id='"+form.getIndice()+"' group by a.descripcion union all "+
                     " select sum(decode(id_so,34,1,cantidad)*(precio_capex_soft + precio_opex_out + precio_capex_desa + precio_capex_hw)) precio ,a.descripcion ambiente from "+
                     "  virtual d,  ambientes a, productos p where d.ambiente=a.ambiente_id "+
                     " and id_cotizacion='"+form.getIndice()+"' and d.id_so = P.PRODUCTO_ID group by a.descripcion) a group by ambiente order by 1 asc");
               

        ArrayList<Descriptor> totalAmbiente = new ArrayList<Descriptor>();
        try {
            while(rs.next()){
                Descriptor desc = new Descriptor();
                desc.setId(rs.getString("precio"));
                desc.setDescripcion(rs.getString("ambiente"));
                totalAmbiente.add(desc);
                double d = Double.parseDouble(rs.getString("precio"));
                total = total + (int)d;
            }
        rs.close();dao.closeConnection();     
        } catch (SQLException ex) {
             CotizadorLog.getInstance().log(ex.getMessage());
        }
         
        form.setTotal(total);
        return totalAmbiente;
    }
     
     public ArrayList<Descriptor> totalesNaturaleza(ActionMapping mapping, HttpServletRequest request, CotizadorForm form) {
                
        DbUtil dao = new DbUtil(form.getMoneda());
        
        ResultSet rs = dao.getResult("select sum(precio) precio,naturaleza from ( "+
            " select sum(precio_capex_hw * decode(id_so,34,1,cantidad)) precio,'DTI.CAPEX.COMPRAHARDWARE' naturaleza from virtual"+
            " where id_cotizacion='"+form.getIndice()+"' "+
            " union all "+
            " select sum(precio_capex_soft * cantidad),'DTI.CAPEX.COMPRASOFTWARE' from virtual"+
            " where id_cotizacion='"+form.getIndice()+"' union all"+
            " select sum(precio_opex_out * cantidad),'OUTSOURCING' from virtual v, productos p"+
            " where id_cotizacion='"+form.getIndice()+"'  and v.id_so = P.PRODUCTO_ID union all"+
            " select sum(precio_capex_desa * cantidad),'DTI.CAPEX.DESARROLLOS' from virtual"+
            " where id_cotizacion='"+form.getIndice()+"' union all"+
            " select sum(precio * cantidad * meses) precio,n.descripcion naturaleza from cotizaciones_detalle d, "+
            " productos p, naturaleza n"+
            " where d.producto_id = p.producto_id and p.naturaleza_id=n.id"+
            " and d.cotizacion_id='"+form.getIndice()+"' group by n.descripcion) a"+
            " group by naturaleza order by precio asc");
               

        ArrayList<Descriptor> totalNat= new ArrayList<Descriptor>();
        try {
            while(rs.next()){
                Descriptor desc = new Descriptor();
                desc.setId(rs.getString("precio"));
                desc.setDescripcion(rs.getString("naturaleza"));
                totalNat.add(desc);
            }
        rs.close();dao.closeConnection();     
        } catch (SQLException ex) {
              CotizadorLog.getInstance().log(ex.getMessage());
        }
        
        return totalNat;
    }
}
