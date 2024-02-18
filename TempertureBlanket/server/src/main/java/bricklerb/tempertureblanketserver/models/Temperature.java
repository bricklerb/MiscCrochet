package bricklerb.tempertureblanketserver.models;

public class Temperature {
    private double value;
    private double lat;
    private double lon;
    private double locationName;

    public Temperature(double value, double lat, double lon, double locationName) {
        this.value = value;
        this.lat = lat;
        this.lon = lon;
        this.locationName = locationName;
    }

    public Temperature() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLocationName() {
        return locationName;
    }

    public void setLocationName(double locationName) {
        this.locationName = locationName;
    }
}