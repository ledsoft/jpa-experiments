package cz.cvut.kbss.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;

@Embeddable
public class FromToTime {

    @Column(name = "FROM_TIME")
    private LocalTime from;

    @Column(name = "TO_TIME")
    private LocalTime to;

    public FromToTime() {
    }

    public FromToTime(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }
}
