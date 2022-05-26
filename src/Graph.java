import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Vertex> vertices;

    public Graph(LinkedList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<DijkstrasDto> DijkstraSearch(String start, String finish,
                                                        double currentDistance,
                                                        ArrayList<DijkstrasDto> visited) {
        var vertex = vertices.stream()
                .filter(x -> x.getName()
                .equals(start)).findFirst().orElse(null);

        if (vertex == null) throw new IllegalArgumentException();

        for (var edge: vertex.getEdges()) {
            double distance = edge.getCost() + currentDistance;
            var dijkstrasDto = new DijkstrasDto(edge.getDestination().getName(), distance, vertex.getName());

            if (edge.getDestination().getName().equals(finish)) {
                var latest = visited.stream()
                        .filter(x -> x.getNodeName().equals(finish) && x.getDistance() < distance)
                        .findFirst().orElse(dijkstrasDto);

                visited.removeIf(x -> x.getNodeName().equals(finish));
                visited.add(latest);

                continue;
            }

            if (visited.stream().anyMatch(x -> x.getNodeName().equals(edge.getDestination().getName()))) {
                continue;
            }

            visited.add(dijkstrasDto);

            visited = DijkstraSearch(edge.getDestination().getName(), finish, distance, visited);
        }

        return visited;
    }
}
