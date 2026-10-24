
package project;

import java.util.Scanner ;


public class BodyCare extends Care {
    Scanner input = new Scanner(System.in);
    
    
    //properties
    private String BodyBaths;
    private String HairRemoval;
    private String HandCare;
    private String FootCare;
    
    
     // constructors
    
    public BodyCare() {    } //Empty constructor
    public BodyCare(int duration, boolean massageTherapy) {
        super( duration, massageTherapy);
    }
    public BodyCare(String BodyBaths, String HairRemoval, String HandCare, String FootCare, int duration, boolean massageTherapy) { //full constructor
        super( duration, massageTherapy);
        setBodyBaths(BodyBaths);
        setHairRemoval(HairRemoval);
        this.HandCare = HandCare;
        this.FootCare = FootCare;
    }
    
    
     // all getter
    public String getBodyBaths() {
        return BodyBaths;
    }
    public String getHairRemoval() {
        return HairRemoval;
    }
    public String getHandCare() {
        return HandCare;
    }
    public String getFootCare() {
        return FootCare;
    }
    
    
    // all setter
    public void setBodyBaths(String BodyBaths) {
        System.out.println("\nHow do you want me to help you body bath ?");
        System.out.println("1. Regular Moroccan bath - 170 SAR");
        System.out.println("2. Royal Moroccan bath - 230 SAR ");
        System.out.print("Enter your choice (1-2): ");
        int body =input.nextInt();
       
        switch(body){
            case 1:
                this.BodyBaths = "Regular Moroccan bath" ;
                setServiceName("Regular Moroccan bath - 170 SAR");
                setPrice(170);
                break;
            case 2:
                this.BodyBaths = "Royal Moroccan bath";
                setServiceName("Royal Moroccan bath - 230 SAR");
                setPrice(230);
                break;
            default:
                System.out.println("Invalid choice.");
                
    }
}
    public void setHairRemoval(String HairRemoval) {
         System.out.println("\nHow do you want me to help you hair removal ?");
         System.out.println("Laser - (99-299 SAR)");
         System.out.println("Wax - (100-114 SAR)");
         System.out.print("Enter your choice(Wax / Laser): ");
         String hair =input.nextLine();
        
         switch(hair){
            case "Laser":
                 System.out.println("1 session - 99 SAR");
                 System.out.println("3 sessions - 199 SAR");
                 System.out.println("6 sessions - 299 SAR");
                 System.out.println("How many sessions do you need? (1, 3, 6):");
                 int sessions=input.nextInt();
                 
                 switch(sessions){
                    case 1:
                      setServiceName("Laser (1 session) - 99 SAR");
                      setPrice(99);
                      this.HairRemoval = "Laser (1 session) - 99 SAR";
                      break;
                    case 3:
                      setServiceName("Laser (3 sessions) - 199 SAR");
                      setPrice(199);
                      this.HairRemoval = "Laser (3 sessions) - 199 SAR";
                      break;
                    case 6:
                      setServiceName("Laser (3 sessions) - 299 SAR");
                      setPrice(299);
                      this.HairRemoval = "Laser (6 sessions) - 299 SAR";
                      break;
                    default:
                      System.out.println("Invalid choice");
                 }
                break;
                
            case "Wax":
                 System.out.println("\nchoose area for waxing: ");
                 System.out.println("Hand Care - 100 SAR");
                 System.out.println("Foot Care - 114 SAR");
                 System.out.print("Enter your choice: ");
                 String waxArea = input.nextLine();
                 
                 if (waxArea.equals("Hand Care")){
                    setServiceName("Hand Care - 100 SAR");
                    setPrice(100);
                    this.HairRemoval = "Wax (Hand Care) - 100 SAR";
                 }else if(waxArea.equals("Foot Care")){
                    setServiceName("Foot Care - 114 SAR");
                    setPrice(114);
                    this.HairRemoval = "Wax (Foot Care) - 114 SAR";
                 }else{
                     System.out.println("Unknown area.");
                 }
                    break;
            default:
                System.out.println("Invalid choice.");
        }
   }
    public void setHandCare(String HandCare) {
        System.out.print("\nDo you want a massage service? (Yes / No): ");
        String m = input.next();
        input.nextLine();

        while(m.equals("Yes")){
            
        System.out.println("30 minutes - 99 SAR");
        System.out.println("45 minutes - 199 SAR");
        System.out.println("60 minutes - 299 SAR");
        System.out.print("Enter duration (30, 45, 60): ");
        int d = input.nextInt();
        input.nextLine(); 
            switch(d){
                case 30:
                    setDuration(d);
                    setPrice(99);
                    setServiceName("Hand care (30 minutes)- 99 SAR");
                    break;
                case 45:
                    setDuration(d);
                    setPrice(199);
                    setServiceName("Hand care (45 minutes)- 199 SAR");
                    break;
                case 60:
                    setDuration(d);
                    setPrice(299);
                    setServiceName("Hand care (60 minutes)- 299 SAR");
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
            break;
        }
    }
    public void setFootCare(String FootCare) {
        System.out.print("\nDo you want a massage service? (Yes / No): ");
        String m = input.next();
        input.nextLine();

        while(m.equals("Yes")){
            
        System.out.println("30 minutes - 99 SAR");
        System.out.println("45 minutes - 199 SAR");
        System.out.println("60 minutes - 299 SAR");
        System.out.print("Enter duration (30, 45, 60): ");
        int d = input.nextInt();
        input.nextLine(); 
            switch(d){
                case 30:
                    setDuration(d);
                    setPrice(99);
                    setServiceName("Foot care (30 minutes)- 99 SAR");
                    break;
                case 45:
                    setDuration(d);
                    setPrice(199);
                    setServiceName("Foot care (45 minutes)- 199 SAR");
                    break;
                case 60:
                    setDuration(d);
                    setPrice(299);
                    setServiceName("Foot care (60 minutes)- 299 SAR");
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
            break;
        }
    }
    
    // Overridden method
    @Override
    public void chooseService() {
        while(true){
        System.out.println("\nChoose a Body care service:");
        System.out.println("1. Body Baths");
        System.out.println("2. Hair Removal");
        System.out.println("3. Hand Care");
        System.out.println("4. Foot Care");
        System.out.print("Enter your choice (1-4): ");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                setBodyBaths("");
                break;
            case 2:
                setHairRemoval("");
                break;
            case 3:
                setHandCare("");
                break;
            case 4:
                setFootCare("");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                continue;
        }
        break;
        }
    }

    //toString method
    @Override
    public String toString() {
        return String.format("%s Welcome to the body care section\n our services:\n Body Baths:%s\n Hair Removal:%s\n Hand Care:%s\n Foot Care:%s\n",super.toString(),getBodyBaths(),getHairRemoval(),getHandCare(),getFootCare() );
    }
    
    // Implement reserve method from Reservable
    @Override
    public void reserve() {
        System.out.println("Body Care service \"" + getServiceName() + "\" has been reserved.");
    }

}
