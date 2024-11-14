package cpit252_project;

import java.util.Scanner;

public class Booking {
    private static int bookingCounter = 0; // Static counter for booking IDs
    private int bookingID;
    private Customer customer;
    private DivingService service;
    private String date;

    public Booking(Customer customer, DivingService service, String date) {
        this.bookingID = ++bookingCounter; // Increment and assign booking ID
        this.customer = customer;
        this.service = service;
        this.date = date;
    }

   public static void makeBooking(Scanner scanner) {
    System.out.print("Enter Customer National ID: ");
    int nationalID = scanner.nextInt();
    Customer customer = Customer.findCustomer(nationalID);
    if (customer == null) {
        System.out.println("Customer not found.");
        return;
    }

    System.out.print("Enter Service Number to book: ");
    int serviceNum = scanner.nextInt();
    
    DivingService service = null;
    for (DivingService s : Service.services) {
        if (s instanceof DivingTrip && ((DivingTrip) s).getServiceNum() == serviceNum) {
            service = s;
            break;
        } else if (s instanceof DivingCourse && ((DivingCourse) s).getServiceNum() == serviceNum) {
            service = s;
            break;
        }
    }

    if (service == null) {
        System.out.println("Service not found.");
        return;
    }

    System.out.print("Enter booking date (DD-MM-YYYY): ");
    scanner.nextLine(); // Clear buffer
    String date = scanner.nextLine();

    // Create a new booking
    Booking booking = new Booking(customer, service, date);
    customer.addBooking(booking); // Add booking to the customer's list
    System.out.println("Booking successful. Booking ID: " + booking.getBookingID());
}

     public static void cancelBooking(Scanner scanner) {
        System.out.print("Enter Customer National ID: ");
        int nationalID = scanner.nextInt();
        Customer customer = Customer.findCustomer(nationalID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter Booking ID to cancel: ");
        int bookingID = scanner.nextInt();
        String result = customer.cancelBooking(bookingID);
        System.out.println(result);
    }
    
    public int getBookingID() {
        return bookingID;
    }

    public String getBookingInfo() {
        return "Booking ID: " + bookingID + ", Customer: " + customer.getCustomerInfo() + ", Service: " + service.getName() + ", Date: " + date;
    }

} 
