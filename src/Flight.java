package src;
public class Flight {
    private String flightCode;
    private String destination;
    private String company;
    private int maxPassengers;
    private double maxBagWeight;
    private double maxBagVolume;

    public Flight(String flightCode, String destination, String company, int maxPassengers, double maxBagWeight, double maxBagVolume) {
        this.flightCode = flightCode;
        this.destination = destination;
        this.company = company;
        this.maxPassengers = maxPassengers;
        this.maxBagWeight = maxBagWeight;
        this.maxBagVolume = maxBagVolume;
    }

    // Getters and setters
    // You can generate these using your IDE or write them manually
    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public double getMaxBagWeight() {
        return maxBagWeight;
    }

    public void setMaxBagWeight(double maxBagWeight) {
        this.maxBagWeight = maxBagWeight;
    }

    public double getMaxBagVolume() {
        return maxBagVolume;
    }

    public void setMaxBagVolume(double maxBagVolume) {
        this.maxBagVolume = maxBagVolume;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightCode='" + flightCode + '\'' +
                ", destination='" + destination + '\'' +
                ", company='" + company + '\'' +
                ", maxPassengers=" + maxPassengers +
                ", maxBagWeight=" + maxBagWeight +
                ", maxBagVolume=" + maxBagVolume +
                '}';
    }
}

