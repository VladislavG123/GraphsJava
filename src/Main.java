import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Arrange
        var vA = new Vertex("A");
        var vB = new Vertex("B");
        var vC = new Vertex("C");
        var vD = new Vertex("D");
        var vE = new Vertex("E");
        var vF = new Vertex("F");

        vA.addEdge(new Edge(0.5, vB));
        vA.addEdge(new Edge(1, vC));

        vB.addEdge(new Edge(0.5, vA));
        vB.addEdge(new Edge(4, vE));

        vC.addEdge(new Edge(1, vA));
        vC.addEdge(new Edge(1, vD));
        vC.addEdge(new Edge(4, vE));

        vD.addEdge(new Edge(1, vC));
        vD.addEdge(new Edge(1, vF));

        vE.addEdge(new Edge(4, vC));
        vE.addEdge(new Edge(1, vF));
        vE.addEdge(new Edge(4, vB));

        vF.addEdge(new Edge(1, vD));
        vF.addEdge(new Edge(1, vE));

        var list = new LinkedList<Vertex>();
        list.add(vA);
        list.add(vB);
        list.add(vC);
        list.add(vD);
        list.add(vE);
        list.add(vF);

        var graph = new Graph(list);

        // Act
        var visited = new ArrayList<DijkstrasDto>();
        visited.add(new DijkstrasDto("A", 0, null));

        var result = graph.DijkstraSearch("A", "E", 0, visited);

        var founded = result.stream().filter(x -> x.getNodeName().equals("E")).findFirst().orElse(null);
        if (founded == null) throw new NullPointerException();

        // Assert
        System.out.println("Distance: " + founded.getDistance());

        var way = new ArrayList<String>();
        while (founded != null) {
            way.add(founded.getNodeName());

            var nodeName = founded.getLastNodeName();
            founded = result.stream().filter(x -> x.getNodeName().equals(nodeName)).findFirst().orElse(null);
        }

        System.out.println("\nWay: ");
        for (int i = way.size() - 1; i >= 0 ; i--) {
            System.out.print(way.get(i) + " ");
        }

        System.out.println("\n\nTable: ");
        for (var item: result) {
            System.out.println(item.toString());
        }
    }
}