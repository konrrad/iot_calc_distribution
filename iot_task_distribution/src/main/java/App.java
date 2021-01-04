import model.Branch;
import services.data_converters.DataConverter;
import services.fdg_iterators.FdgIterator;

public class App {
    private final FdgIterator fdgIterator;
    private final DataConverter localDataConverter;
    private final DataConverter simulationDataConverter;

    public App(FdgIterator fdgIterator, DataConverter localDataConverter, DataConverter simulationDataConverter) {
        this.fdgIterator = fdgIterator;
        this.localDataConverter = localDataConverter;
        this.simulationDataConverter = simulationDataConverter;
    }

    String run(String inputData) {
        Branch parsedData = localDataConverter.jsonToModel(inputData);
        fdgIterator.setBranch(parsedData);
        fdgIterator.doIterations();
        return localDataConverter.modelToJson(parsedData);
    }
}
