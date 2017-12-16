package sowa.domain.people.regions;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "territories")
public class Territory {

    private Integer territoryID;
    private String territoryDescription;
    private Integer regionID;

    public Territory(Integer territoryID, String territoryDescription, Integer regionID) {
        this.territoryID = territoryID;
        this.territoryDescription = territoryDescription;
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
