package cz.cvut.kbss.jpa.experiment;

import cz.cvut.kbss.jpa.model.Employee;
import cz.cvut.kbss.jpa.model.Student;

import javax.persistence.EntityManager;

public class CascadeOnReference extends BaseExperiment {

    public CascadeOnReference(EntityManager em) {
        super(em);
    }

    @Override
    protected void experiment() {
        final Employee advisor = new Employee();
        advisor.setId(1);
        advisor.setName("Advisor");
        final Student student = new Student();
        student.setId(2);
        student.setName("Student");
        student.setEmail("student@example.org");
        em.getTransaction().begin();
        em.persist(advisor);
        em.persist(student);
        student.setAdvisor(advisor);
        em.getTransaction().commit();
        em.clear();
        em.getEntityManagerFactory().getCache().evictAll();

        em.getTransaction().begin();
        final Student s = em.getReference(Student.class, student.getId());
        em.remove(s);
        em.getTransaction().commit();

        final Employee result = em.find(Employee.class, advisor.getId());
        System.out.println("Advisor is " + result);
    }
}
