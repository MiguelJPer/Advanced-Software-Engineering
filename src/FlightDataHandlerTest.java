package src;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FlightDataHandlerTest {
	private FlightDataHandler flightDataHandler;

    @Before
    public void setUp() {
        flightDataHandler = new FlightDataHandler();
    }
    public Map<String, String> parseFlightData(String filePath) throws IOException {
        Map<String, String> flightData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Assuming CSV format with comma as delimiter
                if (parts.length >= 2) {
                    String flightCode = parts[0].trim();
                    String destination = parts[1].trim();
                    flightData.put(flightCode, destination);
                }
            }
        }

        return flightData;
    }
    
    @Test
    public void testFlightDataParsingAndStorage() {
        try {
            Map<String, String> flightList = flightDataHandler.parseFlightData("flightList.csv");
            assertEquals(20, flightList.size()); // 
            assertEquals("London Heathrow Airport", flightList.get("AB12")); // Assuming flight code AB12 goes to London Heathrow Airport
            assertEquals("Los Angeles International Airport", flightList.get("CD34")); // Assuming flight code CD34 goes to Los Angeles International Airport
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
