package src;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class PassengerTest {
	@Test
    public void testPassengerCreation() {
        
        String csvData = "12345,Alice Johnson,AB12,FALSE," +
                         "67890,Bob Smith,CD34,FALSE," +
                         "13579,Charlie Brown,EF56,FALSE," +
                         "24680,David White,GH78,FALSE," +
                         "98765,Emma Taylor,IJ90,FALSE," +
                         "54321,Frank Miller,KL12,FALSE," +
                         "24681,Grace Davis,MN34,FALSE," +
                         "35791,Henry Clark,OP56,FALSE," +
                         "46802,Ivy Wilson,QR78,FALSE," +
                         "57913,Jack Anderson,ST90,FALSE," +
                         "68024,Kate Roberts,UV12,FALSE," +
                         "79135,Liam Thompson,WX34,FALSE," +
                         "80246,Mia Garcia,YZ56,FALSE," +
                         "91357,Noah Martinez,AB78,FALSE," +
                         "12468,Olivia Lopez,CD90,FALSE," +
                         "23579,Peter Harris,EF12,FALSE," +
                         "34680,Quinn Lee,GH34,FALSE," +
                         "45791,Rachel Phillips,IJ56,FALSE," +
                         "56802,Samuel Rodriguez,KL78,FALSE," +
                         "67913,Thomas Scott,MN90,FALSE";

        // Parsing CSV data and creating passengers
        String[] rows = csvData.split(",");
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < rows.length; i += 4) {
            String bookingReferenceCode = rows[i];
            String name = rows[i + 1];
            String flightCode = rows[i + 2];
            boolean checkedIn = Boolean.parseBoolean(rows[i + 3]);
            passengers.add(new Passenger(bookingReferenceCode, name, flightCode, checkedIn));
        }

        // Assertions for each passenger
        assertEquals("12345", passengers.get(0).getBookingReferenceCode());
        assertEquals("Alice Johnson", passengers.get(0).getName());
        assertEquals("AB12", passengers.get(0).getFlightCode());
        assertFalse(passengers.get(0).isCheckedIn());

       
    }

}
