import java.util.ArrayList;
interface Traversal {
    ArrayList<Integer> Traversal(Edges[][] e);
}
public class BFSTraversal implements Traversal {
    //Vertices startVertex;

    @Override
    public ArrayList<Integer> Traversal(Edges[][] AdjMatrix ){

    ArrayList<Integer> outputlist = new ArrayList<Integer>();
    //Graphs gr = new Graphs();
    //AdjMatrix = gr.matrixGraph();
    //Graphs.startVertex = AdjMatrix[][];
    int[] visited = new int[Graphs.unique_vertices.size()];
    
    ArrayList<Integer> queue = new ArrayList<Integer>();
    queue.add(10);

    // Set source as visited
    visited[10] = 1;

    int curr;
    while (!queue.isEmpty())
    {
        curr = queue.get(0);
        
        // Print the current node
        outputlist.add( Graphs.unique_vertices.get(curr));
        queue.remove(queue.get(0));

        // For every adjacent vertex to
        // the current vertex
        //System.out.println("VVVVVV"+Graphs.unique_vertices.size());
        for(int i = 0; i < Graphs.unique_vertices.size(); i++)
        {
            //System.out.println("cueee"+curr);
           try{ 
               if(AdjMatrix[curr][i] !=null){
            if (AdjMatrix[curr][i].weight==1 && (visited[i]==0))
            {
                // System.out.println("neighbor of "+ curr+" are "+i);
                // Push the adjacent node to
                // the queue
                queue.add(i);
                
                // Set
                visited[i] = 1;
            }
        }
        }catch(Exception e){

        }
        }
    }
    return outputlist;
 }

    

    
   
}
