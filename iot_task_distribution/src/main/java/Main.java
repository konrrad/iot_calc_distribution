import services.data_converters.LocalDataConverter;
import services.data_converters.SimulationDataConverter;
import services.fdg_iterators.SimpleFdgIterator;

import java.util.List;

import static services.utils.Utils.readFile;

public class Main {
    public static void main(String[] args) {
        String inputData = readFile(args[0]);
        String simulationData = new App(
                new SimpleFdgIterator(),
                new LocalDataConverter(),
                new SimulationDataConverter()
        ).run(inputData);
        System.out.println(simulationData);
    }
}
