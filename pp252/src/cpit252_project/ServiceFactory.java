/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

class ServiceFactory {
    
    public static DivingService createService(int serviceNumber, String name, String type, String description, String date) {
        if (type.equalsIgnoreCase("Trip")) {
            return new DivingTrip(serviceNumber, name, type, description, date);
        } else if (type.equalsIgnoreCase("Course")) {
            // Assuming you have some default dates for courses
            return new DivingCourse(serviceNumber, name, type, description, "2024-08-01", "2024-08-20", "Beginner");
        }
        return null;
    }
    
    
}
