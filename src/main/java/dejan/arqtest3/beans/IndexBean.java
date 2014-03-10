package dejan.arqtest3.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class IndexBean {
    @Inject
    FacadeBean facadeBean;
    
    public void doSomething() {
        System.err.println("asdfasdf");
        facadeBean.save();
    }
    
}
