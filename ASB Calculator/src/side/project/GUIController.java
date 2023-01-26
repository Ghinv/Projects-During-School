/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package side.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Sufyan
 */
public class GUIController implements Initializable {

    @FXML
    private TextField txtPrincipal;
    @FXML
    private TextField txtDividend;
    @FXML
    private TextField txtBonus;
    @FXML
    private TextField txtAddedBonus;
    @FXML
    private TextField txtAddedBonusUnit;
    @FXML
    private TextField txtPeriod;
    @FXML
    private TextField txtDeposit;
    @FXML
    private ComboBox<String> comboYear;
    @FXML
    private Text lblResult;
    @FXML
    private Text lblResult1;
    @FXML
    private Text lblResult2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboYear.getItems().removeAll(comboYear.getItems());
        comboYear.getItems().addAll("2022", "2021", "2020","2019","2018");
        comboYear.getSelectionModel().select("");
    }    

    
        public void Data(){
         // Get the selected origin and destination
        

        
        double dividend, bonus, addedbonus, addedbonusUnit; 
        if (comboYear.getSelectionModel().getSelectedItem().equals("2022")) {
            dividend = 3.35;
            bonus = 1.25;
            addedbonus = 0.5;
            addedbonusUnit = 30000;    
        }
        else if (comboYear.getSelectionModel().getSelectedItem().equals("2021")){
            dividend = 4.25;
            bonus = 0.75;
            addedbonus = 0;
            addedbonusUnit = 0;
        }
        else if (comboYear.getSelectionModel().getSelectedItem().equals("2020")){
            dividend = 4.25;
            bonus = 0;
            addedbonus = 0.75;
            addedbonusUnit = 30000;
        }
        else if (comboYear.getSelectionModel().getSelectedItem().equals("2019")){
            dividend = 5.00;
            bonus = 0.5;
            addedbonus = 0;
            addedbonusUnit = 0;
        }
        else if (comboYear.getSelectionModel().getSelectedItem().equals("2018")){
            dividend = 6.50;
            bonus = 0.5;
            addedbonus = 0;
            addedbonusUnit = 0;
        }
        else{
            dividend = 0;
            bonus = 0;
            addedbonus = 0;
            addedbonusUnit = 0;            
        }
        
        txtDividend.setText(Double.toString(dividend));
        txtBonus.setText(Double.toString(bonus));
        txtAddedBonus.setText(Double.toString(addedbonus));
        txtAddedBonusUnit.setText(Double.toString(addedbonusUnit));
        
    }
    
        public void Calculate(){
            double P = Double.parseDouble(txtPrincipal.getText());
            double D = Double.parseDouble(txtDividend.getText());
            double B = Double.parseDouble(txtBonus.getText());
            double AB = Double.parseDouble(txtAddedBonus.getText());
            double BU = Double.parseDouble(txtAddedBonusUnit.getText());
            double Period = Double.parseDouble(txtPeriod.getText());
            double Deposit = Double.parseDouble(txtDeposit.getText());
            
            double totalFirst, totalSecond, totalDividend, totalFinal, totalThird,totalFifth, totalAddedBonus, totalBonus, totalFourth, r, r2, r3;
            
            r = D/100;
            r2 = B/100;
            r3 = AB/100;
            double totalWithdrawal = P + (12 * Period * Deposit);
            
            if ( P >= BU ){

                  totalFirst = P * (Math.pow((1+(r/1)),(Period*1)));
                  totalSecond = Deposit * (((Math.pow((1+(r/12)),(Period*12)))-1)/(r/12));
                  totalDividend = (totalFirst + totalSecond) - totalWithdrawal ;
                  
                  totalThird = P * (Math.pow((1+(r2/1)),(Period*1)));
                  totalFourth = Deposit * (((Math.pow((1+(r2/12)),(Period*12)))-1)/(r2/12));
                  totalBonus = (totalThird + totalFourth) - totalWithdrawal;
                  
                  totalFifth = BU * (Math.pow((1+(r3/1)),(Period*1)));
                  totalAddedBonus = totalFifth - BU;
                  
                  totalFinal = totalDividend + totalBonus + totalAddedBonus;
                  

                }
            else {


                  totalFirst = P * (Math.pow((1+(r/1)),(Period*1)));
                  totalSecond = Deposit * (((Math.pow((1+(r/12)),(Period*12)))-1)/(r/12));
                  totalDividend = (totalFirst + totalSecond) - totalWithdrawal ;
                  
                  totalThird = P * (Math.pow((1+(r2/1)),(Period*1)));
                  totalFourth = Deposit * (((Math.pow((1+(r2/12)),(Period*12)))-1)/(r2/12));
                  totalBonus = (totalThird + totalFourth) - totalWithdrawal;
                  
                  totalFifth = P * (Math.pow((1+(r3/1)),(Period*1)));
                  totalAddedBonus = totalFifth - P;
                  
                  totalFinal = totalDividend + totalBonus + totalAddedBonus;
            }
            
            
            lblResult.setText("Your total dividend is: " + String.format("%.2f",totalDividend));
            lblResult1.setText("Your total bonus is: " + String.format("%.2f",totalBonus));
            lblResult2.setText("Your total dividend + bonus + added bonus is: " + String.format("%.2f",totalFinal));
        
        
        
            
        }

    @FXML
    private void comboYearAction(ActionEvent event) {
        comboYear.valueProperty().addListener((observable, oldValue, newValue) -> {
        Data();
        });
    }

    @FXML
    private void btnCalculateAction(ActionEvent event) {
        Calculate();
    }
}
