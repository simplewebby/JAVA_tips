import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.stage.Stage;

// Allows the user to enter a meal amount and select a tip rate.
// When the claculate button is pressed the tip and total for the meal is displayed

public class tips extends Application {

    private TextField tfMeal = new TextField();
    private TextField tfTip = new TextField();
    private TextField tfTotal = new TextField();
    private ComboBox cbTips;
    private ObservableList<String> tip_rates =
            FXCollections.observableArrayList (
                    "0.05", "0.10",
                    "0.15", "0.18",
                    "0.20", "0.22",
                    "0.25", "0.30");

  @Override
  // Override the start method in the Application class
  public void start(Stage primaryStage) {

    VBox pane = new VBox(5);      

    tfMeal.setPrefColumnCount(10);
    tfTip.setPrefColumnCount(5);
    tfTotal.setPrefColumnCount(10);

// Compmo box for tip rates
    cbTips = new ComboBox(tip_rates);
    cbTips.setVisibleRowCount(4);
    cbTips.setValue(tip_rates.get(4));

    pane.getChildren().addAll(new Label("Amount: "), tfMeal, new Label("Tip rates: "), cbTips);


    HBox hBox = new HBox(5);
    Button btCalculate = new Button("Calculate Tip");

    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(btCalculate, new Label("Tip: "), tfTip, new Label("Total: "), tfTotal);
    // tip and total are display only fields
    tfTip.setEditable(false);
    tfTotal.setEditable(false);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 375, 150);
    primaryStage.setTitle("Tip calculator"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    btCalculate.setOnAction(new EventHandler<ActionEvent>() {

        public void handle(ActionEvent e) {
            // take the values in  tfMeal and cbTip
            // calculate and display in tfTip and tfTotal as the tip and total
            // for extra credit add exception handling (but do not display the error in the console)

            // this statement gets the tip rate
            double tiprt = Double.parseDouble(cbTips.getValue().toString());
            double tfMealVal = Double.parseDouble(tfMeal.getText().toString());
            double rslt = tfMealVal*tiprt;
            double totalAmnt = rslt+tfMealVal;
            tfTip.setText(Double.toString(rslt));
            tfTotal.setText(Double.toString(totalAmnt));

        }
    });



  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
} 
    
			
    
   
  
  
