import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 450);

        primaryStage.setTitle("Calculator App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
