package cpit252_project;

import java.util.Scanner;
import java.util.List;

public class MainClass {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        // Adding default services
        Service.addService(ServiceFactory.createService(101, "Explore Red Sea", "Trip", "Dive at the beautiful coral reefs", "2024-07-15"));
        Service.addService(ServiceFactory.createService(102, "Beginner Diving Course", "Course", "Learn basic diving skills", "2024-12-01"));
        

        boolean run = true;
        while (run) {
            System.out.println("\n--- Diving Center System Menu ---");
            System.out.println("1. Register Customer");
            System.out.println("2. Search for Service");
            System.out.println("3. Book Service");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Show Service Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = getIntInput(1, 6); // Validate input for menu selection
            switch (choice) {
                case 1:
                    Customer.registerCustomer(scanner);
                    break;
                case 2:
                    Service.searchForService();
                    break;
                case 3:
                    Booking.makeBooking(scanner);
                    break;
                case 4:
                    Booking.cancelBooking(scanner);
                    break;
                case 5:
                    Service.showServiceInfo();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    run = false;
                    break;
            }
        }
        scanner.close();
    }

    

    // Helper method to ensure integer input
    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // Generic integer input validation
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
