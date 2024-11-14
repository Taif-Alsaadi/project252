package cpit252_project;



public class DivingTrip implements DivingService {
    
   // private static List<DivingTrip> divingTrips = new ArrayList<>();
    public static final int MAX_CAPACITY = 6; // Maximum capacity for diving trips
    private static int currentCapacity;
    private String date;
    private int serviceNum;
    private String name;
    private String type;
    private String description;
    
    public DivingTrip(int serviceNum, String name, String type, String description, String date) {
        this.date = date;
       // divingTrips.add(this); // Add this diving trip to the list upon creation
        this.currentCapacity = 0; // Initially no bookings
        this.serviceNum = serviceNum;
        this.name = name;
        this.type = type;
        this.description = description;
        this.date = date;
        Service.addService(this); // Add to the service list
    }

    public static int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public String getDate() {
        return date;
    }

    
    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Diving Trip Information:\n");
        info.append("Service Number: ").append(getServiceNum()).append("\n");
        info.append("Name: ").append(getName()).append("\n");
        info.append("Type: ").append(getType()).append("\n");
        info.append("Description: ").append(getDescription()).append("\n");
        info.append("Date: ").append(date).append("\n");
        return info.toString();
    }

      
    //---------------------------------------
    @Override
    public void performService() {
        System.out.println("Performing a Diving Trip.");
    }

    @Override
    public double getCost() {
        return 150.0; // Base cost for diving trip
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getServiceNum() {
        return serviceNum;
    }
    
     
//---------------------------------------------
 


} 
