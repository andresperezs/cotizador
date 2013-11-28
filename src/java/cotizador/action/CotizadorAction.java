/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador.action;
import abm.productos.dao.ProductosDao;
import abm.productos.dominio.Producto;
import com.logs.CotizadorLog;
import cotizador.contributor.CotizadorContibutor;
import cotizador.dao.CotizadorDao;
import dao.DbUtil;
import cotizador.dominio.cotizacion;
import cotizador.form.CotizadorForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author ar00112343
 */
public class CotizadorAction extends Action{
    
    private final static String INDEX= "showIndex";
    private final static String VER_DETALLE= "detalle";
    private final static String VOLVER= "volver";
    private final static String BUSCAR= "buscar";
    private final static String BUSCAR_DETALLE= "buscarDetalle";
    private final static String EMPTY= "vacio";
    private final static String BORRAR_COTIZACION= "borrar";
    private final static String BORRAR_COTIZACION_DETALLE= "borrarDetalle";
    private final static String BORRAR_COTIZACION_DETALLE_VIRTUAL= "borrarDetalleVirtual";
    private final static String ALTA_COTIZACION= "create";   
    private final static String INSERTAR_DETALLE= "insertarDetalle"; 
    private final static String INSERTAR_CABECERA= "insertarCabecera"; 
    private final static String EXPORTAR= "exportarDetalle"; 
    private final static String EDITAR_DETALLE= "editar"; 
    private final static String EDITAR_DETALLE_VIRTUAL= "editarVirtual"; 
    private final static String VIRTUAL= "virtual"; 
    private final static String BASE= "base"; 
    private final static String INSERTARVIRTUAL="insertarVirtual";
    private final static String TOTALES="totales";
    private final static String BACKUP="backup";
    private final static String RACK="rack";
    private final static String INFO="saveInfo";
    private final static String EDITINFO="editInfo";
    
