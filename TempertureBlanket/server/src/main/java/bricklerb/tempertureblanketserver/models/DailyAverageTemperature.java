package bricklerb.tempertureblanketserver.models;

public class DailyAverageTemperature {
    private double min;
    private double max;
    private double afternoon;
    private double morning;
    private double evening;
    private double lat;
    private double lon;

    public DailyAverageTemperature() {
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

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(double afternoon) {
        this.afternoon = afternoon;
    }

    public double getMorning() {
        return morning;
    }

    public void setMorning(double morning) {
        this.morning = morning;
    }

    public double getEvening() {
        return evening;
    }

    public void setEvening(double evening) {
        this.evening = evening;
    }
}