/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abm.naturalezas.action;

import abm.naturalezas.dao.NaturalezasDao;
import abm.naturalezas.dominio.Naturaleza;
import abm.naturalezas.form.NaturalezasForm;
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
public class NaturalezasAction extends Action{
    
    private final static String INDEX= "showIndex";
    private final static String BUSCAR= "buscar";
    private final static String BORRAR= "borrar";
    private final static String NUEVO= "nuevo";
    private final static String EDIT= "edit";
    private final static String GRABAR= "insertar";
    
    public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,
            HttpServletResponse response)
                {
                   NaturalezasForm naturalezasForm = (NaturalezasForm) form;
                   
                   getUser(naturalezasForm,request);
                   
                   if (naturalezasForm.getAccion().equals(INDEX))
                       return  showIndex(mapping,request,naturalezasForm);
                   if (naturalezasForm.getAccion().equals(BUSCAR))
                       return  buscar(mapping,request,naturalezasForm);
                   if (naturalezasForm.getAccion().equals(BORRAR))
                       return  borrar(mapping,request,naturalezasForm);  
                   if (naturalezasForm.getAccion().equals(NUEVO))
                       return  create(mapping,request,naturalezasForm);      
                   if (naturalezasForm.getAccion().equals(GRABAR))
                       return  save(mapping,request,naturalezasForm);   
                   if (naturalezasForm.getAccion().equals(EDIT))
                       return  edit(mapping,request,naturalezasForm);   
                   return null;
                }

    private ActionForward showIndex(ActionMapping mapping,HttpServletRequest request, NaturalezasForm form) {
        
        form.setId(0);
        form.setLista(null);
        
        return mapping.findForward(INDEX);
    }
    
    private ActionForward buscar(ActionMapping mapping,HttpServletRequest request, NaturalezasForm form) {
        
        form.setId(0);
        NaturalezasDao dao = new NaturalezasDao(form.getRegion());
         
        ArrayList<Naturaleza> lista = dao.getLista();
        
            
        form.setLista(lista);
        request.setAttribute("lista",lista );
        
        return mapping.findForward(BUSCAR);
    }
    
    private ActionForward borrar(ActionMapping mapping,HttpServletRequest request, NaturalezasForm form) {
        
        NaturalezasDao dao = new NaturalezasDao(form.getRegion());
         
        ActionErrors errores = new ActionErrors();
        ActionMessage message = new ActionMessage("error.okBajaNaturaleza");
          
        if(!dao.borrar(form.getIndice())){
            message = new ActionMessage("error.bajaNaturalezas");
        }
            errores.add(ActionErrors.GLOBAL_MESSAGE, message);
            saveErrors(request, errores);
         
        ArrayList<Naturaleza> lista = dao.getLista();
        
        form.setLista(lista);
        request.setAttribute("lista",lista );
        
        return mapping.findForward(BUSCAR);
    }

    private ActionForward create(ActionMapping mapping, HttpServletRequest request, NaturalezasForm form) {
        
        NaturalezasDao dao = new NaturalezasDao(form.getRegion());
        form.setNombre(""); 
        form.setIndice(0);
        
        request.setAttribute("naturalezas", dao.getNaturalezas()); 
      
        return mapping.findForward(NUEVO);
    }

    private ActionForward save(ActionMapping mapping, HttpServletRequest request, NaturalezasForm naturalezasForm) {
        
         boolean resultado = false;
         NaturalezasDao dao = new NaturalezasDao(naturalezasForm.getRegion());
         
         if(naturalezasForm.getIndice() != 0){
            resultado = dao.updateNaturaleza(naturalezasForm); 
         }else{   
            resultado = dao.saveNaturaleza(naturalezasForm);
         } 
         
         ActionErrors errores = new ActionErrors();
         ActionMessage message = new ActionMessage("error.okAltaNaturaleza");
          
         if(!resultado){
            message = new ActionMessage("error.altaNaturalezas");
         }
            errores.add(ActionErrors.GLOBAL_MESSAGE, message);
            saveErrors(request, errores);
         
         
         return buscar(mapping,request,naturalezasForm);
    }
    
    private ActionForward edit(ActionMapping mapping, HttpServletRequest request, NaturalezasForm form) {
        
        NaturalezasDao dao = new NaturalezasDao(form.getRegion());
        Naturaleza nat = new Naturaleza();
        
        nat = dao.getNaturalezaById(form.getIndice());
        request.setAttribute("naturalezas", dao.getNaturalezas()); 
        
        form.setNombre(nat.getDescripcion()); 
        
        return mapping.findForward(NUEVO);
    }
   
  private void getUser(NaturalezasForm form, HttpServletRequest request) {
        
         HttpSession session = request.getSession();
         form.setUsuario(session.getAttribute("UserName").toString());
         form.setRegion(session.getAttribute("region").toString());
        
    }
}
