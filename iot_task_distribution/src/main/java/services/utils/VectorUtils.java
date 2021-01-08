package services.utils;

import javax.vecmath.Vector2d;

public class VectorUtils {
    public static void normalize(Vector2d v) {
        if (v.length() == 0) {
            return;
        }
        v.normalize();
    }
}
