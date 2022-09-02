package cz.cvut.kbss.jpa.experiment;

import cz.cvut.kbss.jpa.model.Department;
import cz.cvut.kbss.jpa.model.Employee;

import javax.persistence.EntityManager;
import java.util.Collections;

/**
 * Checks how cascading works on the mappedBy side of a bidirectional relationship.
 */
public class MappedByCascadePersist extends BaseExperiment {

    public MappedByCascadePersist(EntityManager em) {
        super(em);
    }

    @Override
    protected void experiment() {
        final Department dept = new Department("Test");
        final Employee emp = new Employee();
        emp.setId(1);
        emp.setName("test");
        dept.setEmployees(Collections.singletonList(emp));
        em.getTransaction().begin();
        em.persist(dept);
        em.getTransaction().commit();
        em.clear();
        em.getEntityManagerFactory().getCache().evictAll();

        final Department d = em.find(Department.class, dept.getId());

        System.out.println(d);
        System.out.println(d.getEmployees());
    }
}
