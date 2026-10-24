
package project;

import java.util.Scanner;


public class Hair extends Service {

    Scanner input = new Scanner(System.in);

    //properties
    private String style;  
    private String length; 
    private String color;  
    private int duration;  

    
    //constructors
    
    public Hair() {} //Empty constructor
    public Hair(String serviceName, double price) {
        super(serviceName, price);
    } 
    public Hair(String style, String length, String color, int duration, String serviceName, double price) { //Full constructor
        super(serviceName, price);
        this.style = style;
        this.length = length;
        this.color = color;
        this.duration = duration;
    }
    
    
    // Getter
    public String getStyle() {
        return style;
    }
    public String getLength() {
        return length;
    }
    public String getColor() {
        return color;
    }
      public int getDuration() {
        return duration;
    }
    
    
    // Setter
    public void setStyle(String style) {
        this.style = style;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setDuration(int duration) {    
        this.duration = duration;
    }
 
    
    // Method to cut hair
    public void cutHair() {
        System.out.println("Cutting hair to the style: " + style + " with length: " + length);
    }

    // Method to dye hair
    public void dyeHair() {
        System.out.println("Dyeing hair to color: " + color);
    }

    // Method to wash hair
    public void washHair() {
        System.out.println("Washing hair with moisturizing shampoo.");
    }

    // Method to blow dry hair
    public void blowDry() {
        System.out.println("Blow drying hair.");
    }

    // Method to apply hair treatment
    public void applyHairTreatment() {
        System.out.println("Applying deep conditioning treatment for healthier hair.");
    }


    
    // Overridden Method 
    @Override
    public void chooseService() {

    while(true){
    System.out.println("\nChoose a hair service:");
    System.out.println("1. Cut Hair - 80 SAR");
    System.out.println("2. Dye Hair - 50 SAR");
    System.out.println("3. Wash Hair - 60 SAR");
    System.out.println("4. Blow Dry - 100 SAR");
    System.out.println("5. Hair Treatment - 150 SAR");
    System.out.print("Enter your choice: ");
    int choice = input.nextInt();
    input.nextLine(); // Consume the leftover newline
    
    switch (choice) {
            case 1: // Cut Hair
                System.out.print("Enter desired style: ");
                setStyle(input.nextLine());

                System.out.print("Enter desired length: ");
                setLength(input.nextLine());

                setPrice(80);
                setServiceName("Cut Hair - 80 SAR");
                
                cutHair();
                break;
             case 2: // Dye Hair
                System.out.print("Enter desired hair color: ");
                setColor(input.nextLine());

                setPrice(50);
                setServiceName("Dye Hair - 50 SAR");

                dyeHair();                
                break;
            case 3: // Wash Hair
                setPrice(60);
                setServiceName("Wash Hair - 60 SAR");

                washHair();
                break;
            case 4: // Blow Dry
                setPrice(100);
                setServiceName("Blow Dry - 100 SAR");

                blowDry();
                break;
            case 5: // Hair Treatment
                setPrice(150);
                setServiceName("Hair Treatment - 150 SAR");

                applyHairTreatment();
                break;
            default:
                System.out.println("Invalid choice.");
                continue;
        }
        break;
    }
    }


    // Method to return a string with service details
    @Override
     public String toString() {
        return String.format("Hair Service Details: \nStyle: %s \nLength: %s \nColor: %s \nPrice: %.2f $ \nDuration: %d minutes \n",
            this.getStyle(), this.getLength(),this.getColor(), this.getPrice(), this.getDuration());
    }
     
     // Implement reserve method from Reservable
    @Override
    public void reserve() {
        System.out.println("Hair service \"" + getServiceName() + "\" has been reserved.");
    }
}