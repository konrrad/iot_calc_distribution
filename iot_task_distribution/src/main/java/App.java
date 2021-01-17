import model.Frame;
import services.data_converters.DataConverter;
import services.fdg_iterators.FdgIterator;
import services.fdg_iterators.SimpleFdgIteratorWithVisualization;
import services.utils.Visualizer;

public class App {
    private final DataConverter localDataConverter;
    private final DataConverter simulationDataConverter;
    private final Visualizer visualizer;

    public App(DataConverter localDataConverter, DataConverter simulationDataConverter, Visualizer visualizer) {
        this.localDataConverter = localDataConverter;
        this.simulationDataConverter = simulationDataConverter;
        this.visualizer=visualizer;
    }

    public String run(String inputData) {
        Frame parsedData = localDataConverter.jsonToModel(inputData);
        FdgIterator fdgIterator = new SimpleFdgIteratorWithVisualization(parsedData,visualizer);
        fdgIterator.doIterations();
        return localDataConverter.modelToJson(parsedData);
    }
}
