package src;
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class FlightDataHandler {
//    public static void main(String[] args) throws Exception {
//        int scannerIndex = 0;
//        Map flightList = new HashMap<String, String>();
//
//        // Passenger Data temp variables
//        String flightCode = "";
//        String destination = "";
//        String company = "";
//        int maxPassengers = 0;
//        double maxBagWeight = 0.0;
//        double maxBagVolume = 0.0;
//        // parsing a CSV file into Scanner class constructor
//        Scanner sc = new Scanner(new File("Datasets\\flightList.csv"));
//        sc.useDelimiter(",|\\r?\\n"); // sets the delimiter pattern to comma or newline, handling optional carriage return
//        while (sc.hasNext()) // returns a boolean value
//        {
//            switch (scannerIndex) {
//                case 0:
//                    flightCode = sc.next();
//                    scannerIndex++;
//                    break;
//                case 1:
//                    destination = sc.next();
//                    scannerIndex++;
//                    break;
//                case 2:
//                    company = sc.next();
//                    scannerIndex++;
//                    break;
//                case 3:
//                    maxPassengers = Integer.parseInt(sc.next());
//                    scannerIndex++;
//                    break;
//                case 4:
//                    maxBagWeight = Double.parseDouble(sc.next());
//                    scannerIndex++;
//                    break;
//                case 5:
//                    maxBagVolume = Double.parseDouble(sc.next());
//                    // PLACEHOLDER: The Value of passengerList will need to be an instance of
//                    // Passenger class.
//                    flightList.put(flightCode, destination);
//                    scannerIndex = 0;
//                    break;
//            }
//        }
//        sc.close();// closes the scanner
//        System.out.println(flightList);
//    }
//}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightDataHandler {
    public static void main(String[] args) throws Exception {
        List<Flight> flightList = new ArrayList<>();
        flightList = flightListGetter();

        // Displaying the flightList with newline after each object
        for (Flight flight : flightList) {
            System.out.println(flight);
            System.out.println(); // Adding a newline after each object
        }
    }

    public static List<Flight> flightListGetter() throws FileNotFoundException {
        List<Flight> flightList = new ArrayList<>();

        // Parsing the CSV file
        Scanner sc = new Scanner(new File("Datasets\\flightList.csv"));
        sc.useDelimiter(",|\r?\n"); // Setting the delimiter pattern to comma or newline, handling optional carriage return
        while (sc.hasNext()) {
            String[] data = new String[6]; // Array to store flight data

            // Reading each line of flight data
            for (int i = 0; i < 6; i++) {
                if (sc.hasNext()) {
                    data[i] = sc.next();
                }
            }

            // Creating a Flight object and adding it to the flightList list
            String flightCode = data[0];
            String destination = data[1];
            String company = data[2];
            int maxPassengers = Integer.parseInt(data[3]);
            double maxBagWeight = Double.parseDouble(data[4]);
            double maxBagVolume = Double.parseDouble(data[5]);
            Flight newFlight = new Flight(flightCode, destination, company, maxPassengers, maxBagWeight, maxBagVolume);
            flightList.add(newFlight);
        }
        sc.close(); // Closing the scanner

        return flightList;
    }
}

