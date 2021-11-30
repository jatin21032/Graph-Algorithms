import java.util.ArrayList;

public class DFSTraversal implements Traversal {

    ArrayList<Integer> outputlist = new ArrayList<Integer>();
    int[] visited = new int[Graphs.unique_vertices.size()];

    public void dfs_util(Edges[][] AdjMatrix, int s) {
        visited[s] = 1;
        
        outputlist.add(Graphs.unique_vertices.get(s));
       
        for(int i = 0; i < Graphs.unique_vertices.size(); i++)
        {
            if(AdjMatrix[s][i]!=null){
            if(AdjMatrix[s][i].weight==1 && (visited[i]==0))
                dfs_util(AdjMatrix, i);
        }
    }
    }
    
    public ArrayList<Integer> GraphTraversal(Edges[][] AdjMatrix ) {
        
        dfs_util(AdjMatrix, startVertex);
        return outputlist;
        
    }
}
