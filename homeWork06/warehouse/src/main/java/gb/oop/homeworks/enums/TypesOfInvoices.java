package gb.oop.homeworks.enums;

public enum TypesOfInvoices {
    INVOICE("Приходная"), WAYBILL("Расходная");
    private String description;
    TypesOfInvoices(String description){
        this.description = description;
    }
    TypesOfInvoices(){}
    public String getDescription(){
        return description;
    }
}
