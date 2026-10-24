
package project;

import java.util.Scanner ;
import java.util.ArrayList ;
import java.util.InputMismatchException ;

public class Main {
  
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        BookingSystem bookingSystem = new BookingSystem();
        ArrayList<Service> myList = new ArrayList<>() ;
        
        System.out.println("\n**** Welcome to our Salon ****");

        int choice;
        do {
            System.out.println("\nPlease choose a service:");
            System.out.println("1. Hair");
            System.out.println("2. MakeUp");
            System.out.println("3. Manicure");
            System.out.println("4. Care");
            System.out.println("5. Read bookings from file");
            System.out.println("6. Save bookings to file");
            System.out.println("0. Exit and proceed to booking");

            try{
                System.out.print("Enter your choice (0-6): ");
                choice = input.nextInt();
                input.nextLine(); // consume newline

                Service service = null;

                switch (choice) {
                    case 1:
                        service = new Hair();
                        service.chooseService();
                        myList.add(service);
                        break;
                    case 2:
                        service = new MakeUp();
                        service.chooseService();
                        myList.add(service);
                        break;
                    case 3:
                        service = new Manicure();
                        service.chooseService();
                        myList.add(service);
                        break;
                    case 4:
                        System.out.println("\n Choose from Care services:");
                        System.out.println("1. Facial");
                        System.out.println("2. BodyCare");
                        System.out.print("Enter your choice: ");
                        int subChoice = input.nextInt();
                        input.nextLine(); // newline

                        if (subChoice == 1) {
                            service = new Facial(0, false); // placeholder values
                            service.chooseService();
                            myList.add(service);
                        } else if (subChoice == 2) {
                            service = new BodyCare(0, false); // placeholder values
                            service.chooseService();
                            myList.add(service);
                        } else {
                            System.out.println("Invalid care option.");
                        }
                        break;
                    case 5: // Read from text file
                        ReadText rt = new ReadText();
                        rt.openTextFile("BookingSystem.txt");
                        rt.readFromFile();
                        rt.closeFile();
                        break;
                        
                    case 6: // Save/Write to text file
                        WriteText wf = new WriteText();
                        wf.openTextFile("BookingSystem.txt");

                        if (myList.isEmpty()) {
                            System.out.println("No bookings found to save.");
                        } else {
                            for (Service s : myList) {
                                wf.writeToFile(s);
                            }
                            System.out.println("All bookings have been successfully saved to the text file 'BookingSystem.txt'.");
                        }
                        wf.closeFile();
                        break;
                        
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                input.nextLine();
                choice = -1;
                }
        } while (choice != 0);
        

        // Booking phase
        System.out.println("\n------------ Booking Page ------------");
        bookingSystem.bookAppointment();
        System.out.println(bookingSystem.toString(myList));

        input.close();    
    }
}
       