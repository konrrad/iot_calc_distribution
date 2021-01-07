package model;

public class Frame {
    public final double width;
    public final double height;
    public final double temp;
    public final Branch branch;

    public Frame(int width, int height, double temp, Branch branch) {
        this.width = width;
        this.height = height;
        this.temp = temp;
        this.branch = branch;
    }
}
