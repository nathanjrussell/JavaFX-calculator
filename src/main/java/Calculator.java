import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    private final TextField firstNumber = new TextField();
    private final TextField secondNumber = new TextField();
    private final Label result = new Label("Result: ");

    @Override
    public void start(Stage stage) {
        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setStyle("-fx-padding: 15;");

        layout.add(new Label("First number:"), 0, 0, 4, 1);
        layout.add(firstNumber, 0, 1, 4, 1);
        layout.add(new Label("Second number:"), 0, 2, 4, 1);
        layout.add(secondNumber, 0, 3, 4, 1);

        String[] operations = {"+", "-", "*", "/"};
        for (int column = 0; column < operations.length; column++) {
            String operation = operations[column];
            Button button = new Button(operation);
            button.setMinWidth(55);
            button.setOnAction(event -> calculate(operation));
            layout.add(button, column, 4);
        }

        layout.add(result, 0, 5, 4, 1);
        stage.setTitle("JavaFX Calculator");
        stage.setScene(new Scene(layout, 310, 240));
        stage.setResizable(false);
        stage.show();
    }

    private void calculate(String operation) {
        try {
            double first = Double.parseDouble(firstNumber.getText());
            double second = Double.parseDouble(secondNumber.getText());

            if (!Double.isFinite(first) || !Double.isFinite(second)) {
                result.setText("Enter two finite numbers.");
                return;
            }

            if (operation.equals("/") && second == 0) {
                result.setText("Cannot divide by zero.");
                return;
            }

            double answer;
            switch (operation) {
                case "+": answer = first + second; break;
                case "-": answer = first - second; break;
                case "*": answer = first * second; break;
                default: answer = first / second;
            }

            if (Double.isFinite(answer)) {
                result.setText("Result: " + answer);
            } else {
                result.setText("Result is too large.");
            }
        } catch (NumberFormatException exception) {
            result.setText("Enter two valid numbers.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
