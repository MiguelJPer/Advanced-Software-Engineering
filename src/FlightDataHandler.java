package src;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FlightDataHandler {
    public static void main(String[] args) throws Exception {
        int scannerIndex = 0;
        HashMap flightList = new HashMap<String, String>();

        // Passenger Data temp variables
        String flightCode = "";
        String destination = "";
        String company = "";
        int maxPassengers = 0;
        double maxBagWeight = 0.0;
        double maxBagVolume = 0.0;
        // parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("Datasets\\flightList.csv"));
        sc.useDelimiter(","); // sets the delimiter pattern
        while (sc.hasNext()) // returns a boolean value
        {
            switch (scannerIndex) {
                case 0:
                   String current = sc.next();
                    if (Pattern.matches("[A-Z]{2}\\d{2}", current)) {
                        flightCode = current;
                        scannerIndex++;
                    } else {
                        throw new IllegalArgumentException("Wrong flight code format");
                    }
                    break;
                case 1:
                    destination = sc.next();
                    scannerIndex++;
                    break;
                case 2:
                    company = sc.next();
                    scannerIndex++;
                    break;
                case 3:
                    maxPassengers = Integer.parseInt(sc.next());
                    scannerIndex++;
                    break;
                case 4:
                    maxBagWeight = Double.parseDouble(sc.next());
                    scannerIndex++;
                    break;
                case 5:
                    maxBagVolume = Double.parseDouble(sc.next());
                    // PLACEHOLDER: The Value of passengerList will need to be an instance of
                    // Passenger class.
                    Flight newFlight = new Flight(destination, company, maxPassengers, maxBagWeight, maxBagVolume);
                    flightList.put(flightCode, destination);
                    scannerIndex = 0;
                    break;
            }
        }
        sc.close();// closes the scanner
        System.out.println(flightList);
    }
}