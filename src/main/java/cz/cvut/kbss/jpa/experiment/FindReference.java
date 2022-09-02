package cz.cvut.kbss.jpa.experiment;

import cz.cvut.kbss.jpa.model.Employee;

import javax.persistence.EntityManager;

/**
 * Checks how finding instance that is already loaded as via getReference works.
 */
public class FindReference extends BaseExperiment {

    public FindReference(EntityManager em) {
        super(em);
    }

    @Override
    protected void experiment() {
        final Employee emp = new Employee();
        emp.setId(117);
        emp.setName("Some person");
        emp.setSalary(10000.0);
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        final Employee reference = em.getReference(Employee.class, emp.getId());
        final Employee result = em.find(Employee.class, emp.getId());
        System.out.println(reference);
        System.out.println(result);
        System.out.println("reference == find ? " + (reference == result));
    }
}
