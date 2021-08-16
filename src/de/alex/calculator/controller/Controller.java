package de.alex.calculator.controller;

import de.alex.calculator.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    public Model model = new Model();

    @FXML
    private TextField outputText;

    private String operator = "";
    private String percent = "";
    private String result = "";
    private double firstDigit;
    private double secondDigit;

    private boolean start = true;

    public void btnDigitClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String value = button.getText();
        if (start){
            outputText.setText("");
            start = false;
        }
        if(",".equals(value)){
            value = value.replace(',', '.');
        }
        outputText.setText(outputText.getText() + value);
    }

    public void btnOperatorClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String value = button.getText();
        if (!"=".equals(value)){
            operator = value;
            firstDigit = Double.parseDouble(outputText.getText());
            outputText.setText("");
        }else{
            if (operator.isEmpty()) return;
            outputText.setText(String.valueOf(model.calculation(firstDigit, Double.parseDouble(outputText.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    public void btnClearClick() {
        outputText.setText("");
    }

    public void btnSqrtClick() {
        outputText.setText(String.valueOf(Math.sqrt(Double.parseDouble(outputText.getText()))));
    }
    @FXML
    public void btnPercentClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String value = button.getText();
        if (!"%".equals(value)){
            firstDigit = Double.parseDouble(outputText.getText());
            outputText.setText("");
            operator = value;
        }else if(operator.isEmpty()) return;
                secondDigit = Double.parseDouble(outputText.getText());
                outputText.setText(String.valueOf(model.percentCalculation(firstDigit, secondDigit, operator)));
                operator = "";
                start = true;
        }
}

