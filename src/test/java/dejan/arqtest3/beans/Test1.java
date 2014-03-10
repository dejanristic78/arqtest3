

package dejan.arqtest3.beans;

import static org.junit.Assert.*;

import dejan.arqtest3.model.SomePerson;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class Test1 {
    @Deployment
    public static JavaArchive createArchiveAndDeploy() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClasses(FacadeBean.class, SomePerson.class)
                .addAsManifestResource("test-persistence.xml", ArchivePaths.create("persistence.xml"))
            //.addAsManifestResource("META-INF/persistence.xml", ArchivePaths.create("persistence.xml"))
            .addAsManifestResource("WEB-INF/beans.xml", ArchivePaths.create("beans.xml"));
    }
 
    @EJB
    FacadeBean facadeBean;
    
    @Test
    public void someTest() {
        System.out.println("ASDFASDFASDF "+facadeBean);
        assertTrue(facadeBean.save());
        
    }
    
}
