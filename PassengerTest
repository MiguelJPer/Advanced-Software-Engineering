
package src;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Map;


public class PassengerTest {
	@Test
    public void testPassengerConstructor() {
        Passenger passenger = new Passenger("ABC123", "John Doe", "FL123", false);
        assertEquals("ABC123", passenger.getBookingReferenceCode());
        assertEquals("John Doe", passenger.getName());
        assertEquals("FL123", passenger.getFlightCode());
        assertFalse(passenger.isCheckedIn());
    }

    @Test
    public void testPassengerSettersAndGetters() {
        Passenger passenger = new Passenger("ABC123", "John Doe", "FL123", false);
        passenger.setBookingReferenceCode("XYZ456");
        assertEquals("XYZ456", passenger.getBookingReferenceCode());

        passenger.setName("Jane Smith");
        assertEquals("Jane Smith", passenger.getName());

        passenger.setFlightCode("FL456");
        assertEquals("FL456", passenger.getFlightCode());

        passenger.setCheckedIn(true);
        assertTrue(passenger.isCheckedIn());

        passenger.setBaggageWeight(25.5);
        assertEquals(25.5, passenger.getBaggageWeight(), 0.01);

        passenger.setBaggageVolume(10.0);
        assertEquals(10.0, passenger.getBaggageVolume(), 0.01);
    }

}
