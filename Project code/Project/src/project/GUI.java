package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class GUI extends Application {

    private String selectedService = null; // to store the selected service

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Salon Booking System");

        // ============== show a menu (First scene ) ==============
        Label selectLabel = new Label("Select a Service:");

        //CheckBox for multiple choices
        CheckBox hairBox = new CheckBox("Hair");
        CheckBox makeupBox = new CheckBox("MakeUp");
        CheckBox maniBox = new CheckBox("Manicure");
        CheckBox careBox = new CheckBox("Care");

        Button bookButton = new Button("Book Now"); // button to start booking
        
        // layout
        GridPane firstScene = new GridPane(); 
        firstScene.setPadding(new Insets(20)); 
        firstScene.setHgap(10); 
        firstScene.setVgap(10);
        firstScene.setAlignment(Pos.CENTER); 
        firstScene.add(selectLabel, 0, 0);
        firstScene.add(hairBox, 0, 1);
        firstScene.add(makeupBox, 0, 2);
        firstScene.add(maniBox, 0, 3);
        firstScene.add(careBox, 0, 4);
        firstScene.add(bookButton, 0, 5);
        
        Scene scene1 = new Scene(firstScene, 400, 300);

        
        // ============== choosing date and time (Second scene) ==============
        Label dateLabel = new Label("Choose a Date:");
        DatePicker date = new DatePicker();

        Label timeLabel = new Label("Enter Time (e.g. 2:00 PM):");
        TextField time = new TextField();

        Button confirmButton = new Button("Confirm Booking"); // button to cofirm booking, shows a message

        // layout
        GridPane secondScene = new GridPane();
        secondScene.setPadding(new Insets(20));
        secondScene.setHgap(10);
        secondScene.setVgap(10);
        secondScene.setAlignment(Pos.CENTER);
        secondScene.add(dateLabel, 0, 0);
        secondScene.add(date, 1, 0);
        secondScene.add(timeLabel, 0, 1);
        secondScene.add(time, 1, 1);
        secondScene.add(confirmButton, 1, 2);
        
        Scene scene2 = new Scene(secondScene, 400, 300);

        
        // ============== First button action ==============
        bookButton.setOnAction(e -> {
            StringBuilder selected = new StringBuilder();
            
            if(hairBox.isSelected())
                selected.append("Hair, ");
            
            if(makeupBox.isSelected())
                selected.append("MakeUp, ");
            
            if(maniBox.isSelected())
                selected.append("Manicure, ");
            
            if(careBox.isSelected())
                selected.append("Care, ");
        
            if(selected.length() == 0){
                showAlert("No selection", "Please select at least one service.");
            }else{ // removeing the comma and space
                selected.setLength(selected.length() - 2);
                selectedService = selected.toString();
                primaryStage.setScene(scene2); // move to the second scene
            }
        });
        
        // ============== Second button action ==============
        confirmButton.setOnAction(e -> {
            try{
                String selectedDate = (date.getValue() != null) ? date.getValue().toString() : "";
                String selectedTime = time.getText().trim();

                if (selectedDate.isEmpty() || selectedTime.isEmpty()) {
                    showAlert("Missing Info", "Please enter date, time, or both.");
                
                } else {   
                    String message = String.format("You booked %s service at date %s in time %s.", selectedService, selectedDate, selectedTime);
                    showAlert("Booking Confirmed", message);
                    }
            }catch (Exception ex) {
                showAlert("Error", "Something went wrong while confirming your booking.");      
            }
        });

        // Starting the app (Stage)
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    // Method for showing messages
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //object Alert, type(information)
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}