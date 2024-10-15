import java.util.*;

public class FraudDetectionModule {
    private List<Map<String, String>> suspiciousActivities;
    private Set<String> blacklistedUsers;

    public FraudDetectionModule() {
        suspiciousActivities = new ArrayList<>();
        blacklistedUsers = new HashSet<>();
    }

    public void monitorRides(RideSharingSystem rideSharingSystem) {
        for (Ride ride : rideSharingSystem.getActiveRides().values()) {
            if (detectFraud(ride)) {
                flagActivity(ride.getPassengerId(), "Unusually high fare");
                flagActivity(ride.getDriverId(), "Unusually high fare in repeated rides");
            }
        }
    }

    private boolean detectFraud(Ride ride) {
        return ride.getFare() > 100.0f; // Example threshold
    }

    public void flagActivity(String userId, String reason) {
        Map<String, String> activity = new HashMap<>();
        activity.put("user_id", userId);
        activity.put("reason", reason);
        suspiciousActivities.add(activity);
        System.out.println("User " + userId + " flagged for: " + reason);
    }

    public void blockUser(String userId) {
        blacklistedUsers.add(userId);
        System.out.println("User " + userId + " has been blacklisted.");
    }

    public void analyzePatterns() {
        Map<String, Integer> userFraudCounts = new HashMap<>();
        for (Map<String, String> activity : suspiciousActivities) {
            String userId = activity.get("user_id");
            userFraudCounts.put(userId, userFraudCounts.getOrDefault(userId, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : userFraudCounts.entrySet()) {
            if (entry.getValue() >= 3) { // Example threshold for blacklisting
                blockUser(entry.getKey());
            }
        }
    }

    // Getters for suspicious activities and blacklisted users
    public List<Map<String, String>> getSuspiciousActivities() {
        return suspiciousActivities;
    }

    public Set<String> getBlacklistedUsers() {
        return blacklistedUsers;
    }
}
