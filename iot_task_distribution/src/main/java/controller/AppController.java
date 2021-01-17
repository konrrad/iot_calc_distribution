package controller;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import model.Machine;
import model.Process;
import services.utils.Visualizer;

import javax.vecmath.Vector2d;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AppController implements Visualizer {
    @FXML
    public ScatterChart<Double, Double> chart;
    private final XYChart.Series<Double, Double> machinesSeries = new XYChart.Series<>();
    private final XYChart.Series<Double, Double> processesSeries = new XYChart.Series<>();
    private long previous=0;

    public void initialize(){
        chart.getData().addAll(List.of(machinesSeries, processesSeries));
        machinesSeries.setName("Machines");
        processesSeries.setName("Processes");
    }

    // @TODO it should be probably used in iterator loop (it should guarantee visualization)
    public void update(List<Machine> machines, List<Process> processes){
        AnimationTimer animationTimer=new AnimationTimer() {

            @Override
            public void handle(long l) {
                if(l-previous>=1000000000L)
                {
                    processes.forEach(process -> System.out.println(process.getLocation()));
                    updateChart(machines,processes);
                    previous=l;
                }
            }
        };
        animationTimer.start();

    }

    private void updateChart(List<Machine> machines, List<Process> processes)
    {
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
