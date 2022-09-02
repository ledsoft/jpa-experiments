package cz.cvut.kbss.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private List<Employee> employees;

    @OneToOne(mappedBy = "dept")
    private DepartmentDetail detail;

    public Department() {
    }

    public Department(String name) {
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public DepartmentDetail getDetail() {
        return detail;
    }

    public void setDetail(DepartmentDetail detail) {
        this.detail = detail;
    }
}
