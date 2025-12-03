package Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalculatorFrame extends JFrame {
    private JPanel contentPane;
    private JTextField display;
    private JPanel buttonPanel;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton equalsButton, clearButton;

    private double firstNumber = 0;
    private String operator = "";

    public CalculatorFrame() {
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setContentPane(contentPane);


        btn0.addActionListener(e -> append("0"));
        btn1.addActionListener(e -> append("1"));
        btn2.addActionListener(e -> append("2"));
        btn3.addActionListener(e -> append("3"));
        btn4.addActionListener(e -> append("4"));
        btn5.addActionListener(e -> append("5"));
        btn6.addActionListener(e -> append("6"));
        btn7.addActionListener(e -> append("7"));
        btn8.addActionListener(e -> append("8"));
        btn9.addActionListener(e -> append("9"));


        addButton.addActionListener(e -> setOperator("+"));
        subButton.addActionListener(e -> setOperator("-"));
        mulButton.addActionListener(e -> setOperator("*"));
        divButton.addActionListener(e -> setOperator("/"));


        equalsButton.addActionListener(this::calculate);
        clearButton.addActionListener(e -> display.setText(""));
    }

    private void append(String digit) {
        display.setText(display.getText() + digit);
    }

    private void setOperator(String op) {
        firstNumber = getNumber();
        operator = op;
        display.setText("");
    }

    private void calculate(ActionEvent e) {
        double secondNumber = getNumber();
        double result = 0;

        switch (operator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "*": result = firstNumber * secondNumber; break;
            case "/":
                if (secondNumber == 0) {
                    display.setText("Error");
                    return;
                }
                result = firstNumber / secondNumber;
                break;
        }
        display.setText(String.valueOf(result));
    }

    private double getNumber() {
        try {
            return Double.parseDouble(display.getText());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorFrame().setVisible(true));
    }
}
