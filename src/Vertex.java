import java.util.LinkedList;

public class Vertex {
    private String name;
    private LinkedList<Edge> edges;

    public Vertex(String name, LinkedList<Edge> edges) {
        this.name = name;
        this.edges = edges;
    }

    public Vertex(String name) {
        this.name = name;
        this.edges = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
