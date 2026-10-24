package project;

import java.util.Scanner;

public class Facial extends Care{
    
    Scanner input = new Scanner(System.in);
    
    //properties
    private int SkinType;
    private String FacialCleaning;

    
    //constructors
    public Facial() {} //Empty constructor

    public Facial(int duration, boolean massageTherapy) {
        super(duration, massageTherapy);
    }
    public Facial(int SkinType, String FacialCleaning, int duration, boolean massageTherapy) {
        super( duration, massageTherapy);
        this.SkinType = SkinType;
        this.FacialCleaning = FacialCleaning;
    }
    
    
    // all getter
    public int getSkinType() {
        return SkinType;
    }
    public String getFacialCleaning() {
        return FacialCleaning;
    }

  
    // all setter
    public void setSkinType(int SkinType) {
        
        switch(SkinType){
            case 1:
                FacialCleaning= "Basic Facial";
                setPrice(50);
                setServiceName("Normal skin (Basic Facial) - 50 SAR");
                break;
                
            case 2:
                FacialCleaning="HydraFacial";
                setPrice(80);
                setServiceName("Oily skin (HydraFacial) - 80 SAR");
                break;
                
            case 3:
                FacialCleaning="Moisture Boost Facial";
                setPrice(70);
                setServiceName("Dry skin (Moisture Boost Facial) - 70 SAR");
                break;
                
            case 4:
                FacialCleaning="Balancing Facial";
                setPrice(45);
                setServiceName("Combination skin (Balancing Facial) - 45 SAR");
                break;
                
            case 5:
                FacialCleaning="Soothing Facial";
                setPrice(65);
                setServiceName("Sensitive skin (Soothing Facial) - 65 SAR");
                break;
                
            default:
                System.out.println("Invalid choice");
                this.SkinType = SkinType;
        }
    }
    public void setFacialCleaning(String FacialCleaning) {
        this.FacialCleaning = FacialCleaning;
    }
    
    
    //method will preform facial service if exists 
    public void startFacial(){
        System.out.println("Starting the facial treatment");
    }
    //method will remove facial service if it does not exists
    public void endFacial(){
    System.out.println("Facial treatment completed");
    }

    //Overridden method
    @Override
    public void chooseService() {
        System.out.println("\nChoose your skin type:");
        System.out.println("1. Normal skin - 50 SAR");
        System.out.println("2. Oily skin - 80 SAR");
        System.out.println("3. Dry skin - 70 SAR");
        System.out.println("4. Combination skin - 45 SAR");
        System.out.println("5. Sensitive skin - 65 SAR");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        setSkinType(choice);
    }
    
    //toString method
    @Override
    public String toString() {
        return String.format("%s Welcome to the skin care section\n our services:\n Skin Type:%s\n Facial Cleaning:%s ",
                super.toString(),getSkinType(),getFacialCleaning());
    }
    
    // Implement reserve method from Reservable
    @Override
    public void reserve() {
        System.out.println("Facial service \"" + getServiceName() + "\" has been reserved.");
    } 
}
