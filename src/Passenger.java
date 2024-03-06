package src;

<<<<<<< HEAD
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Passenger {
    private final StringProperty bookingReferenceCode;
    private final StringProperty name;
    private final StringProperty flightCode;
    private final BooleanProperty checkedIn;

    public Passenger(String bookingReferenceCode, String name, String flightCode, boolean checkedIn) {
        this.bookingReferenceCode = new SimpleStringProperty(bookingReferenceCode);
        this.name = new SimpleStringProperty(name);
        this.flightCode = new SimpleStringProperty(flightCode);
        this.checkedIn = new SimpleBooleanProperty(checkedIn);
    }

    // Getter methods for JavaFX Properties
    public StringProperty bookingReferenceCodeProperty() {
        return bookingReferenceCode;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty flightCodeProperty() {
        return flightCode;
    }

    public BooleanProperty checkedInProperty() {
        return checkedIn;
    }

    // Getter methods for original data types
    public String getBookingReferenceCode() {
        return bookingReferenceCode.get();
    }

    public String getName() {
        return name.get();
    }

    public String getFlightCode() {
        return flightCode.get();
    }

    public boolean isCheckedIn() {
        return checkedIn.get();
=======
public class Passenger {
    private String bookingReferenceCode;
    private String name;
    private String flightCode;
    private boolean checkedIn;
    private double baggageWeight;
    private double baggageVolume;

    
    public Passenger(String bookingReferenceCode, String name, String flightCode, boolean checkedIn) {
        this.bookingReferenceCode = bookingReferenceCode;
        this.name = name;
        this.flightCode = flightCode;
        this.checkedIn = checkedIn;
    }

    // Getter and Setter method
    public String getBookingReferenceCode() {
        return bookingReferenceCode;
    }

    public void setBookingReferenceCode(String bookingReferenceCode) {
        this.bookingReferenceCode = bookingReferenceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(double baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public double getBaggageVolume() {
        return baggageVolume;
    }

    public void setBaggageVolume(double baggageVolume) {
        this.baggageVolume = baggageVolume;
    }

    // toString method, print passenger's information
    @Override
    public String toString() {
        return "Passenger{" +
                "bookingReferenceCode='" + bookingReferenceCode + '\'' +
                ", name='" + name + '\'' +
                ", flightCode='" + flightCode + '\'' +
                ", checkedIn=" + checkedIn +
                ", baggageWeight=" + baggageWeight +
                ", baggageVolume=" + baggageVolume +
                '}';
>>>>>>> upstream/main
    }
}
