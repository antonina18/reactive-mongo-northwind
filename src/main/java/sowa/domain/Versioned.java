package sowa.domain;

import org.springframework.data.annotation.Id;

public abstract class Versioned {

    @Id
    private String _id;
    private Integer version;

    @Override
    public String toString() {
        return "Versioned{" +
                "_id=" + _id +
                ", version=" + version +
                '}';
    }
}
