package dejan.arqtest3.beans;

import dejan.arqtest3.model.SomePerson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FacadeBean {
    @PersistenceContext(unitName = "arqtest3PU")
    EntityManager em;
    
    public boolean save() {
        System.err.println("save");
//         SomePerson p = new SomePerson();
//         System.err.println(p);
//         em.persist(p);
//         SomePerson pp = new SomePerson();
//         System.err.println(pp);
//         em.persist(p);
        try
        {
            SomePerson p = new SomePerson();
            em.persist(p);
        } catch (Exception e)
        {
            System.err.println("fel i inlägg i databas");
            System.err.println(e.getMessage());
            return false;
        } 
        
        return true;
    }
}
