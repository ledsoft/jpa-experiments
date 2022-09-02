package cz.cvut.kbss.jpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
})
@NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("P")
@Entity
public class Person {

    @Id
    Integer id;

    @Basic(optional = false)
    String name;

    @ManyToMany
    private Set<Person> friends;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getFriends() {
        if (friends == null) {
            this.friends = new HashSet<>();
        }
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
