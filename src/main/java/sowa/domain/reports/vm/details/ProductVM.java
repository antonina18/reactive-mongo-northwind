package sowa.domain.reports.vm.details;

public class ProductVM {

    public String id;

    public String productName;
    public String quantityPerUnit;
    public Double unitPrice;
    public Short unitsInStock;
    public Short unitsOnOrder;
    public Short reorderLevel;
    public Boolean discontinued;

    public SupplierVM supplier;
    public CategoryVM category;

}
