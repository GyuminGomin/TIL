package simple_test_java.my_test.src.t20231130.practice3;

public class Location {
    
    private double latitude; // 위도
    private double longitude; // 경도


    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Location [longtitude=" + longitude + ", latitude=" + latitude + "]";
    }

    
}
