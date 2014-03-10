package dejan.arqtest3.beans;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class Test2 {
    @Deployment
    public static JavaArchive createArchiveAndDeploy() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClasses(CDIBean.class, MyPojo.class, MyEJB.class, JSFBean.class)
            .addAsManifestResource("WEB-INF/beans.xml", ArchivePaths.create("beans.xml"));
    }
    
    @Inject
    CDIBean cb;
    
    @Inject
    MyPojo mp;  
    
    @EJB
    MyEJB ejb;
    
    @Inject
    JSFBean jsf;
    
    @Test
    public void someTest() {
        System.out.println("QWERQWERQWER "+cb+ " | "+mp+ " | "+ejb);
    }
    @Test
    public void jsfBeanTest() {
        assertEquals("Message from JSFBean", jsf.message());
        assertEquals("Message from CDIBean", jsf.messageFromCDIBean());
    }
    
    
    
}