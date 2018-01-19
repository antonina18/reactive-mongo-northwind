package sowa.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract class DomainModel {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
//    @JsonDeserialize(using = ObjectIdDeserializer.class)
    public ObjectId _id;
}
