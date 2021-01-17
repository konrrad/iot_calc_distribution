import controller.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import services.data_converters.LocalDataConverter;
import services.data_converters.SimulationDataConverter;

import java.io.IOException;

import static services.utils.Utils.readFile;

public class Starter extends Application {

    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader();
            BorderPane layout = fxmlLoader.load(getClass().getResource("./appView.fxml").openStream());

            AppController appController=fxmlLoader.getController();
            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("iot_task_distribution");
            primaryStage.show();

            String inputData = readFile("src/main/resources/data/frame.json");
            String simulationData = new App(
                    new LocalDataConverter(),
                    new SimulationDataConverter(),
                    appController
            ).run(inputData);
            System.out.println(simulationData);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
