import java.util.ArrayList;

public class BFSTraversal {
    //Vertices startVertex;

    
    public ArrayList<Integer> Traversal(Edges[][] AdjMatrix ){

    ArrayList<Integer> outputlist = new ArrayList<Integer>();
    //Graphs gr = new Graphs();
    //AdjMatrix = gr.matrixGraph();
    //Graphs.startVertex = AdjMatrix[][];
    int[] visited = new int[Graphs.unique_vertices.size()];
    
    ArrayList<Integer> queue = new ArrayList<Integer>();
    queue.add(0);

    // Set source as visited
    visited[0] = 1;

    int curr;
    while (!queue.isEmpty())
    {
        curr = queue.get(0);
        Vertices v = new Vertices();
        // Print the current node
        outputlist.add( Graphs.unique_vertices.get(curr));
        queue.remove(queue.get(0));

        // For every adjacent vertex to
        // the current vertex
        for(int i = 0; i < Graphs.unique_vertices.size(); i++)
        {
            if (AdjMatrix[curr][i].weight==1 && (visited[i]==0))
            {
                 
                // Push the adjacent node to
                // the queue
                queue.add(i);

                // Set
                visited[i] = 1;
            }
        }
    }
    return outputlist;
 }
}
