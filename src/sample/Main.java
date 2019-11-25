package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {

    // creating 3 states and a switch loop

    private static int state = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane trafficPane = new Pane();
        trafficPane.setPrefSize(250, 600);

        Label trafficLabel = new Label("Traffic Light");
        trafficLabel.relocate(110, 0);
        trafficLabel.resize(10, 10);
        trafficLabel.setTextFill(Color.RED);

        trafficPane.getChildren().add(trafficLabel);

        Group trafficBox = new Group();

        Rectangle trafficLights = new Rectangle(120, 360);
        trafficLights.relocate(90, 30);
        trafficLights.setFill(Color.BLACK);


        // make 3 circles
        Circle redLight = new Circle();
        redLight.setRadius(50);
        redLight.setFill(Color.GRAY);
        redLight.relocate(100, 40);

        Circle yellowLight = new Circle();
        yellowLight.setRadius(50);
        yellowLight.setFill(Color.GRAY);
        yellowLight.relocate(100, 160);

        Circle greenLight = new Circle();
        greenLight.setRadius(50);
        greenLight.setFill(Color.GRAY);
        greenLight.relocate(100, 280);


        trafficBox.getChildren().addAll(redLight, yellowLight, greenLight, trafficLights);
        redLight.toFront(); yellowLight.toFront(); greenLight.toFront();
        trafficPane.getChildren().add(trafficBox);

        String[] prompts = {"Next", "Back"};
        Button nextButton = new Button(prompts[0]);
        Button backButton = new Button(prompts[1]);

        nextButton.relocate(75, 400);
        backButton.relocate(200, 400);
        trafficPane.getChildren().addAll(nextButton, backButton);

        nextButton.setOnMouseClicked (event -> {
            state++;
            if (state > 2) {
                state = 0;
            }
            switch(state) {
                case 0:
                    redLight.setFill(Color.RED);
                    yellowLight.setFill(Color.GRAY);
                    greenLight.setFill(Color.GRAY);
                    break;
                case 1:
                    yellowLight.setFill(Color.YELLOW);
                    greenLight.setFill(Color.GRAY);
                    redLight.setFill(Color.GRAY);
                    break;
                case 2:
                    greenLight.setFill(Color.GREEN);
                    yellowLight.setFill(Color.GRAY);
                    redLight.setFill(Color.GRAY);
                    break;
            }
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(trafficPane, 300, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

// vm opções: --module-path /Users/g00396/Downloads/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml