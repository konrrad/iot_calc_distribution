package services.fdg_iterators;

import model.Frame;
import services.utils.Visualizer;

import java.util.ArrayList;

public class SimpleFdgIteratorWithVisualization extends SimpleFdgIterator {
    protected final int splittingInterval;
    private final Visualizer visualizer;

    public SimpleFdgIteratorWithVisualization(Frame frame, Visualizer visualizer) {
        super(frame);
        this.splittingInterval = iterationsCount / 5;
        this.visualizer = visualizer;
    }

    @Override
    protected void doOneIteration(int iterationNum) {
        super.doOneIteration(iterationNum);
        visualizer.update(new ArrayList<>(this.frame.branch.getMachines()),new ArrayList<>(this.frame.branch.getProcessing().getProcesses()));
    }
}
