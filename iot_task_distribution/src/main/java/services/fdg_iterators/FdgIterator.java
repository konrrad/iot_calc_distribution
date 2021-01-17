package services.fdg_iterators;

import model.Frame;
import services.fdg_iterators.displacement_writers.DisplacementWriter;
import services.fdg_iterators.displacement_writers.M2MDisplacementWriter;
import services.fdg_iterators.displacement_writers.M2PDisplacementWriter;

import javax.vecmath.Vector2d;

import static java.lang.Math.random;
import static java.lang.Math.round;

public abstract class FdgIterator {
    protected final Frame frame;
    protected final DisplacementWriter m2pDisplacementWriter;
    protected final DisplacementWriter m2mDisplacementWriter;
    private final int iterationsCount;

    public FdgIterator(Frame frame, int iterationsCount) {
        this.frame = frame;
        this.m2pDisplacementWriter = M2PDisplacementWriter.of(frame);
        this.m2mDisplacementWriter = M2MDisplacementWriter.of(frame);
        this.iterationsCount = iterationsCount;
    }

    public FdgIterator(Frame frame) {
        this(frame, 100);
    }

    public void doIterations() {
        initialize();
        for (int iterationNum = 0; iterationNum < iterationsCount; iterationNum++) {
            writeRepDisplacements();
            writeAttrDisplacements();
            updateLocations();
            cool();
            printFrame(iterationNum);
        }
        clearDisplacements();
    }

    private void printFrame(int i) {
        System.out.print("N: " + i + ", T: "+ m2mDisplacementWriter.getTemp() + " | ");
        frame.branch.getAllVertices().forEach(v -> System.out.print("(x: "+ round(v.getLocation().x) + ", y: "+round(v.getLocation().y) + ") "));
        System.out.print("\n");
    }

    private void cool() {
        m2mDisplacementWriter.cool();
        m2pDisplacementWriter.cool();
    }

    private void clearDisplacements() {
        frame.branch.getAllVertices().forEach(v -> v.getDisplacement().set(0, 0));
    }

    protected void initialize() {
        frame.branch.getAllVertices().forEach(v -> v.getLocation().add(new Vector2d(random()* frame.width, random()* frame.height)));
    }

    protected abstract void writeAttrDisplacements();

    protected abstract void writeRepDisplacements();

    protected abstract void updateLocations();

}
