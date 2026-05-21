import java.util.*;

public class Graph {

    private Map<Integer, List<Edge>> adjList;  // Changed to store weighted edges
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
        vertices.putIfAbsent(v.getId(), v);
    }

    public void addEdge(int from, int to) {
        // Default unweighted edge (weight = 1) for backward compatibility
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int weight) {
        Vertex sourceVertex = vertices.get(from);
        Vertex destVertex = vertices.get(to);

        if (sourceVertex != null && destVertex != null) {
            Edge edge = new Edge(sourceVertex, destVertex, weight);
            adjList.get(from).add(edge);
        }
    }

    // For directed graph (optional)
    public void addDirectedEdge(int from, int to, int weight) {
        Vertex sourceVertex = vertices.get(from);
        Vertex destVertex = vertices.get(to);

        if (sourceVertex != null && destVertex != null) {
            Edge edge = new Edge(sourceVertex, destVertex, weight);
            adjList.get(from).add(edge);
        }
    }

    public void printGraph() {
        for (int v : adjList.keySet()) {
            System.out.print(v + " -> ");
            for (Edge edge : adjList.get(v)) {
                System.out.print(edge.getDestination().getId() + "(" + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    // ========== DIJKSTRA'S ALGORITHM IMPLEMENTATION ==========

    /**
     * Implements Dijkstra's algorithm to find shortest paths from start vertex
     * to all other vertices in the graph.
     *
     * Time Complexity: O(V^2) with simple array implementation
     * Space Complexity: O(V)
     *
     * @param start the starting vertex id
     */
    public void dijkstra(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Error: Vertex " + start + " not found in graph!");
            return;
        }

        int n = vertices.size();

        // Arrays for distances and visited nodes
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        int[] previous = new int[n];  // To reconstruct paths

        // Initialize distances
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }
        distances[start] = 0;

        System.out.println("\n========== DIJKSTRA'S ALGORITHM ==========");
        System.out.println("Finding shortest paths from vertex " + start);
        System.out.println("===========================================\n");

        // Main loop - find shortest path to all vertices
        for (int count = 0; count < n - 1; count++) {
            // Find vertex with minimum distance among unvisited vertices
            int u = minDistance(distances, visited);

            if (u == -1) {
                // No reachable vertices left
                break;
            }

            // Mark vertex as visited
            visited[u] = true;

            // Update distances for adjacent vertices
            for (Edge edge : adjList.get(u)) {
                int v = edge.getDestination().getId();
                int weight = edge.getWeight();

                // Update distance if a shorter path is found
                if (!visited[v] && distances[u] != Integer.MAX_VALUE
                        && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    previous[v] = u;
                }
            }

            // Print step-by-step progress
            printStep(count + 1, distances, visited);
        }

        // Print final results
        printShortestPaths(start, distances, previous);
    }

    /**
     * Finds the vertex with minimum distance value from the set of unvisited vertices.
     *
     * @param distances array of distances
     * @param visited array of visited flags
     * @return vertex id with minimum distance, or -1 if none found
     */
    private int minDistance(int[] distances, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] <= minDist) {
                minDist = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Prints a single step of Dijkstra's algorithm.
     */
    private void printStep(int step, int[] distances, boolean[] visited) {
        System.out.println("Step " + step + ":");
        System.out.print("  Distances: [");
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.print("∞");
            } else {
                System.out.print(distances[i]);
            }
            if (i < distances.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.print("  Visited:   [");
        for (int i = 0; i < visited.length; i++) {
            System.out.print(visited[i] ? "✓" : "✗");
            if (i < visited.length - 1) System.out.print(", ");
        }
        System.out.println("]\n");
    }

    /**
     * Prints the final shortest paths and distances.
     */
    private void printShortestPaths(int start, int[] distances, int[] previous) {
        System.out.println("========== FINAL RESULTS ==========");
        System.out.println("Shortest distances from vertex " + start + ":\n");

        for (int i = 0; i < distances.length; i++) {
            if (i == start) {
                System.out.println("  To vertex " + i + " (START): distance = 0");
            } else if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("  To vertex " + i + ": REACHABLE");
            } else {
                System.out.print("  To vertex " + i + ": distance = " + distances[i] + " (path: ");
                printPath(start, i, previous);
                System.out.println(")");
            }
        }
        System.out.println("\n===================================\n");
    }

    /**
     * Prints the path from start to end using previous array.
     */
    private void printPath(int start, int end, int[] previous) {
        if (end == start) {
            System.out.print(start);
            return;
        }
        if (previous[end] == -1) {
            System.out.print("No path");
            return;
        }
        printPath(start, previous[end], previous);
        System.out.print(" -> " + end);
    }

    // ========== EXISTING METHODS (updated to work with Edge class) ==========

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Edge edge : adjList.get(current)) {
                int neighbor = edge.getDestination().getId();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (Edge edge : adjList.get(current)) {
            int neighbor = edge.getDestination().getId();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}