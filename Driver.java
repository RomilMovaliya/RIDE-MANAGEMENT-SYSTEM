import java.util.Map;

public class Driver extends User {
    // below I add some Additional attributes 
    private Map<String, String> vehicleInfo;  // e.g., {"make": "Toyota", "model": "Camry", "license_plate": "ABC123"}
    private boolean isAvailable;

    // Constructor
    public Driver(String userId, String name, Location location, Map<String, String> vehicleInfo) {
        super(userId, name, location);  // Call the constructor of the abstract User class
        this.vehicleInfo = vehicleInfo;
        this.isAvailable = true;  // Driver starts as available by default
    }

    // Method to accept a ride request 
    public void acceptRide(RideRequest rideRequest) {
        if (isAvailable) {
            System.out.println("Driver " + this.name + " accepted ride request from Passenger " + rideRequest.getPassengerId());
            this.isAvailable = false;  // Driver becomes unavailable after accepting a ride
        } else {
            System.out.println("Driver " + this.name + " is not available to accept the ride request.");
        }
    }

    /*// Method to complete a ride
    public void completeRide(Ride ride) {
        System.out.println("Driver " + this.name + " completed the ride.");
        this.isAvailable = true;  // Driver becomes available again after completing the ride
    }*/

    // Method to rate a passenger
    public void ratePassenger(String passengerId, float rating) {
        System.out.println("Driver " + this.name + " rated Passenger " + passengerId + " with a rating of " + rating);
    }

    // Implementation of the abstract method from User class
    @Override
    public String getRole() {
        return "Driver";
    }

    // Getter for vehicle information
    public Map<String, String> getVehicleInfo() {
        return vehicleInfo;
    }

    // Getter for availability
    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for availability (in case it's needed externally)
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
