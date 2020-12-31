package services.fdg_iterators;

import model.Branch;
import services.fdg_iterators.displacement_writers.DisplacementWriter;
import services.fdg_iterators.displacement_writers.M2MDisplacementWriter;
import services.fdg_iterators.displacement_writers.M2PDisplacementWriter;

import java.util.List;

public abstract class FdgIterator {
    private final List<Branch> branches;
    private final DisplacementWriter m2pDisplacementWriter;
    private final DisplacementWriter m2mDisplacementWriter;
    private final int iterationsCount;

    public FdgIterator(List<Branch> branches, DisplacementWriter m2pDisplacementWriter, DisplacementWriter m2mDisplacementWriter, int iterationsCount) {
        this.branches = branches;
        this.m2pDisplacementWriter = m2pDisplacementWriter;
        this.m2mDisplacementWriter = m2mDisplacementWriter;
        this.iterationsCount = iterationsCount;
    }

    public FdgIterator(List<Branch> branches) {
        this(branches, new M2PDisplacementWriter(), new M2MDisplacementWriter(), 100);
    }

    public void doIterations() {
        for (int iterationNum = 0; iterationNum < iterationsCount; iterationNum++) {
            writeAttrDisplacements();
            writeRepDisplacements();
            updateLocations();
        }
    }

    protected abstract void writeAttrDisplacements();
    protected abstract void writeRepDisplacements();
    protected abstract void updateLocations();

    public List<Branch> getBranches() {
        return branches;
    }
}
