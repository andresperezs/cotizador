/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abm.productos.action;

import abm.productos.dao.ProductosDao;
import abm.productos.dominio.Producto;
import abm.productos.form.ProductosForm;
import dao.DbUtil;
import java.util.ArrayList;
import java.util.HashMap;
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
public class ProductosAction extends Action{
    
    private final static String INDEX= "showIndex";
    private final static String BUSCAR= "buscar";
    private final static String BORRAR= "borrar";
    private final static String NUEVO= "nuevo";
    private final static String EDIT= "edit";
    private final static String GRABAR= "insertar";
    
    public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,
            HttpServletResponse response)
                {
                   ProductosForm productosForm = (ProductosForm) form;
                   
                   getUser(productosForm,request);
                   
                   if (productosForm.getAccion().equals(INDEX))
                       return  showIndex(mapping,request,productosForm);
                   if (productosForm.getAccion().equals(BUSCAR))
                       return  buscar(mapping,request,productosForm);
                   if (productosForm.getAccion().equals(BORRAR))
                       return  borrar(mapping,request,productosForm);  
                   if (productosForm.getAccion().equals(NUEVO))
                       return  create(mapping,request,productosForm);      
                   if (productosForm.getAccion().equals(GRABAR))
                       return  save(mapping,request,productosForm);    
                   if (productosForm.getAccion().equals(EDIT))
                       return  edit(mapping,request,productosForm);   
                   return null;
                }

    private ActionForward showIndex(ActionMapping mapping,HttpServletRequest request, ProductosForm form) {
        
        form.setId(0);
        ArrayList<Producto> lista = new ArrayList<Producto>();
        form.setLista(lista);
        request.setAttribute("lista",lista );
        
        return mapping.findForward(INDEX);
    }
   
    private ActionForward buscar(ActionMapping mapping,HttpServletRequest request, ProductosForm form) {
        
        form.setId(0);
        ProductosDao dao = new ProductosDao(form.getRegion());
        ArrayList<Producto> lista = dao.getLista();
        
        form.setLista(lista);
        request.setAttribute("lista",lista );
        
        return mapping.findForward(BUSCAR);
    }
    
    private ActionForward borrar(ActionMapping mapping,HttpServletRequest request, ProductosForm form) {
        
        ProductosDao dao = new ProductosDao(form.getRegion());
         
        ActionErrors errores = new ActionErrors();
        ActionMessage message = new ActionMessage("error.okBajaProducto");
          
        if(!dao.borrar(form.getIndice())){
            message = new ActionMessage("error.bajaProductos");
        }
            errores.add(ActionErrors.GLOBAL_MESSAGE, message);
            saveErrors(request, errores);
         
        ArrayList<Producto> lista = dao.getLista();
        
        form.setLista(lista);
        request.setAttribute("lista",lista );
        
        return mapping.findForward(BUSCAR);
    }

    private ActionForward create(ActionMapping mapping, HttpServletRequest request, ProductosForm form) {
        
        ProductosDao dao = new ProductosDao(form.getRegion());
        
        form.setIndice(0);
        form.setNombre(""); 
        form.setPrecio(0); 
        form.setNaturaleza(0); 
        
        HashMap<String, String> tipos = new HashMap<String, String>();
        
        tipos.put("Licencia SO", "Licencia SO");
        tipos.put("Licencia DB", "Licencia DB");
        tipos.put("Licencia Genericas", "Licencia Genericas");
        tipos.put("Storage", "Storage");
        tipos.put("Comunicaciones", "Comunicaciones");
        tipos.put("Asistencia Tecnica", "Asistencia Tecnica");
        tipos.put("Fisico", "Fisico");
        
        request.setAttribute("tipos", tipos); 
        request.setAttribute("naturalezas", dao.getNaturalezas()); 
        
        return mapping.findForward(NUEVO);
    }

    private ActionForward save(ActionMapping mapping, HttpServletRequest request, ProductosForm form) {
        
        boolean resultado = false;
        ProductosDao dao = new ProductosDao(form.getRegion());
        
         if(form.getIndice() != 0){
            resultado = dao.updateProducto(form); 
         }else{   
            resultado = dao.saveProducto(form);
         } 
         
         ActionErrors errores = new ActionErrors();
         ActionMessage message = new ActionMessage("error.okAltaProducto");
          
         if(!resultado){
            message = new ActionMessage("error.altaProductos");
         }
            errores.add(ActionErrors.GLOBAL_MESSAGE, message);
            saveErrors(request, errores);
         
         
         return buscar(mapping,request,form);
    }
    
    private ActionForward edit(ActionMapping mapping, HttpServletRequest request, ProductosForm form) {
        
        ProductosDao dao = new ProductosDao(form.getRegion());
        Producto producto = new Producto();
        
        producto = dao.getProductoById(form.getIndice());
        request.setAttribute("naturalezas", dao.getNaturalezas()); 
        
         HashMap<String, String> tipos = new HashMap<String, String>();
        
        tipos.put("Licencia SO", "Licencia SO");
        tipos.put("Licencia DB", "Licencia DB");
        tipos.put("Licencia Genericas", "Licencia Genericas");
        tipos.put("Storage", "Storage");
        tipos.put("Comunicaciones", "Comunicaciones");
        tipos.put("Asistencia Tecnica", "Asistencia Tecnica");
        tipos.put("Fisico", "Fisico");
        
        request.setAttribute("tipos", tipos); 
        
        form.setNombre(producto.getDescripcion()); 
        form.setPrecio((int)producto.getPrecio()); 
        form.setNaturaleza(producto.getNaturaleza());
        
        return mapping.findForward(NUEVO);
    }
  
     private void getUser(ProductosForm form, HttpServletRequest request) {
        
         HttpSession session = request.getSession();
         form.setUsuario(session.getAttribute("UserName").toString());
         DbUtil dbu = new DbUtil(session.getAttribute("region").toString());
         form.setRegion(session.getAttribute("region").toString());
         form.setPerfil(dbu.queryValor("select tipo from usuarios where id='"+form.getUsuario()+"'"));
        
    }
}