    public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,
            HttpServletResponse response)
                {
                   CotizadorForm cotizadorForm = (CotizadorForm) form;
                   
                   System.out.println("ACCION - "+cotizadorForm.getAccion());
                   getUser(cotizadorForm,request);
                   
                   if (cotizadorForm.getAccion().equals(INDEX))
                       return showIndex(mapping);
                   if (cotizadorForm.getAccion().equals(VER_DETALLE))
                       return verDetalle(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(BUSCAR))
                       return  buscar(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(BUSCAR_DETALLE))
                       return  verDetalle(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(VOLVER))
                       return  buscar(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(BORRAR_COTIZACION))
                       return borrar(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(BORRAR_COTIZACION_DETALLE))
                       return borrarDetalle(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(ALTA_COTIZACION))
                       return create(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(INSERTAR_DETALLE))
                       return insertarDetalle(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(INSERTAR_CABECERA))
                       return insertarCabecera(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(EXPORTAR))
                       exportar(mapping,request,cotizadorForm,response);
                   if (cotizadorForm.getAccion().equals(EDITAR_DETALLE))
                       return editar(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(VIRTUAL))
                       return virtual(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(BASE))
                       return virtual(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(INSERTARVIRTUAL))
                       return insertarVirtual(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(EDITAR_DETALLE_VIRTUAL))
                       return editarVirtual(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(BORRAR_COTIZACION_DETALLE_VIRTUAL))
                       return borrarDetalleVirtual(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(TOTALES))
                       return totales(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(BACKUP))
                       return backup(mapping,request,cotizadorForm);
                    if (cotizadorForm.getAccion().equals(RACK))
                       return rack(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(INFO))
                       return saveInfo(mapping,request,cotizadorForm);
                   if (cotizadorForm.getAccion().equals(EDITINFO))
                       return editProyecto(mapping,request,cotizadorForm);
                   
                   return null;
                }

    private ActionForward showIndex(ActionMapping mapping) {
         
        return mapping.findForward(EMPTY);
    }
    
    private ActionForward buscar(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        
        ArrayList<cotizacion> lista = dao.getListaCotizaciones(form.getNombre());
           
        form.setLista(lista);
        request.setAttribute("lista",lista );
        
        if(lista.isEmpty())
            return mapping.findForward(EMPTY);
        else    
            return mapping.findForward(INDEX);
    }
    
    private ActionForward verDetalle(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        form.setMuestraMant(dao.getMuestraMant());
        
        ArrayList<cotizacion> lista = dao.getListaDetalles(form.getIndice());
        
        form.setLista(lista);
        form.setSimbolo(dao.getSimboloMoneda());
        request.setAttribute("lista",lista );
       
        if(lista.isEmpty())
            return mapping.findForward("vacioDetalle");
        else    
            return mapping.findForward("showDetalle");
    }
    
    private ActionForward editProyecto(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        dao.setInfo(form.getIndice(),form);
        
        return mapping.findForward("editInfo");
    }
    
    private ActionForward borrar(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        DbUtil util = new DbUtil(form.getMoneda());
        
        util.ejecutar("delete from cotizaciones_detalle where cotizacion_id='"+form.getIndice()+"'"); 
        
        util = new DbUtil(form.getMoneda());
        util.ejecutar("delete from virtual where id_cotizacion='"+form.getIndice()+"'"); 
        
        util = new DbUtil(form.getMoneda());
        util.ejecutar("delete from cotizaciones_cabecera where cotizacion_id='"+form.getIndice()+"'");        
        util.closeConnection();
        return  buscar(mapping,request,form);
    }
    
    private ActionForward borrarDetalle(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        DbUtil util = new DbUtil(form.getMoneda());
        util.ejecutar("delete from cotizaciones_detalle where (cotizacion_id||producto_id||ambiente)='"+form.getIdDetalle()+"'");        
        util.closeConnection();
        return  verDetalle(mapping,request,form);
    }
     
    private ActionForward borrarDetalleVirtual(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        DbUtil util = new DbUtil(form.getMoneda());
        util.ejecutar("delete from virtual where id='"+form.getIdDetalle()+"'");        
        
        return  verDetalle(mapping,request,form);
    }
    
    private ActionForward insertarDetalle(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        ProductosDao daoProd = new ProductosDao(form.getMoneda());
        int id = form.getIndice(); 
        String idDetalle = form.getIdDetalle(); 
        
        Producto prod = daoProd.getProductoById(form.getIdProducto());
        
        if(prod.getTipo().equalsIgnoreCase("fisico") || prod.getTipo().equalsIgnoreCase("Licencia SO")){
            
            float precioCapexDesa = 0;
            float precioCapexHW = 0;
            float precioOpex = 0;
            float precioCapexSoft = 0;
            
            //SI LICENCIA SO
            if(prod.getTipo().equalsIgnoreCase("Licencia SO")){
                
                precioCapexSoft = prod.getPrecio();        
                if(prod == null || prod.getDescripcion() == null)
                    precioOpex = 0;
                else if(prod.getDescripcion().contains("Win"))
                    precioOpex = precioCapexSoft * ((float)0.2);
                else if(prod.getDescripcion().contains("Hat")){
                    precioOpex = precioCapexSoft ;
                    precioCapexSoft = 0;
                }
            }else  
            {
                if(prod.getTipo().equalsIgnoreCase("fisico"))
                    precioCapexHW = prod.getPrecio();    
                precioCapexDesa = daoProd.getPrecioByDesc("Instalación y Configuración  Equipo Fisico");
            }
            
            if(idDetalle.equals("")){
                dao.ejecutar("insert into virtual values(" + dao.getIdVirtual() + "," + id + ",'"
                + 0 + "','" + form.getProcesador() + "','" + 0 + "'," + form.getRaid()
                + "," + form.getIdProducto() + "," + precioCapexSoft + "," + precioOpex + "," + precioCapexDesa + ","
                + precioCapexHW + "," + form.getAmbiente() + "," + 0 + "," + form.getCantidad() + ",'"+form.getObservaciones()+"',0)");
            }else{
                dao.ejecutar("delete from virtual where id ='"+idDetalle+"'");
                dao.ejecutar("insert into virtual values(" + idDetalle + "," + id + ",'"
                + 0 + "','" + form.getProcesador() + "','" + 0 + "'," + form.getRaid()
                + "," + form.getIdProducto() + "," + precioCapexSoft + "," + precioOpex + "," + precioCapexDesa + ","
                + precioCapexHW + "," + form.getAmbiente() + "," + 0 + "," + form.getCantidad() + ",'"+form.getObservaciones()+"',0)");
            }  
            
        }else{ 
                    
            if(!dao.existeId(idDetalle)){
          
            dao.ejecutar("insert into cotizaciones_detalle values("+id+",'"+form.getIdProducto()+"','"
                     +form.getObservaciones()+"',"+form.getAmbiente()+","+form.getCantidad()+","+form.getMeses()+")");
            } else{
                 dao.ejecutar("delete from cotizaciones_detalle where (cotizacion_id||producto_id||ambiente)='"+idDetalle+"'");
                 dao.ejecutar("insert into cotizaciones_detalle values("+id+",'"+form.getIdProducto()+"','"
                         +form.getObservaciones()+"',"+form.getAmbiente()+","+form.getCantidad()+","+form.getMeses()+")");
            }
        }
        return  verDetalle(mapping,request,form);
    }
    
    private ActionForward create(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
         
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        form.setIdDetalle("");
        form.setCantidad(0);
        form.setObservaciones("");
        form.setAmbiente("1");
        request.setAttribute("descripcion", ""); 
        request.setAttribute("ambiente", "1"); 
        request.setAttribute("productos", dao.getProductos()); 
        request.setAttribute("ambientes", dao.getAmbientes()); 
        return mapping.findForward(ALTA_COTIZACION);
    }
    
    private ActionForward saveInfo(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
         
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        int id = form.getIndice();
        String pgi = form.getPgi();
        String nombre = form.getNombre();
        String clarity =  form.getClarity();
         
        dao.ejecutar("update cotizaciones_cabecera set nombre='"+nombre+"',pgi='"+pgi+"',clarity='"+clarity+"' where cotizacion_id="+id);   
        
        return  buscar(mapping,request,form);
    }
    
    private ActionForward insertarCabecera(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
        
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        int id = dao.getIdCotizacion(); 
         
        dao.ejecutar("insert into cotizaciones_cabecera values("+id+",'"+form.getNombre()+"',null,null,sysdate)");   
        
        return  buscar(mapping,request,form);
    }
    
    private void exportar(ActionMapping mapping, HttpServletRequest request, CotizadorForm cotizadorForm,HttpServletResponse res) {
       
        CotizadorContibutor cc = new CotizadorContibutor();
        cotizadorForm.setListaAmbientes(cc.totales(mapping, request, cotizadorForm));
        cc.exportar(request, cotizadorForm, res);    
            
    }
    
    private ActionForward editar(ActionMapping mapping,HttpServletRequest request,CotizadorForm cotizadorForm) {
         
        CotizadorDao dao = new CotizadorDao(cotizadorForm.getMoneda());
        
        int id = cotizadorForm.getIndice();
        String idDetalle = cotizadorForm.getIdDetalle();
        
        cotizacion cot = dao.getDetalle(id,idDetalle);
          
        request.setAttribute("productos", dao.getProductos()); 
        request.setAttribute("ambientes", dao.getAmbientes()); 
        
        request.setAttribute("descripcion", cot.getIdProducto()); 
        request.setAttribute("ambiente", cot.getAmbiente()); 
        
        cotizadorForm.setMeses(cot.getMeses()); 
        cotizadorForm.setAmbiente(cot.getAmbiente()); 
        cotizadorForm.setIdProducto(cot.getIdProducto()); 
        cotizadorForm.setCantidad(cot.getCantidad()); 
        cotizadorForm.setObservaciones(cot.getObservaciones()); 
        
        return mapping.findForward(ALTA_COTIZACION);
    }
    
    private ActionForward editarVirtual(ActionMapping mapping,HttpServletRequest request,CotizadorForm cotizadorForm) {
         
        CotizadorDao dao = new CotizadorDao(cotizadorForm.getMoneda());
        ProductosDao daoProd = new ProductosDao(cotizadorForm.getMoneda());
        String tipo = "Licencia SO";
        
        int id = cotizadorForm.getIndice();
        String idDetalle = cotizadorForm.getIdDetalle();
        
        dao.getDetalleVirtual(cotizadorForm,id,idDetalle);
          
        request.setAttribute("productos", dao.getProductos()); 
        request.setAttribute("ambientes", dao.getAmbientes()); 
        
        request.setAttribute("ambiente", cotizadorForm.getAmbiente()); 
        request.setAttribute("meses", cotizadorForm.getMeses()); 
        
        request.setAttribute("so", dao.getLicencias(tipo)); 
        request.setAttribute("raid", dao.getRaid()); 
        request.setAttribute("observaciones", cotizadorForm.getObservaciones());
        
        Producto prod = daoProd.getProductoById(cotizadorForm.getIdProducto());
        
        if(prod.getDescripcion().equalsIgnoreCase("Unidad de Rack"))
            return mapping.findForward(RACK);
        
        if(prod.getTipo().equalsIgnoreCase("fisico") || prod.getTipo().equalsIgnoreCase("comunicaciones")){
            return mapping.findForward(ALTA_COTIZACION);
        }
        
        if(cotizadorForm.getMemoria() == 0 && cotizadorForm.getDisco() == 0)        
            return mapping.findForward(BACKUP);
        else if(cotizadorForm.getMemoria() != 0)      
            return mapping.findForward(VIRTUAL);
        else      
            return mapping.findForward(BASE)  ;
    }
    
    private ActionForward virtual(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
         
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        String tipo = "Licencia SO";
          
        form.setIdDetalle("");
        form.setMemoria(0);
        form.setDisco(0);
        form.setCantidad(0);
        form.setProcesador(0);
         
        request.setAttribute("raid", dao.getRaid()); 
        request.setAttribute("ambientes", dao.getAmbientes()); 
        
        if(form.getAccion().equals(BASE)) {
            tipo = "Licencia DB";
        }
           
        request.setAttribute("so", dao.getLicencias(tipo)); 
        return mapping.findForward(form.getAccion());
    }

    private ActionForward insertarVirtual(ActionMapping mapping, HttpServletRequest request, CotizadorForm form) {
                
        CotizadorContibutor cc = new CotizadorContibutor();
       
        ActionErrors errores = new ActionErrors();
        ActionMessage message = new ActionMessage("ok.altaVirtual");
          
        if(!cc.insertarVirtual(mapping, request, form)){
            message = new ActionMessage("error.altaVirtual");
        }
        
        errores.add(ActionErrors.GLOBAL_MESSAGE, message);
        saveErrors(request, errores);
            
        return  verDetalle(mapping,request,form);
    }
    
    private ActionForward totales(ActionMapping mapping,HttpServletRequest request,CotizadorForm form) {
         
        CotizadorContibutor cc = new CotizadorContibutor();
        form.setListaAmbientes(cc.totales(mapping, request, form));
        form.setListaNaturaleza(cc.totalesNaturaleza(mapping, request, form));
        return mapping.findForward(TOTALES);
    }

    private ActionForward backup(ActionMapping mapping, HttpServletRequest request, CotizadorForm form) {
        
        form.setCantidad(0);   
        form.setDisco(0);   
        form.setMemoria(0);
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        request.setAttribute("ambientes", dao.getAmbientes()); 
        return mapping.findForward(BACKUP);
    }
    
    private ActionForward rack(ActionMapping mapping, HttpServletRequest request, CotizadorForm form) {
        
        form.setCantidad(0); 
        form.setMeses(0);
        form.setDescripcion("rack");
        CotizadorDao dao = new CotizadorDao(form.getMoneda());
        request.setAttribute("ambientes", dao.getAmbientes()); 
        return mapping.findForward(RACK);
    }
    
    private void getUser(CotizadorForm form,HttpServletRequest request) {
        
         HttpSession session = request.getSession();
         form.setUsuario(session.getAttribute("UserName").toString());
         form.setMoneda(session.getAttribute("region").toString());
         DbUtil dbu = new DbUtil(form.getMoneda());
         form.setPerfil(dbu.queryValor("select tipo from usuarios where id='"+form.getUsuario()+"'"));
         System.out.println("FIN GETUSER - ");
    }
    
}