package services.fdg_iterators;

import model.Branch;
import services.fdg_iterators.displacement_writers.DisplacementWriter;
import services.fdg_iterators.displacement_writers.M2MDisplacementWriter;
import services.fdg_iterators.displacement_writers.M2PDisplacementWriter;

public abstract class FdgIterator {
    protected Branch branch;
    protected final DisplacementWriter m2pDisplacementWriter;
    protected final DisplacementWriter m2mDisplacementWriter;
    private final int iterationsCount;

    public FdgIterator(DisplacementWriter m2pDisplacementWriter, DisplacementWriter m2mDisplacementWriter, int iterationsCount) {
        this.m2pDisplacementWriter = m2pDisplacementWriter;
        this.m2mDisplacementWriter = m2mDisplacementWriter;
        this.iterationsCount = iterationsCount;
    }

    public FdgIterator() {
        this(new M2PDisplacementWriter(), new M2MDisplacementWriter(), 100);
    }

    public void doIterations() {
        for (int iterationNum = 0; iterationNum < iterationsCount; iterationNum++) {
            writeRepDisplacements();
            writeAttrDisplacements();
            updateLocations();
        }
    }


    protected abstract void writeAttrDisplacements();

    protected abstract void writeRepDisplacements();

    protected abstract void updateLocations();

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
