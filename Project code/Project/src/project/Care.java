
package project;

import java.util.Scanner ;

public class Care extends Service{
    
    Scanner input = new Scanner(System.in);
   
    //properties
    private int duration;
    private boolean massageTherapy;
    
    //constructors
    public Care( ) {
    }
    public Care(int duration, boolean massageTherapy) {
        this.duration = duration;
        this.massageTherapy = massageTherapy;
       
    }
    public Care(int duration, boolean massageTherapy, String serviceName, double price) {
        super(serviceName, price);
        this.duration = duration;
        this.massageTherapy = massageTherapy;
        
    }
    
    // all getter
    public int getDuration() {
        return duration;
    }
    public boolean isMassageTherapy() {
        return massageTherapy;
    }
    

  // all setter
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setMassageTherapy(boolean massageTherapy) {
        this.massageTherapy = massageTherapy;
    }
    

     //  method
    public Service chooseSubService(){
        while(true){
        System.out.println("\nChoose a care service:");
        System.out.println("1. Body Care");
        System.out.println("2. Facial");
        System.out.print("Enter your choice (1-2): ");
        int choice = input.nextInt();
        input.nextLine();
        
        Service subService = null ;
        switch (choice) {
            case 1:
                subService = new BodyCare();
                break;
            case 2:
                subService = new Facial();
                break;
            default:
                System.out.println("Invalid choice.");
                continue;
        }
        subService.chooseService();
        return subService ;

    }
    }
   
    //toString method
    @Override
    public String toString() {
        return String.format("Welcome to the care section\n our services:\n Duration:%d\n massage Therapy:%s\n ",
                getDuration(),isMassageTherapy());
    }
    
    // Implement reserve method from Reservable
    @Override
    public void reserve() {
        System.out.println("Care service \"" + getServiceName() + "\" has been reserved.");
    }

    @Override
    public void chooseService() {
        //no action needed
    }
    }
    
