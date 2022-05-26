public class Edge {
    private double cost;
    private Vertex destination;

    public Edge(double cost, Vertex destination) {
        this.cost = cost;
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }
}
