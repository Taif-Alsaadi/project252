package cpit252_project;

import java.util.List;


public class ManagerSingleton {
    
    private static ManagerSingleton managerInstance;   
    private String managerName;
    private int managerId;
   
    
    
    private ManagerSingleton(int managerId, String managerName) {
        this.managerName=managerName;
        this.managerId = managerId;
           }

    public String getManagerName() {
        return "Manager Name: "+managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerId() {
        return "Manager ID: "+managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    
   
    public static ManagerSingleton getInstance(int managerId,  String name) {
        if (managerInstance == null) {
            managerInstance = new ManagerSingleton(managerId, name);
        }
        return managerInstance;
    }

   

 //22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
    
    public void addDivingCourse1(DivingCourse course) {
    DivingCourse.getDivingCourses().add(course);
}

public void deleteDivingCourse(int serviceNum) {
    DivingCourse.removeDivingCourse(serviceNum);
}

public void addDivingTrip1(DivingTrip trip) {
    DivingTrip.getDivingTrips().add(trip);
}

public void deleteDivingTrip(int serviceNum) {
    DivingTrip.removeDivingTrip(serviceNum);
}

public List<Service> viewAllServices() {
    return Service.getAllServices();
}

public void editDivingCourse(int serviceNum, String newName, String newDescription) {
    DivingCourse course = DivingCourse.findDivingCourse(serviceNum);
    if (course != null) {
        course.setName(newName);
        course.setDescription(newDescription);
    }
}

public void editDivingTrip(int serviceNum, String newName, String newDescription) {
    DivingTrip trip = DivingTrip.findDivingTrip(serviceNum);
    if (trip != null) {
        trip.setName(newName);
        trip.setDescription(newDescription);
    }
}

public int[] viewBookingsForService(int serviceNum) {
    Service service = Service.findService(serviceNum);
    if (service == null) {
        return new int[0];
    }
    return service.getBookingIDs();
}

public void updateCapacity(int serviceNum, int change) {
    Service service = Service.findService(serviceNum);
    if (service == null) {
        return;
    }
    if (service instanceof DivingCourse course) {
        course.setCurrentCapacity(course.getCurrentCapacity() + change);
    } else if (service instanceof DivingTrip trip) {
        trip.setCurrentCapacity(trip.getCurrentCapacity() + change);
    }
}


   
}
