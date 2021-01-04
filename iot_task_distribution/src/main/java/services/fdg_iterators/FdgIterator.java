package services.fdg_iterators;

import model.Branch;
import services.fdg_iterators.displacement_writers.DisplacementWriter;
import services.fdg_iterators.displacement_writers.M2MDisplacementWriter;
import services.fdg_iterators.displacement_writers.M2PDisplacementWriter;

import static java.lang.Math.*;

public abstract class FdgIterator {
    protected final Branch branch;
    protected final DisplacementWriter m2pDisplacementWriter;
    protected final DisplacementWriter m2mDisplacementWriter;
    private final int iterationsCount;

    public FdgIterator(Branch branch, int iterationsCount) {
        double optimalDistanceM2M = sqrt(100.0 / branch.verticesCount());
        double optimalDistanceM2P = sqrt(100.0 / pow(branch.verticesCount(), 3));
        this.branch = branch;
        this.m2pDisplacementWriter = new M2PDisplacementWriter(optimalDistanceM2P);
        this.m2mDisplacementWriter = new M2MDisplacementWriter(optimalDistanceM2M);
        this.iterationsCount = iterationsCount;
    }

    public FdgIterator(Branch branch) {
        this(branch, 100);
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

}
