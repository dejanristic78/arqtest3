package dejan.arqtest3.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;

@RequestScoped
@Named
public class IndexBean {
    @Inject
    private transient Logger logger;
    
    public IndexBean() {
        //LOGGER = LoggerFactory.getLogger(IndexBean.class);
    }
    public void doSomething() {
        System.err.println("asdf");
        logger.info("IndexBean LOGGING");
    }
    
}
