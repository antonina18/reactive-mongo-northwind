package sowa.domain.people.regions;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.domain.Versioned;

@Document(collection = "regions")
public class Region extends Versioned{

    private String regionDescription;

    public Region(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionDescription='" + regionDescription + '\'' +
                "} " + super.toString();
    }
}
