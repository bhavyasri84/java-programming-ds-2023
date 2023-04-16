package graphs;


class Graph1{

    private int size;
    private int [][]adjMatrix ;
    public Graph1(int size){
        this.size = size;
        adjMatrix = new int[size][size];

    }

    public void addEdge(int source,int destination){
        adjMatrix[source][destination] = 1;

    }

    public void printadjMatrix(){
        for(int[] row : adjMatrix){
            for(int vertex : row){
                System.out.print(vertex+" ");
            }
            System.out.println();
        }
    }
}
public class AdjacencyMatrixMain {
    public static void main(String[] args) {
        Graph1 graph1 = new Graph1(4);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(1,2);
        graph1.addEdge(2,3);
        graph1.printadjMatrix();

    }
}
