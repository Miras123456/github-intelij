# Assignment 4: Graph Traversal and Representation System


---
## IT-2502 Rinatuly Miras

---

# Experiment Class

Used for:
- Running tests
- Measuring execution time
- Comparing BFS and DFS
---
# BFS Algorithm

```Breadth-First Search explores vertices level by level.```

Steps:
1. Start from a vertex
2. Add it to queue
3. Visit neighbors
4. Repeat until queue is empty
## Data Structure
- Queue
# Time Complexity
`O(V + E)`
Where:

- V = number of vertices
- E = number of edges
 
## Use Cases
- Shortest path
- Navigation systems
- Social networks
---
# DFS Algorithm

``Depth-First Search explores vertices deeply before backtracking.``

Steps:
1. Start from a vertex
2. Visit neighbor
3. Continue recursively
4. Backtrack when necessary
## Data Structure
- Recursion stack
## Time Complexity
`O(V + E)`
## Use Cases
- Path finding
- Cycle detection
- Maze solving
---
# Experimental Results
1. ![img.png](img.png)
2. ![img_1.png](img_1.png)
3.  ![img_2.png](img_2.png)

---

# Analysis Questions
1. How does graph size affect BFS and DFS performance?

Larger graphs require more processing time because more vertices and edges are visited.

2. Which traversal is faster?

Both algorithms showed similar performance.
DFS was slightly faster in some tests.

3. Do results match O(V + E)?

Yes.
Traversal time increased as the number of vertices and edges increased.

4. How does graph structure affect traversal order?

Different edge connections change the order in which vertices are visited.

5. When is BFS preferred over DFS?

BFS is preferred when the shortest path is needed.

6. What are the limitations of DFS?

DFS does not guarantee the shortest path and may cause deep recursion.

---
## BFS vs DFS
|  BFS                     | DFS                              |
|--------------------------| -------------------------------- |
| Uses Queue               | Uses Recursion/Stack             |
| Level-by-level traversal | Depth traversal                  |
| Finds shortest path      | Does not guarantee shortest path |
| More memory usage        | Less memory in some cases        |


## Reflection

- This assignment improved understanding of graph structures and traversal algorithms.
- BFS and DFS use different traversal strategies, but both are important for graph processing.
- The most challenging part was implementing traversal correctly using visited vertices.