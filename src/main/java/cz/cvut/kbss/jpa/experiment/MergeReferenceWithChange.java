package cz.cvut.kbss.jpa.experiment;

import cz.cvut.kbss.jpa.model.Employee;
import cz.cvut.kbss.jpa.model.Student;

import javax.persistence.EntityManager;

/**
 * Checks how merging an object with reference that contains a changed attribute works (without cascading).
 */
public class MergeReferenceWithChange extends BaseExperiment {

    public MergeReferenceWithChange(EntityManager em) {
        super(em);
    }

    @Override
    protected void experiment() {
        final Employee emp = new Employee();
        emp.setId(117);
        emp.setName("Some person");
        emp.setSalary(10000.0);
        final Student student = new Student();
        student.setEmail("student@fel.cvut.cz");
        student.setName("Some student");
        student.setId(118);


        em.getTransaction().begin();
        em.persist(emp);
        em.persist(student);
        emp.setSubordinate(student);
        em.getTransaction().commit();
        em.clear();
        em.getEntityManagerFactory().getCache().evictAll();

        em.getTransaction().begin();
        emp.getSubordinate().setEmail("newmail@fel.cvut.cz");
        final Employee merged = em.merge(emp);
        System.out.println(merged.getSubordinate().getEmail());
        em.getTransaction().commit();
    }
}
