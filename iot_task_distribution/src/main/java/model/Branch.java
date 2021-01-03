package model;

import java.util.List;

public class Branch {
    private final Processing processing;
    private final List<Machine> machines;

    public Branch(Processing processing, List<Machine> machines) {
        this.processing = processing;
        this.machines = machines;
    }

    public Processing getProcessings() {
        return processing;
    }

    public List<Machine> getMachines() {
        return machines;
    }
}
