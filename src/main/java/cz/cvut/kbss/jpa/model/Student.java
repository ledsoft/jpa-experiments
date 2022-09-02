package cz.cvut.kbss.jpa.model;

import javax.persistence.*;

@EntityListeners(Listener.class)
@DiscriminatorValue("P")
@Entity
public class Student extends Person {

    String email;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Employee advisor;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Employee advisor) {
        this.advisor = advisor;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @PostLoad
    public void postLoad() {
        System.out.println("Student postLoad");
    }
}
