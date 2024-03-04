package src;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class PassengerQueryUI extends Application {
    private List<Passenger> passengerList;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMainScene();
    }

    private void showMainScene() {
        Button showButton = new Button("Query");
        showButton.setOnAction(event -> {
            try {
                showPassengerDataScene();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        VBox root = new VBox(showButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }

    private void showPassengerDataScene() throws FileNotFoundException {
        // Load passenger data
        passengerList = PassengerDataHandler.passengerListGetter();

        // Text field for input
        TextField inputField = new TextField();
        inputField.setPromptText("Enter Name or Booking Reference");

        // Button to execute query
        Button queryButton = new Button("Query");
        queryButton.setOnAction(event -> executeQuery(inputField.getText()));

        HBox inputBox = new HBox(inputField, queryButton);

        // TableView to display query results
        TableView<Passenger> tableView = new TableView<>();
        TableColumn<Passenger, String> bookingRefCol = new TableColumn<>("Booking Reference");
        bookingRefCol.setCellValueFactory(new PropertyValueFactory<>("bookingReferenceCode"));

        TableColumn<Passenger, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Passenger, String> flightCodeCol = new TableColumn<>("Flight Code");
        flightCodeCol.setCellValueFactory(new PropertyValueFactory<>("flightCode"));

        TableColumn<Passenger, String> checkedInCol = new TableColumn<>("Checked In");
        checkedInCol.setCellValueFactory(cellData -> {
            boolean checkedIn = cellData.getValue().isCheckedIn();
            return new SimpleStringProperty(checkedIn ? "Yes" : "No");
        });

        tableView.getColumns().addAll(bookingRefCol, nameCol, flightCodeCol, checkedInCol);

        // Button to return to main menu
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> showMainScene());

        VBox root = new VBox(inputBox, tableView, returnButton);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Passenger Query");
        primaryStage.show();
    }

    private void executeQuery(String query) {
        List<Passenger> queryResult = passengerList.stream()
                .filter(passenger -> passenger.getName().equalsIgnoreCase(query)
                        || passenger.getBookingReferenceCode().equalsIgnoreCase(query))
                .collect(Collectors.toList());

        if (queryResult.isEmpty()) {
            showInputErrorAlert();
        } else {
            showQueryResult(queryResult);
        }
    }

    private void showQueryResult(List<Passenger> queryResult) {
        ObservableList<Passenger> data = FXCollections.observableArrayList(queryResult);
        TableView<Passenger> tableView = new TableView<>(data);

        TableColumn<Passenger, String> bookingRefCol = new TableColumn<>("Booking Reference");
        bookingRefCol.setCellValueFactory(new PropertyValueFactory<>("bookingReferenceCode"));

        TableColumn<Passenger, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Passenger, String> flightCodeCol = new TableColumn<>("Flight Code");
        flightCodeCol.setCellValueFactory(new PropertyValueFactory<>("flightCode"));

        TableColumn<Passenger, String> checkedInCol = new TableColumn<>("Checked In");
        checkedInCol.setCellValueFactory(cellData -> {
            boolean checkedIn = cellData.getValue().isCheckedIn();
            return new SimpleStringProperty(checkedIn ? "Yes" : "No");
        });

        tableView.getColumns().addAll(bookingRefCol, nameCol, flightCodeCol, checkedInCol);

        // Button to return to query scene
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            try {
                showPassengerDataScene();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        VBox root = new VBox(tableView, returnButton);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Query Result");
        primaryStage.show();
    }

    private void showInputErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText("Invalid input. Please enter a valid Name or Booking Reference.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
