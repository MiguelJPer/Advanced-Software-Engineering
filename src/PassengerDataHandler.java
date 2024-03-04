package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerDataHandler {
    public static void main(String[] args) throws Exception {
        List<Passenger> passengerList = passengerListGetter();

        // Displaying the passengerList with newline after each object
        for (Passenger passenger : passengerList) {
            System.out.println(passenger.toString());
            System.out.println(); // Adding a newline after each object
        }
    }

    public static List<Passenger> passengerListGetter() throws FileNotFoundException {
        List<Passenger> passengerList = new ArrayList<>();

        // Parsing the CSV file
        Scanner sc = new Scanner(new File("Datasets\\bookingList.csv"));
        sc.useDelimiter(","); // Setting the delimiter pattern to comma or newline, handling optional carriage return
        while (sc.hasNext()) {
            String bookingNumber = sc.next();
            String name = sc.next();
            String flightCode = sc.next();
            boolean isChecked = Boolean.parseBoolean(sc.next());

            Passenger newPassenger = new Passenger(bookingNumber, name, flightCode, isChecked);
            passengerList.add(newPassenger);
        }
        sc.close(); // Closing the scanner
        return passengerList;
    }
}

//import java.io.*;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//
//public class PassengerDataHandler {
//    public static void main(String[] args) throws Exception {
//        int scannerIndex = 0;
//        HashMap passengerList = new HashMap<Integer, Passenger>();
//
//        // Passenger Data temp variables
//        Integer bookingNumber = 0;
//        String name = "";
//        String flightCode = "";
//        boolean isChecked = false;
//        // parsing a CSV file into Scanner class constructor
//        Scanner sc = new Scanner(new File("Datasets\\bookingList.csv"));
//        sc.useDelimiter(","); // sets the delimiter pattern
//        while (sc.hasNext()) // returns a boolean value
//        {
//            switch (scannerIndex) {
//                case 0:
//                    String current = sc.next();
//                    if (Pattern.matches("\\d{5}", current)) {
//                        bookingNumber = Integer.parseInt(current);
//                        scannerIndex++;
//                    } else {
//                        throw new IllegalArgumentException("Wrong booking number format");
//                    }
//                    break;
//                case 1:
//                    current = sc.next();
//                    if (Pattern.matches("[A-Za-z]+\\s[A-Za-z]+", current)) {
//                        name = current;
//                        scannerIndex++;
//                    } else {
//                        throw new IllegalArgumentException("Wrong name format");
//                    }
//                    break;
//                case 2:
//                    current = sc.next();
//                    if (Pattern.matches("[A-Z]{2}\\d{2}", current)) {
//                        flightCode = current;
//                        scannerIndex++;
//                    } else {
//                        throw new IllegalArgumentException("Wrong flight code format");
//                    }
//                    break;
//                case 3:
//                    isChecked = Boolean.valueOf(sc.next());
//                    // PLACEHOLDER: The Value of passengerList will need to be an instance of
//                    // Passenger class.
//                    Passenger newPassenger = new Passenger(flightCode, name, flightCode, isChecked);
//                    passengerList.put(bookingNumber, newPassenger);
//                    scannerIndex = 0;
//                    break;
//            }
//        }
//        sc.close();// closes the scanner
//        System.out.println(passengerList);
//    }
//}



