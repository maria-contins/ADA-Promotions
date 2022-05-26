package graphs;

public class EdgeClass implements Edge {

    private final int first;
    private final int second;
    private final int label;

    public EdgeClass(int first, int second, int label) {
        this.first = first;
        this.second = second;
        this.label = label;   // label is cost
    }

    @Override
    public int label() {
        return label;
    }

    @Override
    public int firstNode() {
        return first;
    }

    @Override
    public int secondNode() {
        return second;
    }

    @Override
    public int oppositeNode(int node) {
        if (node == first) return second;
        return first;
    }
}
