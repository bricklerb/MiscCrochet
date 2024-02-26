package bricklerb.tempertureblanketserver.models;

public class City {
    private double lat;
    private double lon;
    private int id;

    public City(double lat, double lon, int id, String name) {
        this.lat = lat;
        this.lon = lon;
        this.id = id;
        this.name = name;
    }

    public City() {
        lat = 0;
        lon = 0;
        id = 0;
        name = "";
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
