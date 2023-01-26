package application;

import java.beans.EventHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mainWindowController {

    @FXML
    private Label labelCalculate;
    @FXML
    private TextField textPrincipal, textTenure, textInterestRate;
    @FXML
    private Button btnCalculate;

    int principal, tenure;
    double interestRate;
    

    public void calculate(Stage s) {

        EventHandler event = new EventHandler() {

            public void hand(ActionEvent e) {
                setText()
            }
        }

        principal = 
    }

    

}