package services.fdg_iterators.displacement_writers;

import model.Frame;

public class M2PDisplacementWriter extends DisplacementWriter {

    public M2PDisplacementWriter(double optimalDistance, double temp, double width, double height) {
        super(optimalDistance, temp, width, height);
    }

    public static DisplacementWriter of(Frame frame) {
        return new M2PDisplacementWriter(frame.getOptimalDistance(0.5), frame.temp, frame.width, frame.height);
    }
}
