import java.time.LocalDateTime;

public class Ride {
    private String rideId;
    private String driverId;
    private String passengerId;
    private Location origin;
    private Location destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private float fare;

    public Ride(String rideId, String driverId, String passengerId, Location origin, Location destination) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.startTime = null;
        this.endTime = null;
        this.fare = 0.0f;
    }

    public void startRide() {
        this.startTime = LocalDateTime.now();
        System.out.println("Ride " + rideId + " has started.");
    }

    public void endRide() {
        this.endTime = LocalDateTime.now();
        this.fare = calculateFare();
        System.out.println("Ride " + rideId + " has ended. Fare: " + fare);
    }

    private float calculateFare() {
        return 50.0f; // Placeholder for actual fare calculation
    }

    public String getRideId() {
        return rideId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public float getFare() {
        return fare;
    }
}
