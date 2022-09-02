package cz.cvut.kbss.jpa.model;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class Listener {

    private int counter = 0;

    @PrePersist
    public void prePersist(Object instance) {
        counter++;
        System.out.println("Counter is:" + counter);
    }

    @PreUpdate
    public void preUpdate(Object instance) {
        System.out.println("PreUpdate called!");
        if (instance instanceof Employee) {
            ((Employee) instance).setName("Name from listener");
        }
    }
}
