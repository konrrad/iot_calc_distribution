package controller;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import model.Frame;
import model.Machine;
import model.Process;
import services.data_converters.DataConverter;
import services.data_converters.LocalDataConverter;
import services.fdg_iterators.SimpleFdgIteratorWithVisualization;

import javax.vecmath.Vector2d;
import java.util.List;

public class AppController {
    private final XYChart.Series<Double, Double> machinesSeries = new XYChart.Series<>();
    private final XYChart.Series<Double, Double> processesSeries = new XYChart.Series<>();
    private final DataConverter localDataConverter = new LocalDataConverter();
    @FXML
    public ScatterChart<Double, Double> chart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    private SimpleFdgIteratorWithVisualization fdgIterator;

    private String inputData = "";

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public void initialize() {
        chart.getData().addAll(List.of(machinesSeries, processesSeries));
        machinesSeries.setName("Machines");
        processesSeries.setName("Processes");

    }

    public void runFDGIterations() {
        Frame parsedData = localDataConverter.jsonToModel(inputData);
        xAxis.setUpperBound(parsedData.width*2);
        xAxis.setLowerBound(parsedData.width*(-1));
        yAxis.setUpperBound(parsedData.height*2);
        yAxis.setLowerBound(parsedData.height*(-1));
        System.out.println(inputData);
        fdgIterator = new SimpleFdgIteratorWithVisualization(parsedData);
        fdgIterator.initialize();
        iterate();
    }

    private void iterate() {
        AnimationTimer animationTimer = new FDGTimer(fdgIterator,100);
        animationTimer.start();
    }

    private void updateChart(List<Machine> machines, List<Process> processes) {
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

    private class FDGTimer extends AnimationTimer {
        private final SimpleFdgIteratorWithVisualization simpleFDGIterator;
        private final int iterationsNum;
        private int iterationCounter = 0;
        private long previousTime = 0;
        private final long interval=500000000L;

        public FDGTimer(SimpleFdgIteratorWithVisualization simpleFdgIteratorWithVisualization, int iterationsNum) {
            this.simpleFDGIterator = simpleFdgIteratorWithVisualization;
            this.iterationsNum = iterationsNum;
        }

        @Override
        public void handle(long l) {
            if (l - this.previousTime >= interval) {
                if (this.iterationsNum <= this.iterationCounter)
                    this.stop();
                this.simpleFDGIterator.doOneIteration(iterationCounter);
                this.iterationCounter++;
                updateChart(this.simpleFDGIterator.getFrame().branch.getMachines(), this.simpleFDGIterator.getFrame().branch.getProcessing().getProcesses());
                this.previousTime = l;
            }
        }
    }

}
