import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaAPI {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        EntityManager em=emf.createEntityManager();
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Object []> cq=cb.createQuery(Object[].class);
        Root<Employee> r=cq.from(Employee.class);
        cq.multiselect(r.get("dept"), cb.count(r)).groupBy(r.get("dept"));
        Query q=em.createQuery(cq);
        List<Object[]> li=q.getResultList();
        li.forEach(e->{
            System.out.println(e[0]+" "+ e[1]);
        });
    }
}
