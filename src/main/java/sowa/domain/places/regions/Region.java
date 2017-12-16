package sowa.domain.places.regions;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "regions")
public class Region {

    @Id
    private Integer regionID;

    private String regionDescription;

    public Region(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionID=" + regionID +
                ", regionDescription='" + regionDescription + '\'' +
                '}';
    }
}
