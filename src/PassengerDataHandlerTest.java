package src;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.util.Map;
import org.junit.Test;

public class PassengerDataHandlerTest {
	public Map<Integer, Passenger> parsePassengerData(File file) {
		
		return null;
		}
	@Test
    public void testPassengerDataHandler() throws Exception {
        PassengerDataHandler dataHandler = new PassengerDataHandler();
        File file = new File("Datasets\\bookingList.csv");
        Map<Integer, Passenger> passengerList = dataHandler.parsePassengerData(file);
        assertNotNull(passengerList);
        assertFalse(passengerList.isEmpty());
        
    }
}
