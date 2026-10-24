
package project;


public abstract class Service implements Reservable {
    
    //properties
    private String serviceName;
    private double price ;
    
    
    //constructors
    public Service() {}// Empty constructor
    public Service(String serviceName, double price) { // Full constructor
        this.serviceName = serviceName;
        this.price = price;
    } 
    
    //getter
    public String getServiceName() {
        return serviceName;
    }
    public double getPrice() {
        return price;
    }
    
    //setter
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    
    // Overridden method
    public abstract void chooseService();
    
    
}
