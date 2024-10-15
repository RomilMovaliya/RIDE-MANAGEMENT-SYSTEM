import java.time.LocalDateTime;
  // Only needed if RideRequest is in a different package

public class RideRequest {
    private String requestId;
    private String passengerId;
    private Location origin;
    private Location destination;
    private LocalDateTime timestamp;

    // Constructor
    public RideRequest(String passengerId, Location origin, Location destination) {
        this.requestId = generateRequestId();
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.timestamp = LocalDateTime.now();
    }

    // Generate a unique request ID (could be more sophisticated)
    private String generateRequestId() {
        return "REQ" + System.currentTimeMillis();
    }

    // Getters for the attributes
    public String getPassengerId() {
        return passengerId;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
