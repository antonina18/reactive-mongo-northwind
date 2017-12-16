package sowa.domain.places.territories;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "territories")
public class Territory {

    @Id
    private String territoryID;

    private String territoryDescription;
    private Integer regionID;

    public Territory(String territoryID, String territoryDescription, Integer regionID) {
        this.territoryID = territoryID;
        this.territoryDescription = territoryDescription;
        this.regionID = regionID;
    }

    public String getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(String territoryID) {
        this.territoryID = territoryID;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    @Override
    public String toString() {
        return "Territory{" +
                "territoryID=" + territoryID +
                ", territoryDescription='" + territoryDescription + '\'' +
                ", regionID=" + regionID +
                '}';
    }
}
