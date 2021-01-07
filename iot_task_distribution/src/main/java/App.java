import model.Frame;
import services.data_converters.DataConverter;
import services.fdg_iterators.FdgIterator;
import services.fdg_iterators.SimpleFdgIterator;

public class App {
    private final DataConverter localDataConverter;
    private final DataConverter simulationDataConverter;

    public App(DataConverter localDataConverter, DataConverter simulationDataConverter) {
        this.localDataConverter = localDataConverter;
        this.simulationDataConverter = simulationDataConverter;
    }

    String run(String inputData) {
        Frame parsedData = localDataConverter.jsonToModel(inputData);
        FdgIterator fdgIterator = new SimpleFdgIterator(parsedData);
        fdgIterator.doIterations();
        return localDataConverter.modelToJson(parsedData);
    }
}
