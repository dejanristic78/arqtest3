/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.arqtest3.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean()
@ViewScoped
public class JSFBean {
    @Inject
    CDIBean cdi;
    
    public String message() {
        return "Message from JSFBean";
    }
    public String messageFromCDIBean() {
        return cdi.getMessage();
    }
    
}
