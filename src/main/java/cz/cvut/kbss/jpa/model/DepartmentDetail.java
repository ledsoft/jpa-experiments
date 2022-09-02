package cz.cvut.kbss.jpa.model;

import javax.persistence.*;

@Entity
public class DepartmentDetail {

    @Id
    private Integer id;

    @JoinColumn(name = "ID")
    @MapsId
    @OneToOne
    private Department dept;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
