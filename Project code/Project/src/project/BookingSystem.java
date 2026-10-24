package project;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingSystem implements Reservable {

    private String date;  // Date of the service (e.g., 02/03/2025)
    private String time;  // Time of the service (e.g., 3pm)

    // Empty constructor
    public BookingSystem() {
    }

    public BookingSystem(String date, String time) {
        this.date = date;
        this.time = time;
    }

    // Getters 
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    //Setters
    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Ask user for booking details
    public void bookAppointment() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the date of your appointment (dd/MM/yyyy): ");
        date = input.nextLine();

        System.out.print("Enter the time of your appointment (e.g., 3pm): ");
        time = input.nextLine();
    }

    // method that get the arrayList 
    public String getServicesDetails(ArrayList<Service> services) {
        String details = "";
        for (Service service : services) {
            details += service.getServiceName() + " - " + service.getPrice() + " SAR\n";
        }
        return details;
    }

    // Calculate total price
    public double calculateTotal(ArrayList<Service> services) {
        double total = 0;
        for (Service service : services) {
            total += service.getPrice();
        }
        return total;
    }

    // toString method (display invoice)
    public String toString(ArrayList<Service> services) {
        return String.format("------------ Booking Details ------------\nDate: %s\nTime: %s\n------------ Your Services ------------\n%s"
                + "----------------------------------\nTotal: %.2f SAR\nThank you for choosing our salon!\n",
                date, time, getServicesDetails(services), calculateTotal(services));
    }

    @Override
    public void reserve() {
        //no needed action
    }

}
