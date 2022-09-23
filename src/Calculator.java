import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator implements EventHandler<ActionEvent> {
    GridPane grid;
    TextField textField;
    Button one, two, three, four, five, six, seven, eight, nine, equal, mul, div, add, sub, clear;
    double num1, num2, result;
    String operation;

    Calculator() {
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        textField = new TextField();
        textField.setEditable(false);

        one = new Button("1");
        two = new Button("2");
        three = new Button("3");
        four = new Button("4");
        five = new Button("5");
        six = new Button("6");
        seven = new Button("7");
        eight = new Button("8");
        nine = new Button("9");
        equal = new Button("=");
        clear = new Button("Clear");
        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        one.setOnAction(this);
        two.setOnAction(this);
        three.setOnAction(this);
        four.setOnAction(this);
        five.setOnAction(this);
        six.setOnAction(this);
        seven.setOnAction(this);
        eight.setOnAction(this);
        nine.setOnAction(this);
        equal.setOnAction(this);
        add.setOnAction(this);
        sub.setOnAction(this);
        mul.setOnAction(this);
        div.setOnAction(this);
        clear.setOnAction(this);
    }

    public void display(Stage s) {

        grid.add(one, 0, 0);
        grid.add(two, 1, 0);
        grid.add(three, 2, 0);
        grid.add(clear, 4, 0);
        grid.add(four, 0, 1);
        grid.add(five, 1, 1);
        grid.add(six, 2, 1);

        grid.add(seven, 0, 2);
        grid.add(eight, 1, 2);
        grid.add(nine, 2, 2);

        grid.add(add, 4, 1);
        grid.add(sub, 4, 2);
        grid.add(div, 4, 3);
        grid.add(mul, 4, 4);
        grid.add(equal, 4, 5);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(textField, grid);

        Scene scene = new Scene(vBox);
        s.setScene(scene);
        s.setTitle("Calculator");
        s.setHeight(400);
        s.setWidth(200);
        s.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == one) {
            textField.appendText("1");
        }
        if (actionEvent.getSource() == two) {
            textField.appendText("2");
        }
        if (actionEvent.getSource() == three) {
            textField.appendText("3");
        }
        if (actionEvent.getSource() == four) {
            textField.appendText("4");
        }
        if (actionEvent.getSource() == five) {
            textField.appendText("5");
        }
        if (actionEvent.getSource() == six) {
            textField.appendText("6");
        }
        if (actionEvent.getSource() == seven) {
            textField.appendText("7");
        }
        if (actionEvent.getSource() == eight) {
            textField.appendText("8");
        }
        if (actionEvent.getSource() == nine) {
            textField.appendText("9");
        }
        if (actionEvent.getSource() == add) {
            num1 = Double.parseDouble(textField.getText());
            operation = "add";
            textField.clear();
        }
        if (actionEvent.getSource() == sub) {
            num1 = Double.parseDouble(textField.getText());
            operation = "sub";
            textField.clear();
        }
        if (actionEvent.getSource() == mul) {
            num1 = Double.parseDouble(textField.getText());
            operation = "mul";
            textField.clear();
        }
        if (actionEvent.getSource() == div) {
            num1 = Double.parseDouble(textField.getText());
            operation = "div";
            textField.clear();
        }
        if (actionEvent.getSource() == clear) {
            textField.clear();
            result = 0;
        }
        if (actionEvent.getSource() == equal) {
            num2 = Double.parseDouble(textField.getText());
            if ((num1 >= 0) && (num2 >= 0) && operation != null) {
                switch (operation) {
                    case "add" -> {
                        result = num1 + num2;
                        textField.setText(result + "");
                    }
                    case "sub" -> {
                        result = num1 - num2;
                        textField.setText(result + "");
                    }
                    case "mul" -> {
                        result = num1 * num2;
                        textField.setText(result + "");
                    }
                    case "div" -> {
                        result = num1 / num2;
                        textField.setText(result + "");
                    }
                }
            }
        }
    }
}
