package services.utils;

import model.Machine;
import model.Process;

import java.util.List;

public interface Visualizer {
    void update(List<Machine> machines, List<Process> processes);
}
