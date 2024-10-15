import java.util.List;

public class Passenger extends User {
    // Additional attribute
    private List<String> paymentMethods;

    // Constructor
    public Passenger(String userId, String name, Location location, List<String> paymentMethods) {
        super(userId, name, location);  // Call the constructor of the abstract User class
        this.paymentMethods = paymentMethods;
    }

    // Method to request a ride
    public RideRequest requestRide(Location destination) {
        return new RideRequest(this.userId, this.location, destination);  // Creates and returns a new ride request
    }

    // Method to rate a driver
    public void rateDriver(String driverId, float rating) {
        // Logic to rate the driver
        System.out.println("Passenger " + this.name + " rated Driver " + driverId + " with a rating of " + rating);
    }

    // Implementation of the abstract method from User class
    @Override
    public String getRole() {
        return "Passenger";
    }

    // Getter for payment methods
    public List<String> getPaymentMethods() {
        return paymentMethods;
    }
}
