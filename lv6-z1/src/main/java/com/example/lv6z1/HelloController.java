package com.example.lv6z1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static java.lang.Math.pow;

public class HelloController {
    @FXML
    private Label result;
    private StringBuilder string = new StringBuilder();
    private boolean eqWasCalled = false;
    private void calculate(){
        double a = 0, b = 0;
        int i = 0;
        while(i < string.length() && string.charAt(i) >= '0' && string.charAt(i) <= '9'){
            a = a * 10 + (string.charAt(i) - '0');
            i++;
        }
        if(!(i < string.length())){
            result.setText(String.valueOf(a));
            return;
        }

        char operator = string.charAt(i);
        i++;
        if(operator == '.'){
            double tmp = 0;
            int dec = 0;
            while(i < string.length() && string.charAt(i) >= '0' && string.charAt(i) <= '9'){
                tmp = tmp * 10 + (string.charAt(i) - '0');
                i++;
                dec++;
            }
            a = a + tmp / pow(10, dec);
            if(!(i < string.length())){
                result.setText(String.valueOf(a));
                return;
            }
            operator = string.charAt(i);
            i++;
        }
        if(!(i < string.length())){
            result.setText("Error");
            return;
        }

        while(i < string.length() && string.charAt(i) >= '0' && string.charAt(i) <= '9'){
            b = b * 10 + (string.charAt(i) - '0');
            i++;
        }
        if(i < string.length()){
            char operator2 = string.charAt(i);
            i++;
            int dec = 0;
            double tmp = 0;
            if(operator2 == '.'){
                while(i < string.length() && string.charAt(i) >= '0' && string.charAt(i) <= '9'){
                    tmp = tmp * 10 + (string.charAt(i) - '0');
                    i++;
                    dec++;
                }
                b = b + tmp / pow(10, dec);
            }
        }

        double c = 0;
        if(operator == '+') c = a + b;
        else if(operator == '-') c = a - b;
        else if(operator == 'x') c = a * b;
        else if(operator == '/') c = a / b;
        else if(operator == '%') c = a % b;

        result.setText(String.valueOf(c));
    }

    @FXML
    protected void onButtonModClick() {
        result.setText(result.getText() + "%");
        string.append('%');
    }
    @FXML
    protected void onButtonDivClick() {
        result.setText(result.getText() + "/");
        string.append('/');
    }
    @FXML
    protected void onButtonMulClick() {
        result.setText(result.getText() + "x");
        string.append('x');
    }
    @FXML
    protected void onButtonMinusClick() {
        result.setText(result.getText() + "-");
        string.append('-');
    }
    @FXML
    protected void onButtonPlusClick() {
        result.setText(result.getText() + "+");
        string.append('+');
    }
    @FXML
    protected void onButtonEqClick() throws InterruptedException {
        result.setText(result.getText() + "=");
        calculate();
        string.setLength(0);
        eqWasCalled = true;
    }
    @FXML
    protected void onButtonPtClick() {
        result.setText(result.getText() + ".");
        string.append('.');
    }
    @FXML
    protected void onButton0Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "0");
        string.append('0');
    }
    @FXML
    protected void onButton1Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "1");
        string.append('1');
    }
    @FXML
    protected void onButton2Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "2");
        string.append('2');
    }
    @FXML
    protected void onButton3Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "3");
        string.append('3');
    }
    @FXML
    protected void onButton4Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "4");
        string.append('4');
    }
    @FXML
    protected void onButton5Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "5");
        string.append('5');
    }
    @FXML
    protected void onButton6Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "6");
        string.append('6');
    }
    @FXML
    protected void onButton7Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "7");
        string.append('7');
    }
    @FXML
    protected void onButton8Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "8");
        string.append('8');
    }
    @FXML
    protected void onButton9Click() {
        if(eqWasCalled){
            result.setText("");
            eqWasCalled = false;
        }
        result.setText(result.getText() + "9");
        string.append('9');
    }
}