import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 450);

        primaryStage.setTitle("Calculator App");
        primaryStage.setScene(scene);

        TextField display = new TextField();
        display.setEditable(false);
        display.setPrefHeight(100);
        display.setStyle("-fx-font-size: 18px; -fx-alignment: center-right;");
        display.setMinWidth(300);

        GridPane buttonGrid = new GridPane();
        VBox.setVgrow(buttonGrid, Priority.ALWAYS);

        Button oneButton = new Button("1");
        Button twoButton = new Button("2");
        Button threeButton = new Button("3");
        Button fourButton = new Button("4");
        Button fiveButton = new Button("5");
        Button sixButton = new Button("6");
        Button sevenButton = new Button("7");
        Button eightButton = new Button("8");
        Button nineButton = new Button("9");
        Button zeroButton = new Button("0");
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        Button equalsButton = new Button("=");
        Button clearButton = new Button("C");

        buttonGrid.addColumn(0, oneButton, fourButton, sevenButton, clearButton);
        buttonGrid.addColumn(1, twoButton, fiveButton, eightButton, zeroButton);
        buttonGrid.addColumn(2, threeButton, sixButton, nineButton, equalsButton);
        buttonGrid.addColumn(3, addButton, subtractButton, multiplyButton, divideButton);

        for (Button button : new Button[] { oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton,
                sevenButton, eightButton, nineButton, zeroButton, addButton, subtractButton, multiplyButton,
                divideButton, equalsButton, clearButton }) {
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setStyle("-fx-font-size: 18px;");
        }

        for (int i = 0; i < 4; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);
            buttonGrid.getColumnConstraints().add(col);
        }

        for (int i = 0; i < 4; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            buttonGrid.getRowConstraints().add(row);
        }

        root.getChildren().addAll(display, buttonGrid);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
