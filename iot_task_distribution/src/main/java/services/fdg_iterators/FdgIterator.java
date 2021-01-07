package services.fdg_iterators;

import model.Frame;
import services.fdg_iterators.displacement_writers.DisplacementWriter;
import services.fdg_iterators.displacement_writers.M2MDisplacementWriter;
import services.fdg_iterators.displacement_writers.M2PDisplacementWriter;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public abstract class FdgIterator {
    protected final Frame frame;
    protected final DisplacementWriter m2pDisplacementWriter;
    protected final DisplacementWriter m2mDisplacementWriter;
    private final int iterationsCount;

    public FdgIterator(Frame frame, int iterationsCount) {
        double optimalDistanceM2M = sqrt(100.0 / frame.branch.verticesCount());
        double optimalDistanceM2P = sqrt(100.0 / pow(frame.branch.verticesCount(), 3));
        this.frame = frame;
        this.m2pDisplacementWriter = new M2PDisplacementWriter(optimalDistanceM2P);
        this.m2mDisplacementWriter = new M2MDisplacementWriter(optimalDistanceM2M);
        this.iterationsCount = iterationsCount;
    }

    public FdgIterator(Frame frame) {
        this(frame, 100);
    }

    public void doIterations() {
        for (int iterationNum = 0; iterationNum < iterationsCount; iterationNum++) {
            writeRepDisplacements();
            writeAttrDisplacements();
            updateLocations();
        }
        clearDisplacements();
    }

    private void clearDisplacements() {
        frame.branch.getAllVertices().forEach(v -> {
            v.getDisplacement().setX(0);
            v.getDisplacement().setY(0);
        });
    }


    protected abstract void writeAttrDisplacements();

    protected abstract void writeRepDisplacements();

    protected abstract void updateLocations();

}
