package cz.cvut.kbss.jpa.experiment;

import cz.cvut.kbss.jpa.model.Days;
import cz.cvut.kbss.jpa.model.FromToTime;
import cz.cvut.kbss.jpa.model.OpeningHours;

import javax.persistence.EntityManager;
import java.time.LocalTime;
import java.util.HashMap;

/**
 * Checks how reusing embeddable instances in element collection works.
 */
public class ElementCollection extends BaseExperiment {

    public ElementCollection(EntityManager em) {
        super(em);
    }

    @Override
    protected void experiment() {
        final OpeningHours test = new OpeningHours();
        final FromToTime hours = new FromToTime(LocalTime.NOON, LocalTime.MIDNIGHT);
        test.setOpeningHours(new HashMap<>());
        test.getOpeningHours().put(Days.MONDAY, hours);
        test.getOpeningHours().put(Days.TUESDAY, hours);
        em.getTransaction().begin();
        em.persist(test);
        em.getTransaction().commit();

        final OpeningHours result = em.find(OpeningHours.class, test.getId());
        System.out.println(result);
    }
}
