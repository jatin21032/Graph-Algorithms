import java.util.ArrayList;
interface Traversal {
    public int startVertex=10;
    public ArrayList<Integer> GraphTraversal(Edges[][] e);
}
public class BFSTraversal implements Traversal {
    
    @Override
    public ArrayList<Integer> GraphTraversal(Edges[][] AdjMatrix ){

    ArrayList<Integer> outputlist = new ArrayList<Integer>();
    int[] visited = new int[Graphs.unique_vertices.size()];
    ArrayList<Integer> queue = new ArrayList<Integer>();
    queue.add(startVertex);
    visited[10] = 1;

    int curr;
    try{
    while (!queue.isEmpty())
    {
        curr = queue.get(0);
        
        // Print the current node
        outputlist.add( Graphs.unique_vertices.get(curr));
        queue.remove(queue.get(0));
        for(int i = 0; i < Graphs.unique_vertices.size(); i++)
        {
          
           try{ 
               if(AdjMatrix[curr][i] !=null){
            if (AdjMatrix[curr][i].weight==1 && (visited[i]==0))
            {
                
                queue.add(i);
             visited[i] = 1;
            }
        }
        }catch(Exception e){

        }
        }
    }
   }catch(Exception e){
       System.out.println("Error while traversing graph!!"+e);
   }
    return outputlist;
 }

    

    
   
}
