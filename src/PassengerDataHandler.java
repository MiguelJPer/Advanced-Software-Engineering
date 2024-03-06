package src;

import src.DataStructure.Passenger;

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

        // Assuming the format is Booking Number, Name, Flight Code, Checked In
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            if (parts.length == 4) {
                String bookingNumber = parts[0];
                String name = parts[1];
                String flightCode = parts[2];
                boolean isChecked = Boolean.parseBoolean(parts[3]);

                // Ensure Flight Code has the correct format
                if (isValidFlightCode(flightCode)) {
                    Passenger newPassenger = new Passenger(bookingNumber, name, flightCode, isChecked);
                    passengerList.add(newPassenger);
                } else {
                    System.err.println("Invalid Flight Code format: " + flightCode);
                }
            } else {
                System.err.println("Invalid data format: " + line);
            }
        }

        // Validate Flight Code format (two uppercase letters followed by two digits)
        sc.close(); // Closing the scanner
        return passengerList;
    }

    private static boolean isValidFlightCode(String flightCode) {
        return flightCode.matches("[A-Z]{2}\\d{2}");
        sc.useDelimiter(","); // sets the delimiter pattern
        /*
         * while (sc.hasNext()) // returns a boolean value
         * {
         * switch (scannerIndex) {
         * case 0:
         * String current = sc.next();
         * if (Pattern.matches("\\d{5}", current)) {
         * bookingNumber = Integer.parseInt(current);
         * scannerIndex++;
         * } else {
         * throw new IllegalArgumentException("Wrong booking number format");
         * }
         * break;
         * case 1:
         * current = sc.next();
         * if (Pattern.matches("[A-Za-z]+\\s[A-Za-z]+", current)) {
         * name = current;
         * scannerIndex++;
         * } else {
         * throw new IllegalArgumentException("Wrong name format");
         * }
         * break;
         * case 2:
         * current = sc.next();
         * if (Pattern.matches("[A-Z]{2}\\d{2}", current)) {
         * flightCode = current;
         * scannerIndex++;
         * } else {
         * throw new IllegalArgumentException("Wrong flight code format");
         * }
         * break;
         * case 3:
         * isChecked = Boolean.valueOf(sc.next());
         * // PLACEHOLDER: The Value of passengerList will need to be an instance of
         * // Passenger class.
         * Passenger newPassenger = new Passenger(flightCode, name, flightCode,
         * isChecked);
         * passengerList.put(bookingNumber, newPassenger);
         * scannerIndex = 0;
         * break;
         * }
         * }
         */
        while (sc.hasNext()) {
            bookingNumber = Integer.parseInt(sc.next());
            name = sc.next();
            flightCode = sc.next();
            isChecked = Boolean.parseBoolean(sc.next());

            Passenger newPassenger = new Passenger(flightCode, name, flightCode, isChecked);
            passengerList.put(bookingNumber, newPassenger);
        }
        sc.close();// closes the scanner
        System.out.println(passengerList);
    }
}