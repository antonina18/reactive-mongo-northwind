package sowa.domain.products;

        import org.bson.types.ObjectId;
        import org.springframework.data.mongodb.core.mapping.Document;
        import sowa.common.DomainModel;

//@Document(collection = "categories")
public class Category {

    public String name;
    public String description;
    public byte[] picture;

//    public Category() {
//        this._id = ObjectId.get();
//    }
}
