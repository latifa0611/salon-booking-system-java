
package project;
import java.util.Scanner;

public class MakeUp extends Service {
    
    //properties
    private String type; 
    private Facial[] facials;
    
    // constructors
    public MakeUp() {}  // Default constructor
    public MakeUp(String type,  Facial[] facials) { // Constructor with initial values
        this.type = type;
        this.facials = facials;
    }

    // Getter
    public String getType() {
        return type;
    }
    public Facial[] getFacial() {
        return facials;
    }

    // Setter 
    public void setType(String type) {
        this.type = type;
    }
    
    public void setFacial(Facial[] facials) {
        this.facials = facials;
    }
    

    //Method to apply makeup
    public void applyMakeUp(){
        System.out.println("Applying "+type+"makeup");
        if (facials != null && facials.length > 0) {
        for (Facial f : facials) {
            f.startFacial();
            }
        }
    }
    //Method to remove makeup
    public void removeMakeUp(){
        System.out.println("Removing "+type+"makeup");
        if (facials != null && facials.length > 0) {
        for (Facial f : facials) {
            f.endFacial();
            }
        }
    }
    // Method to touch up the makeup
    public void touchUp() {
        System.out.println("Touching up the makeup for a fresh look.");
    }

    // Overridden Method
    @Override
    public void chooseService() {
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.println("\nChoose a makeup service:");
        System.out.println("1. Apply Makeup - 150 SAR");
        System.out.println("2. Remove Makeup - 80 SAR");
        System.out.println("3. Touch Up - 30 SAR");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();


        switch (choice) {
            case 1: 
                applyMakeUp();
                setServiceName("Apply Makeup - 150 SAR");
                setPrice(150);
            break;
            case 2: 
                removeMakeUp(); 
                setServiceName("Remove Makeup - 80 SAR");
                setPrice(80);
            break;
            case 3: 
                System.out.println("Touching up the makeup for a fresh look.");
                setServiceName("Touch Up - 30 SAR");
                setPrice(30);
            break;
            default: System.out.println("Invalid choice.");
                setServiceName(null);
                setPrice(0);
                continue;
        }
        break;
        }
    }

    // Method to return a string with service details
    @Override
public String toString() {
    String result = String.format("MakeUp Service Details:\nType: %s\n", type);
    if (facials != null && facials.length > 0) {
        result += "Facial Services Included:\n";
        for (Facial f : facials) {
            result += String.format("%s\n", f.toString());
        }
    }
    return result;
}
     
     // Implement reserve method from Reservable
    @Override
    public void reserve() {
        System.out.println("Make Up service \"" + getServiceName() + "\" has been reserved.");
    }

}