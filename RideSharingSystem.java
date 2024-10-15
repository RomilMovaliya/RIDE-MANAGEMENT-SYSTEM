import java.util.*;

public class RideSharingSystem {
    private List<Driver> drivers;
    private Map<String, Passenger> passengers;
    private Map<String, Ride> activeRides;
    private Queue<RideRequest> rideRequests;
    private Map<String, Float> surgePricingZones;

    public RideSharingSystem() {
        this.drivers = new ArrayList<>();
        this.passengers = new HashMap<>();
        this.activeRides = new HashMap<>();
        this.rideRequests = new PriorityQueue<>(Comparator.comparing(RideRequest::getTimestamp));
        this.surgePricingZones = new HashMap<>();
    }

    public void registerUser(User user) {
        if (user instanceof Driver) {
            drivers.add((Driver) user);
            System.out.println("Registered Driver: " + user.getName());
        } else if (user instanceof Passenger) {
            passengers.put(user.getUserId(), (Passenger) user);
            System.out.println("Registered Passenger: " + user.getName());
        }
    }

    public void removeUser(String userId) {
        passengers.remove(userId);
        drivers.removeIf(driver -> driver.getUserId().equals(userId));
        System.out.println("Removed user with ID: " + userId);
    }

    public Driver findNearestDriver(RideRequest rideRequest) {
        // Placeholder: You can implement a spatial search algorithm here
        return drivers.stream()
                .filter(Driver::isAvailable)
                .findFirst()
                .orElse(null);
    }

    public Ride dispatchRide(RideRequest rideRequest) {
        Driver driver = findNearestDriver(rideRequest);
        if (driver != null) {
            driver.acceptRide(rideRequest);
            Ride ride = new Ride("RIDE" + System.currentTimeMillis(), driver.getUserId(), rideRequest.getPassengerId(), rideRequest.getOrigin(), rideRequest.getDestination());
            activeRides.put(ride.getRideId(), ride);
            return ride;
        } else {
            System.out.println("No available drivers for ride request.");
            return null;
        }
    }

    public void updateSurgePricing() {
        // Implement surge pricing logic based on demand and supply
    }

    public float calculateFare(Ride ride) {
        return ride.getFare(); // You may want to enhance this with actual calculation logic
    }

    // Method to get active rides
    public Map<String, Ride> getActiveRides() {
        return activeRides; // Return the active rides map
    }
}
