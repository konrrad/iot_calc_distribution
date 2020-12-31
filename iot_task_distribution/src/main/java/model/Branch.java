package model;

import java.util.List;

public class Branch {
    private final List<Processing> processings;
    private final List<Machine> machines;

    public Branch(List<Processing> processings, List<Machine> machines) {
        this.processings = processings;
        this.machines = machines;
    }

    public List<Processing> getProcessings() {
        return processings;
    }

    public List<Machine> getMachines() {
        return machines;
    }
}
