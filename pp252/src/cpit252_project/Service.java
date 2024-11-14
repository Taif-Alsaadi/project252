
package cpit252_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    
    public static List<DivingService> services = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private int serviceNum;
    private int[] bookingIDs=new int[30];

//--------------------------------------
    public static void addService(DivingService service) {
        services.add(service);
    }

    public static void searchForService() {
    // Get the keyword from the user
    System.out.print("Enter keyword to search for services: ");
    String keyword = scanner.nextLine();
    
    // Initialize a list to hold found services
    List<DivingService> foundServices = new ArrayList<>();
    
    // Search in the services list
    for (DivingService service : services) {
        if (service.getName().toLowerCase().contains(keyword.toLowerCase()) ||
            service.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
            foundServices.add(service);
        }
    }
    // Print the results
    if (!foundServices.isEmpty()) {
        System.out.println("Services found:");
        for (DivingService service : foundServices) {
            System.out.println(service.getName() + " - " + service.getDescription());
        }
    } else {
        System.out.println("No services found with the keyword '" + keyword + "'.");
    }
}

    public static void showServiceInfo() {
    System.out.print("Enter Service Number to show info: ");
    int serviceNum = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    DivingService service = null;

    for (DivingService s : services) {
        if (s instanceof DivingTrip && ((DivingTrip) s).getServiceNum() == serviceNum) {
            service = s;
            break;
        } else if (s instanceof DivingCourse && ((DivingCourse) s).getServiceNum() == serviceNum) {
            service = s;
            break;
        }
    }
    if (service != null) {
        if (service instanceof DivingTrip) {
            System.out.println(((DivingTrip) service).getInfo());
        } else if (service instanceof DivingCourse) {
            System.out.println(((DivingCourse) service).getInfo());
        }
    } else {
        System.out.println("Service not found.");
    }
}
    
    public static void removeService(int serviceNum) {
    for (DivingService service : services) {
        if (service.getServiceNum() == serviceNum) {
            services.remove(service); // Remove from the general services list
        }
    }
}
    
    //-----------------------------------------------------------



    
     public int getServiceNum() {
        return serviceNum;
    }



}
