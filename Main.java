import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create instances of the RideSharingSystem and FraudDetectionModule
        RideSharingSystem rideSharingSystem = new RideSharingSystem();
        FraudDetectionModule fraudDetectionModule = new FraudDetectionModule();

        // Register Drivers
        Driver driver1 = new Driver("DRV1001", "John Doe", new Location(37.7749f, -122.4194f), 
            Map.of("make", "Toyota", "model", "Camry", "license_plate", "ABC123"));
        Driver driver2 = new Driver("DRV1002", "Jane Smith", new Location(37.8044f, -122.2711f), 
            Map.of("make", "Honda", "model", "Civic", "license_plate", "XYZ789"));

        rideSharingSystem.registerUser(driver1);
        rideSharingSystem.registerUser(driver2);

        // Register Passengers
        Passenger passenger1 = new Passenger("PAS2001", "Alice Johnson", new Location(37.7739f, -122.4312f), List.of("Credit Card"));
        Passenger passenger2 = new Passenger("PAS2002", "Bob Brown", new Location(37.8049f, -122.4494f), List.of("PayPal"));

        rideSharingSystem.registerUser(passenger1);
        rideSharingSystem.registerUser(passenger2);

        // Process Ride Requests
        RideRequest rideRequest1 = passenger1.requestRide(new Location(37.7849f, -122.4094f));  // Alice requests a ride
        RideRequest rideRequest2 = passenger2.requestRide(new Location(37.7949f, -122.3994f));  // Bob requests a ride

        // Dispatch Rides
        Ride ride1 = rideSharingSystem.dispatchRide(rideRequest1);
        Ride ride2 = rideSharingSystem.dispatchRide(rideRequest2);  // Bob's request may fail if no driver is available

        // Complete Rides
        if (ride1 != null) {
            ride1.startRide();
            ride1.endRide();
            passenger1.rateDriver(driver1.getUserId(), 5.0f);  // Alice rates driver1
            driver1.ratePassenger(passenger1.getUserId(), 5.0f); // Driver1 rates Alice
        }

        // Fraud Detection
        fraudDetectionModule.monitorRides(rideSharingSystem);
        fraudDetectionModule.analyzePatterns();

        // Output data
        System.out.println("Average Rating for Driver1: " + driver1.getAverageRating());
        System.out.println("Average Rating for Passenger1: " + passenger1.getAverageRating());
        System.out.println("Flagged Activities: " + fraudDetectionModule.getSuspiciousActivities());
        System.out.println("Blacklisted Users: " + fraudDetectionModule.getBlacklistedUsers());
    }
}
