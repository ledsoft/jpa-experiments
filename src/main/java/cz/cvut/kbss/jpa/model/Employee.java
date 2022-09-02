package cz.cvut.kbss.jpa.model;

import javax.persistence.*;

@SqlResultSetMapping(name = "testMapping",
        entities = {
                @EntityResult(entityClass = Employee.class, fields = {
                        @FieldResult(name = "salaryyy", column = "income")
                }),
                @EntityResult(entityClass = Student.class)
        })
@EntityListeners(Listener.class)
@DiscriminatorValue("P")
@Entity
public class Employee extends Person {

    @ManyToOne
    private Department department;

    private Double salary;

    @OneToOne(fetch = FetchType.EAGER)
    private Student subordinate;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Student getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(Student subordinate) {
        this.subordinate = subordinate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @PostLoad
    public void postLoad() {
        System.out.println("Employee postLoad.");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", subordinate=" + subordinate +
                "} " + super.toString();
    }
}
