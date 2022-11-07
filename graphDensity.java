import java.util.Vector;

// Brief explanation of what graph density is 
//graph density represents the ratio between the edges present in a graph and the maximum number of
//edges the graph can have
// graph density provides an idea of how dense a graph is in terms of edge connectivity
// it is useful when we have a vast network and want to add new edges to the network
// graph density formular for a simple undirected graph is DEN(UNDIRECTED) = |E| 
                                                                      // -------------
                                                                        //   (|V|*|V|-1)
                                                                        // --------------
                                                                        //        2

//graph density formular for a  directed graph is DEN(UNDIRECTED) =  |E| 
                                                             // -------------
                                                            //   (|V|*|V|-1)
                                                            
// in this code we will find the density for a simple undirected graph
public class graphDensity {
	// first create the graph using adjacency list using vector class of java
	static int V ;
	
	@SuppressWarnings("unchecked")
	static Vector<Integer> [] adjList = new Vector[V];
	@SuppressWarnings({ "unchecked", "static-access" })
	public graphDensity(int V) {
		this.V = V;
		this.adjList = new Vector[V];
     for (int i = 0; i < V; i++) //an iteration to
     adjList[i] = new Vector<Integer>(); // create a vector for every vertex
	}
	// for undirected graph edges are added in both directions from i to j and from j to i 
	public static void addEdge(int i, int j){
		if(i < 0 || i >= V) {
			System.out.println("vertex " + i + " does not exist in this graph");
		}  if(j < 0 || j >= V) {
			System.out.println("vertex " + j + " does not exist in this graph");
		} else 
        adjList[i].add(j); // adding j in i's vector list
        adjList[j].add(i);  // adding i in j's vector list
    }
//the time complexity is O(V) because we have to traverse through every adjacenncy list of every vertex
	public static float countEdges(){
		// we first find the number of edges present in our graph
        int sum = 0;
        int totalsum = 0 ;
        // traverse all vertices
        for (int i = 0; i < V; i++)
            // add all edge that are linked to the current vertex
            sum = sum + adjList[i].size();
      //we divide sum by two because in undirected graph, each edge is counted twice
            totalsum = totalsum + sum / 2;
             return totalsum;
	} 
	// we find the number of maximum possible edges the graph can have 
	public static int maximumNumberOfEdges() {
// the maximum number of edges a undirected  graph can have is the number of vertices it has V
// times (V-1) = (V * V-1)  because for maximum edges to be found, every vertex V is connected
// to the other (V-1) vertices in the graph hence (V * V-1). then this value has to be divided by 2 
// because in undirected graph, edges are counted twice hence the formular = ((V) * (V-1)) / 2; 
		int maxii = ((V) * (V-1)) / 2;
		int MaximumEdges = 0; // storing the maximum value here 
		MaximumEdges = maxii;
		return MaximumEdges;
	}
	public static void densityOfGraph() {
		countEdges();
		maximumNumberOfEdges();
		
	System.out.println("the density of the graph is : " +countEdges() / maximumNumberOfEdges());
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int V = 6; 
	       graphDensity Graph  = new graphDensity(V);
	       Graph.addEdge( 0, 1);
	       Graph.addEdge( 0, 2);
	       Graph.addEdge( 1, 3);
	       Graph.addEdge( 2, 3);
	       Graph.addEdge(2, 5);
	       Graph.addEdge(3, 4);
	       Graph.addEdge( 4, 5);
			System.out.println("the number of edges in the graph is  : " + Graph.countEdges());
			System.out.println("the maximum number of edges the graph can have are " + maximumNumberOfEdges());
			densityOfGraph();
		// TODO Auto-generated method stub

	}

}
