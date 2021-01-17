package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import model.Machine;
import model.Process;

import javax.vecmath.Vector2d;
import java.util.List;

public class AppController {
    @FXML
    public ScatterChart<Double, Double> chart;
    private final XYChart.Series<Double, Double> machinesSeries = new XYChart.Series<>();
    private final XYChart.Series<Double, Double> processesSeries = new XYChart.Series<>();

    public void initialize(){
        chart.getData().addAll(List.of(machinesSeries, processesSeries));
        machinesSeries.setName("Machines");
        processesSeries.setName("Processes");
    }

    // @TODO it should be probably used in iterator loop (it should guarantee visualization)
    public void updateChart(List<Machine> machines, List<Process> processes){
        machinesSeries.getData().clear();
        processesSeries.getData().clear();

        machines.forEach(machine -> {
            Vector2d location = machine.getLocation();
            machinesSeries.getData().add(new XYChart.Data<>(location.x, location.y));
        });

        processes.forEach(process -> {
            Vector2d location = process.getLocation();
            processesSeries.getData().add(new XYChart.Data<>(location.x, location.y));
        });
    }
}
