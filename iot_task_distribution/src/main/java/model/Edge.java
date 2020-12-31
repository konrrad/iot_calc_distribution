package model;

public class Edge {
    private final Vertex from;
    private final Vertex to;
    private final boolean directed;

    public Edge(Vertex from, Vertex to, boolean directed) {
        this.from = from;
        this.to = to;
        this.directed = directed;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public boolean isDirected() {
        return directed;
    }
}
