
package project;


import java.util.Scanner;


public class Manicure extends Service {

    Scanner input = new Scanner(System.in);
    
    //properties
    private String style;
    private String polishColor;

    
    //constructors
    public Manicure() {} // Empty constructor
    public Manicure(String serviceName, double price, String style, String polishColor) { // Full Constructor
        super(serviceName, price);
        this.style = style;
        this.polishColor = polishColor;
    }

    // Getters
    public String getStyle() {
        return style;
    }
    public String getPolishColor() {
        return polishColor;
    }
    
    // Setters
    public void setStyle(String style) {    
        this.style = style;
    }
    public void setPolishColor(String polishColor) {
        this.polishColor = polishColor;
    }
    
    
    
    // Overridden method
    @Override
    public void chooseService() {
        while(true){
        System.out.println("\nChoose a manicure service:");
        System.out.println("1. Clean Nails - 40 SAR");
        System.out.println("2. Apply Polish - 60 SAR");
        System.out.println("3. Remove Polish - 30 SAR");
        System.out.print("Enter your choice (1-3): ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                setServiceName("Clean Nails - 40 SAR");
                setPrice(40);
                setStyle("Claen");
                System.out.println("Claening nails...");
                break;
            case 2:
                setServiceName("Apply Polish - 60 SAR");
                setPrice(60);
                System.out.print("Enter polish color: ");
                input.nextLine();
                setPolishColor(input.nextLine());
                setStyle("Polished");
                System.out.println("Applying nail polish in color: " + getPolishColor());
                break;
            case 3:
                setServiceName("Remove Polish - 30 SAR");
                setPrice(30);
                setStyle("None");
                setPolishColor("None");
                System.out.println("Removing nail polish.");
                break;
            default:
                System.out.println("Invalid choice.");
                continue;
        }
        break;
        }
    }

    // toString method
    @Override
    public String toString() {
    return String.format("Manicure Service \nName: %s\nStyle: %s\nPolish Color: %s\nPrice: %.2f $ ",
                         getServiceName(), style, polishColor, getPrice() );
    }

    // Implement reserve method from Reservable
    @Override
    public void reserve() {
        System.out.println("Manicure service \"" + getServiceName() + "\" has been reserved.");
    }
}
   