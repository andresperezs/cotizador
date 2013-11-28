/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author ar00112343
 */
public class LoginForm extends ActionForm {

    private String userName = "";
    private String password = "";
    private String moneda = "";
        
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        

        ActionErrors errors = new ActionErrors();

        if (getUserName() == null || getUserName().length() < 1) {

            errors.add("userName", new ActionMessage("error.userName.required"));

        }

        if (getPassword() == null || getPassword().length() < 1) {

            errors.add("password", new ActionMessage("error.password.required"));

        }

        return errors;

    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
    
    
}
