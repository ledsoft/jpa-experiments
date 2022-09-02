package cz.cvut.kbss.jpa;

import cz.cvut.kbss.jpa.experiment.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        new Main().doJpa();
    }

    public void doJpa() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("oom");
        final EntityManager em = emf.createEntityManager();
        try {
            new CascadeOnReference(em).run();
//            new ElementCollection(em).run();
//            new FindReference(em).run();
//            new MappedByCascadePersist(em).run();
//            new MergeManagedWithChanges(em).run();
//            new MergeReferenceWithChange(em).run();
        } finally {
            em.close();
            emf.close();
        }
    }
}
