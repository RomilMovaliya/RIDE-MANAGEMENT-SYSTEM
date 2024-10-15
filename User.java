import java.util.ArrayList;
import java.util.List;

// Abstract class User 
public abstract class User {
    // Attributes
    protected String userId;
    protected String name;
    protected Location location;
    protected List<Float> ratings;

    // Creating a Constructor for user abstract class
    public User(String userId, String name, Location location) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.ratings = new ArrayList<>();  // Initialize empty ratings list
    }

    // Here i create Method to update the user's location
    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }

    // Method to calculate and return the average rating
    public float getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0f; // Return 0 if no ratings are available
        }

        float sum = 0;
        for (Float rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    // Abstract method - this will be implemented in subclasses
    public abstract String getRole();

    // Getter methods
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public List<Float> getRatings() {
        return ratings;
    }

    // Method to add a rating
    public void addRating(float rating) {
        ratings.add(rating);
    }
}
