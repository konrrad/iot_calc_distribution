package model;

import java.util.List;

public class Branch {
    private Processing processing;
    private List<Machine> machines;

    public Processing getProcessings() {
        return processing;
    }

    public List<Machine> getMachines() {
        return machines;
    }
}
