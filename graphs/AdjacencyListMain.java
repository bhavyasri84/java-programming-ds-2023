package graphs;


import java.util.*;

//Adjacency List representation of a Graph
class DirectedGraph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private int size;
    private boolean[] visited;


    public DirectedGraph(int size) {
        this.size = size;
        visited = new boolean[size];
    }

    public void addEdge(int source, int des) {
        if (adjList.containsKey(source)) {
            List<Integer> neighbors = adjList.get(source);
            neighbors.add(des);
            adjList.put(source, neighbors);
        } else {
            List<Integer> neighbours = new LinkedList<>();
            neighbours.add(des);
            adjList.put(source, neighbours);
        }
    }

    public void printGraph() {
        System.out.println(adjList);
    }

    public void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            if (adjList.containsKey(vertex)) {
                List<Integer> neighbors = adjList.get(vertex);
                for (Integer neigh : neighbors) {
                    if (visited[neigh] == false) {
                        queue.add(neigh);
                        visited[neigh] = true;
                    }
                }
            }

        }
    }

    public void findInAndOutDegree(){
       for(Map.Entry<Integer,List<Integer>> entry : adjList.entrySet()){
           int vertex = entry.getKey();
            int indegree = findInDegree(vertex);
           System.out.println("vertex : " + entry.getKey() + " outdegree : " + entry.getValue().size() + "  indegree : " + indegree);
       }
    }

    public int findInDegree(int vertex){
        int indegree = 0 ;
        for(Map.Entry<Integer,List<Integer>> entry : adjList.entrySet()){
            List<Integer> edges  = entry.getValue();
            for(int edge : edges){
                if(edge == vertex){
                    indegree ++ ;
                    //System.out.println(indegree);
                }
            }
        };
        return indegree;
    }
}
public class AdjacencyListMain {
    public static void main(String[] args) {

        DirectedGraph directedGraph = new DirectedGraph(7);
        directedGraph.addEdge(1,2);
        directedGraph.addEdge(1,3);
        directedGraph.addEdge(2,4);
        directedGraph.addEdge(3,2);
        directedGraph.addEdge(3,4);
        directedGraph.addEdge(3,5);
        directedGraph.addEdge(4,5);
        directedGraph.addEdge(5,6);
        directedGraph.addEdge(3,6);
        directedGraph.printGraph();
        directedGraph.findInAndOutDegree();


    }
}

