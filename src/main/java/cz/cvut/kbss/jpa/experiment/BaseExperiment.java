package cz.cvut.kbss.jpa.experiment;

import javax.persistence.EntityManager;

public abstract class BaseExperiment implements Runnable {

    protected final EntityManager em;

    protected BaseExperiment(EntityManager em) {
        this.em = em;
    }

    @Override
    public void run() {
        printStart();
        experiment();
        printEnd();
    }

    protected abstract void experiment();

    protected void printStart() {
        System.out.println("=================================");
        System.out.println("Experiment: " + getClass().getSimpleName());
        System.out.println("---------------------------------");
    }

    protected void printEnd() {
        System.out.println("=================================\n\n\n");
    }
}
