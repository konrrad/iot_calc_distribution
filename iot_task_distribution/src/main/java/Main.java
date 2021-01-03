import services.data_converters.LocalDataConverter;
import services.data_converters.SimulationDataConverter;
import services.fdg_iterators.SimpleFdgIterator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputData = "{}";
        String simulationData = new App(
                new SimpleFdgIterator(null),
                new LocalDataConverter(),
                new SimulationDataConverter()
        ).run(inputData);
        System.out.println(simulationData);
    }
}
