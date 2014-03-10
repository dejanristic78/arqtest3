/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.arqtest3.beans;

import dejan.arqtest3.log.Logged;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
public class CDIBean {
    @Logged
    public String getMessage() {
        return "Message from CDIBean";
    }
}
