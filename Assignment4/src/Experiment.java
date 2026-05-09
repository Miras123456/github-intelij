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

    public void printResults() {

        System.out.println("Experiments completed.");
    }
}