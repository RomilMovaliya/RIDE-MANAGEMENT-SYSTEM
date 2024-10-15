public class Location {
    private float latitude;
    private float longitude;

    // Constructor
    public Location(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    // Method to calculate distance to another location (optional)
    public double distanceTo(Location other) {
        // Implement distance calculation using Haversine formula, or simple Cartesian distance for simplicity
        double latDiff = Math.toRadians(this.latitude - other.latitude);
        double lonDiff = Math.toRadians(this.longitude - other.longitude);
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) + 
                   Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(other.latitude)) * 
                   Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double radiusOfEarth = 6371.0; // in kilometers
        return radiusOfEarth * c;
    }
}
