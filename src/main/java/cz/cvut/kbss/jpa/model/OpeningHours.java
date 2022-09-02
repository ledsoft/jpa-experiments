package cz.cvut.kbss.jpa.model;

import javax.persistence.*;
import java.util.Map;

@Entity
public class OpeningHours {

    @Id
    @GeneratedValue
    private Integer id;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @CollectionTable(name = "OPENING_HOURS")
    private Map<Days, FromToTime> openingHours;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Days, FromToTime> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Map<Days, FromToTime> openingHours) {
        this.openingHours = openingHours;
    }
}
