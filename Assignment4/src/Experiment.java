public class Experiment {

    public void runTraversals(Graph g, int start) {
        System.out.println("BFS Traversal:");
        long bfsStart = System.nanoTime();
        g.bfs(start);
        long bfsEnd = System.nanoTime();
        System.out.println("BFS Time: " + (bfsEnd - bfsStart) + " ns");
        System.out.println();

        System.out.println("DFS Traversal:");
        long dfsStart = System.nanoTime();
        g.dfs(start);
        long dfsEnd = System.nanoTime();
        System.out.println("DFS Time: " + (dfsEnd - dfsStart) + " ns");
        System.out.println();
    }

    public void runMultipleTests() {
        testGraph(10);
        testGraph(30);
        testGraph(100);

        // Bonus: Test Dijkstra's algorithm with weighted graphs
        testDijkstra();
    }

    private void testGraph(int size) {
        Graph g = new Graph();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
        }

        System.out.println("====================================");
        System.out.println("GRAPH SIZE: " + size);
        System.out.println("====================================");

        if (size == 10) {
            System.out.println("Graph Structure:");
            g.printGraph();
            System.out.println();
        }

        runTraversals(g, 0);
    }

    /**
     * BONUS: Tests Dijkstra's algorithm on various weighted graphs
     */
    private void testDijkstra() {
        System.out.println("\n\n");


        System.out.println("     BONUS: DIJKSTRA'S ALGORITHM      ");



        // Test 1: Simple weighted graph
        testDijkstraSimple();

        // Test 2: Graph with multiple paths
        testDijkstraMultiplePaths();

        // Test 3: Graph with unreachable vertices
        testDijkstraUnreachable();

        // Test 4: Graph with equal weights
        testDijkstraEqualWeights();
    }

    private void testDijkstraSimple() {
        System.out.println("---------- TEST 1: Simple Weighted Graph ----------\n");

        Graph g = new Graph();

        // Create vertices 0-4
        for (int i = 0; i < 5; i++) {
            g.addVertex(new Vertex(i));
        }

        // Add weighted edges
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);
        g.addEdge(2, 4, 10);
        g.addEdge(3, 4, 2);

        System.out.println("Graph Structure (undirected weighted):");
        g.printGraph();

        // Run Dijkstra from vertex 0
        g.dijkstra(0);
    }

    private void testDijkstraMultiplePaths() {
        System.out.println("\n---------- TEST 2: Graph with Multiple Paths ----------\n");

        Graph g = new Graph();

        // Create vertices 0-6
        for (int i = 0; i < 7; i++) {
            g.addVertex(new Vertex(i));
        }

        // Add weighted edges (directed for more interesting paths)
        g.addDirectedEdge(0, 1, 2);
        g.addDirectedEdge(0, 2, 4);
        g.addDirectedEdge(1, 3, 7);
        g.addDirectedEdge(1, 4, 3);
        g.addDirectedEdge(2, 4, 1);
        g.addDirectedEdge(3, 5, 2);
        g.addDirectedEdge(4, 5, 5);
        g.addDirectedEdge(4, 6, 6);
        g.addDirectedEdge(5, 6, 1);

        System.out.println("Graph Structure (directed weighted):");
        g.printGraph();

        // Run Dijkstra from vertex 0
        g.dijkstra(0);
    }

    private void testDijkstraUnreachable() {
        System.out.println("\n---------- TEST 3: Graph with Unreachable Vertices ----------\n");

        Graph g = new Graph();

        // Create vertices 0-5
        for (int i = 0; i < 6; i++) {
            g.addVertex(new Vertex(i));
        }

        // First component (0, 1, 2)
        g.addEdge(0, 1, 3);
        g.addEdge(1, 2, 2);

        // Second component (3, 4, 5) - disconnected from first
        g.addEdge(3, 4, 5);
        g.addEdge(4, 5, 1);

        System.out.println("Graph Structure (disconnected components):");
        g.printGraph();

        // Run Dijkstra from vertex 0 (cannot reach vertices 3,4,5)
        g.dijkstra(0);
    }

    private void testDijkstraEqualWeights() {
        System.out.println("\n---------- TEST 4: Graph with Equal Weights ----------\n");

        Graph g = new Graph();

        // Create vertices 0-4
        for (int i = 0; i < 5; i++) {
            g.addVertex(new Vertex(i));
        }

        // Add edges with equal weights (like unweighted graph)
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 4, 1);

        System.out.println("Graph Structure (all weights = 1):");
        g.printGraph();

        // Run Dijkstra from vertex 0
        g.dijkstra(0);
    }

    public void printResults() {
        System.out.println("Experiments completed.");
    }
}