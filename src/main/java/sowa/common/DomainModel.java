package sowa.common;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract class DomainModel {
    @Id
    public ObjectId _id;
}
