package cz.cvut.kbss.jpa.experiment;

import cz.cvut.kbss.jpa.model.Person;
import cz.cvut.kbss.jpa.model.Student;

import javax.persistence.EntityManager;
import java.util.Collections;

/**
 * Checks how merging an instance that is already managed and has changes works.
 */
public class MergeManagedWithChanges extends BaseExperiment {

    public MergeManagedWithChanges(EntityManager em) {
        super(em);
    }

    @Override
    protected void experiment() {
        final Student student = new Student();
        student.setId(117);
        student.setName("Test Student");
        student.setEmail("test.student@fel.cvut.cz");
        final Person p = new Person();
        p.setName("Test");
        p.setId(118);
        student.setFriends(Collections.singleton(p));

        em.getTransaction().begin();
        em.persist(student);
        em.persist(p);
        em.getTransaction().commit();
        em.clear();
        em.getEntityManagerFactory().getCache().evictAll();

        final Person result = em.find(Person.class, student.getId());
        System.out.println(result.getClass() + " - " + result);
        em.getTransaction().begin();
        p.setName(null);
        final Student merged = em.merge(student);
        System.out.println(merged);
        em.getTransaction().commit();
    }
}
