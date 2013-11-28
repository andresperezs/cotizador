/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login.action;

import dao.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.form.LoginForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author ar00112343
 */
public class LoginAction extends org.apache.struts.action.Action {

    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("logger inicial");
        LoginForm loginForm = (LoginForm) form;
        if(!loginForm.getMoneda().equals("")) {
            
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
                
                Hashtable env = new Hashtable();
                env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
                
                String ad ="ardc1svp00001.latam1.prosegur.local";
                        
                if(loginForm.getMoneda().equals("latam2")){
                    ad="brbhzsvp0001.latam2.prosegur.local";
                }
                if(loginForm.getMoneda().equals("emea")){
                    ad="ESDC1SVP00064.emea.prosegur.local";
                }
                                        
                env.put(Context.PROVIDER_URL, "ldap://"+ad+":389/DC=prosegur,DC=local");
                String user =loginForm.getMoneda() +"\\"+loginForm.getUserName();
                env.put(Context.SECURITY_AUTHENTICATION, "simple");
                env.put(Context.SECURITY_PRINCIPAL, user);
                env.put(Context.SECURITY_CREDENTIALS, loginForm.getPassword());
                // Create the initial context
                try {
                    DirContext ctx = new InitialDirContext(env);
                    ctx.close();

                } catch (NamingException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    ActionErrors errores = new ActionErrors();
                    ActionMessage message = new ActionMessage("error.credenciales");

                    errores.add(ActionErrors.GLOBAL_MESSAGE, message);
                    saveErrors(request, errores);
                    return mapping.findForward(FAILURE);
                    
                }
                
                HttpSession session = request.getSession();
                session.setAttribute("UserName", loginForm.getUserName());
                session.setAttribute("region", loginForm.getMoneda());
                
                return mapping.findForward(SUCCESS);

        }

        return mapping.findForward(FAILURE);
    }
}