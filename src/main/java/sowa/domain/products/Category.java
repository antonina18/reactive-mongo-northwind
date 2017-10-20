package sowa.domain.products;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.domain.Versioned;

@Document
public class Category {

    public String categoryName;
    public String Description;
    public byte[] picture;

}
