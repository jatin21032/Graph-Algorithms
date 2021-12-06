/**This File is performing DFS traversal by Implementing methods of interface Traversal.
 * This class file features the concepts of INHERITENCE and ABSTRACTION by implementing abstract function(GraphTraversal) of an interface.
 */
package oopd;
import java.util.ArrayList;

//Class implementing interface
public class DFSTraversal implements Traversal {

    ArrayList < Integer > outputlist = new ArrayList < Integer > ();
    int[] visited = new int[Graphs.unique_vertices.size()];

    //This function performing traversal in DFS manner by using Recursion stack.
    public void dfs_util(Edges[][] AdjMatrix, int s) {
        visited[s] = 1;

        outputlist.add(Graphs.unique_vertices.get(s));

        for (int i = 0; i < Graphs.unique_vertices.size(); i++) {
            if (AdjMatrix[s][i] != null) {
                if (AdjMatrix[s][i].weight == 1 && (visited[i] == 0))
                    dfs_util(AdjMatrix, i);
            }
        }
    }
    //This function overriding interface method and calling above function
    @Override
    public ArrayList < Integer > GraphTraversal(Edges[][] AdjMatrix) {

        dfs_util(AdjMatrix, startVertex);
        return outputlist;

    }
}